import scala.annotation.tailrec

class RecursiveDigitSum {
  def superDigit(n: String, k: Int): Int = {
    loop(n, k).toInt
  }

  @tailrec
  private def loop(d: String, mult: Long): String = {
    if(d.length > 1)
      loop((d.map(_.toString.toLong).sum * mult).toString, 1L)
    else d
  }
}
