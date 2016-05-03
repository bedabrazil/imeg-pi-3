/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.imeg.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import br.senac.tads.pi3.imeg.entity.Produto;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author matheus.ssouza1
 */
public class ProdutoDAO {

    private PreparedStatement pst;

    public boolean cadastrarProduto(Produto produto) {

        String sql = "INSERT INTO  PRODUTOS(CATEGORIAS_ID, NOME, PRECO_CUSTO, PRECO_VENDA, QTDE_MIN, QTDE_MAX, SALDO)"
                + "VALUES (?,?,?,?,?,?,?);";
        try {
            pst = new Conexao().prepararStatement(sql);
            pst.setInt(1, produto.getCATEGORIAS_ID());
            pst.setString(2, produto.getNome());
            pst.setDouble(3, produto.getPRECO_CUSTO());
            pst.setDouble(4, produto.getPRECO_VENDA());
            pst.setInt(5, produto.getQTDE_MIN());
            pst.setInt(6, produto.getQTDE_MAX());
            pst.setDouble(7, produto.getSALDO());
            if (pst.executeUpdate() > 0) {
                return true;
            }

        } catch (SQLException ex) {
            System.out.println("ERRO DE SQL: " + ex.getMessage());
        } finally {
            try {
                pst.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    public ArrayList<Produto> consultarProduto(String nome) {
        String sql = "SELECT * FROM Produto WHERE Nome LIKE '" + nome + "%';";
        ArrayList<Produto> tempProduto = new ArrayList<>();

        try {
            pst = new Conexao().prepararStatement(sql);
            ResultSet rs = pst.executeQuery(sql);
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
            return tempProduto;

        } catch (SQLException ex) {
            System.out.println("ERRO DE SQL: " + ex.getMessage());
        } finally {
            try {
                pst.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    public boolean alterarProduto(int codigo, Produto produto) {
        String sql = "UPDATE Produto SET CATEGORIAS_ID=?, NOME=?, PRECO_CUSTO=?, PRECO_VENDA=?, QTDE_MIN=?, QTDE_MAX=?, SALDO=?"
                + "WHERE Id = ?";
        // UPDATE

        try {
            pst = new Conexao().prepararStatement(sql);
            pst.setInt(1, produto.getCATEGORIAS_ID());
            pst.setString(2, produto.getNome());
            pst.setDouble(3, produto.getPRECO_CUSTO());
            pst.setDouble(4, produto.getPRECO_VENDA());
            pst.setInt(5, produto.getQTDE_MIN());
            pst.setInt(6, produto.getQTDE_MAX());
            pst.setDouble(7, produto.getSALDO());
            if (pst.executeUpdate() > 0) {
                return true;
            }

        } catch (SQLException ex) {
            System.out.println("ERROR SQL: " + ex.getMessage());
        } finally {
            try {
                pst.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }
}
