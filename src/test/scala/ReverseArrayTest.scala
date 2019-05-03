import org.scalatest.{FlatSpec, MustMatchers}

class ReverseArrayTest extends FlatSpec with MustMatchers{

  "" should "" in {
    val target = new ReverseArray
    val a = Array(1,2,3,4)
    val res = target.reverseArray(a.clone())
    res must be (a.reverse)

  }

}
