package com.senac.pi.floricultura.model;

import java.util.List;

public class GrupoPermissao {
    private Integer id_grupo;
    private String nome;
    private List<TelaPermissoes> listaTelas;

    public GrupoPermissao(Integer id_grupo, String nome) {
        this.id_grupo = id_grupo;
        this.nome = nome;
    }
    
    public GrupoPermissao(Integer id_grupo, String nome, List<TelaPermissoes> listaTelas) {
        this.id_grupo = id_grupo;
        this.nome = nome;
        this.listaTelas = listaTelas;
    }

    public List<TelaPermissoes> getListaTelas() {
        return listaTelas;
    }

    public void setListaTelas(List<TelaPermissoes> listaTelas) {
        this.listaTelas = listaTelas;
    }
    
    public int getId_grupo() {
        return id_grupo;
    }

    public void setId_grupo(int id_grupo) {
        this.id_grupo = id_grupo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
