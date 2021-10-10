package org.ositran.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

/**
 *
 * @author javier castillo
 */
public class PropertyFileUtils {

    private PropertyFileUtils() {
    }

    /**
     * Load a properties file from the classpath
     * @param propsName
     * @return Properties
     * @throws Exception
     */
    public static Properties load(String propsName) throws Exception {
        Properties props = new Properties();
        URL url = Thread.currentThread().getContextClassLoader().getResource(propsName);
        props.load(url.openStream());
        return props;
    }

    /**
     * Load a Properties File
     * @param propsFile
     * @return Properties
     * @throws IOException
     */
    public static Properties load(File propsFile) throws IOException {
        Properties props = new Properties();
        FileInputStream fis = new FileInputStream(propsFile);
        props.load(fis);
        fis.close();
        return props;
    }
}
