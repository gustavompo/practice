class Hourglass {

  def hourglassSum(arr: Array[Array[Int]]): Int = {
    var maxSum = Int.MinValue
    for (y <- 0 to arr.length - 3) {
      for (x <- 0 to arr(0).length - 3) {
        val current = arr(y)(x) + arr(y)(x + 1) + arr(y)(x + 2) + arr(y + 1)(x + 1) + arr(y + 2)(x) + arr(y + 2)(x + 1) + arr(y + 2)(x + 2)
        maxSum = if (current > maxSum) current else maxSum
      }
    }
    maxSum
  }

  //21:54
  //22:01 code v1
  //22:08 test pass


}
