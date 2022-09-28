package example

import org.scalajs.dom

import be.doeraene.webcomponents.ui5.*
import be.doeraene.webcomponents.ui5.configkeys.*
import com.raquo.laminar.api.L.*

////////////////////////////////////////////// Main

object MyApp:
  val myComponent =
    div(
      Input(
        _.required := true,
        _.valueState := ValueState.Information,
        _.placeholder := "Enter your name",
        onChange.mapToValue --> Observer(println)
      )
    )
      
  def main(args: Array[String]): Unit =
    val _ = documentEvents.onDomContentLoaded.foreach { _ =>
      val appContainer = dom.document.querySelector("#app")
      appContainer.innerHTML = ""
      val _            = render(appContainer, myComponent)
    }(unsafeWindowOwner)
