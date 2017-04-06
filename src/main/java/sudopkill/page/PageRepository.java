package sudopkill.page;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sudopkill.account.Account;

import java.util.List;

/**
 * Created by harisghauri on 3/9/2017.
 */

@Repository
public interface PageRepository extends JpaRepository<Page, Long> {


    Page findOneById(Long id);
    @Query("select count(a) > 0 from Page a where a.id = :id")
    boolean exists(@Param("id") Long id);

    Page findOneByTitle(String title);
    @Query("select count(a) > 0 from Page a where a.title = :title")
    boolean exists(@Param("title") String title);


    @Query("select p from Page p order by p.likes.size desc")
    List<Page> sortByMostLiked();

   // @Query("select p from Page p order by p.created desc")
   // List<Page> sortByMostRecent();
}
