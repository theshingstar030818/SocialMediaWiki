package sudopkill.provider;


/**
 * Created by tanzeelrana on 3/5/2017.
 */

public enum AuthProvider {

    FACEBOOK("facebook"), GITHUB("github"), LOCAL("local");

    private String providerType;

    public String getProviderType() {
        return providerType;
    }

    AuthProvider(final String providerType) {
        this.providerType = providerType;
    }

}