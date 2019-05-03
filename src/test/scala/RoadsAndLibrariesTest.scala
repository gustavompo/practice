import org.scalatest.{FlatSpec, MustMatchers}

class RoadsAndLibrariesTest extends FlatSpec with MustMatchers {
  "" should "" in {
    val target = new RoadsAndLibraries
    val citites = Array(
      Array(1, 2),
      Array(3, 1),
      Array(2, 3)
    )
    val res = target.roadsAndLibraries(0, 2, 1, citites)
    res must be(4)
  }
}
