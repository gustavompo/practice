import org.scalatest.{FlatSpec, MustMatchers}

class DynamicArraySpec extends FlatSpec with MustMatchers {

  "dynamic array" should "process" in {
    val target = new DynamicArray
    val queries = Array(
      Array(1, 0, 5),
      Array(1, 1, 7),
      Array(1, 0, 3),
      Array(2, 1, 0),
      Array(2, 1, 1)
    )
    val result = target.dynamicArray(2, queries)
    result.head must be(7)
    result.last must be(3)
    result.length must be(2)
  }

}
