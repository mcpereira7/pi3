/*
 * André de Amorim Yamamoto
 * TADS - Turma A
 * aay.andre@outlook.com
 */
package com.senac.pi.floricultura.controllers;

import com.senac.pi.floricultura.DAO.UsuarioDAO;
import com.senac.pi.floricultura.model.Usuario;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aayan
 */
public class ServicoUsuario {

    public static Usuario LogarUsuario(String user, String password) {

        Usuario usuario = null;

        try {

            usuario = UsuarioDAO.getUser(user);

            if (!usuario.getPassword().equals(password)) {
                return null;
            }

        } catch (SQLException ex) {
            Logger.getLogger(ServicoUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }

        return usuario;
    }

}
