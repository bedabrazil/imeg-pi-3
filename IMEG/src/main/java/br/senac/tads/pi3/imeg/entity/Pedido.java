/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.imeg.entity;

import br.senac.tads.pi3.imeg.util.CarrinhoDeCompras;
import br.senac.tads.pi3.imeg.util.ProdutoInexistenteException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Márcio Soares <marcio@mail.com>
 */
public class Pedido implements CarrinhoDeCompras {

    private ArrayList<Produto> produtos;

    public Pedido() {
        this.produtos = new ArrayList<>();
    }

    @Override
    public void adicionar(Produto produto) {
        this.produtos.add(produto);
    }

    @Override
    public double valor() {
        double soma = 0;
        for (Produto produto : this.produtos) {
            soma += produto.getPrecoVenda();
        }
        return soma;
    }

    @Override
    public void remover(Produto produto) throws ProdutoInexistenteException {
        if (!this.produtos.remove(produto)) {
            throw new ProdutoInexistenteException("Produto Inexistente no Carrinho");
        }
    }

    @Override
    public int quantidadeItens(Produto produto) {
        int qtd = 0;
        for (int i = 0; i < this.produtos.size(); i++) {
            if (produto.getClass().isInstance(this.produtos.get(i))) {
                qtd++;
            }
        }
        return qtd;
    }

    @Override
    public int quantidadeItens() {
        return this.produtos.size();
    }

    @Override
    public List<Produto> produtos() {
        return this.produtos;
    }

}
