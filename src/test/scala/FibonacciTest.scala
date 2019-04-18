import org.scalatest.{FlatSpec, MustMatchers}

class FibonacciTest extends FlatSpec with MustMatchers {

  "a" should "b" in {
    val target = new Fibonacci
    val res = target.fibonacci(3)
    res must be(2)
  }


}
