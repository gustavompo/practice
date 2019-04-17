import org.scalatest.{FlatSpec, MustMatchers}

class StaircaseTest extends FlatSpec with MustMatchers {

  "a" should "ok" in {
    val res = new StairCase().staircase(6)
    print(res)
  }

}
