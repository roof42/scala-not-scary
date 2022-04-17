import java.util.{Calendar, Date}

object Category extends scala.Enumeration {
  type Category = Value
  val Sport, Economy, Technology = Value
}

object State extends scala.Enumeration {
  type State = Value
  val Watching, Read, Archived = Value
}

import Category._
import State._
class News(
    val title: String,
    val url: String,
    val publishDate: Date,
    val category: Option[Category],
    var state: State = State.Watching
)
object News {
  def read(news: News): News = {
    news.state match {
      case State.Watching => {
        news.state = State.Read
        news
      }
      case _ => news
    }
  }
  def moveToArchived(news: News): News = {
    news.state = State.Archived
    news
  }
}

val a = new News(
  title = "Bitcoin hit new high",
  url = "http://somewebsite.com/news/economic/123455",
  publishDate = Calendar.getInstance().getTime(),
  category = Some(Category.Economy)
)
val c = News.read(a)
c.state
News.read(c)
c.state
val b = News.moveToArchived(a)
b.state
