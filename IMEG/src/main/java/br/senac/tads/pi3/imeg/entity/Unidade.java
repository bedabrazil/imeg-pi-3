/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.imeg.entity;

/**
 *
 * @author eilane
 */
public class Unidade {

    private int id;
    private Estado estado;
    private String nome;

    public Unidade(){
    }
    
    public Unidade(String nome, Estado estado, int id) {
        this.nome = nome;
        this.estado = estado;
        this.id = id;
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Estado getEstado() {
        return estado;
    }

    public String getNome() {
        return nome;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
