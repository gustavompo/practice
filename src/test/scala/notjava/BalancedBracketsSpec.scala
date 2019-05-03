package notjava

import org.scalatest.{FlatSpec, MustMatchers}

class BalancedBracketsSpec extends FlatSpec with MustMatchers{

  "a" should "bn" in {
    BalancedBrackets.isBalanced("{{[[(())]]}}") must be("YES")
  }

  "a" should "bnot" in {
    BalancedBrackets.isBalanced("{[(])}") must be("NO")
  }

  "c" should "NO" in {
    BalancedBrackets.isBalanced("{(([])[])[]}[]") must be("YES")
    BalancedBrackets.isBalanced("{{[[(())]]}}") must be("YES")
  }

}
