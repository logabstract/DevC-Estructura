
package pe.com.scotiabank.tbk.payment.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Properties;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

public class PaymentWsUtils
{
    
    private static final Logger log = LoggerFactory.getLogger(PaymentWsUtils.class);

    public static final String sMESS_TITTLES = "MSG_TITTLES";

    private static MessageSource messageSource;

    public static void setMessageSource(MessageSource messageSource)
    {
        PaymentWsUtils.messageSource = messageSource;
    }

    public static MessageSource getMessageSource()
    {
        return messageSource;
    }

    static public String getMessage(String key, String lang)
    {
        String sResult = "";
        sResult = getMessageResource(key);
        if (sResult == null)
            sResult = "";

        return sResult;
    }

    public static String getMessageResource(String key, String[] arguments)
    {
        if (messageSource != null)
        {
            return messageSource.getMessage(key, arguments, LocaleContextHolder.getLocale());
        }
        return "";
    }

    public static String getMessageResource(String key)
    {
        return getMessageResource(key, new String[] {});
    }

    public static String getValueFromProperties(String key)
    {
        Properties prop = new Properties();
        InputStream input = null;
        try
        {
            input = PaymentWsUtils.class.getClassLoader().getResourceAsStream(PaymentWsConstants.PROPERTIES_FILENAME);
            // load a properties file
            prop.load(input);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        // get the property value and print it out
        return prop.getProperty(key);
    }

}
