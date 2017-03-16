package sudopkill.signup;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.context.annotation.PropertySource;
import sudopkill.account.Account;
import sudopkill.AuthProvider.AuthProvider;

/**
 * Created by tanzeelrana on 3/4/2017.
 */
@PropertySource("classpath:messages.properties")
public class SignupForm {

    private static final String NOT_BLANK_MESSAGE = "notBlank.message";
    private static final String EMAIL_MESSAGE = "email.message";
    private static final String EMAIL_EXISTS_MESSAGE = "email-exists.message";
    private static final String USERNAME_EXISTS_MESSAGE = "username-exists.message";

    @NotBlank(message = SignupForm.NOT_BLANK_MESSAGE)
    @Email(message = SignupForm.EMAIL_MESSAGE)
    @EmailExists(message = SignupForm.EMAIL_EXISTS_MESSAGE)
    private String email;

    @NotBlank(message = SignupForm.NOT_BLANK_MESSAGE)
    @UsernameExists(message = SignupForm.USERNAME_EXISTS_MESSAGE)
    private String username;

    @NotBlank(message = SignupForm.NOT_BLANK_MESSAGE)
    private String password;

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

    public Account createAccount() {
        return new Account(getEmail(), getUsername(), getPassword(), "ROLE_USER", AuthProvider.LOCAL.toString());
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}