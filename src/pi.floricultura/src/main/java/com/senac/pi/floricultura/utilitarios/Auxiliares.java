/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senac.pi.floricultura.utilitarios;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Marcelo Pereira <macope727@gmail.com>
 */
public class Auxiliares {
    
    public static Date ftmtData(){
        SimpleDateFormat formato = new SimpleDateFormat( "yyyy-MM-dd" );
        Date data = new Date(System.currentTimeMillis());
        String date = formato.format(data);
        try {
            return data = formato.parse(date);
        } catch (Exception e) {
        }
        return null;
    }
    
}
