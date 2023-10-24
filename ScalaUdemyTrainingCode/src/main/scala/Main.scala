object Main {
  trait MyPredicate[-T] {
    def test(x: T): Boolean
  }

  trait MyTransformer[-A, B] {
    def transform(x: A, y: B): B
  }

  abstract class MyList[+A]{
    def map[B](transformer: MyTransformer[A, B]): MyList[B]
    def filter(predicate: MyPredicate[A]): MyList[A]
    def flatMap[B](transformer: MyTransformer[A, MyList[B] ]): MyList[B]
  }

  def main(args: Array[String]): Unit = {

  }
}