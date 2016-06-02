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

    public ArrayList<Produto> produtosVendidosPorUnidade(Funcionario funcionario) {
        String sql = "SELECT * FROM ITENS_SAIDA WHERE UNIDADES_ID=?";
        try {
            ArrayList<Produto> produtos = new ArrayList<>();
            pst = new Conexao().prepararStatement(sql);
            pst.setInt(1, funcionario.getUnidade().getId());
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Produto produto = new ProdutoDao().pesquisarPorId(rs.getInt("PRODUTOS_ID"));
                produtos.add(produto);
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

        public ArrayList<Produto> produtosVendidosPorVendedor(Funcionario funcionario) {
        String sql = "SELECT * FROM ITENS_SAIDA WHERE UNIDADES_ID=? AND FUNCIONARIOS_ID=?";
        try {
            ArrayList<Produto> produtos = new ArrayList<>();
            pst = new Conexao().prepararStatement(sql);
            pst.setInt(1, funcionario.getUnidade().getId());
            pst.setInt(2, funcionario.getId());
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Produto produto = new ProdutoDao().pesquisarPorId(rs.getInt("PRODUTOS_ID"));
                produtos.add(produto);
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
    public void consultaritemSaida(ItemSaida itemSaida) {

    }

    public void alteraritemSaida(ItemSaida itemSaida) {

    }

    public void removeritemSaida(ItemSaida itemSaida) {

    }
}
