/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.imeg.entity;

/**
 *
 * @author Eilane
 */
public class ItemVenda {

    private int id;
    private Produto produto;
    private Categoria categoria;
    private int quantidade;
    private double total;
 
    public void setId(int id) {
        this.id = id;
    }

    
    
    public void setTotal(double total) {
        this.total = total;
    }
        
    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    
    public int getId() {
        return id;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getTotal() {
        this.total = this.quantidade * this.produto.getPrecoVenda();
        return total;
    }


}
