/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.imeg.util;

/**
 *
 * @author Márcio Soares <marcio@mail.com>
 */
public class ProdutoInexistenteException extends Exception {

    /**
     * Creates a new instance of <code>ProdutoInexistenteException</code>
     * without detail message.
     */
    public ProdutoInexistenteException() {
    }

    /**
     * Constructs an instance of <code>ProdutoInexistenteException</code> with
     * the specified detail message.
     *
     * @param msg the detail message.
     */
    public ProdutoInexistenteException(String msg) {
        super(msg);
    }
}
