package sudopkill.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by tanzeelrana on 3/10/2017.
 */

@Controller
public class AccountController {

    @Autowired
    AccountRepository accountRepository;

    @ModelAttribute("module")
    String module() {
        return "account";
    }

    @RequestMapping(value = "/account", method = RequestMethod.GET)
    String user(Principal principal, @RequestParam("id") String id, Model model) {
        Account user = accountRepository.findOneById(id);
        model.addAttribute("id", id);
        model.addAttribute("user", user);
        return "/account/account";
    }
}
