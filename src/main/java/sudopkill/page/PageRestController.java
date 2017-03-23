package sudopkill.page;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by markpineda on 2017-03-23.
 */
@RestController
public class PageRestController {

    private final PageRepository pageRepository;

    public PageRestController(PageRepository pageRepository) {
        this.pageRepository = pageRepository;
    }

    @GetMapping("api/page/{pageId}")
    @ResponseStatus(value = HttpStatus.OK)
    public Page page(@PathVariable("id") Long id) {
        return this.pageRepository.findOne(id);
    }

    @GetMapping("api/page")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Page> pages() {
        return this.pageRepository.findAll();
    }

}
