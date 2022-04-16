object Count {
  def fizzBuzz(value: Int): String = {
    if ((value % 3 == 0) && (value % 5 == 0)) {
      "FizzBuzz"
    } else if (value % 3 == 0) {
      "Fizz"
    } else if (value % 5 == 0) {
      "Buzz"
    } else {
      value.toString()
    }
  }

  def patternMatchingFizzBuzz(value: Int): String = {
    val (f, b) = ((value % 3 == 0), (value % 5 == 0))
    (f, b) match {
      case (true, true)  => "FizzBuzz"
      case (true, false) => "Fizz"
      case (false, true) => "Buzz"
      case _             => value.toString()
    }
  }

  def patternMatchingFizzBuzz1(value: Int): String = {
    // val t = ((value % 3 == 0), (value % 5 == 0))
    ((value % 3 == 0), (value % 5 == 0)) match {
      case (true, true)  => "FizzBuzz"
      case (true, false) => "Fizz"
      case (false, true) => "Buzz"
      case _             => value.toString()
    }
  }
}

Count.fizzBuzz(3)
Count.fizzBuzz(5)
Count.fizzBuzz(15)
Count.fizzBuzz(1)

Count.patternMatchingFizzBuzz(5)

Count.patternMatchingFizzBuzz1(8)
