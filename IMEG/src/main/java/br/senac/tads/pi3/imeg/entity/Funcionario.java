/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.imeg.entity;

import br.senac.tads.pi3.imeg.util.Validate;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    private String salt;

    public Funcionario() {
    }

    public Funcionario(String nome, Cargo cargo, Unidade unidade, Acesso acesso, String email, String senha, boolean status) {
        this.nome = nome;
        this.cargo = cargo;
        this.unidade = unidade;
        this.email = email;
        this.acesso = acesso;
        this.status = status;
        this.senha = senha;
        this.salt = Validate.nextSalt();
        this.senhaHash = gerarHash(senha, this.salt);
    }

    public Funcionario(int id, String nome, Cargo cargo, Unidade unidade, Acesso acesso, String email, String senha, boolean status) {
        this.id = id;
        this.nome = nome;
        this.cargo = cargo;
        this.unidade = unidade;
        this.email = email;
        this.acesso = acesso;
        this.status = status;
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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public boolean autenticar(String email, String senha) {
        if (this.email != null) {
            try {
                return this.getEmail().equals(email) && Arrays.equals(this.senhaHash, Validate.gerarHashSenhaPBKDF2(senha, this.salt));
            } catch (NoSuchAlgorithmException | InvalidKeySpecException ex) {
                Logger.getLogger(Funcionario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    public char[] gerarHash(String senha, String salt) {
        try {
            this.senhaHash = Validate.gerarHashSenhaPBKDF2(senha, this.getSalt());
        } catch (NoSuchAlgorithmException | InvalidKeySpecException ex) {
            Logger.getLogger(Funcionario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this.senhaHash;
    }
}
