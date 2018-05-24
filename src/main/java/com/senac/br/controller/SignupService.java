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
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author aayan
 */
public class SignupService {

    public static boolean signupUser(HttpServletRequest request)
            throws UserException {

        String nome = request.getParameter("nome");
        String login = request.getParameter("login");
        String email = request.getParameter("email");
        String[] senhas = request.getParameterValues("pass");

        //Verifica se a senha e sua confirmacao sao iguais
        //e se os demais campos estao preenchidos
        if (!senhas[0].equalsIgnoreCase(senhas[1]) || nome.equals("")
                || login.equals("") || email.equals("")) {
            return false;
        }

        try {
            //Cria o usuario com as informacoes obtidas acima
            User novo = new User(nome, login, email, senhas[0]);
            //Adiciona o usuario ao banco
            UserDAO.createUser(novo);
            //Retorna true se der tudo certo para fins de tela de erro
            return true;
        } catch (SQLException e) {
            throw new UserException("Erro ao cadastrar usuario.", e.getCause());
        }
    }

}
