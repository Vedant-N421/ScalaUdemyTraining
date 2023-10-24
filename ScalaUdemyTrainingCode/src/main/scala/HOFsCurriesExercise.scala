object HOFsCurriesExercise {
  def main(args: Array[String]): Unit = {
    def toCurry[A](f: (A, A) => A): A => A => A = {
      x => y => f(x, y)
    }
    def fromCurry[A](f: A => A => A): (A, A) => A = {
      (x, y) => f(x)(y)
    }
    def compose[A, B, T](f: B => A, g: T => B): T => A = {
      x => f(g(x))
    }
    def andThen[A, B, T](f: A => A, g: A => A): A => A = {
      x => g(f(x))
    }
    val numbers = List(1, 2, 3, 4)
    val chars = List('a', 'b', 'c', 'd')

    val combo = numbers.flatMap(n => chars.map(c => "" + c + n))

    println(combo)

  }
}
