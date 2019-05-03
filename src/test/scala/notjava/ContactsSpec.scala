package notjava

import org.scalatest.{FlatSpec, MustMatchers}

class ContactsSpec extends FlatSpec with MustMatchers {

  "a" should "bn" in {
    val target = new Contacts
    val in = Array(
      Array("add", "hack"),
      Array("add", "hackerrank"),
      Array("find", "hac"),
      Array("find", "hak")
    )

    val res = target.contacts(in).toList
    res.sameElements(0 :: 2 :: Nil) must be(true)
  }

}
