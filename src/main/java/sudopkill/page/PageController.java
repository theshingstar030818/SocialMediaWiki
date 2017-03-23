package sudopkill.page;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.ui.Model;

import sudopkill.account.AccountService;

import java.util.List;

/**
 * Created by harisghauri on 3/9/2017.
 */

@Controller
public class PageController {


    @Autowired
    AccountService accountService;

    @Autowired
    PageRepository pageRepository;

    @Autowired
    PageService pageService;

    @ModelAttribute("module")
    String module() {
        return "page";
    }

    @RequestMapping(value = "/createPage", method = RequestMethod.GET)
    public String newPage(Model model){
        model.addAttribute("page", new Page());
        return "page/createPage";
    }

    @RequestMapping(value = "/createPage", method = RequestMethod.POST)
    public String createPage(@ModelAttribute Page page){
        return "page/page";
    }

    @RequestMapping(value = "/page/{pageId+1}/editPage", method = RequestMethod.POST)
    public String editPage(){return null;}

    @RequestMapping(value = "/page")
    public String page(){
        return "/page/page";
    }
}
