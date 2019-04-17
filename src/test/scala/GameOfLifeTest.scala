import org.scalatest.{FlatSpec, MustMatchers}

class GameOfLifeTest extends FlatSpec with MustMatchers {

  val b0 = Array(
    Array(1, 1, 1),
    Array(0, 1, 1),
    Array(0, 0, 1)
  )
  val b1 = Array(
    Array(1, 0, 1),
    Array(1, 0, 0),
    Array(0, 1, 1)
  )
  val b2 = Array(
    Array(0, 1, 0),
    Array(1, 0, 1),
    Array(1, 1, 0)
  )
  val b3 = Array(
    Array(0, 0, 0, 1, 1),
    Array(0, 0, 0, 1, 1),
    Array(0, 1, 0, 1, 1),
    Array(0, 0, 1, 1, 1),
    Array(0, 0, 0, 1, 1)
  )
  val target = new GameOfLife()

  "aliveNeighbors" should "happy path" in {
    target.aliveNeighbors(0, 0, b0) must be(2)
    target.aliveNeighbors(1, 1, b1) must be(3)
    target.aliveNeighbors(2, 3, b3) must be(4)
  }

  "game" should "doit" in {
    target.game(b0, 1) must be(b1)
    target.game(b0, 2) must be(b2)
  }
}
