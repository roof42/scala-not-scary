object State extends scala.Enumeration {
  type State = Value
  val Todo, Doing, Done = Value
}

import State._
case class Task(
    val id: Int = 0,
    val detail: String = "",
    val state: State = Todo
)

object Task {
  def next(task: Task) = {
    task.state match {
      case Todo  => task.copy(state = Doing)
      case Doing => task.copy(state = Done)
      case Done  => task
    }
  }
}

val t1 = new Task(0, "buy banana")
val t2 = Task.next(t1)
val t3 = Task.next(t2)
