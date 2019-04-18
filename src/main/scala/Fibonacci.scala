import scala.collection.mutable

class Fibonacci {

  def fibonacci(x: Int): Int = {
    if (x == 0 || x == 1) x
    else memo(x - 1, fibonacci(x - 1)) + memo(x - 2, fibonacci(x - 2))
  }

  val m = mutable.Map[Int, Int]()

  def memo(p: Int, fn: => Int) = {
    if (m.contains(p)) m(p)
    else {
      val r = fn
      m(p) = r
      r
    }
  }

}
