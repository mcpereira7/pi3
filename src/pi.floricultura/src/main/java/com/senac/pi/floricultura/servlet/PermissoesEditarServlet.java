package com.senac.pi.floricultura.servlet;

import com.senac.pi.floricultura.DAO.grupoPermissaoDAO;
import com.senac.pi.floricultura.model.GrupoPermissao;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "PermissoesEditarServlet", urlPatterns = {"/PermissoesEditar"})
public class PermissoesEditarServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sessao = request.getSession();
        
        int id_grupo = Integer.parseInt(request.getParameter("idGrupoEditar"));
        
        GrupoPermissao grupo = grupoPermissaoDAO.GruposPermissoesByGrupo(id_grupo);
        
        sessao.setAttribute("grupoEditar", grupo);
        request.getRequestDispatcher("WEB-INF/jsp/PermissoesEditar.jsp").forward(request, response);
    }
}
