object AnonClasses {
  def main(args: Array[String]): Unit = {
    abstract class Animal {
      def eat: Unit
    }
    // anonymous class
    // class AnonClasses$$anon$1 extends Animal {
    val funAnimal: Animal = new Animal{
      override def eat: Unit = println("HAHA")
    }
    println(funAnimal.getClass)
  }
}
