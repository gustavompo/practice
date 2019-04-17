import org.scalatest.{FlatSpec, MustMatchers}

class BirthDayCandlesTest extends FlatSpec with MustMatchers {

  "a" should "ok" in {
    val res = new BirthDayCandles().birthdayCakeCandles(Array(3, 2, 1, 3))

    res must be(2)
  }

}
