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
        page.setAuthor(accountService.getCurrentUser());
        page = pageRepository.save(page);
        return "redirect:/page";
    }

    @RequestMapping(value = "/createChildPage", method = RequestMethod.POST)
    public String createChildPage(@ModelAttribute Page page){
        page.setAuthor(accountService.getCurrentUser());
        page = pageRepository.save(page);
        return "redirect:/page";
    }

//    @RequestMapping(value = "/page/{pageId+1}/editPage", method = RequestMethod.POST)
//    public String editPage(){return null;}

    @RequestMapping(value = "/page")
    public String page(){
        return "/page/page";
    }

    @RequestMapping(value ="/page/deletePage/{pageId}", method = RequestMethod.GET)
    public String deletePage(@PathVariable Long pageId){
        pageRepository.delete(pageId);
        return "redirect:/page";
    }

    @RequestMapping(value ="/page/editPage/{pageId}", method = RequestMethod.GET)
    public String editPage(Model model, @PathVariable Long pageId){
        Page page = pageRepository.findOneById(pageId);
        model.addAttribute("page", page);
        return "page/editPage";
    }

    @RequestMapping(value ="/page/viewPage/{pageId}", method = RequestMethod.GET)
    public String viewPage(Model model, @PathVariable Long pageId){
        Page page = pageRepository.findOneById(pageId);
        model.addAttribute("page", page);
        return "page/viewPage";
    }

}
