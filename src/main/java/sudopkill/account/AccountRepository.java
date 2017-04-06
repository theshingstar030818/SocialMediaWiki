package sudopkill.account;

/**
 * Created by tanzeelrana on 3/5/2017.
 */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Sort;

import java.util.List;

@Repository
@Transactional
public interface AccountRepository extends JpaRepository<Account, Long> {

    Account findOneById(int id);
    @Query("select count(a) > 0 from Account a where a.id = :id")
    boolean idExists(@Param("id") int id);

    Account findOneByEmail(String email);
    @Query("select count(a) > 0 from Account a where a.email = :email")
    boolean existsEmail(@Param("email") String email);

    Account findOneByUsername(String username);
    @Query("select count(a) > 0 from Account a where a.username = :username")
    boolean existsUsername(@Param("username") String username);

    /*
    public List<Account> findAllByMyFollowers(){
        return Account.findAll(new Sort(Sort.Direction.ASC,"myFollowers"));
    }*/

    public List<Account> findAllByOrderByIdAsc();


    public List<Account> findAllByOrderByIdDesc();

//    @Query("select a from Account a ORDER BY COUNT(myfollowers) DESC")
//    List<Account> findAllByMyFollowers();

    @Query("select a from Account a order by a.myFollowers.size desc")
    List<Account> findAllByMyFollowers();




}