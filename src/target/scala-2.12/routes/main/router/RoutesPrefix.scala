// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/steve/git/primitive-web/primitive-web/conf/routes
// @DATE:Mon Jan 14 14:44:45 EST 2019


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
