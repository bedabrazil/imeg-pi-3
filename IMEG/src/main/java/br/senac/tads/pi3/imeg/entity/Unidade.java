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
    private boolean status;
    private boolean matriz;

    public Unidade(){
    }
    
    public Unidade(String nome, Estado estado, boolean status, boolean matriz) {
        this.nome = nome;
        this.estado = estado;       
        this.status = status;
        this.matriz = matriz;
    }
    public Unidade(int id, String nome, Estado estado, boolean status, boolean matriz) {
        this.nome = nome;
        this.estado = estado;       
        this.status = status;
        this.id = id;
        this.matriz = matriz;
    }
    public Unidade(String nome, Estado estado, boolean status) {
        this.nome = nome;
        this.estado = estado;       
        this.status = status;
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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean isMatriz() {
        return matriz;
    }

    public void setMatriz(boolean matriz) {
        this.matriz = matriz;
    }
    
}
