import scala.collection.mutable

class AStar {

  type Board = Array[Array[Int]]

  implicit val nodeOrdering: Ordering[MiddleNode] = (x: MiddleNode, y: MiddleNode) => {
    val r = x.remainingDist - y.remainingDist
    if (r > 0) 1 else if (r < 0) -1 else 0
  }

  def findPath(initial: Node, target: Target, board: Board): Option[MiddleNode] = {
    var current: Option[MiddleNode] = Some(MiddleNode(initial.x, initial.y, null, 0))
    val done: mutable.Set[Node] = mutable.Set[Node]()
    var seen = List[MiddleNode]()
    seen = listAdjacent(current.get, target, board)
    done.add(current.get)
    var found = None: Option[MiddleNode]
    while (current.nonEmpty && found.isEmpty) {
//      println(printStatus(board, done, seen))
//      println()
      val adj = listAdjacent(current.get, target, board).filterNot { ad => done.exists { e => e.x == ad.x && e.y == ad.y } }
      seen = seen ++ adj
      val fin = adj.find { n => n.x == target.x && n.y == target.y }
      fin.foreach { f => found = Some(f) }
      if (seen.nonEmpty) {
        current = Some(seen.min)
        seen = seen.filterNot(n => n.x == current.get.x && n.y == current.get.y)
        done.add(current.get)
      }
      else current = None
    }
    found
  }

  def printStatus(board: Board, done: mutable.Set[Node], seen: List[Node]): String = {
    board.zipWithIndex.map { case (line, yix) => line.zipWithIndex.map {
      case (xcell, xix) =>
        if (done.exists(d => d.is(xix, yix))) "#"
        else if (seen.exists(d => d.is(xix, yix))) "+"
        else "."
    }.mkString("")
    }.mkString("\n")
  }

  def boardPath(board: Board, path: Node): String = {
    val b = board.map(line => line.mkString(", ")).mkString("\n")
    val p = board.zipWithIndex.map { case (line, yix) => line.zipWithIndex.map { case (xcell, xix) => if (path.hasInPath(xix, yix)) "#" else "-" }.mkString("") }.mkString("\n")
    s"$b\n\n$p"
  }

  private def listAdjacent(n: MiddleNode, target: Target, board: Board) = {
    List((n.x - 1, n.y), (n.x, n.y - 1), (n.x + 1, n.y), (n.x, n.y + 1))
      .filter { case (x, y) => x >= 0 && y >= 0 && x < board(0).length && y < board.length && board(y)(x) > 0 }
      .map { case (x, y) => MiddleNode(x, y, n, distanceTo(target, n)) }
  }

  private def distanceTo(target: Node, node: Node): Double = {
    Math.sqrt(Math.pow(target.x - node.x, 2) + Math.pow(target.y - node.y, 2))
  }

}

sealed trait Node {
  val x: Int = 0

  val y: Int = 0

  def hasInPath(x: Int, y: Int): Boolean = this.x == x && this.y == y

  override def equals(obj: Any): Boolean = obj.isInstanceOf[Node] && obj.asInstanceOf[Node].x == this.x && obj.asInstanceOf[Node].y == y

  override def hashCode(): Int = (x * Math.pow(10, 2) + y * Math.pow(10, 4)).toInt

  def is(x: Int, y: Int): Boolean = this.x == x && this.y == y
}

case object Root extends Node

case class Target(override val x: Int, override val y: Int) extends Node

case class MiddleNode(override val x: Int, override val y: Int, prev: MiddleNode, remainingDist: Double) extends Node {
  override def hasInPath(x: Int, y: Int): Boolean = (this.x == x && this.y == y) || prev != null && prev.hasInPath(x, y)
}