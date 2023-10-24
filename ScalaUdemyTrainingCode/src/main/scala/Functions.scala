object Functions {

  val someFunc: Int => (Int => Int) = x => {
    val another: Int => Int = y => x + y
    another
  }

  def nTimes(f: Int => Int, n: Int, x: Int): Int = {
    if (n <= 0) x
    else nTimes(f, n-1, f(x))
  }

  def plusOne(x: Int): Int = {
    x + 1
  }

  def nTimesBetter(f: Int => Int, n: Int): (Int => Int) = {
    if (n <= 0) (x: Int) => x
    else (x: Int) => nTimesBetter(f, n-1)(f(x))
  }

  def main(args: Array[String]): Unit = {
  println(nTimesBetter(plusOne, 10)(1))
  }
}
