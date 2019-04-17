class StairCase {
  def staircase(n: Int): String = {
    val rows = for {
      r <- 1 to n
    } yield " " * (n - r) + ("#" * r)
    rows.mkString("\n")
  }
}
