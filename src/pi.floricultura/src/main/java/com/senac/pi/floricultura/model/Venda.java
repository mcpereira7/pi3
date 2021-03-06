/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senac.pi.floricultura.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Vinicius
 */
public class Venda {

    private int id;
    private int codigo;
    private Calendar data;
    private Date dtDate;
    private int idPessoa;
    private String cpfPessoa;
    private int idVendedor;
    private ArrayList<ItensVenda> listaItensVenda;
    private double valorTotal;

    public Venda() {
        this.listaItensVenda = new ArrayList<>();
    }

    public Venda(Calendar data, int idPessoa, int idVendedor, ArrayList<ItensVenda> listaItensVenda) {
        this.data = data;
        this.idPessoa = idPessoa;
        this.idVendedor = idVendedor;
        this.listaItensVenda = listaItensVenda;
    }

    public Venda(ResultSet rs) throws SQLException, Exception {

        id = rs.getInt("id_Venda");
        codigo = rs.getInt("Codigo");
        idPessoa = rs.getInt("id_Cliente");
        cpfPessoa = rs.getString("CPF");
        valorTotal = rs.getFloat("ValorTotal");
        //Datas
        java.sql.Date novo = rs.getDate("Data");
        data = Calendar.getInstance();
        data.setTime(novo);
        dtDate = data.getTime();
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    public Date getDtDate() {
        return dtDate;
    }

    public void setDtDate(Date dtDate) {
        this.dtDate = dtDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codVenda) {
        this.codigo = codVenda;
    }

    public Calendar getDataVenda() {
        return data;
    }

    public void setDataVenda(Calendar dataVenda) {
        this.data = dataVenda;
    }

    public int getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(int pessoa) {
        this.idPessoa = pessoa;
    }

    public String getCpfPessoa() {
        return cpfPessoa;
    }

    public void setCpfPessoa(String cpfPessoa) {
        this.cpfPessoa = cpfPessoa;
    }

    public int getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(int idVendedor) {
        this.idVendedor = idVendedor;
    }

    public ArrayList<ItensVenda> getListaItensVenda() {
        return listaItensVenda;
    }

    public void setListaItensVenda(ArrayList<ItensVenda> listaProdutos) {
        this.listaItensVenda = listaProdutos;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public void sumValorTotal() {
        double total = 0;

        for (ItensVenda item : this.listaItensVenda) {
            total += (item.getValor() * item.getQuantidade());
        }

        this.valorTotal = total;
    }

}
