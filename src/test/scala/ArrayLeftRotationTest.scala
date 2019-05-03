import org.scalatest.{FlatSpec, MustMatchers}

class ArrayLeftRotationTest extends FlatSpec with MustMatchers {

  "" should "" in {
    val target = new ArrayLeftRotation
    val orig = Array(1, 2, 3, 4, 5)
    val res = target.rotLeft(orig, 5)
    res must be(orig)
//    res must be(Array(5, 1, 2, 3, 4))
  }

}
