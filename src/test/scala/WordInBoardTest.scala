import org.scalatest.{FlatSpec, MustMatchers}

class WordInBoardTest extends FlatSpec with MustMatchers {
  val board = Array(
    Array('A', 'J', 'A', 'P', 'B', 'D', 'P'),
    Array('P', 'S', 'E', 'P', 'L', 'S', 'J'),
    Array('P', 'M', 'E', 'F', 'E', 'A', 'F'),
    Array('Y', 'W', 'R', 'Q', 'T', 'G', 'S'),
    Array('M', 'N', 'U', 'W', 'E', 'D', 'J'),
    Array('N', 'J', 'I', 'P', 'S', 'T', 'G'),
    Array('L', 'A', 'W', 'T', 'O', 'S', 'L')
  )

  "a" should "adjacents" in {
    val target = new WordInBoard(board)
    target.adjacents(Point(3, 3, 'Q')) must contain(Point(3, 2, 'R'))
    target.adjacents(Point(3, 3, 'Q')) must contain(Point(2, 3, 'F'))
    target.adjacents(Point(3, 3, 'Q')) must contain(Point(3, 4, 'T'))
    target.adjacents(Point(3, 3, 'Q')) must contain(Point(4, 3, 'W'))
  }

  "findWord" should "findit" in {
    val target = new WordInBoard(board)
    val res = target.findWord("APPLE").get
    res.head.x must be(2)
    res.last.y must be(2)
    res.last.x must be(4)
  }

}
