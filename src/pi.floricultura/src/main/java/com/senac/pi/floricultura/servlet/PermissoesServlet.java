package com.senac.pi.floricultura.servlet;

import com.senac.pi.floricultura.controllers.ServicoGrupoPermissao;
import com.senac.pi.floricultura.model.GrupoPermissao;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author leand
 */
@WebServlet(name = "PermissoesServlet", urlPatterns = {"/PermissoesListar"})
public class PermissoesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<GrupoPermissao> permissoes = ServicoGrupoPermissao.ListarPermissoes();
        
        HttpSession sessao = request.getSession();
        sessao.setAttribute("listaPermissoes", permissoes);
        request.getRequestDispatcher("WEB-INF/jsp/Permissoes.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

}
