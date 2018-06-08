/*
 * André de Amorim Yamamoto
 * TADS - Turma A
 * aay.andre@outlook.com
 */
package com.senac.br.controller;

import com.senac.br.DAO.UserDAO;
import com.senac.br.exception.UserException;
import com.senac.br.model.User;
import java.sql.SQLException;

/**
 *
 * @author aayan
 */
public class LoginService {

    public static boolean ValidateUser(String login, String senha)
            throws UserException {

        try {
            User logado = UserDAO.getUserByLogin(login, senha);

            //Verifica se o usuario foi preenchido
            return logado != null;

        } catch (SQLException ex) {
            throw new UserException("Senha ou usuario incorretos.(LoginService)", ex.getCause());
        }

    }

    public static User GetUser(String login, String senha) throws UserException {

        User logado = null;

        try {
            logado = UserDAO.getUserByLogin(login, senha);
        } catch (SQLException ex) {
            throw new UserException("Erro ao obter usuario do banco com login e senha.(LoginService)", ex.getCause());
        }
        //Retorna o usuario provavelmente preenchido
        return logado;
    }
}
