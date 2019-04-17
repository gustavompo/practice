class MinMaxSum {

  def miniMaxSum(arr: Array[Int]) {
    val s: Array[Long] = arr.map(_.toLong).sorted
    println(s"${s.take(4).sum} ${s.reverse.take(4).sum}")
  }
}
