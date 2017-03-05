package sudopkill.signin;

/**
 * Created by tanzeelrana on 3/4/2017.
 */
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
public class SigninController {

    @GetMapping("signin")
    public String signin(Principal principal) {
        System.out.println("principal : " + principal);
        if(principal != null){
            return "/";
        }else {
            return "signin/signin";
        }
    }

    @PostMapping("signin")
    public String signin() {
        return "signin/signin";
    }
}