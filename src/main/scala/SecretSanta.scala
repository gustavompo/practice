import scala.collection.mutable
import scala.util.Random

class SecretSanta {

  type NameAndEmail = (String, String)

  def solveIt(input: String): List[String] = {

    val nms: Array[NameAndEmail] = input.split("\n").map { l =>
      val nmEmail = l.split(",")
      (nmEmail(0), nmEmail(1))
    }
    val randomIxs: mutable.Seq[Int] = randomIndexes(nms.indices.toList)
    val nameAndEmailsRandomSorted = randomIxs.map(e => nms(e))

    val result = for {
      ix <- nameAndEmailsRandomSorted.indices
    } yield {
      if (ix == 0) {
        toAssignStr(nameAndEmailsRandomSorted.last, nameAndEmailsRandomSorted.head)
      } else {
        toAssignStr(nameAndEmailsRandomSorted(ix - 1), nameAndEmailsRandomSorted(ix))
      }
    }
    val a = "a" -> "b"
    result.toList
  }

  def toAssignStr(a: NameAndEmail, b: NameAndEmail): String = (a, b) match {
    case ((nm, _), (nm2, _)) => s"$nm -> $nm2"
  }


  def randomIndexes(nms: List[Int]): mutable.MutableList[Int] = {
    var indices = nms.indices.toList
    val randomIndexes = mutable.MutableList[Int]()
    while (indices.nonEmpty) {
      val r = if (indices.length == 1) 0 else Random.nextInt(indices.length - 1)
      val ix = indices(r)
      randomIndexes += ix
      indices = indices.filter(e => e != ix)
    }
    randomIndexes
  }
}



