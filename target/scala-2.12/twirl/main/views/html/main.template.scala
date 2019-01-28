
package views.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import java.lang._
import java.util._
import scala.collection.JavaConverters._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._
import play.data._
import play.core.j.PlayFormsMagicForJava._

object main extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[String,Html,play.twirl.api.HtmlFormat.Appendable] {

  /*
 * This template is called from the `index` template. This template
 * handles the rendering of the page header and body tags. It takes
 * two arguments, a `String` for the title of the page and an `Html`
 * object to insert into the body of the page.
 */
  def apply/*7.2*/(title: String)(content: Html):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*8.1*/("""
"""),format.raw/*9.1*/("""<!DOCTYPE html>
<html lang="en">
    <head>
    <meta http-equiv="Content-Security-Policy: script-src 'self' https://maps.googleapis.com/maps/ap">
    
        """),format.raw/*14.62*/("""
        """),format.raw/*15.9*/("""<title>"""),_display_(/*15.17*/title),format.raw/*15.22*/("""</title>
        <link rel="stylesheet" media="screen" href=""""),_display_(/*16.54*/routes/*16.60*/.Assets.versioned("stylesheets/main.css")),format.raw/*16.101*/("""">
        <link rel="shortcut icon" type="image/png" href=""""),_display_(/*17.59*/routes/*17.65*/.Assets.versioned("images/favicon.png")),format.raw/*17.104*/("""">
        
    <meta charset="utf-8">
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
     <style>
      html """),format.raw/*22.12*/("""{"""),format.raw/*22.13*/(""" """),format.raw/*22.14*/("""height: 100% """),format.raw/*22.27*/("""}"""),format.raw/*22.28*/("""
      """),format.raw/*23.7*/("""body """),format.raw/*23.12*/("""{"""),format.raw/*23.13*/(""" """),format.raw/*23.14*/("""height: 100%; margin: 0; padding: 0; font-family:sans-serif; """),format.raw/*23.75*/("""}"""),format.raw/*23.76*/("""
      """),format.raw/*24.7*/("""#map-canvas """),format.raw/*24.19*/("""{"""),format.raw/*24.20*/(""" """),format.raw/*24.21*/("""height: 100% """),format.raw/*24.34*/("""}"""),format.raw/*24.35*/("""
      """),format.raw/*25.7*/("""h1 """),format.raw/*25.10*/("""{"""),format.raw/*25.11*/(""" """),format.raw/*25.12*/("""position:absolute; background:black; color:white; padding:10px; font-weight:200; z-index:10000;"""),format.raw/*25.107*/("""}"""),format.raw/*25.108*/("""
      """),format.raw/*26.7*/("""#all-examples-info """),format.raw/*26.26*/("""{"""),format.raw/*26.27*/(""" """),format.raw/*26.28*/("""position:absolute; background:white; font-size:16px; padding:20px; bottom:20px; width:350px; line-height:150%; border:1px solid rgba(0,0,0,.2);"""),format.raw/*26.171*/("""}"""),format.raw/*26.172*/("""
    """),format.raw/*27.5*/("""</style>
    <title>Googlemaps Heatmap Layer</title>
    <script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?sensor=false"></script>
    <script src=""""),_display_(/*30.19*/routes/*30.25*/.Assets.versioned("javascripts/build/heatmap.js")),format.raw/*30.74*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*31.19*/routes/*31.25*/.Assets.versioned("javascripts/plugins/gmaps-heatmap/gmaps-heatmap.js")),format.raw/*31.96*/("""" type="text/javascript"></script>
    
    </head>
    <body>
        """),format.raw/*36.32*/("""
        """),_display_(/*37.10*/content),format.raw/*37.17*/("""

    """),format.raw/*39.5*/("""<div id="map-canvas"></div>
    

        <script src=""""),_display_(/*42.23*/routes/*42.29*/.Assets.versioned("javascripts/main.js")),format.raw/*42.69*/("""" type="text/javascript"></script>
    </body>
</html>
"""))
      }
    }
  }

  def render(title:String,content:Html): play.twirl.api.HtmlFormat.Appendable = apply(title)(content)

  def f:((String) => (Html) => play.twirl.api.HtmlFormat.Appendable) = (title) => (content) => apply(title)(content)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Mon Jan 28 04:46:25 EST 2019
                  SOURCE: /Users/steve/git/primitive-web/app/views/main.scala.html
                  HASH: 63044022deb5d67187b4980f6aa071836805c0cf
                  MATRIX: 1206->260|1330->291|1357->292|1545->505|1581->514|1616->522|1642->527|1731->589|1746->595|1809->636|1897->697|1912->703|1973->742|2139->880|2168->881|2197->882|2238->895|2267->896|2301->903|2334->908|2363->909|2392->910|2481->971|2510->972|2544->979|2584->991|2613->992|2642->993|2683->1006|2712->1007|2746->1014|2777->1017|2806->1018|2835->1019|2959->1114|2989->1115|3023->1122|3070->1141|3099->1142|3128->1143|3300->1286|3330->1287|3362->1292|3564->1467|3579->1473|3649->1522|3729->1575|3744->1581|3836->1652|3935->1813|3972->1823|4000->1830|4033->1836|4116->1892|4131->1898|4192->1938
                  LINES: 33->7|38->8|39->9|44->14|45->15|45->15|45->15|46->16|46->16|46->16|47->17|47->17|47->17|52->22|52->22|52->22|52->22|52->22|53->23|53->23|53->23|53->23|53->23|53->23|54->24|54->24|54->24|54->24|54->24|54->24|55->25|55->25|55->25|55->25|55->25|55->25|56->26|56->26|56->26|56->26|56->26|56->26|57->27|60->30|60->30|60->30|61->31|61->31|61->31|65->36|66->37|66->37|68->39|71->42|71->42|71->42
                  -- GENERATED --
              */
          