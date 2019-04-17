import scala.collection.immutable

class WordInBoard(board: Array[Array[Char]]) {
  def adjacents(p: Point): List[Point] = {
    List(
      (p.x - 1, p.y), (p.x, p.y - 1), (p.x + 1, p.y), (p.x, p.y + 1),
    ).filter(p => p._1 >= 0 && p._2 >= 0 && p._1 < board(0).length && p._2 < board.length)
      .map(f => Point(f._2, f._1, board(f._2)(f._1)))
  }

  def loop(word: String, currentPath: List[Point]): Option[List[Point]] = {
    if (word.length == 0) return Some(currentPath)
    val adjacentList = adjacents(currentPath.last).filter(adj => adj.c == word.head)
    if (adjacentList.isEmpty) None
    else
      adjacentList.foldLeft[Option[List[Point]]](None) { (acc, it) =>
        acc match {
          case None => loop(word.tail, currentPath :+ it)
          case v => v
        }
      }
  }

  def findAll(c: Char): immutable.IndexedSeq[Point] = {
    (for {
      y <- board.indices
      x <- board(0).indices
    } yield {
      if (board(y)(x) == c) Some(Point(y, x, c))
      else None
    }).flatten
  }

  def findWord(word: String): Option[List[Point]] = {
    val initialOptions = findAll(word.head)
    initialOptions.foldLeft(None: Option[List[Point]]) { (acc, it) => acc match {
        case None => loop(word.tail, List(it))
        case v => v
      }
    }
  }
}

case class Point(y: Int, x: Int, c: Char)