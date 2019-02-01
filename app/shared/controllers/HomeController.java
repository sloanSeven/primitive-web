package shared.controllers;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;

import com.google.common.hash.Hashing;

import play.mvc.Controller;
import play.mvc.Result;

/**
 * This controller contains an action to handle HTTP requests to the
 * application's home page.
 */
public class HomeController extends Controller {

	/**
	 * An action that renders an HTML page with a welcome message. The configuration
	 * in the <code>routes</code> file means that this method will be called when
	 * the application receives a <code>GET</code> request with a path of
	 * <code>/</code>.
	 */

	HashMap<String, String> map = new HashMap<>();

	public Result index() {
		return ok(views.html.index.render());
	}


	public Result store(String message) {
		String sha256hex = Hashing.sha256().hashString(message, StandardCharsets.UTF_8).toString();
		map.put(sha256hex, message);
		return ok(sha256hex);
	}

	public Result get(String sha256hex) {
		if (!map.containsKey(sha256hex)) {
			return status(333, "not found");
		}
		final String message = map.get(sha256hex);
		return ok(message);
	}

}
