class SocksCalc {

  def sockMerchant(n: Int, ar: Array[Int]): Int = {
    ar.groupBy(e => e).foldLeft(0) { (acc, g) =>
      (g._2.length / 2) + acc
    }
  }
}
