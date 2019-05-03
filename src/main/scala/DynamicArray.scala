import scala.collection.mutable

class DynamicArray {
  def dynamicArray(n: Int, queries: Array[Array[Int]]): Array[Int] = {
    var lastAnswer = 0
    val seqs = Array.fill(10)(mutable.MutableList[Int]())
    val result = mutable.MutableList[Int]()
    queries.foreach {
      case Array(1, x, y) => seqs((x ^ lastAnswer) % n) += y
      case Array(2, x, y) =>
        val seq = seqs((x ^ lastAnswer) % n)
        lastAnswer = seq(y % seq.length)
        result += lastAnswer
        println(lastAnswer)
    }
    result.toArray
  }
}
