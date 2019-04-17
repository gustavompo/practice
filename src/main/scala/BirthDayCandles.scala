class BirthDayCandles {

  def birthdayCakeCandles(ar: Array[Int]): Int = {
    ar.foldLeft((-1, Int.MinValue)) { (acc, i) =>
      if (ar(i) > acc._2) (1, ar(i))
      else if (ar(i) == acc._2) (acc._1 + 1, acc._2)
      else acc
    }._1

  }
}
