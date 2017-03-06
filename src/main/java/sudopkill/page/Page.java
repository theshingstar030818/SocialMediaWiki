package sudopkill.page;

import sudopkill.account.Account;

import javax.persistence.*;
import java.time.Instant;
import java.util.Set;

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

    private String title;
    private String content;
    private Account author;
    private Instant created;

    @ManyToOne
    private Page parent;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "parent")
    private Set<Page> childNodes;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Account> likes;

}
