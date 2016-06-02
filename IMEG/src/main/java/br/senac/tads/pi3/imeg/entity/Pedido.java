/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.imeg.entity;

import br.senac.tads.pi3.imeg.util.CarrinhoDeCompras;
import java.util.Map;

/**
 *
 * @author Márcio Soares <marcio@mail.com>
 */
public class Pedido implements CarrinhoDeCompras {

    Map<Produto, Integer> produtos;

    public Pedido(Map produtos) {
        this.produtos = produtos;
    }

    @Override
    public void adicionar(Produto produto, int qtd) {
        if(!this.produtos.containsKey(produto)){
            this.produtos.put(produto, qtd);
        }
    }

    @Override
    public double valor(Produto produto) {
        int valor = this.produtos.get(produto);
        return produto.getPrecoVenda() * valor;
    }

    @Override
    public void remover(Produto produto) {
        this.produtos.remove(produto);
    }

    @Override
    public int quantidadeItens() {
        return this.produtos.size();
    }

    @Override
    public void qtdProdutos(Produto produto, int qtd) {
        if (!this.produtos.containsKey(produto)) {
            this.produtos.put(produto, qtd);
        }
    }

    @Override
    public Map<Produto, Integer> produtos() {
        return this.produtos;
    }

    @Override
    public double valorTotal() {
        double soma = 0;
        for (Produto produto : this.produtos.keySet()) {
            soma += this.valor(produto);
        }
        return soma;
    }

}
