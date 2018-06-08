/*
 * André de Amorim Yamamoto
 * TADS - Turma A
 * aay.andre@outlook.com
 */
package com.senac.br.support;

import java.sql.Date;
import java.util.Calendar;

/**
 *
 * @author aayan
 */
public class DataSupport {

    public static java.sql.Date UtilDateToSqlDate(java.util.Date utilDate) {

        Calendar cal = Calendar.getInstance();

        cal.setTime(utilDate);

        java.sql.Date sqlDate = new Date(cal.getTimeInMillis());

        return sqlDate;

    }

    public static java.util.Date SqlDateToUtilDate(java.sql.Date sqlDate) {

        Calendar cal = Calendar.getInstance();

        cal.setTimeInMillis(sqlDate.getTime());

        java.util.Date utilDate = cal.getTime();

        return utilDate;
    }

}
