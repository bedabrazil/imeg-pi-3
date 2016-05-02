/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.imeg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import br.senac.tads.pi3.imeg.entity.Produto;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
/**
 *
 * @author matheus.ssouza1
 */
public class ProdutoDAO {
    public int cadastrarProduto(Produto produto) {
        Conexao conn = new Conexao();
        Connection conexao = conn.conectar();
        String sql = "INSERT INTO  PRODUTOS(CATEGORIAS_ID, NOME, PRECO_CUSTO, PRECO_VENDA, QTDE_MIN, QTDE_MAX, SALDO)"
                + "VALUES (?,?,?,?,?,?,?);";
        try (PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setInt(1, produto.getCATEGORIAS_ID());
            ps.setString(2, produto.getNome());
            ps.setDouble(3, produto.getPRECO_CUSTO());
            ps.setDouble(4, produto.getPRECO_VENDA());
            ps.setInt(5, produto.getQTDE_MIN());
            ps.setInt(6, produto.getQTDE_MAX());
            ps.setDouble(7, produto.getSALDO());
            ps.execute();
            ps.close();

        } catch (SQLException e) {
            System.err.println("Erro ao cadastrar!");
        } finally {
            conn.desconectar(); // não precisa fechar o banco ?:???
        }
        return 1;
    }
    public ArrayList<Produto> consultarProduto(String nome) {
        Conexao conn = new Conexao();
        Connection conexao = conn.conectar();
        Statement stm;
        ResultSet rs;
        ArrayList<Produto> tempProduto = new ArrayList<>();
        try {
            stm = conexao.createStatement();
            String sql;
          
            sql = "SELECT * FROM Produto WHERE Nome LIKE '" + nome + "%';";
           
          
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                Produto produto = new Produto();
                produto.setCATEGORIAS_ID(rs.getInt("CATEGORIAS_ID"));
                produto.setNome(rs.getString("nome"));
                produto.setPRECO_CUSTO(rs.getDouble("PRECO_CUSTO"));
                produto.setPRECO_VENDA(rs.getDouble("PRECO_VENDA"));
                produto.setQTDE_MIN(rs.getInt("QTDE_MIN"));
                produto.setQTDE_MAX(rs.getInt("QTDE_MAX"));
                produto.setSALDO(rs.getInt("SALDO"));
                produto.setSTATUS(rs.getBoolean("STATUS"));
                tempProduto.add(produto);
                
            }
           
            rs.close();
            stm.close();

        } catch (Exception e) {
            System.err.println("Erro ao consultar.");
        } finally {
            conn.desconectar();
        }
        return tempProduto;
    }
    public int alterarProduto(int codigo, Produto produto) {
        Conexao conn = new Conexao();
        Connection conexao = conn.conectar();
        // UPDATE
        try {
            conexao.setAutoCommit(false);
            String sql = "UPDATE Produto SET CATEGORIAS_ID=?, NOME=?, PRECO_CUSTO=?, PRECO_VENDA=?, QTDE_MIN=?, QTDE_MAX=?, SALDO=?"
                    + "WHERE Id = ?";
            try (PreparedStatement ps = conexao.prepareStatement(sql)) {
                ps.setInt(1, produto.getCATEGORIAS_ID());
                ps.setString(2, produto.getNome());
                ps.setDouble(3, produto.getPRECO_CUSTO());
                ps.setDouble(4, produto.getPRECO_VENDA());
                ps.setInt(5, produto.getQTDE_MIN());
                ps.setInt(6, produto.getQTDE_MAX());
                ps.setDouble(7, produto.getSALDO());
                ps.execute();
                conexao.commit();
            }

        } catch (Exception ex) {
            System.err.println("Erro ao alterar!");
        } finally {
            conn.desconectar();
        }
        return 1;
    }
}
