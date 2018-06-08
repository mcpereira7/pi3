/*
 * André de Amorim Yamamoto
 * TADS - Turma A
 * aay.andre@outlook.com
 */
package com.senac.pi.floricultura.controllers;

import com.senac.pi.floricultura.DAO.FuncionarioDAO;
import com.senac.pi.floricultura.model.Funcionario;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aayan
 */
public class ServicoFuncionario {

    //Nao utilizar esse metodo ainda
    public static Funcionario LogarUsuario(String user, String password) {

        Funcionario usuario = null;

        try {

            usuario = FuncionarioDAO.getUser(user);

//            if (!usuario.getPassword().equals(password)) {
//                return null;
//            }

        } catch (SQLException ex) {
            Logger.getLogger(ServicoFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        }

        return usuario;
    }
    
    public static void cadastrarFuncionario(Funcionario us) throws SQLException, Exception{
        
        try {
            FuncionarioDAO.inserirFuncionario(us);
            
        } catch (SQLException ex) {
            Logger.getLogger(ServicoFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

}
