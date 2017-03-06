package sudopkill.AuthProvider;

import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.InteractiveAuthenticationSuccessEvent;
import org.springframework.stereotype.Component;
import sudopkill.config.ClientResources;

/**
 * Created by haris on 3/6/17.
 */

@Component
public class AuthenticationListener implements ApplicationListener<InteractiveAuthenticationSuccessEvent> {

    @Override
    public void onApplicationEvent(final InteractiveAuthenticationSuccessEvent event) {
        System.out.println("+++++++ ================ ------------");
//        ClientResources clientResources = new ClientResources();
//
//        System.out.println(" " + clientResources.toString());
//        System.out.println(" " + clientResources.getClient().getAccessTokenUri());
//        System.out.println(" " + clientResources.getClient().getClientId());
//        System.out.println(" " + clientResources.getClient().getClientSecret());
//        System.out.println(" " + clientResources.getClient().getGrantType());
//        System.out.println(" " + clientResources.getClient().getId());
//        System.out.println(" " + clientResources.getClient().getPreEstablishedRedirectUri());
//        System.out.println(" " + clientResources.getClient().getTokenName());
//        System.out.println(" " + clientResources.getClient().getUserAuthorizationUri());
//        System.out.println(" " + clientResources.getClient().getAuthenticationScheme());
//        System.out.println(" " + clientResources.getClient().getClientAuthenticationScheme());
//        System.out.println(" " + clientResources.getClient().getScope());
//        System.out.println(" " + clientResources.getClient().hashCode());
//        System.out.println(" " + clientResources.getClient().isAuthenticationRequired());
//        System.out.println(" " + clientResources.getClient().isClientOnly());
//        System.out.println(" " + clientResources.getClient().isUseCurrentUri());
//        System.out.println(" " + clientResources.getClient().getClass());
//
//        System.out.println(" " + clientResources.getResource().getClass());
//        System.out.println(" " + clientResources.getResource().hashCode());
//        System.out.println(" " + clientResources.getResource().getClientId());
//        System.out.println(" " + clientResources.getResource().getClientSecret());
//        System.out.println(" " + clientResources.getResource().getId());
//        System.out.println(" " + clientResources.getResource().getResourceId());
//        System.out.println(" " + clientResources.getResource().getServiceId());
//        System.out.println(" " + clientResources.getResource().getTokenInfoUri());
//        System.out.println(" " + clientResources.getResource().getTokenType());
//        System.out.println(" " + clientResources.getResource().getUserInfoUri());
//        System.out.println(" " + clientResources.getResource().toString());
//        System.out.println(" " + clientResources.getResource().getFilterOrder());
//        System.out.println(" " + clientResources.getResource().getJwt());
//        System.out.println(" " + clientResources.getResource().isPreferTokenInfo());
    }
}
