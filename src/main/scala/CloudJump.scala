import scala.annotation.tailrec

class CloudJump {
  def jumpingOnClouds(c: Array[Int]): Int = {
    var i = -1
    var jumps = -1
    whilee({
      i = i + 1; i < c.length
    }) {
      if (i + 2 < c.length && c(i + 2) != 1) {
        i = i + 1
      }
      jumps = jumps + 1
    }
    jumps
  }

  @tailrec
  private def whilee(cond: => Boolean)(block: => Unit) {
    if (cond) {
      block
      whilee(cond)(block)
    }
  }
}
