

class NewyearCaosSort {

  def runner(q: Array[Int]): String = {
    var bribes = 0
    for (ix <- q.indices.reverse) {
      var finished = false
      whilee(!finished) {
        val r = moveNext(ix, q)
        if (r == -1) return "Too chaotic"
        if (q(ix) == ix + 1) finished = true
        bribes += r
      }
    }
    bribes.toString
  }

  def minimumBribes(q: Array[Int]) = {
    println(runner(q))
  }

  private def moveNext(ix: Int, q: Array[Int]): Int = {
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
