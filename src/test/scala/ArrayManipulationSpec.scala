import org.scalatest.{FlatSpec, MustMatchers}

class ArrayManipulationSpec extends FlatSpec with MustMatchers {

  "a" should "b" in {
    val target = new ArrayManipulation
    val res = target.arrayManipulation(5, Array(
      Array(1, 2, 100),
      Array(2, 5, 100),
      Array(3, 4, 100)
    ))

    res must be(200)
  }

}
