/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.imeg.entity;

import java.util.Date;

/**
 *
 * @author diogo.lsousa
 */
public class ItemEntrada {
    
    private int id;
    private Produto produto;
    private Funcionario funcionario;
    private Date dataTransacao;
    private int qtdeProduto;
    private double precoCusto;
    private double precoVenda;
    
    
    public double getPrecoCusto() {
        return precoCusto;
    }

    public void setPrecoCusto(double precoCusto) {
        this.precoCusto = precoCusto;
    }
  
    public int getId() {
        return id;
    }

    public Date getDataTransacao() {
        return dataTransacao;
    }

    public void setDataTransacao(Date dataTransacao) {
        this.dataTransacao = dataTransacao;
    }

    public int getQtdeProduto() {
        return qtdeProduto;
    }

    public void setQtdeProduto(int qtdeProduto) {
        this.qtdeProduto = qtdeProduto;
    }

    public Produto getProduto() {
        return produto;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }
    
    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    
    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public double getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(double precoVenda) {
        this.precoVenda = precoVenda;
    }
}
