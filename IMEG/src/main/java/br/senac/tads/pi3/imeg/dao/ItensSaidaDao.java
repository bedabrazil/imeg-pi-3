/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.imeg.dao;

import br.senac.tads.pi3.imeg.entity.Funcionario;
import br.senac.tads.pi3.imeg.entity.ItemSaida;
import br.senac.tads.pi3.imeg.entity.Produto;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author diogo.lsousa
 */
public class ItensSaidaDao {

    private PreparedStatement pst;

    public void incluiritemSaida(ItemSaida itemSaida) {

        String sql = "INSERT INTO ITENS_SAIDA(PRODUTOS_ID, UNIDADES_ID, DATA_TRANSACAO, QTDE_PRODUTOS) VALUES(?,?,?,?)";

        try {
            pst = new Conexao().prepararStatement(sql);
//            pst.setInt(1, itemSaida.getProduto());
//            pst.setInt(2, itemSaida.getFuncionarios_id());
            pst.setDate(3, new Date(System.currentTimeMillis()));
            pst.setInt(4, itemSaida.getQtdeProdutos());

            pst.execute();
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(ItensSaidaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<ItemSaida> produtosVendidosPorUnidade(Funcionario funcionario) {
        String sql = "SELECT * FROM ITENS_SAIDA WHERE UNIDADES_ID=?";
        try {
            ArrayList<ItemSaida> itensSaida = new ArrayList<>();
            pst = new Conexao().prepararStatement(sql);
            pst.setInt(1, funcionario.getUnidade().getId());
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                ItemSaida iSaida = new ItemSaida();
                iSaida.setProduto(new ProdutoDao().pesquisarPorId(rs.getInt("PRODUTOS_ID")));
                iSaida.setDataTransacao(rs.getDate("DATA_TRANSACAO"));
                iSaida.setFuncionario(new FuncionarioDao().pesquisarPorId(rs.getInt("FUNCIONARIOS_ID")));
                iSaida.setPrecoVenda(rs.getDouble("PRECO_VENDA"));
                iSaida.setQtdeProdutos(rs.getInt("QTDE_PRODUTOS"));
                itensSaida.add(iSaida);
            }
            return itensSaida;
        } catch (SQLException ex) {
            Logger.getLogger(Funcionario.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                pst.close();
            } catch (SQLException ex) {
                Logger.getLogger(ItensSaidaDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

        public ArrayList<ItemSaida> produtosVendidosPorVendedor(Funcionario funcionario) {
        String sql = "SELECT * FROM ITENS_SAIDA WHERE UNIDADES_ID=? AND FUNCIONARIOS_ID=?";
        try {
            ArrayList<ItemSaida> itensSaida = new ArrayList<>();
            pst = new Conexao().prepararStatement(sql);
            pst.setInt(1, funcionario.getUnidade().getId());
            pst.setInt(2, funcionario.getId());
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                ItemSaida iSaida = new ItemSaida();
                iSaida.setProduto(new ProdutoDao().pesquisarPorId(rs.getInt("PRODUTOS_ID")));
                iSaida.setDataTransacao(rs.getDate("DATA_TRANSACAO"));
                iSaida.setFuncionario(funcionario);
                iSaida.setPrecoVenda(rs.getDouble("PRECO_VENDA"));
                iSaida.setQtdeProdutos(rs.getInt("QTDE_PRODUTOS"));
                itensSaida.add(iSaida);
            }
            return itensSaida;
        } catch (SQLException ex) {
            Logger.getLogger(Funcionario.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                pst.close();
            } catch (SQLException ex) {
                Logger.getLogger(ItensSaidaDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
    
    public boolean adicionar(Produto produto, int qtd, Funcionario funcionario) {
        String sql = "INSERT INTO ITENS_SAIDA (PRODUTOS_ID, UNIDADES_ID, FUNCIONARIOS_ID, DATA_TRANSACAO, QTDE_PRODUTOS, PRECO_VENDA)"
                +" VALUES(?,?,?,?,?,?)";
        try{
            pst = new Conexao().prepararStatement(sql);
            pst.setInt(1, produto.getId());
            pst.setInt(2, funcionario.getUnidade().getId());
            pst.setInt(3, funcionario.getId());
            pst.setDate(4, new java.sql.Date(System.currentTimeMillis()));
            pst.setInt(5, qtd);
            pst.setDouble(6, produto.getPrecoVenda());
            if (pst.executeUpdate() > 0) {
                return true;
            }            
        } catch (SQLException ex) {
            Logger.getLogger(Funcionario.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                pst.close();
            } catch (SQLException ex) {
                Logger.getLogger(ItensSaidaDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    public ArrayList<ItemSaida> produtosVendidos() {
        String sql = "SELECT * FROM ITENS_SAIDA";
        try{
            pst = new Conexao().prepararStatement(sql);
            ResultSet rs = pst.executeQuery();
            ArrayList<ItemSaida> produtos = new ArrayList<>();
            while(rs.next()){
                ItemSaida iSaida = new ItemSaida();
                iSaida.setProduto(new ProdutoDao().pesquisarPorId(rs.getInt("PRODUTOS_ID")));
                iSaida.setFuncionario(new FuncionarioDao().pesquisarPorId(rs.getInt("FUNCIONARIOS_ID")));
                iSaida.setQtdeProdutos(rs.getInt("QTDE_PRODUTOS"));
                iSaida.setDataTransacao(rs.getDate("DATA_TRANSACAO"));
                iSaida.setPrecoVenda(rs.getDouble("PRECO_VENDA"));
                produtos.add(iSaida);
            }
            return produtos;
        } catch (SQLException ex) {
            Logger.getLogger(Funcionario.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                pst.close();
            } catch (SQLException ex) {
                Logger.getLogger(ItensSaidaDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    public void removeritemSaida(ItemSaida itemSaida) {

    }
}
