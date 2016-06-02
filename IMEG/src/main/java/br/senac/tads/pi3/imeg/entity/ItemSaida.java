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
public class ItemSaida {
    private int id;
    private Produto produto;
    private Funcionario funcionario;
    private Date dataTransacao;
    private int qtdeProdutos;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }


    /**
     * @return the produtos_id
     */
 

    /**
     * @return the data_transacao
     */
    public Date getDataTransacao() {
        return dataTransacao;
    }

    /**
     * @param dataTransacao the data_transacao to set
     */
    public void setDataTransacao(Date dataTransacao) {
        this.dataTransacao = dataTransacao;
    }

    /**
     * @return the qtdeProdutos
     */
    public int getQtdeProdutos() {
        return qtdeProdutos;
    }

    /**
     * @param qtdeProdutos the qtdeProdutos to set
     */
    public void setQtdeProdutos(int qtdeProdutos) {
        this.qtdeProdutos = qtdeProdutos;
    }

    /**
     * @return the produto
     */
    public Produto getProduto() {
        return produto;
    }

    /**
     * @param produto the produto to set
     */
    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    /**
     * @return the funcionario
     */
    public Funcionario getFuncionario() {
        return funcionario;
    }

    /**
     * @param funcionario the funcionario to set
     */
    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
}
