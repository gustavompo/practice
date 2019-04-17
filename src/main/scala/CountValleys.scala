class CountValleys {
  def countingValleys(n: Int, s: String): Int = {
    // previous position, countOfValeys
    s.foldLeft((0, 0)) { (prevAndCount, current) =>
      val (prevPosition, valeys) = prevAndCount
      val vCount = if (prevPosition == 0 && current == 'D') valeys + 1 else valeys
      (prevPosition + (if (current == 'D') -1 else 1), vCount)
    }._2
  }
}
