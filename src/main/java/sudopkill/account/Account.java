package sudopkill.account;

/**
 * Created by tanzeelrana on 3/5/2017.
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import sudopkill.page.Page;
import sudopkill.AuthProvider.AuthProvider;

import javax.persistence.*;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("serial")
@Entity
@Table(name = "ACCOUNT")
public class Account implements java.io.Serializable {

    @Id
    @GeneratedValue
    private Long id;
    @Column(unique = true)
    private String email;
    @JsonIgnore
    private String password;
    private String role = "ROLE_USER";
    private Instant created;

    @Column(nullable = false)
    private String authProvider;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Page> myPages;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Page> myLikes;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Account> following;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Account> followers;

    protected Account() {}

    public Account(String email, String password, String role, AuthProvider authProvider) {
        this.email = email;
        this.password = password;
        this.role = role;
        this.created = Instant.now();
        this.authProvider = authProvider.toString();
        this.myPages = new HashSet<>();
        this.myLikes = new HashSet<>();
        this.following = new HashSet<>();
        this.followers = new HashSet<>();
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Instant getCreated() {
        return created;
    }

    public String getAuthProvider() {
        return authProvider;
    }

    public Set<Page> getMyPages() {
        return myPages;
    }

    public Set<Page> getMyLikes() {
        return myLikes;
    }

    public Set<Account> getFollowing() {
        return following;
    }

    public Set<Account> getFollowers() {
        return followers;
    }

    public void setAuthProvider(String authProvider) {
        this.authProvider = authProvider;
    }

    public void setMyPages(Set<Page> myPages) {
        this.myPages = myPages;
    }

    public void setMyLikes(Set<Page> myLikes) {
        this.myLikes = myLikes;
    }

    public void setFollowing(Set<Account> following) {
        this.following = following;
    }

    public void setFollowers(Set<Account> followers) {
        this.followers = followers;
    }
}