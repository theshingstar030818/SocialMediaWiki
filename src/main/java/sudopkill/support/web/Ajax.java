package sudopkill.support.web;

/**
 * Created by tanzeelrana on 3/4/2017.
 */
public class Ajax {

    private Ajax() {
    }

    public static boolean isAjaxRequest(String requestedWith) {
        return requestedWith != null ? "XMLHttpRequest".equals(requestedWith) : false;
    }
}