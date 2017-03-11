package sudopkill.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

    @ModelAttribute("currentUser")
    Account module(Principal principal) {
        return accountRepository.findOneByEmail( principal.getName() );
    }

    @RequestMapping(value = "/account/{id}", method = RequestMethod.GET)
    String user(Principal principal, @PathVariable("id") Long id, Model model) {
        Account user = accountRepository.findOne(id);
        model.addAttribute("user", user);
        return "/account/account";
    }
}
