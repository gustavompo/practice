class ArrayLeftRotation {

  def rotLeft(a: Array[Int], d: Int): Array[Int] = {
    val x = d % a.length
    val res = Array(a: _*)
    for (ix <- a.indices) {
      val target = if (ix - x < 0) a.length + (ix - x) else ix - x
      res(target) = a(ix)
    }
    res
  }

  //22:11
  //22:24 code
  //22:30 test pass
  //22:37 nowok

}
