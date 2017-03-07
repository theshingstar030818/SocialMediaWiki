package sudopkill.facebook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.User;
import org.springframework.social.facebook.api.impl.FacebookTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sudopkill.account.Account;
import sudopkill.account.AccountService;

/**
 * Created by tanzeelrana on 3/7/2017.
 */
@Service
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class FacebookAccountService{

    @Autowired
    private AccountService accountService;

    @Transactional(noRollbackFor = Exception.class)
    public Account getFacebookAccountService(OAuth2Authentication auth){
//        UsernamePasswordAuthenticationToken upat = (UsernamePasswordAuthenticationToken)auth.getUserAuthentication();
        OAuth2AuthenticationDetails details = (OAuth2AuthenticationDetails)auth.getDetails();

        String accessToken = details.getTokenValue(); // access token received from Facebook after OAuth authorization
        Facebook facebook = new FacebookTemplate(accessToken);

        String[] fieldsToMap = {"id"};

        User userProfile = facebook.fetchObject("me", User.class, fieldsToMap);
        Account account = accountService.getUser(userProfile.getId());

        if(account != null){
            return account;
        }else{
            account = new FacebookAccount(facebook, auth);
            account = accountService.save(account);
            return account;
        }
    }
}
