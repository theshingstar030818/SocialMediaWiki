package sudopkill.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

/**
 * Created by tanzeelrana on 3/4/2017.
 */

@Controller
public class HomeController {

    @GetMapping(value = {"/","/home"})
    String index(Principal principal) {
        System.out.println("principal : " + principal);
        return principal != null ? "home/homeSignedIn" : "home/homeNotSignedIn";
    }

}
