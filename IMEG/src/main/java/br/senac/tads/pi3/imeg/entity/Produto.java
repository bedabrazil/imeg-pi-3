/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.imeg.entity;

import java.sql.Blob;

/**
 *
 * @author matheus.ssouza1
 */
public class Produto {

    private int id;
    private String nome;
    private Categoria categoria;
    private double precoCusto;
    private double precoVenda;
    private int qtdeMin;
    private int qtdeMax;
    private int saldo;
    private boolean status;
    private Blob arquivo;
    private String nomeDoArquvo;
    private String descricao;
    private String descricaoCurta;
    
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

    public double getPrecoCusto() {
        return precoCusto;
    }

    public void setPrecoCusto(double precoCusto) {
        this.precoCusto = precoCusto;
    }

    public double getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(double precoVenda) {
        this.precoVenda = precoVenda;
    }

    public int getQtdeMin() {
        return qtdeMin;
    }

    public void setQtdeMin(int qtdeMin) {
        this.qtdeMin = qtdeMin;
    }

    public int getQtdeMax() {
        return qtdeMax;
    }

    public void setQtdeMax(int qtdeMax) {
        this.qtdeMax = qtdeMax;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Blob getArquivo() {
        return arquivo;
    }

    public void setArquivo(Blob arquivo) {
        this.arquivo = arquivo;
    }

    public String getNomeDoArquvo() {
        return nomeDoArquvo;
    }

    public void setNomeDoArquvo(String nomeDoArquvo) {
        this.nomeDoArquvo = nomeDoArquvo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricaoCurta() {
        return descricaoCurta;
    }

    public void setDescricaoCurta(String descricaoCurta) {
        this.descricaoCurta = descricaoCurta;
    }

}
