package sudopkill.signin;

/**
 * Created by tanzeelrana on 3/4/2017.
 */
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class SigninController {

    @GetMapping("signin")
    public String signin(Principal principal) {
        if(principal != null){
            System.out.println("This got called A");
            return "home/homeSignedIn";
        }else{
            System.out.println("This got called B");
            return "signin/signin";
        }
    }
}