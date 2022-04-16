import scala.collection.mutable.ArrayBuffer

val nums = (1 to 10).toList
nums.take(1)
nums.take(2)

val ex = nums.last
val elem = nums.lastOption
elem match {
  case Some(value) => println(value)
  case None        => println("Element doesn't exist")
}

nums.takeWhile(_ < 5) ++ nums.dropWhile(_ < 5)
nums.drop(4)
nums.dropWhile(_ < 5)

val list = List("b", "c")

"a" +: list
list :+ "d"
list

list(0)
list(1)

val v = Vector("b", "c")

"a" +: v
v :+ "d"
v

v(0)
v(1)

val am = ArrayBuffer[Int]()
am += 1
am += 2
