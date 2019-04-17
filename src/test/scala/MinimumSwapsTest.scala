import org.scalatest.{FlatSpec, MustMatchers}

class MinimumSwapsTest extends FlatSpec with MustMatchers {

  "s" should "ok" in {
    val res = new MinimumSwaps().runner(Array(7, 1, 3, 2, 4, 5, 6))
    res must be("5")
  }

  "s" should "ok2" in {
    val res = new MinimumSwaps().runner(Array(4, 3, 1, 2))
    res must be("3")
  }

  "s" should "ok3" in {
    val res = new MinimumSwaps().runner(Array(2, 3, 4, 1, 5))
    res must be("3")
  }

  "s" should "ok4" in {
    val res = new MinimumSwaps().runner(Array(1, 3, 5, 2, 4, 6, 7))
    res must be("3")
  }


}
