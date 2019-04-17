import org.scalatest.{FlatSpec, MustMatchers}

class RecursiveCombinationTest extends FlatSpec with MustMatchers {

  "a" should "do" in {
    val res = new RecursionCombination().stepsComb(35, 1 :: 2 :: 3 :: Nil)
    res must be(1132436852)
  }

}
