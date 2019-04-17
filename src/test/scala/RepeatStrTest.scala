import org.scalatest.{FlatSpec, MustMatchers}

class RepeatStrTest extends FlatSpec with MustMatchers {
  "a" should "ok" in {
    val res = new RepeatStr().repeatedString("a", 1000000000000L)
    res must be (1000000000000L)
  }
}
