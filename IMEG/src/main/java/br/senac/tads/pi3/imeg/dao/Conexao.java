/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.imeg.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author marcio.soares <marcio@mail.com>
 */
public class Conexao {
    
    private Connection conexao = null;
    
//************************************************************************************************   
//-- RETORNA UMA CONEXÃO COM O BANCO DE DADOS
//************************************************************************************************
    public Connection getConexao() {
        if (conexao == null) {
            try {
                conexao = DriverManager.getConnection(
                    "jdbc:derby://localhost:1527/imegdb;SecurityMechanism=3;territory=pt_BR;collation=TERRITORY_BASED",
                    "adm", // usuario
                    "adm"); // senha
            } catch (SQLException e) {
                System.out.println("ERROR DE SQL: " + e.getMessage());
            }
        }
        return conexao;
    }

//************************************************************************************************   
//-- PREPARA UM ESTADO PARA RECEBER UM COMANDO SQL
//************************************************************************************************    
    public PreparedStatement prepararStatement(String sql) {
        if (conexao == null) {
            conexao = getConexao();
            try {
                return conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            } catch (SQLException e) {
                System.out.println("ERRO De SQL: " + e.getMessage() + "\nERROR CODE: " + e.getErrorCode());
            }
        }
        return null;
    }    
 
}
