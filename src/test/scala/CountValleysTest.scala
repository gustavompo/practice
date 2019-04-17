import org.scalatest.{FlatSpec, MustMatchers}

class CountValleysTest extends FlatSpec with MustMatchers{

  "run" should "ok" in{
    val target = new CountValleys
    val res = target.countingValleys(0,"UDDDUDUUDDDDUU")
    res must be (2)
  }
}
