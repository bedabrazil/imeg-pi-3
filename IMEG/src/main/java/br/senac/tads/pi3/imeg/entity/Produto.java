/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.imeg.entity;

/**
 *
 * @author matheus.ssouza1
 */
public class Produto {
    
    private int id;
    private String nome;
    private int CATEGORIAS_ID;
    private double PRECO_CUSTO;
    private double PRECO_VENDA;
    private int QTDE_MIN;
    private int QTDE_MAX;
    private int SALDO;
    private boolean STATUS;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCATEGORIAS_ID() {
        return CATEGORIAS_ID;
    }

    public void setCATEGORIAS_ID(int CATEGORIAS_ID) {
        this.CATEGORIAS_ID = CATEGORIAS_ID;
    }

    public double getPRECO_CUSTO() {
        return PRECO_CUSTO;
    }

    public void setPRECO_CUSTO(double PRECO_CUSTO) {
        this.PRECO_CUSTO = PRECO_CUSTO;
    }

    public double getPRECO_VENDA() {
        return PRECO_VENDA;
    }

    public void setPRECO_VENDA(double PRECO_VENDA) {
        this.PRECO_VENDA = PRECO_VENDA;
    }

    public int getQTDE_MIN() {
        return QTDE_MIN;
    }

    public void setQTDE_MIN(int QTDE_MIN) {
        this.QTDE_MIN = QTDE_MIN;
    }

    public int getQTDE_MAX() {
        return QTDE_MAX;
    }

    public void setQTDE_MAX(int QTDE_MAX) {
        this.QTDE_MAX = QTDE_MAX;
    }

    public int getSALDO() {
        return SALDO;
    }

    public void setSALDO(int SALDO) {
        this.SALDO = SALDO;
    }

    public boolean isSTATUS() {
        return STATUS;
    }

    public void setSTATUS(boolean STATUS) {
        this.STATUS = STATUS;
    }
    
      
}
