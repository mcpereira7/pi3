package com.senac.pi.floricultura.controllers;

import com.senac.pi.floricultura.model.GrupoPermissao;
import com.senac.pi.floricultura.DAO.grupoPermissaoDAO;
import com.senac.pi.floricultura.model.TelaPermissoes;
import java.util.List;

public class ServicoGrupoPermissao {
    public static void AtualizarGrupoPermissaoTelas(GrupoPermissao grupoPermissao) throws Exception{
        List<TelaPermissoes> permissoes = grupoPermissao.getListaTelas();

        //se o grupo não possui ID, então cadastrar
        if (grupoPermissao.getId_grupo() == 0){
            grupoPermissaoDAO.InserirGrupoPermissao(grupoPermissao);
        }else{
            //Atualizar o grupo caso tenham alterado o seu nome
            grupoPermissaoDAO.AtualizarGrupoPermissao(grupoPermissao);
        }
        
        for (TelaPermissoes permissao : permissoes) {
            //Cadastrar as permissões que ainda não estão no grupo.
            if (!grupoPermissaoDAO.VerificaGrupoPermissaoTelas(grupoPermissao.getId_grupo(), permissao.getId())){
                grupoPermissaoDAO.InserirGrupoPermissaoTelas(grupoPermissao.getId_grupo(), permissao.getId());
            //Pode ter cadastrado, porém com disable, nesse caso atualiza para disable = false.
            }else if(grupoPermissaoDAO.VerificaGrupoPermissaoTelasDisable(grupoPermissao.getId_grupo(), permissao.getId())){
                grupoPermissaoDAO.ReativarGrupoPermissaoTelas(grupoPermissao.getId_grupo(), permissao.getId());
            }
            //Excluir as permissões que foram marcadas para ser retiradas do grupo
            if (permissao.isExcluido()){
                grupoPermissaoDAO.ExcluirGrupoPermissaoTelas(grupoPermissao.getId_grupo(), permissao.getId());
            }
        }
    }
    
    public static List<GrupoPermissao> ListarPermissoes(){
        return grupoPermissaoDAO.ListarGruposPermissoes();
    }
}
