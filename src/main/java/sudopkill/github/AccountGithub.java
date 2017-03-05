package sudopkill.github;

import sudopkill.account.Account;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

/**
 * Created by tanzeelrana on 3/5/2017.
 */

@SuppressWarnings("serial")
@Entity
@Table(name = "ACCOUNT_GITHUB")
public class AccountGithub extends Account implements java.io.Serializable{

    @Id
    @Column(unique = true)
    private int id;
    private String login;
    private String avatar_url;
    private String gravatar_id;
    @Column(unique = true)
    private String url;
    @Column(unique = true)
    private String html_url;
    private String followers_url;
    private String following_url;
    private String gists_url;
    private String starred_url;
    private String subscriptions_url;
    private String organizations_url;
    private String repos_url;
    private String events_url;
    private String received_events_url;
    private String type;
    private Boolean site_admin;
    private String name;
    private String company;
    private String blog;
    private String location;
    @Column(unique = true)
    private String email;
    private Boolean hireable;
    private String bio;
    private int public_repos;
    private int public_gists;
    private int followers;
    private int following;
    private Date created_at;
    private Date updated_at;
}
