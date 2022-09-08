package domain

import java.util.{Calendar, Date}
import scala.xml.Node
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

case class News(
    val title: String,
    val url: String,
    val publishDate: LocalDateTime,
    val category: Option[Category],
    val state: State = Watching
)

object News {
  def read(news: News): News = {
    news.state match {
      case Watching => news.copy(state = Read)
      case _        => news
    }
  }

  def archived(news: News): News = {
    news.copy(state = Archived)
  }

  def apply(xmlNode: Node): News = {
    News(
      title = xmlNode.child(1).text,
      url = xmlNode.child(7).text,
      publishDate = LocalDateTime
        .parse(
          xmlNode.child(9).text,
          DateTimeFormatter.RFC_1123_DATE_TIME
        ),
      category = None
    )
  }
}

sealed abstract class Category
case object Sport extends Category
case object Economy extends Category
case object Technology extends Category

sealed abstract class State
case object Watching extends State
case object Read extends State
case object Archived extends State
