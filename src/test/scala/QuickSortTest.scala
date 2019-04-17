import org.scalatest.{FlatSpec, MustMatchers}

class QuickSortTest extends FlatSpec with MustMatchers {

  val target = new QuickSort()
  "sort" should "sort" in {
    val arr = Array(2, 6, 6, 87, 8, 5, 3, 5, 7, 8)
    target.sort(arr, 0, arr.length - 1)
    print(arr.toList)
    arr(0) must be(2)
    arr(1) must be(3)
    arr.last must be(87)
  }

}
