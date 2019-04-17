class GameOfLife {

  def game(b: Array[Array[Int]], lives: Int): Array[Array[Int]] = {
    val nextLifeBoard = b.transpose.transpose
    var board = b
    for (_ <- 1 to lives) {
      for (y <- board.indices) {
        for (x <- board(0).indices) {
          val aliveNeighborsCount = aliveNeighbors(x, y, board)
          if (aliveNeighborsCount == 2 || aliveNeighborsCount == 3)
            nextLifeBoard(y)(x) = 1
          else
            nextLifeBoard(y)(x) = 0
        }
      }
      board = nextLifeBoard.transpose.transpose
    }
    nextLifeBoard
  }

  def aliveNeighbors(x: Int, y: Int, board: Array[Array[Int]]): Int = {
    val all = for {
      a <- x - 1 to x + 1
      b <- y - 1 to y + 1
    } yield {
      (a, b)
    }
    all.count { p =>
      val (cX, cY) = p
      val withinBoard = cX >= 0 && cY >= 0 && cY < board.length && cX < board(0).length
      val notItself = !(cX == x && cY == y)
      val alive = withinBoard && board(cY)(cX) > 0
      withinBoard && notItself && alive
    }
  }

}
