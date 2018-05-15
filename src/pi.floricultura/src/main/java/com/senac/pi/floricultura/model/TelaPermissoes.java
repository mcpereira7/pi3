package com.senac.pi.floricultura.model;

public class TelaPermissoes extends Tela{
    private boolean excluido;
    
    public TelaPermissoes(int id, String nome, String caminho, boolean excluir) {
        super(id, nome, caminho);
        this.excluido = excluir;
    }
    
    public TelaPermissoes(int id, boolean excluir) {
        super(id);
        this.excluido = excluir;
    }
    
    public boolean isExcluido() {
        return excluido;
    }

    public void setExcluido(boolean excluido) {
        this.excluido = excluido;
    }
}
