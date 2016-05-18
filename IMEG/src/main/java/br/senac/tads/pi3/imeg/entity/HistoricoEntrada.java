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
public class HistoricoEntrada {
    
    private int id;
    private Produto produto;
    private Funcionario funcionario;
    private Date data_transacao;
    private int qtde_produtos;
    private double preco_custo;
    
    
    public double getPreco_custo() {
        return preco_custo;
    }

    public void setPreco_custo(double preco_custo) {
        this.preco_custo = preco_custo;
    }
  
    public int getId() {
        return id;
    }

    public Date getData_transacao() {
        return data_transacao;
    }

    public void setData_transacao(Date data_transacao) {
        this.data_transacao = data_transacao;
    }

    public int getQtde_produtos() {
        return qtde_produtos;
    }

    public void setQtde_produtos(int qtde_produtos) {
        this.qtde_produtos = qtde_produtos;
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
}
