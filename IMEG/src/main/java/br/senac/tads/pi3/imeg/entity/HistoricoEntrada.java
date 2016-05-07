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

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    /**
     * @return the produtos_id
     */

    /**
     * @return the data_transacao
     */
    public Date getData_transacao() {
        return data_transacao;
    }

    /**
     * @param data_transacao the data_transacao to set
     */
    public void setData_transacao(Date data_transacao) {
        this.data_transacao = data_transacao;
    }

    /**
     * @return the qtde_produtos
     */
    public int getQtde_produtos() {
        return qtde_produtos;
    }

    /**
     * @param qtde_produtos the qtde_produtos to set
     */
    public void setQtde_produtos(int qtde_produtos) {
        this.qtde_produtos = qtde_produtos;
    }

    /**
     * @return the produto
     */
    public Produto getProduto() {
        return produto;
    }

    /**
     * @return the funcionario
     */
    public Funcionario getFuncionario() {
        return funcionario;
    }
}
