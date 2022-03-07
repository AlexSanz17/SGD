package org.ositran.repositorio;

import java.util.Date;

import org.apache.commons.lang.time.DateFormatUtils;

public class RepositorioUtils {
    public static String darFormatoFecha(Date date) {
        return DateFormatUtils.format(date, "yyyy-MM-dd'T'HH:mm:ss.SSS") + 'Z';
    }
}
