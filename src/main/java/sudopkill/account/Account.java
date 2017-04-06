package sudopkill.account;

/**
 * Created by tanzeelrana on 3/5/2017.
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import sudopkill.AuthProvider.AuthProvider;
import sudopkill.page.Page;
import javax.persistence.*;
import java.sql.Date;
import java.time.Instant;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("serial")
@Entity
@Table(name = "ACCOUNT")
@Inheritance
@Access(AccessType.FIELD)
public class Account implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;

    @Column(unique = true)
    public String email;

    @Column(unique = true)
    public String username;

    @JsonIgnore
    private String password;
    @Column(nullable = false)
    public String authProvider;
    public String about = "";
    public String name = "";
    public String profilePicture = "http://ec2-52-11-47-52.us-west-2.compute.amazonaws.com/moodle/theme/image.php/clean/core/1475717594/u/f1";
    public String role = "ROLE_USER";
    public Instant created = Instant.now();
    public Date created_at = new Date((Calendar.getInstance().getTime()).getTime());

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private Set<Page> myPages;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Page> myLikes;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Account> myFollowers;

    @ManyToMany(mappedBy = "myFollowers", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Account> myFollowing;

   // private int numFollowers;

    public Account() {}

    public Account(String email, String username, String password, String role, String authProvider) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.role = role;
        this.authProvider = authProvider;

        myFollowers = new HashSet<>();
        myFollowing = new HashSet<>();
        myLikes = new HashSet<>();
        myPages = new HashSet<>();

        if(authProvider == AuthProvider.LOCAL.toString()){
            this.name = username;
        }
    }

    public Set<Page> getMyPages() {
        return myPages;
    }

    public Set<Page> getMyLikes() {
        return myLikes;
    }

    public Set<Account> getMyFollowers() {
        return myFollowers;
    }

    public void setMyFollowers(Set<Account> myFollowers) {
        this.myFollowers = myFollowers;
    }

    public Set<Account> getMyFollowing(){
        return this.myFollowing;
    }

    public void setMyFollowing(Set<Account> myFollowing) {
        this.myFollowing = myFollowing;
    }

    public void addMyFollower(Account account){
        this.myFollowers.add(account);
    }

    public void removeMyFollower(Account account){
        this.myFollowers.remove(account);
    }

    public void addMyFollowing(Account account){
        this.myFollowing.add(account);
    }

    public void removeMyFollowing(Account account){
        this.myFollowing.remove(account);
    }

    public boolean hasFollower(Account account){ return this.myFollowers.contains(account); }

    public void setAuthProvider(String authProvider) {
        this.authProvider = authProvider;
    }

    public int getId() {
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

    public void setMyPages(Set<Page> myPages) {
        this.myPages = myPages;
    }

    public void setMyLikes(Set<Page> myLikes) {
        this.myLikes = myLikes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public void addMyPages(Page page){
        this.myPages.add(page);
    }

    public void addMyLikes(Page page){
        this.myLikes.add(page);
    }

    public void removeMyPages(Page page){
        this.myPages.remove(page);
    }

    public void removeMyLikes(Page page){
        this.myLikes.remove(page);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object obj) {

        if (obj == null) {
            return false;
        }
        if (!Account.class.isAssignableFrom(obj.getClass())) {
            return false;
        }
        final Account other = (Account) obj;
        if (this.id != (other.getId())) {
            return false;
        }
        if (this.id != other.getId()) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return getId();
    }
}