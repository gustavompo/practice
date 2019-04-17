import org.scalatest.{FlatSpec, Matchers}

class SocksCalcTest extends FlatSpec with Matchers{
  "stocks" should "run" in{
    val sc = new SocksCalc
    val res = sc.sockMerchant(0, Array(1,2,3,4,4,3,2,1,1,1,1,1,1))
    res should be (6)
  }
}
