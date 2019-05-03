import scala.collection.mutable

class RoadsAndLibraries2 {

  def roadsAndLibraries(cityCount: Int, libCost: Int, roadCost: Int, cities: Array[Array[Int]]): Long = {
    if (libCost <= roadCost) return libCost * cityCount

    val adj = (for {_ <- 0 until cityCount} yield {
      (for {_ <- 0 until cityCount} yield false).toArray
    }).toArray

    val unseenCities = mutable.HashSet[Int]()
    for (con <- cities) {
      adj(con(0) - 1)(con(1) - 1) = true
      adj(con(1) - 1)(con(0) - 1) = true
      unseenCities += (con(0)-1)
      unseenCities += (con(1)-1)
    }

    val a: Array[mutable.MutableList[Int]] = Array.fill(10)(mutable.MutableList[Int]())

    val currentCluster = mutable.HashSet[Int]()
    val nextInCluster = mutable.HashSet[Int]()
    var cumulativeCost = 0L

    //navigate in unseen
    while (unseenCities.nonEmpty) {
      val current = unseenCities.head
      unseenCities -= current
      nextInCluster += current

      //depth first to find the cluster
      while (nextInCluster.nonEmpty) {
        val c = nextInCluster.head
        println(s"processed $c")
        currentCluster += c
        nextInCluster -= c
        unseenCities -= c
        val others = adj(c)
        val next = for {ix <- others.indices if others(ix) && !currentCluster.contains(ix)} yield ix
        nextInCluster ++= next
      }

      cumulativeCost += (currentCluster.size - 1).toLong * roadCost + libCost
    }
    cumulativeCost
  }

}

