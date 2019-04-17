class TimeConversion {
  //07:05:45PM
  def timeConversion(s: String): String = {
    val r = "(\\d{2})\\:(\\d{2})\\:(\\d{2})(\\w{2})".r
    s match {
      case r("12", min, sec, "AM") => s"00:$min:$sec"
      case r("12", min, sec, "PM") => s"12:$min:$sec"
      case r(hour, min, sec, "AM") => s"$hour:$min:$sec"
      case r(hour, min, sec, "PM") => s"${hour.toInt + 12}:$min:$sec"
    }
  }
}
