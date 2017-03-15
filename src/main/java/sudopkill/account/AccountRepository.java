package sudopkill.account;

/**
 * Created by tanzeelrana on 3/5/2017.
 */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    Account findOneById(String id);
    @Query("select count(a) > 0 from Account a where a.id = :id")
    boolean idExists(@Param("id") String id);

    Account findOneByEmail(String email);
    @Query("select count(a) > 0 from Account a where a.email = :email")
    boolean exists(@Param("email") String email);

}