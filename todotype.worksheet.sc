abstract class Task {
  val id: Int
  val detail: String
}

object Task {
  def next(t: Task): Task = {
    t match {
      case Todo(id, detail)  => Doing(id, detail)
      case Doing(id, detail) => Done(id, detail)
      case Done(id, detail)  => t
    }
  }
}

case class Todo(id: Int, detail: String) extends Task
case class Doing(id: Int, detail: String) extends Task
case class Done(id: Int, detail: String) extends Task

val t0 = Todo(0, "buy banana")
val t1 = Task.next(t0)
val t2 = Task.next(t1)
