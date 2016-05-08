/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.imeg.entity;

import java.sql.Time;
import java.sql.Timestamp;

/**
 *
 * @author Eilane
 */
public class Cargo {
    private int id;
    private String nome;
    private boolean status;
    private Time criado_em;
    private Time atualizado_em;
    
    public Cargo(String nome, boolean status) {
        this.nome = nome;
        this.status = status;
    }

    public Cargo() {
    }
    
    
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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Time getAtualizado_em() {
        return atualizado_em;
    }

    public void setAtualizado_em(Time atualizado_em) {
        this.atualizado_em = atualizado_em;
    }

    public Time getCriado_em() {
        return criado_em;
    }

    public void getCriado_em(Time time) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
