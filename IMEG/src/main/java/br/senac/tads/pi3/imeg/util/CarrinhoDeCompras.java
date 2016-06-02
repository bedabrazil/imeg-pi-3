/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.imeg.util;

import br.senac.tads.pi3.imeg.entity.Produto;
import java.util.Map;

/**
 *
 * @author Márcio Soares <marcio@mail.com>
 */
public interface CarrinhoDeCompras {
    
    void adicionar(Produto produto, int qtd);

    double valor(Produto produto);

    double valorTotal();

    void remover(Produto produto);

    int quantidadeItens();
    
    void qtdProdutos(Produto produto, int qtd);
    
    Map<Produto, Integer> produtos();
    
}