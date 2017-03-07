package sudopkill.github;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sudopkill.account.Account;
import sudopkill.account.AccountService;
import java.util.LinkedHashMap;

/**
 * Created by tanzeelrana on 3/5/2017.
 */

@Service
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class GithubAccountService{

    @Autowired
    private AccountService accountService;

    @Transactional(noRollbackFor = Exception.class)
    public Account getGithubAccountController(OAuth2Authentication auth) {

        UsernamePasswordAuthenticationToken upat = (UsernamePasswordAuthenticationToken)auth.getUserAuthentication();
        LinkedHashMap upatMap = (LinkedHashMap)upat.getDetails();
        Account account = accountService.getUser((String)upatMap.get("email"));
        if(account != null){
            return account;
        }else{
            account = new GithubAccount(upatMap, auth);
            account = accountService.save(account);
            return account;
        }
    }
}
