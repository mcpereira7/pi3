/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senac.pi.floricultura.model;

import java.util.Calendar;

/**
 *
 * @author Vinicius
 */
public class ValidadorVenda {
       public static boolean validarData(Calendar de, Calendar ate) {

        return de.compareTo(ate) > -7 || de.compareTo(ate) < 7;

    }
}
