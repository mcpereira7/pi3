package com.senac.pi.floricultura.utilitarios;

import java.util.Calendar;
import java.util.Date;

public class AuxiliaresDAO {

    public static String ligaVetorAND(String[] str) {
        String concat = "";
        for (String string : str) {
            if (concat.equals("")) {
                if (string != null) {
                    concat += string;
                }
            } else {
                if (string != null) {
                    concat += " AND " + string;
                }
            }
        }
        return concat;
    }

    public static String filtraRangeDate(String campo, Date dataInicial, Date dataFinal) {
        if (dataInicial != null || dataFinal != null) {
            if (dataInicial == null) {
                return campo +" BETWEEN '1899/01/01 00:00:00' AND '" + new java.sql.Date(dataFinal.getTime()) + "23:59:59'";
            } else {
                Date d = Calendar.getInstance().getTime();
                return campo + " BETWEEN '" + new java.sql.Date(dataFinal.getTime()) + " 00:00:00' AND '" + new java.sql.Date(d.getTime()) + " 23:59:29'";
            }
        }
        return "";
    }
}
