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
public class ProdutoDao {

    private PreparedStatement pst;

    public boolean adicionar(Produto produto) {

        String sql = "INSERT INTO PRODUTOS(CATEGORIAS_ID, NOME, QTDE_MIN, QTDE_MAX)"
                + "VALUES (?,?,?,?)";
        try {
            pst = new Conexao().prepararStatement(sql);
            pst.setInt(1, produto.getCategoria().getId());
            pst.setString(2, produto.getNome());
            pst.setInt(3, produto.getQtdeMin());
            pst.setInt(4, produto.getQtdeMax());
            if (pst.executeUpdate() > 0) {
                return true;
            }

        } catch (SQLException ex) {
            System.out.println("ERRO DE SQL: " + ex.getMessage());
        } finally {
            try {
                pst.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    public ArrayList<Produto> consultarProduto(String pesquisa, String categoria ) {
        String sql = "SELECT  FROM Produto WHERE '"+categoria+"' LIKE '" + pesquisa + "%'";
        ArrayList<Produto> tempProduto = new ArrayList<>();

        try {
            pst = new Conexao().prepararStatement(sql);
            ResultSet rs = pst.executeQuery(sql);
            while (rs.next()) {
                Produto produto = new Produto();
//                produto.getCategoria().getId(rs.getInt("CATEGORIAS_ID"));
                produto.setNome(rs.getString("nome"));
                produto.setPrecoCusto(rs.getDouble("PRECO_CUSTO"));
                produto.setPrecoVenda(rs.getDouble("PRECO_VENDA"));
                produto.setQtdeMin(rs.getInt("QTDE_MIN"));
                produto.setQtdeMax(rs.getInt("QTDE_MAX"));
                produto.setSaldo(rs.getInt("SALDO"));
                produto.setStatus(rs.getBoolean("STATUS"));
                tempProduto.add(produto);

            }
            return tempProduto;

        } catch (SQLException ex) {
            System.out.println("ERRO DE SQL: " + ex.getMessage());
        } finally {
            try {
                pst.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
    public Produto pesquisarPorId(int id ) {
        String sql = "SELECT PRODUTOS.* FROM PRODUTOS WHERE ID=?";

        try {
            pst = new Conexao().prepararStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            Produto produto = new Produto();
            if (rs.next()) {
                
//                produto.getCategoria().getId(rs.getInt("CATEGORIAS_ID"));
                produto.setNome(rs.getString("NOME"));
                produto.setQtdeMin(rs.getInt("QTDE_MIN"));
                produto.setQtdeMax(rs.getInt("QTDE_MAX"));
                produto.setStatus(rs.getBoolean("STATUS"));
            }
            return produto;

        } catch (SQLException ex) {
            System.out.println("ERRO DE SQL: " + ex.getMessage());
        } finally {
            try {
                pst.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    public boolean alterar(Produto produto) {
        String sql = "UPDATE PRODUTOS SET CATEGORIAS_ID=?, NOME=?, QTDE_MIN=?, QTDE_MAX=?"
                + "WHERE ID=?";
        // UPDATE

        try {
            pst = new Conexao().prepararStatement(sql);
            pst.setInt(1, produto.getCategoria().getId());
            pst.setString(2, produto.getNome());
            pst.setInt(3, produto.getQtdeMin());
            pst.setInt(4, produto.getQtdeMax());
            pst.setInt(8, produto.getId());
            if (pst.executeUpdate() > 0) {
                return true;
            }

        } catch (SQLException ex) {
            System.out.println("ERROR SQL: " + ex.getMessage());
        } finally {
            try {
                pst.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }
    public ArrayList<Produto> listar(){
        String sql = "SELECT PRODUTOS.* FROM PRODUTOS";
        try{
            pst = new Conexao().prepararStatement(sql);
            ResultSet res = pst.executeQuery();
            ArrayList<Produto> produtos = new ArrayList<>();
            while(res.next()){
                Produto p = new Produto();
                p.setId(res.getInt("ID"));
                p.setNome(res.getString("NOME"));
                p.setQtdeMax(res.getInt("QTDE_MIN"));
                p.setQtdeMax(res.getInt("QTDE_MAX"));
                produtos.add(p);
            }
            return produtos;
        } catch (SQLException ex) {
            System.out.println("ERROR SQL: " + ex.getMessage());
        } finally {
            try {
                pst.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
}

