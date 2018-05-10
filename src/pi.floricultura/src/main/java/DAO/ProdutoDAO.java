/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.produto;
import Connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ProdutoDAO {

    private static Connection newconnection = null;

    public ProdutoDAO() {
        newconnection = ConnectionFactory.getConnection();
    }

    public static void inserir(produto produto) throws SQLException, Exception {
        PreparedStatement stmtProduto = null;

        String sqlProduto = "INSET INTO Produto(idProduto, nome, descricao, tipo, dt_Cadastro, disable)"
                + "VALUES(?,?,?,?,?,?)";

        try {
            stmtProduto = newconnection.prepareStatement(sqlProduto);
            stmtProduto.setInt(1, produto.getId());
            stmtProduto.setString(2, produto.getNome());
            stmtProduto.setString(3, produto.getDescricao());
            stmtProduto.setString(4, produto.getTipo());
            stmtProduto.setDate(5, produto.getDataCadastro());
        } catch () {
        }
    }

}
