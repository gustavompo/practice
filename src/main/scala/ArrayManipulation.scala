import scala.io.Source

class ArrayManipulation {

  def arrayManipulation(n: Int, queries: Array[Array[Int]]): Long = {
    var max = Long.MinValue
    val arr = Array.fill(n)(0L)
    queries.foreach {
      case Array(st, end, add) => for (i <- st-1 until end){
        arr(i) = arr(i) + add
        max = if(arr(i) > max) arr(i) else max
      }



    }
    max

  }

}
