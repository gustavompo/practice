import org.scalatest.{FlatSpec, MustMatchers}

class NewyearCaosSortTest extends FlatSpec with MustMatchers {

  "it" should "ok" in {
    val r = new NewyearCaosSort().runner(Array(2, 1, 5, 3, 4))
    r must be("3")
  }

  "it" should "ok2" in {
    val res = new NewyearCaosSort().runner(Array(2, 5, 1, 3, 4))
    res must be("Too chaotic")
  }

  "it" should "ok3" in {
    val res = new NewyearCaosSort().runner(Array(1, 2, 5, 3, 7, 8, 6, 4))
    res must be("7")
  }


}
