class ReverseArray {
  def reverseArray(a: Array[Int]): Array[Int] = {
    for ((ix, revIx) <- Range.apply(a.length - 1, (a.length - 1) / 2, -1).zipWithIndex) {
      val tmp = a(ix)
      a(ix) = a(revIx)
      a(revIx) = tmp
    }
    a
  }

}
