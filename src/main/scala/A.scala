//
//
//import scala.collection.mutable
//
//object Solution {
//
//
//  case class CityNode(city: Int, neighbors: mutable.HashSet[CityNode] = mutable.HashSet()) {
//    def isConnected(n: CityNode): Boolean = {
//      if (n == this || neighbors.contains(n)) return true
//      var current = this
//      val visited = mutable.HashSet(this)
//      var next = neighbors.clone()
//      while (next.nonEmpty) {
//        current = next.head
//        next -= current
//        if (current.neighbors.contains(n)) return true
//        visited += current
//        next ++ current.neighbors.diff(visited)
//      }
//      false
//    }
//
//    override def hashCode(): Int = city
//
//    override def equals(obj: Any): Boolean = obj.isInstanceOf[CityNode] && obj.asInstanceOf[CityNode].city == city
//
//    override def toString: String = s"$city {${neighbors.map(_.city).mkString(", ")}}"
//  }
//
//  case class CityCluster(var size: Int, nodes: mutable.HashSet[CityNode] = mutable.HashSet()) {
//    def contains(n: CityNode): Boolean = nodes.exists(e => e.isConnected(n))
//  }
//
//
//  def buildGraph(citiesArr: Array[Array[Int]]): scala.collection.immutable.List[CityNode] = {
//    val cities = mutable.HashSet[CityNode]()
//    for (l <- citiesArr) {
//      val Array(a, b) = l
//      val nA = cities.find(e => e.city == a).getOrElse(CityNode(a))
//      val nB = cities.find(e => e.city == b).getOrElse(CityNode(b))
//      nA.neighbors += nB
//      nB.neighbors += nA
//      cities += nA
//      cities += nB
//    }
//    cities.toList
//  }
//
//  def roadsAndLibraries(unused: Int, libCost: Int, roadCost: Int, cities: Array[Array[Int]]): Long = {
//    val cityNodes = buildGraph(cities)
//    var clusters = mutable.MutableList[CityCluster]()
//    for (node <- cityNodes) {
//      val cluster = clusters.find(nds => nds.contains(node))
//      if (cluster.isDefined) cluster.get.size = cluster.get.size + 1
//      else clusters += CityCluster(1, mutable.HashSet(node))
//    }
//
//    val allCost = for {cluster <- clusters} yield {
//      val singleLibCost = (cluster.size - 1) * roadCost + libCost
//      val multipleLibCost = cluster.size * libCost
//      if (singleLibCost > multipleLibCost)
//        multipleLibCost
//      else singleLibCost
//    }
//    allCost.sum
//  }
//
//
//  def main(args: Array[String]) {
//    val stdin = scala.io.StdIn
//
//    val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))
//
//    val q = stdin.readLine.trim.toInt
//
//    for (qItr <- 1 to q) {
//      val nmC_libC_road = stdin.readLine.split(" ")
//
//      val n = nmC_libC_road(0).trim.toInt
//
//      val m = nmC_libC_road(1).trim.toInt
//
//      val c_lib = nmC_libC_road(2).trim.toInt
//
//      val c_road = nmC_libC_road(3).trim.toInt
//
//      val cities = Array.ofDim[Int](m, 2)
//
//      for (i <- 0 until m) {
//        cities(i) = stdin.readLine.split(" ").map(_.trim.toInt)
//      }
//
//      val result = roadsAndLibraries(n, c_lib, c_road, cities)
//
//      printWriter.println(result)
//    }
//
//    printWriter.close()
//  }
//}
