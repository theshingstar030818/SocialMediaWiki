package sudopkill.page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

/**
 * Created by harisghauri on 3/9/2017.
 */

@Controller
public class PageController {

    private final PageRepository pageRepository;

    public PageController(PageRepository pageRepository) {
        this.pageRepository = pageRepository;
    }

    @GetMapping("page/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public Page page(@PathVariable("id") Long id) {
        return pageRepository.findOne(id);
    }

    @GetMapping("page")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Page> pages() {
        return pageRepository.findAll();
    }
}
