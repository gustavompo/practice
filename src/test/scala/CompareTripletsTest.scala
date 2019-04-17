import org.scalatest.{FlatSpec, MustMatchers}

class CompareTripletsTest extends FlatSpec with MustMatchers {

  "t" should "ok" in {
    val res = new CompareTriplets().compareTriplets(Array(17, 28, 30), Array(99, 16, 8))

    res must be(Array(2, 1))
  }

}
