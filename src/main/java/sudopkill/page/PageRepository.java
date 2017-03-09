package sudopkill.page;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by harisghauri on 3/9/2017.
 */

@Repository
public interface PageRepository extends JpaRepository<Page, Long> {

    Page findOneById(Long id);

    @Query("select count(a) > 0 from Page a where a.id = :id")
    boolean exists(@Param("id") Long id);
}
