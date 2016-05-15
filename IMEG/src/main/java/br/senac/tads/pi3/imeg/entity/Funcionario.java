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
public class Funcionario {

    private int id;
    private Cargo cargo;
    private Unidade unidade;
    private Acesso acesso;    
    private String nome;
    private String email;
    private String senha;
    private char[] senhaHash;
    private boolean status;
    

    public Funcionario() {
    }
  
    public Funcionario(String nome, Cargo cargo, Unidade unidade, Acesso acesso, String email, String senha) {
        this.nome = nome;
        this.cargo = cargo;
        this.unidade = unidade;
        this.email = email;
        this.acesso = acesso;
        this.senha = senha;
    }
    
    public Funcionario(int id, String nome, Cargo cargo, Unidade unidade, Acesso acesso, String email, String senha) {
        this.id = id;
        this.nome = nome;
        this.cargo = cargo;
        this.unidade = unidade;
        this.email = email;
        this.acesso = acesso;
        this.senha = senha;
    }
    
        
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public Unidade getUnidade() {
        return unidade;
    }

    public void setUnidade(Unidade unidade) {
        this.unidade = unidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public char[] getSenhaHash() {
        return senhaHash;
    }

    public void setSenhaHash(char[] senhaHash) {
        this.senhaHash = senhaHash;
    }

    public Acesso getAcesso() {
        return acesso;
    }

    public void setAcesso(Acesso acesso) {
        this.acesso = acesso;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }


}
