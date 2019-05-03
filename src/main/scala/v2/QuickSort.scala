package v2

import scala.util.Random

class QuickSort {

  def inplaceSort(arr: Array[Int]): Unit = {
    innerSort(arr, 0, arr.length - 1)
  }

  private def innerSort(arr: Array[Int], st: Int, end: Int): Unit = {
    if (end - st == 1 && arr(end) < arr(st)) {
      val tmp = arr(end)
      arr(end) = arr(st)
      arr(st) = tmp
    } else if (st < end) {
      val r = Random.nextInt(end - st) + st
      val newIx = setInRightPosition(st, end, r, arr)
      innerSort(arr, st, newIx - 1)
      innerSort(arr, newIx + 1, end)
    }
  }


  def setInRightPosition(st: Int, end: Int, ix: Int, arr: Array[Int]): Int = {
    val tvalue = arr(ix)
    var currentIx = ix
    var targetIx = st
    for (iter <- st to end) {
      if (arr(iter) < tvalue) {
        if (iter > targetIx) {
          currentIx = if (targetIx == currentIx) iter else currentIx
          val tmp = arr(iter)
          arr(iter) = arr(targetIx)
          arr(targetIx) = tmp
        }
        targetIx = targetIx + 1
      }
    }
    val tmp = arr(targetIx)
    arr(targetIx) = arr(currentIx)
    arr(currentIx) = tmp
    targetIx
  }
}