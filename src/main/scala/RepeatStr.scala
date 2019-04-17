class RepeatStr {
  def repeatedString(s: String, n: Long): Long = {
    if (s.length > n) {
      s.substring(0, n.toInt).count(c => c == 'a')
    } else {
      val times = n / s.length
      val last = n % s.length
      val theLast = s.substring(0, last.toInt).count(c => c == 'a')
      (s.count(c => c == 'a').toLong * times) + theLast.toLong
    }
  }
}
