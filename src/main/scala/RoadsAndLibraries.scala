import scala.collection.mutable

case class CityNode(city: Int, neighbors: mutable.HashSet[CityNode] = mutable.HashSet()) {
  def isConnected(n: CityNode): Boolean = {
    if (n == this || neighbors.contains(n)) return true
    var current = this
    val visited = mutable.HashSet(this)
    var next = neighbors.clone()
    while (next.nonEmpty) {
      current = next.head
      next -= current
      if (current.neighbors.contains(n)) return true
      visited += current
      next ++ current.neighbors.diff(visited)
    }
    false
  }

  override def hashCode(): Int = city

  override def equals(obj: Any): Boolean = obj.isInstanceOf[CityNode] && obj.asInstanceOf[CityNode].city == city

  override def toString: String = s"$city {${neighbors.map(_.city).mkString(", ")}}"
}

case class CityCluster(var size: Int, nodes: mutable.HashSet[CityNode] = mutable.HashSet()) {
  def contains(n: CityNode): Boolean = nodes.exists(e => e.isConnected(n))
}

class RoadsAndLibraries {

  def buildGraph(citiesArr: Array[Array[Int]]): List[CityNode] = {
    val cities = mutable.HashSet[CityNode]()
    for (l <- citiesArr) {
      val Array(a, b) = l
      val nA = cities.find(e => e.city == a).getOrElse(CityNode(a))
      val nB = cities.find(e => e.city == b).getOrElse(CityNode(b))
      nA.neighbors += nB
      nB.neighbors += nA
      cities += nA
      cities += nB
    }
    cities.toList
  }

  def roadsAndLibraries(unused: Int, libCost: Int, roadCost: Int, cities: Array[Array[Int]]): Long = {
    val cityNodes = buildGraph(cities)
    var clusters = mutable.MutableList[CityCluster]()
    for (node <- cityNodes) {
      val cluster = clusters.find(nds => nds.contains(node))
      if (cluster.isDefined) cluster.get.size = cluster.get.size + 1
      else clusters += CityCluster(1, mutable.HashSet(node))
    }

    val allCost = for {cluster <- clusters} yield {
      val singleLibCost = (cluster.size - 1).toLong * roadCost + libCost
      val multipleLibCost = cluster.size.toLong * libCost
      if (singleLibCost > multipleLibCost)
        multipleLibCost
      else singleLibCost
    }
    allCost.sum
  }

}

