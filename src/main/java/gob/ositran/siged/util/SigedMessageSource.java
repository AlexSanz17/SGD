/*LICENCIA DE USO DEL SGD .TXT*/package gob.ositran.siged.util;

import com.opensymphony.xwork2.ActionContext;
import java.util.Locale;
import org.springframework.context.support.ResourceBundleMessageSource;

/**
 *
 * @author javier castillo
 */
public class SigedMessageSource extends ResourceBundleMessageSource{

    public String getMessage(MessagePropertiesEnum property) {
        return getMessage(property.getKey(), null);
    }

    public String getMessage(MessagePropertiesEnum property, Object[] args) {
        return getMessage(property.getKey(), args);
    }

    private String getMessage(String code, Object[] args) {
        Locale locale = null;
        ActionContext actionContext = ActionContext.getContext();
        if (actionContext != null) {
            locale = actionContext.getLocale();
        }
        if (locale == null) {
            locale = Locale.getDefault();
        }
        return super.getMessageFromParent(code, args, locale);
    }
}
