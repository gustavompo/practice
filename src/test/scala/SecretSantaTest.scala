import org.scalatest.{FlatSpec, MustMatchers}

import scala.collection.mutable
import scala.util.Random

class SecretSantaTest extends FlatSpec with MustMatchers {

  behavior of "SecretSantaTest"

  val target = new SecretSanta

  it should "solveIt" in {
    val input =
      """Chris,chris@example.com
        |Felix,felix@example.net
        |Elizabeth,lizzy1994@example.com
        |André,andre@example.fr
        |Milo,milo.milo@example.com
        |Olivia,olive99@example.net
        |Hugo,hugo124@example.net
        |Amit,amit.123@example.com
        |Ludwig,ludwig@example.net
        |Raoul,raoul@example.com""".stripMargin

    val result = target.solveIt(input)
    print(result.mkString("\n"))
  }

  it should "randomizeIndexes" in {
    val list = 0 :: 1 :: 2 :: 3 :: 4 :: 5 :: Nil
    val radoms = (1 to 3).map { i => Random.setSeed(i); target.randomIndexes(list) }
    val isOneDiff = radoms.foldLeft((false, mutable.MutableList[Int]()))((res, i) => {
      (res._1 || !res._2.sameElements(i), i)
    })
    isOneDiff._1 must be(true)
  }

}
