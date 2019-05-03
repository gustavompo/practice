package v2

import org.scalatest.{FlatSpec, MustMatchers}

class QuickSortTest extends FlatSpec with MustMatchers{
  val target = new QuickSort

  "sort" should "sort" in{
    val arr = Array(1,2,7,4,2,6,8,9,34,12,6)
    target.inplaceSort(arr)
    arr.head must be(1)
    arr.last must be(34)
    arr(3) must be(4)
  }

  "set in right " should "1" in {
    var arr = Array(3,6,5,8)
    target.setInRightPosition(0,3,2,arr)
    arr(1) must be(5)
    arr.head must be(3)

    arr = Array(1,2,3,4,8,3,4)
    target.setInRightPosition(0,6,5,arr)
    arr(2) must be(3)

    arr = Array(1,2,3,4,8,3,4)
    target.setInRightPosition(0,6,4,arr)
    arr.last must be(8)

    arr = Array(1,2,7,4,2,6,8,9,34,12,6)
    target.setInRightPosition(4,10,8,arr)
    arr.last must be(34)
  }
  "set in right " should "12" in {
    val arr = Array(1,2,7,4,2,6,8,9,34,12,6)
    val r = target.setInRightPosition(0,10,2,arr)
    arr.last must be(34)
  }

}
