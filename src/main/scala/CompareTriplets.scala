class CompareTriplets {
  def compareTriplets(a: Array[Int], b: Array[Int]): Array[Int] = {
    a.zip(b).foldLeft(Array(0, 0)) { (acc, x) =>
      val (a, b) = x
      Array(
        (if (a > b) 1 else 0) + acc(0),
        (if (b > a) 1 else 0) + acc(1)
      )
    }
  }
}
