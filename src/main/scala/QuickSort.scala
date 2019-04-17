import scala.util.Random

class QuickSort {


  def sort(ar: Array[Int], minIx: Int, maxIx: Int): Unit = {
    if (minIx < maxIx) {
      if (Math.abs(minIx - maxIx) == 1) {
        if (ar(minIx) > ar(maxIx)) {
          val tmp = ar(maxIx)
          ar(maxIx) = ar(minIx)
          ar(minIx) = tmp
        }
      } else {
        val pivot = Random.nextInt(maxIx - minIx) + minIx
        val newPivot = findPivotPosition(pivot, minIx, maxIx, ar)
        sort(ar, minIx, newPivot - 1)
        sort(ar, newPivot + 1, maxIx)
      }
    }
  }


  def findPivotPosition(pivotParam: Int, minIx: Int, maxIx: Int, ar: Array[Int]): Int = {
    var pivot = pivotParam
    val v = ar(pivot)
    for (ix <- minIx to maxIx) {
      if (ix < pivot && ar(ix) > v || ix > pivot && ar(ix) < v) {
        pivot = swap(pivot, ix, ar)
      }
    }
    pivot
  }

  def swap(pivotIx: Int, currentIter: Int, ar: Array[Int]) = {
    if (Math.abs(pivotIx - currentIter) == 1) {
      val tmp = ar(currentIter)
      ar(currentIter) = ar(pivotIx)
      ar(pivotIx) = tmp
      currentIter
    } else {
      if (pivotIx > currentIter) {
        val tmp = ar(currentIter)
        ar(currentIter) = ar(pivotIx - 1)
        ar(pivotIx - 1) = ar(pivotIx)
        ar(pivotIx) = tmp
        pivotIx - 1
      } else {
        val tmp = ar(currentIter)
        ar(currentIter) = ar(pivotIx + 1)
        ar(pivotIx + 1) = ar(pivotIx)
        ar(pivotIx) = tmp
        pivotIx + 1
      }
    }
  }

}
