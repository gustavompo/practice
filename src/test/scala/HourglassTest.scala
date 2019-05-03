import org.scalatest.{FlatSpec, MustMatchers}

class HourglassTest extends FlatSpec with MustMatchers {
  val b = Array(
    Array(1, 1, 1, 0, 0, 0),
    Array(0, 1, 0, 0, 0, 0),
    Array(1, 1, 1, 0, 0, 0),
    Array(0, 0, 2, 4, 4, 0),
    Array(0, 0, 0, 2, 0, 0),
    Array(0, 0, 1, 2, 4, 0))

  "a" should "ok" in {
    val target = new Hourglass
    val res = target.hourglassSum(b)
    res must be(19)
  }

}


