// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/steve/git/primitive-web/conf/routes
// @DATE:Tue Jan 29 13:13:03 EST 2019

import play.api.mvc.Call


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:10
package paxos.controllers {

  // @LINE:10
  class ReversePaxosController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:10
    def store(message:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "store/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("message", message)))
    }
  
    // @LINE:11
    def get(id:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "get/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
  }


}
