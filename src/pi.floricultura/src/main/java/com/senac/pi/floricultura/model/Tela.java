package com.senac.pi.floricultura.model;

public class Tela {
    private int id;
    private String nome;
    private String caminho;
    
    public Tela(int id, String nome, String caminho) {
        this.id = id;
        this.nome = nome;
        this.caminho = caminho;
    }
    
    public Tela (int id){
        this.id = id;
    }
    
    public String getCaminho() {
        return caminho;
    }

    public void setCaminho(String caminho) {
        this.caminho = caminho;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
}
