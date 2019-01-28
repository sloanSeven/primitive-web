// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/steve/git/primitive-web/conf/routes
// @DATE:Mon Jan 28 04:47:11 EST 2019

package controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.ReverseSimpleController SimpleController = new controllers.ReverseSimpleController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseHomeController HomeController = new controllers.ReverseHomeController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseAssets Assets = new controllers.ReverseAssets(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.javascript.ReverseSimpleController SimpleController = new controllers.javascript.ReverseSimpleController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseHomeController HomeController = new controllers.javascript.ReverseHomeController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseAssets Assets = new controllers.javascript.ReverseAssets(RoutesPrefix.byNamePrefix());
  }

}
