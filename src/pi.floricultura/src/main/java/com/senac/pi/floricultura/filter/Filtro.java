/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senac.pi.floricultura.filter;

import com.senac.pi.floricultura.DAO.grupoPermissaoDAO;
import com.senac.pi.floricultura.model.Funcionario;
import com.senac.pi.floricultura.model.GrupoPermissao;
import com.senac.pi.floricultura.model.TelaPermissoes;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author leand
 */
@WebFilter(filterName = "Filter", urlPatterns = {"/floricultura/*"})
public class Filtro implements Filter {

    @Override
    public void init(FilterConfig filterConfig)
            throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request,
            ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        HttpSession sessao = httpRequest.getSession();

        if (sessao.getAttribute("usuario") == null) {
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/login");
            return;
        }

        Funcionario usuario = (Funcionario) sessao.getAttribute("usuario");

        GrupoPermissao permissoes = grupoPermissaoDAO.GruposPermissoesByGrupo(usuario.getIdGrupo());

        if (verificarAcesso(permissoes, httpRequest, httpResponse)) {
            chain.doFilter(request, response);
        } else {
            //Falta criar essa tela.
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/erro-nao-autorizado.jsp");
        }

    }

    private static boolean verificarAcesso(GrupoPermissao permissoes,
            HttpServletRequest request, HttpServletResponse response) {
        String paginaAcessada = request.getRequestURI();
        String pagina = paginaAcessada.replace(request.getContextPath(), "");

        for (TelaPermissoes permissao : permissoes.getListaTelas()) {
            if (pagina.startsWith(permissao.getCaminho())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void destroy() {

    }
}
