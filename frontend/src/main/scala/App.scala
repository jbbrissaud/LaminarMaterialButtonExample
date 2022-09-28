package example

import com.raquo.laminar.api.L._
import org.scalajs.dom

import com.github.uosis.laminar.webcomponents.material._

////////////////////////////////////////////// Main

val myComponent =
  div(
    Button()
  )
    
object MyApp:
  def main(args: Array[String]): Unit =
    val _ = documentEvents.onDomContentLoaded.foreach { _ =>
      val appContainer = dom.document.querySelector("#app")
      appContainer.innerHTML = ""
      val _            = render(appContainer, myComponent)
    }(unsafeWindowOwner)
    //test()

////////////////////////////////////////////// Test

  def test() =
    ???
