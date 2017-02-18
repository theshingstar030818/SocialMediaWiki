package sudopkill.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * Created by tanzeelrana on 17/02/17.
 */
@Controller
class AboutController {

    @ModelAttribute("module")
    String module() {
        return "about";
    }

    @GetMapping("/about")
    String about() {
        System.out.println("views/home/about");
        return "home/about";
    }
}