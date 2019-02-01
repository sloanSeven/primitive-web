// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/steve/git/primitive-web/conf/routes
// @DATE:Tue Jan 29 13:13:03 EST 2019

package shared.controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final shared.controllers.ReverseSimpleController SimpleController = new shared.controllers.ReverseSimpleController(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final shared.controllers.javascript.ReverseSimpleController SimpleController = new shared.controllers.javascript.ReverseSimpleController(RoutesPrefix.byNamePrefix());
  }

}
