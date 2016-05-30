/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.imeg.util;

import br.senac.tads.pi3.imeg.entity.Produto;
import java.util.List;

/**
 *
 * @author Márcio Soares <marcio@mail.com>
 */
public interface CarrinhoDeCompras {
    void adicionar(Produto produto);

    double valor();

    void remover(Produto produto) throws ProdutoInexistenteException;

    int quantidadeItens(Produto produto);

    int quantidadeItens();

    List<Produto> produtos();    
}