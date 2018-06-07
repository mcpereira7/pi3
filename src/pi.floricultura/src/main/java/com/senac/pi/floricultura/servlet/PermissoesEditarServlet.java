package com.senac.pi.floricultura.servlet;

import com.senac.pi.floricultura.DAO.grupoPermissaoDAO;
import com.senac.pi.floricultura.controllers.ServicoGrupoPermissao;
import com.senac.pi.floricultura.controllers.ServicoTela;
import com.senac.pi.floricultura.model.GrupoPermissao;
import com.senac.pi.floricultura.model.TelaPermissoes;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        HttpSession sessao = request.getSession();
        
        int id_grupo = Integer.parseInt(request.getParameter("idGrupoEditar"));
        
        GrupoPermissao grupo = grupoPermissaoDAO.GruposPermissoesByGrupo(id_grupo);
        
        sessao.setAttribute("idGrupo", id_grupo);
        sessao.setAttribute("grupoEditar", grupo);
        sessao.setAttribute("listaTelas", ServicoTela.ListarTelas());
        request.getRequestDispatcher("WEB-INF/jsp/PermissoesEditar.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sessao = request.getSession();
        
        Integer idGrupo = (Integer)sessao.getAttribute("idGrupo");
        String[] idTelas = request.getParameterValues("tela");
        String nomeGrupo = request.getParameter("nomeGrupo");
        String[] excluido = request.getParameterValues("excluir");
        
        //carregar as telas que já estavam cadastradas no grupo.
        List<TelaPermissoes> grupoEditar = grupoPermissaoDAO.ListarPermissoesByGrupo(idGrupo);
        
        //Verificar se alguma tela da lista foi marcada para ser excluida.
        if (excluido != null){
            for (int i = 0; i < excluido.length; i++) {
                for (TelaPermissoes telaPermissoes : grupoEditar) {
                    if (telaPermissoes.getId() == Integer.parseInt(excluido[i])){
                        telaPermissoes.setExcluido(true);
                    }
                }
            }
        }
        
        //Carregar as telas adicionadas ao grupo.
        List<TelaPermissoes> telas = new ArrayList<>();
        if (idTelas != null){
            for (int i = 0; i < idTelas.length; i++) {
                TelaPermissoes tela = new TelaPermissoes(Integer.parseInt(idTelas[i]), false);
                telas.add(tela);
            }
        }
        
        //Ligar as duas listas.
        for (TelaPermissoes telaPermissoes : grupoEditar) {
            telas.add(telaPermissoes);
        }
        
        GrupoPermissao grupo = new GrupoPermissao(idGrupo, nomeGrupo, telas);
        
        try {
            //Servico
            ServicoGrupoPermissao.AtualizarGrupoPermissaoTelas(grupo);
            response.sendRedirect(request.getContextPath() + "/index.html");
        } catch (Exception ex) {
            Logger.getLogger(PermissoesCadastrarServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
