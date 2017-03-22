package sudopkill.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.security.Principal;

/**
 * Created by tanzeelrana on 3/10/2017.
 */

@Controller
public class AccountController {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    AccountService accountService;

    @ModelAttribute("module")
    String module() {
        return "account";
    }


    @RequestMapping(value = "/account/{userId}", method = RequestMethod.GET)
    String user(Principal principal, @PathVariable int userId, Model model) {
        System.out.println("userId : " + userId);
        Account user = accountRepository.findOneById(userId);
        model.addAttribute("id", userId);
        model.addAttribute("user", user);
        model.addAttribute("following",user.hasFollower(accountService.getCurrentUser()));
        model.addAttribute("tab","all");
        return "/account/account";
    }

    @RequestMapping(value = "/account/{userId}/followers")
    String followers(Principal principal, @PathVariable int userId, Model model){
        Account user = accountRepository.findOneById(userId);


        model.addAttribute("id", userId);
        model.addAttribute("user", user);
        model.addAttribute("following",user.hasFollower(accountService.getCurrentUser()));
        model.addAttribute("tab","followers");
        System.out.println("need to show all the followers for the user id : " + userId);
        return "/account/account";
    }

    @RequestMapping(value = "/account/{userId}/following")
    String following(Principal principal, @PathVariable int userId, Model model){
        Account user = accountRepository.findOneById(userId);


        model.addAttribute("id", userId);
        model.addAttribute("user", user);
        model.addAttribute("following",user.hasFollower(accountService.getCurrentUser()));
        model.addAttribute("tab","following");
        System.out.println("need to show all the following for the user id : " + userId);
        return "/account/account";
    }

    @RequestMapping(value = "/account/{userId}/pages")
    String pages(Principal principal, @PathVariable int userId, Model model){
        Account user = accountRepository.findOneById(userId);
        model.addAttribute("id", userId);
        model.addAttribute("user", user);
        model.addAttribute("following",user.hasFollower(accountService.getCurrentUser()));
        model.addAttribute("tab","pages");
        System.out.println("need to show all the pages for the user id : " + userId);
        return "/account/account";
    }

    @RequestMapping(value = "/account/{userId}/likes")
    String likes(Principal principal, @PathVariable int userId, Model model){
        Account user = accountRepository.findOneById(userId);
        model.addAttribute("id", userId);
        model.addAttribute("user", user);
        model.addAttribute("following",user.hasFollower(accountService.getCurrentUser()));
        model.addAttribute("tab","likes");
        System.out.println("need to show all the likes for the user id : " + userId);
        return "/account/account";
    }

    @RequestMapping(value = "/account/{userId}/follow")
    String follow(Principal principal, @PathVariable int userId, Model model){
        Account user = accountRepository.findOneById(userId);
        model.addAttribute("id", userId);
        model.addAttribute("user", user);
        user.addMyFollower(accountService.getCurrentUser());
        accountService.getCurrentUser().addMyFollowing(user);
        accountService.update(user);
        model.addAttribute("following",user.hasFollower(accountService.getCurrentUser()));
        return "redirect:/account/" + userId ;
    }

    @RequestMapping(value = "/account/{userId}/unfollow")
    String unfollow(Principal principal, @PathVariable int userId, Model model){
        Account user = accountRepository.findOneById(userId);
        model.addAttribute("id", userId);
        model.addAttribute("user", user);
        user.removeMyFollower(accountService.getCurrentUser());
        accountService.getCurrentUser().removeMyFollowing(user);
        accountService.update(user);
        model.addAttribute("following",user.hasFollower(accountService.getCurrentUser()));
        return "redirect:/account/" + userId ;
    }

//    @RequestMapping(value = "/account/{userId}/update", method = RequestMethod.PUT)
//    public String saveUpdate(@PathVariable int userId, @ModelAttribute("user") Account user) {
//        accountService.update(user);
//        return "redirect:/account/" + userId;
//    }
}
