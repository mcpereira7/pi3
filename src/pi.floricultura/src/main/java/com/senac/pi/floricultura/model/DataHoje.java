/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senac.pi.floricultura.model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author vinicius.presoto
 */
public class DataHoje {

    private Date data = new Date(System.currentTimeMillis());
    private SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyy");

    public String getDataAtual() {
        return df.format(data);
    }

}
