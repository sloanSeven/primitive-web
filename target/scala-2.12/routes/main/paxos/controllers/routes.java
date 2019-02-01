// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/steve/git/primitive-web/conf/routes
// @DATE:Tue Jan 29 13:13:03 EST 2019

package paxos.controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final paxos.controllers.ReversePaxosController PaxosController = new paxos.controllers.ReversePaxosController(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final paxos.controllers.javascript.ReversePaxosController PaxosController = new paxos.controllers.javascript.ReversePaxosController(RoutesPrefix.byNamePrefix());
  }

}
