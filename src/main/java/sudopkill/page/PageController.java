package sudopkill.page;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by harisghauri on 3/9/2017.
 */

@RestController
public class PageController {

    private final PageRepository pageRepository;

    public PageController(PageRepository pageRepository) {
        this.pageRepository = pageRepository;
    }

    @GetMapping("pages/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public Page page(@PathVariable("id") Long id) {
        return this.pageRepository.findOne(id);
    }

    @GetMapping("pages")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Page> pages() {
        return this.pageRepository.findAll();
    }
}
