/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senac.pi.floricultura.model;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Marcelo Pereira <macope727@gmail.com>
 */
public class Usuario extends Funcionario{

    public Usuario(ResultSet rs) throws SQLException {
        super(rs);
    }

    
}
