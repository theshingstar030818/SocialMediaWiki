package sudopkill.page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Created by harisghauri on 3/9/2017.
 */

@Service
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class PageService {

    @PostConstruct
    protected void initialize() {
//        save(new Page("BlankTest", "Test", null, null));
    }

    @Autowired
    private PageRepository pageRepository;

    @Transactional
    public Page save(Page page) {
        pageRepository.save(page);
        return page;
    }

    @Transactional
    public void deletePage(Page page) {
        pageRepository.delete(page);
    }

    public Page getPage(Long id){
        Page page = pageRepository.findOneById(id);
        return page;
    }

    public List<Page> getAllPages(){
        List<Page> pages = pageRepository.findAll();
        return pages;
    }

}
