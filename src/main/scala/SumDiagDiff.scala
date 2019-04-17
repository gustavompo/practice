class SumDiagDiff {
  def diagonalDifference(arr: Array[Array[Int]]): Int = {
    val ixs = for {
      i <- arr.indices
    } yield (arr(i)(i), arr(i)(arr.length - 1 - i))
    val (a, b) = ixs.unzip
    Math.abs(a.sum - b.sum)
  }


}
