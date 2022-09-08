import domain._
object MainProgram extends App {
  import scalaj.http._
  val response: String = Http(
    "http://feeds.bbci.co.uk/news/rss.xml"
  ).asString.body

  import scala.xml.{XML, Elem, NodeSeq, Node}
  val elements: Elem = XML.loadString(response)
  val nodeSeq: NodeSeq = elements \\ "channel" \\ "item"
  val headlines = for { node <- nodeSeq } yield News(node)

  headlines.foreach(println(_))
}
