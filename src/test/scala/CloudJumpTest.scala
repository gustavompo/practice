import org.scalatest.{FlatSpec, MustMatchers}

class CloudJumpTest extends FlatSpec with MustMatchers {
  "test" should "ok" in {
   val res =  new CloudJump().jumpingOnClouds(Array(0,0,1,0,0,1,0))
    res must be (4)
  }
}
