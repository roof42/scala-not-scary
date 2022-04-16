//Thing
abstract class Thing {
  def doSomething(value: String): String
  def doItHere() = s"do it here"
}
//Behavior
trait Identifiable {
  val id: Int
  def identifier()
  def detail() = ""
}

object Person {
  def doSomething(v: String) = s"$v"
  def apply(name: String, age: Int) = new Person(0, name, age)
}

class Person(val id: Int, val name: String = "", val age: Int = 0)
    extends Thing
    with Identifiable {

  println("default constructor")

  def identifier() = ???
  def getName() = { name }
  def doSomething(value: String): String = s"$value - $name"
  def apply(some: String) = s"$name - $some"
  def appy(a: String, b: String) = ???
  def \\(name: String) = s"some method $name"
  def unary_!() = s"unary method"
  def +:(word: String) = s"$word $name"
}
