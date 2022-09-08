import scalaj.http._
import scala.xml.{XML, Elem, NodeSeq, Node}
import domain._
import java.time.format.DateTimeFormatter
import java.time.LocalDateTime
object MainProgram extends App {
  val response: String = Http(
    "http://feeds.bbci.co.uk/news/rss.xml"
  ).asString.body
  val elements:Elem = XML.loadString(response)
  val items: NodeSeq = elements \\ "channel" \\ "item"
  val headlines = for {
    item <- items
  } yield (
    News(
      title = item.child(1).text,
      url = item.child(7).text,
      publishDate = LocalDateTime
        .parse(
          item.child(9).text,
          DateTimeFormatter.RFC_1123_DATE_TIME
        ),
      category = None
    )
  )
  headlines.foreach(println(_))
}
