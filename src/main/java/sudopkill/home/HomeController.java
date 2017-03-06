package sudopkill.home;

import org.springframework.boot.autoconfigure.security.oauth2.resource.AuthoritiesExtractor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestOperations;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import sudopkill.config.ClientResources;

import java.security.Principal;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by tanzeelrana on 3/4/2017.
 */

@Controller
public class HomeController {

    @ModelAttribute("module")
    String module() {
        return "home";
    }

    @RequestMapping({"/","/home", "/user", "/me"})
    String index(Principal principal) {
        System.out.println("principal :  " + principal);
        if(principal != null){

//            ClientResources clientResources = new ClientResources();
//
//            System.out.println(" " + clientResources.toString());
//            System.out.println(" " + clientResources.getClient().getAccessTokenUri());
//            System.out.println(" " + clientResources.getClient().getClientId());
//            System.out.println(" " + clientResources.getClient().getClientSecret());
//            System.out.println(" " + clientResources.getClient().getGrantType());
//            System.out.println(" " + clientResources.getClient().getId());
//            System.out.println(" " + clientResources.getClient().getPreEstablishedRedirectUri());
//            System.out.println(" " + clientResources.getClient().getTokenName());
//            System.out.println(" " + clientResources.getClient().getUserAuthorizationUri());
//            System.out.println(" " + clientResources.getClient().getAuthenticationScheme());
//            System.out.println(" " + clientResources.getClient().getClientAuthenticationScheme());
//            System.out.println(" " + clientResources.getClient().getScope());
//            System.out.println(" " + clientResources.getClient().hashCode());
//            System.out.println(" " + clientResources.getClient().isAuthenticationRequired());
//            System.out.println(" " + clientResources.getClient().isClientOnly());
//            System.out.println(" " + clientResources.getClient().isUseCurrentUri());
//            System.out.println(" " + clientResources.getClient().getClass());
//
//            System.out.println(" " + clientResources.getResource().getClass());
//            System.out.println(" " + clientResources.getResource().hashCode());
//            System.out.println(" " + clientResources.getResource().getClientId());
//            System.out.println(" " + clientResources.getResource().getClientSecret());
//            System.out.println(" " + clientResources.getResource().getId());
//            System.out.println(" " + clientResources.getResource().getResourceId());
//            System.out.println(" " + clientResources.getResource().getServiceId());
//            System.out.println(" " + clientResources.getResource().getTokenInfoUri());
//            System.out.println(" " + clientResources.getResource().getTokenType());
//            System.out.println(" " + clientResources.getResource().getUserInfoUri());
//            System.out.println(" " + clientResources.getResource().toString());
//            System.out.println(" " + clientResources.getResource().getFilterOrder());
//            System.out.println(" " + clientResources.getResource().getJwt());
//            System.out.println(" " + clientResources.getResource().isPreferTokenInfo());

            Map<String, String> map = new LinkedHashMap<>();
            map.put("name", principal.getName());
            System.out.println("user name :  " + principal.getName());
            return "home/homeSignedIn";
        }else{
            return "home/homeNotSignedIn";
        }
    }
}
