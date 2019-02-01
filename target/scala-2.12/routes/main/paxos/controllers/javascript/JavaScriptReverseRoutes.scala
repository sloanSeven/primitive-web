// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/steve/git/primitive-web/conf/routes
// @DATE:Tue Jan 29 13:13:03 EST 2019

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:10
package paxos.controllers.javascript {

  // @LINE:10
  class ReversePaxosController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:10
    def store: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "paxos.controllers.PaxosController.store",
      """
        function(message0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "store/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("message", message0))})
        }
      """
    )
  
    // @LINE:11
    def get: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "paxos.controllers.PaxosController.get",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "get/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
  }


}
