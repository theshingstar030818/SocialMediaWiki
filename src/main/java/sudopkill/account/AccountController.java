package sudopkill.account;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by tanzeelrana on 3/10/2017.
 */

@Controller
public class AccountController {

    @ModelAttribute("")
    String module() {
        return "";
    }

    @RequestMapping({"/account"})
    String current(Principal principal) {
        if(principal != null){
            Map<String, String> map = new LinkedHashMap<>();
            map.put("name", principal.getName());
            return "home/homeSignedIn";
        }else{
            return "home/homeNotSignedIn";
        }
    }
}
