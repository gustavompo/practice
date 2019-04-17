import org.scalatest.{FlatSpec, MustMatchers}

class TimeConversionTest extends FlatSpec with MustMatchers {

  "a" should "ok" in {
    val res = new TimeConversion().timeConversion( "07:05:45PM")

    res must be("19:05:45")
  }

}
