package sudopkill.page;


import com.sun.javafx.sg.prism.NGShape;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.ui.Model;

import sudopkill.account.Account;
import sudopkill.account.AccountService;

import java.util.ArrayList;
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

    @RequestMapping(value = "/page/{pageId+1}/editPage", method = RequestMethod.POST)
    public String editPage(){return null;}

    @RequestMapping(value = "/page")
    public String page(Model model){
        model.addAttribute("accountService", accountService);
        ArrayList<Page> pages = new ArrayList<Page>(pageRepository.findAll());
        model.addAttribute("pages", pages);
        return "/page/page";
    }



    @RequestMapping(value = "/page/sort/{sortType}")
    public String sort(Model model, @PathVariable String sortType){

        switch (sortType){
            case "mostLiked":
                //do blah
                System.out.println("Sort by most liked");
                break;
            case "mostRecent":
                //do blah
                System.out.println("Sort by most recent");
                break;
            default:
                break;
        }

        ArrayList<Page> pages = new ArrayList<Page>(pageRepository.findAll());
        model.addAttribute("pages", pages);
        return "/page/page";
    }


    @RequestMapping(value ="/page/deletePage/{pageId}", method = RequestMethod.GET)
    String deletePage(@PathVariable Long pageId){
        pageRepository.delete(pageId);
        return "redirect:/page";
    }




}
