package sudopkill.signin;

/**
 * Created by tanzeelrana on 3/4/2017.
 */
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SigninController {

    @GetMapping("signin")
    public String signin() {
        return "signin/signin";
    }
}