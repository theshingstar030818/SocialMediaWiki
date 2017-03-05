package sudopkill.page;

import sudopkill.account.Account;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.ArrayList;

/*
 * Created by markpineda on 3/5/2017.
 *
 * Page in context of user created pages
 *
 */

@Entity
@Table(name = "PAGE")
public class Page {

    @Id
    @GeneratedValue
    private long id;

    //Page Creator
    private Account author;

    //Parent Page
    private Page parent;

    //Page Title
    private String title;

    //Page Content
    private String content;

    private long likes;

    //accounts who liked page
    private ArrayList<Account> accounts;

}
