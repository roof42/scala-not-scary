abstract class State
case object Todo extends State
case object Doing extends State
case object Done extends State

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

val t1 = Task(0, "buy banana")
val t2 = Task.next(t1)
val t3 = Task.next(t2)

import scala.collection.mutable.Map
val todoList: Map[Int, Task] = Map.empty[Int, Task]
todoList.addOne(0 -> t1)
todoList.addOne(1 -> t2)
todoList.keys.sum
todoList.values
