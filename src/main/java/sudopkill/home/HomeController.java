package sudopkill.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by tanzeelrana on 3/4/2017.
 */

@Controller
public class HomeController {

    @ModelAttribute("module")
    String module() {
        return "home";
    }

    @RequestMapping({"/","/home", "/user", "/me"})
    String index(Principal principal) {
        System.out.println("principal :  " + principal);
        if(principal != null){

            Map<String, String> map = new LinkedHashMap<>();
            map.put("name", principal.getName());

            System.out.println("user name :  " + principal.getName());

            return "home/homeSignedIn";
        }else{
            return "home/homeNotSignedIn";
        }
    }
}
