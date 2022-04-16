val people = List("Bill", "Candy", "Roof", "Tik")
val ints = List(1, 2, 3, 4, 5)
val strings = List("a", "b", "c", "d", "e")
val (a, b) = ("a", 1)
val newInts = for { i <- ints } yield i + 1

val pairs = for {
  a <- strings
  b <- ints
} yield (a, b)

val lengths = for {
  i <- people
  if i.length() > 3
} yield i

for (p <- people) println(p)
people.foreach(p => println(p))

val x = 42
if (x < 0) {
  println("negative")
} else if (x == 0) {
  println("zero")
} else {
  println("positive")
}
