import scala.collection.mutable

class RecursionCombination {

  def stepsComb(n: Int, steps: List[Int]): Int = {
    steps.foldLeft(0) { (acc, st) =>
      (if (n > st) memo(n - st, stepsComb(n - st, steps))
      else if (n == st) 1
      else 0) + acc
    }
  }

  val m: mutable.Map[Int, Int] = mutable.Map[Int, Int]()

  private def memo(n: Int, fn: => Int) = {
    if (m.contains(n)) m(n)
    else {
      val res = fn
      m.put(n, res)
      res
    }
  }
}
