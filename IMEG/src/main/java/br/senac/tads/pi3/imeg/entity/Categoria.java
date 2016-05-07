/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.imeg.entity;

/**
 *
 * @author diogo.lsousa
 */
public class Categoria {
    private int id;
    private int nome;
    private boolean status;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the nome
     */
    public int getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(int nome) {
        this.nome = nome;
    }

    /**
     * @return the status
     */
    public boolean isStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(boolean status) {
        this.status = status;
    }
    
}
