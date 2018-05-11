package com.senac.pi.floricultura.servlet;

import com.senac.pi.floricultura.controllers.ServicoTela;
import com.senac.pi.floricultura.controllers.ServicoGrupoPermissao;
import com.senac.pi.floricultura.model.GrupoPermissao;
import com.senac.pi.floricultura.model.TelaPermissoes;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "PermissoesCriarServlet", urlPatterns = {"/PermissoesCadastrar"})
public class PermissoesCadastrarServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sessao = request.getSession();
        sessao.setAttribute("listaTelas", ServicoTela.ListarTelas());
        request.getRequestDispatcher("WEB-INF/jsp/PermissoesCriar.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String[] idTelas = request.getParameterValues("tela");
        String nomeGrupo = request.getParameter("nomeGrupo");
        
        //montando o objeto para passar ao servico
        List<TelaPermissoes> telas = new ArrayList<>();
        for (int i = 0; i < idTelas.length; i++) {
            TelaPermissoes tela = new TelaPermissoes(Integer.parseInt(idTelas[i]), false);
            telas.add(tela);
        }
        GrupoPermissao grupo = new GrupoPermissao(0, nomeGrupo, telas);
        
        try {
            //Servico
            ServicoGrupoPermissao.AtualizarGrupoPermissaoTelas(grupo);
        } catch (Exception ex) {
            Logger.getLogger(PermissoesCadastrarServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
