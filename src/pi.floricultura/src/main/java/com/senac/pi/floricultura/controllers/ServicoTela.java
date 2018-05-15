package com.senac.pi.floricultura.controllers;

import com.senac.pi.floricultura.DAO.TelaDAO;
import com.senac.pi.floricultura.model.Tela;
import java.util.List;

public class ServicoTela {
    public static List<Tela> ListarTelas(){
        return TelaDAO.ListarTelas(null, null, null);
    }
}
