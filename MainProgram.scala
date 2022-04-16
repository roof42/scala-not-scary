import scalaj.http._
import scala.xml.XML
object MainProgram extends App {
  val response: HttpResponse[String] = Http(
    "http://feeds.bbci.co.uk/news/rss.xml"
  ).asString
  val elements = XML.loadString(response.body)
  val nodes = elements \\ "channel" \\ "title"
  // val titles = for {
  //   node <- nodes
  //   if node.text.toLowerCase().contains("ukraine")
  // } yield node.text

  val titles = nodes
    .filter(node => node.text.toLowerCase().contains("ukraine"))
    .map(node => node.text)
  titles.foreach(title => println(title))
}
