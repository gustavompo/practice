import scala.collection.mutable

class MinimumSwaps {

  private val swaps = mutable.Map[Int, Int]()

  def runner(q: Array[Int]): String = {
    var moves = 0
    for (ix <- 0 to q.length - 2) {
      var currentValue = q(ix)
      whilee(swaps.contains(currentValue)) {
        val tmp = currentValue
        currentValue = swaps(currentValue)
        q(ix) = currentValue
        swaps.remove(tmp)
      }
      if (q(ix) != ix + 1) {
        swaps.put(ix + 1, q(ix))
        q(ix) = ix + 1
        moves += 1
      }
    }
    moves.toString
  }


  def minimumBribes(q: Array[Int]) = {
    println(runner(q))
  }

  private def move(ix: Int, q: Array[Int]): Int = {
    if (q(ix) == ix + 1) return 0
    val rightValueForIx = ix + 1
    if (q(ix - 1) != rightValueForIx && (ix - 2 < 0 || q(ix - 2) != rightValueForIx)) {
      -1
    } else if (ix - 2 >= 0 && q(ix - 2) == rightValueForIx) {
      val tmp2 = q(ix - 1)
      val tmp1 = q(ix)
      q(ix) = rightValueForIx
      q(ix - 1) = tmp1
      q(ix - 2) = tmp2
      2
    } else {
      val tmp = q(ix - 1)
      q(ix - 1) = q(ix)
      q(ix) = tmp
      1
    }
  }

  def whilee(cond: => Boolean)(block: => Unit) {
    if (cond) {
      block
      whilee(cond)(block)
    }
  }

}
