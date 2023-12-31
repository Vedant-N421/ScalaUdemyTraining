object Maybe {
  abstract class Maybe[+T] {
    def map[B](f: T => B): Maybe[B]

    def flatMap[B](f: T => Maybe[B]): Maybe[B]

    def filter(p: T => Boolean): Maybe[T]
  }

  case object MaybeNot extends Maybe[Nothing] {
    def map[B](f: Nothing => B): Maybe[B] = MaybeNot

    def flatMap[B](f: Nothing => Maybe[B]): Maybe[B] = MaybeNot

    def filter(p: Nothing => Boolean): Maybe[Nothing] = MaybeNot
  }

  case class Just[+T](value: T) extends Maybe[T] {
    def map[B](f: T => B): Maybe[B] = Just(f(value))

    def flatMap[B](f: T => Maybe[B]): Maybe[B] = f(value)

    def filter(p: T => Boolean): Maybe[T] =
      if (p(value)) this
      else MaybeNot
  }

  def main(args: Array[String]): Unit = {
    val just4 = Just(4)
    println(just4)
    println(just4.map(_ * 5))
    println(just4.flatMap(x => Just(x % 2 == 0)))
    println(just4.filter(_ % 2 == 0))
  }
}
