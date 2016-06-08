/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.imeg.entity;

import java.util.Date;

/**
 *
 * @author iosato
 */
public class RelatorioVenda implements Relatorio{
    private int qtdeVendida;
    private Produto produto;
    private Unidade unidade;
    private Funcionario funcionario;
    private double totalValorVenda;
    private Date DataTransacao;
    private String mes;
    
    public int getQtdeVendida() {
        return qtdeVendida;
    }

    public void setQtdeVendida(int qtdeVendida) {
        this.qtdeVendida = qtdeVendida;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Unidade getUnidade() {
        return unidade;
    }

    public void setUnidade(Unidade unidade) {
        this.unidade = unidade;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public double getTotalValorVenda() {
        return totalValorVenda;
    }

    public void setTotalValorVenda(double totalValorVenda) {
        this.totalValorVenda = totalValorVenda;
    }

    public Date getDataTransacao() {
        return DataTransacao;
    }

    public void setDataTransacao(Date DataTransacao) {
        this.DataTransacao = DataTransacao;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }
    
}
