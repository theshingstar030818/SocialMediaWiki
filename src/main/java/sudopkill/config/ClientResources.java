package sudopkill.config;

import org.springframework.boot.autoconfigure.security.oauth2.resource.ResourceServerProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.security.oauth2.client.token.grant.code.AuthorizationCodeResourceDetails;

/**
 * Created by tanzeelrana on 3/5/2017.
 */
public class ClientResources {

    @NestedConfigurationProperty
    private AuthorizationCodeResourceDetails client = new AuthorizationCodeResourceDetails();

    @NestedConfigurationProperty
    private ResourceServerProperties resource = new ResourceServerProperties();

    public AuthorizationCodeResourceDetails getClient() {
        System.out.println(" " + client.toString());
        System.out.println(" " + client.getAccessTokenUri());
        System.out.println(" " + client.getClientId());
        System.out.println(" " + client.getClientSecret());
        System.out.println(" " + client.getGrantType());
        System.out.println(" " + client.getId());
        System.out.println(" " + client.getPreEstablishedRedirectUri());
        System.out.println(" " + client.getTokenName());
        System.out.println(" " + client.getUserAuthorizationUri());
        System.out.println(" " + client.getAuthenticationScheme());
        System.out.println(" " + client.getClientAuthenticationScheme());
        System.out.println(" " + client.getScope());
        System.out.println(" " + client.hashCode());
        System.out.println(" " + client.isAuthenticationRequired());
        System.out.println(" " + client.isClientOnly());
        System.out.println(" " + client.isUseCurrentUri());
        System.out.println(" " + client.getClass());
        return client;
    }

    public ResourceServerProperties getResource() {
        System.out.println(" " + resource.getClass());
        System.out.println(" " + resource.hashCode());
        System.out.println(" " + resource.getClientId());
        System.out.println(" " + resource.getClientSecret());
        System.out.println(" " + resource.getId());
        System.out.println(" " + resource.getResourceId());
        System.out.println(" " + resource.getServiceId());
        System.out.println(" " + resource.getTokenInfoUri());
        System.out.println(" " + resource.getTokenType());
        System.out.println(" " + resource.getUserInfoUri());
        System.out.println(" " + resource.toString());
        System.out.println(" " + resource.getFilterOrder());
        System.out.println(" " + resource.getJwt());
        System.out.println(" " + resource.isPreferTokenInfo());
        return resource;
    }
}
