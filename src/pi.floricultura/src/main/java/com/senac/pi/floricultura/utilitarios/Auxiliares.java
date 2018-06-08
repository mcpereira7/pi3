/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senac.pi.floricultura.utilitarios;

import com.senac.pi.floricultura.exceptions.VendaException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Marcelo Pereira <macope727@gmail.com>
 */
public class Auxiliares {

    public static Date ftmtData() {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Date data = new Date(System.currentTimeMillis());
        String date = formato.format(data);
        try {
            return data = formato.parse(date);
        } catch (Exception e) {
        }
        return null;
    }

    public static Calendar UtilDateToCalendar(Date data) {
        Calendar dataCal = Calendar.getInstance();
        dataCal.setTime(data);
        return dataCal;
    }

    public static Date InputDateToUtilDate(String inputDate)
            throws ParseException {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        try {

            Date resultado = format.parse(inputDate);

            return resultado;

        } catch (ParseException e) {
            throw new ParseException("Erro ao formatar data de input para util date.", 0);
        }

    }
    
//    Utilitário das Unidades Federativas
    
    public String[] getUf(){
        String[] estados = {"AC","AL","AM","AP","BA","CE","DF"
        ,"ES","GO","MA","MG","MS","MT","PA","PB","PE","PI","PR","RJ","RN"
        ,"RO","RR","RS","SC","SE","SP","TO"};
        
        return estados;
    }

}
