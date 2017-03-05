package sudopkill.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.security.Principal;

/**
 * Created by tanzeelrana on 3/4/2017.
 */

@Controller
public class HomeController {

    @ModelAttribute("module")
    String module() {
        return "home";
    }

    @GetMapping(value = {"/","/home"})
    String index(Principal principal) {
        return principal != null ? "home/homeSignedIn" : "home/homeNotSignedIn";
    }

}
