/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.imeg.dao;

import br.senac.tads.pi3.imeg.entity.Funcionario;
import br.senac.tads.pi3.imeg.entity.ItemEntrada;
import br.senac.tads.pi3.imeg.entity.Produto;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Logger;

/**
 *
 * @author diogo.lsousa
 */
public class ItensEntradaDao {

    private PreparedStatement pst;

    public boolean adicionar(ItemEntrada itemEntrada) {
        String sql = "INSERT INTO ITENS_ENTRADA(PRODUTOS_ID, UNIDADES_ID, DATA_TRANSACAO, QTDE_PRODUTOS,PRECO_CUSTO, PRECO_VENDA) VALUES(?,?,?,?,?,?)";

        try {
            pst = new Conexao().prepararStatement(sql);
            pst.setInt(1, itemEntrada.getProduto().getId());
            pst.setInt(2, itemEntrada.getFuncionario().getUnidade().getId());
            pst.setDate(3, new Date(System.currentTimeMillis()));
            pst.setInt(4, itemEntrada.getQtdeProduto());
            pst.setDouble(5, itemEntrada.getPrecoCusto());
            pst.setDouble(6, itemEntrada.getPrecoVenda());
            pst.execute();

            return true;

        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(ItensEntradaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public void atualizarSaldoPrecoVenda(ItemEntrada itemEntrada) {

        String sql = "UPDATE PRODUTOS\n"
                + "SET  SALDO = ?, PRECO_VENDA=?, PRECO_CUSTO=? \n"
                + "WHERE ID = ?";
        try {

            pst = new Conexao().prepararStatement(sql);
            pst.setInt(1, itemEntrada.getProduto().getSaldo() + itemEntrada.getQtdeProduto());
            pst.setDouble(2, itemEntrada.getPrecoVenda());
            pst.setDouble(3, itemEntrada.getPrecoCusto());
            pst.setInt(4, itemEntrada.getProduto().getId());

            pst.execute();
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(ItensEntradaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Produto> listarProdutosComprados(Funcionario funcionario){
        String sql = "SELECT * FROM PEDIDOS_ENTRADA WHERE UNIDADES_ID = ?";
        try{
            ArrayList produtos = new ArrayList();
            pst = new Conexao().prepararStatement(sql);
            pst.setInt(1, funcionario.getUnidade().getId());
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                Produto produto = new ProdutoDao().pesquisarPorId(rs.getInt("PRODUTOS_ID"));
                if(produto != null){
                    produtos.add(produto);
                }
            }
            return produtos;
        } catch (SQLException ex) {
            System.out.println("ERROR SQL: " + ex.getMessage());
        } finally {
            try {
                pst.close();
            } catch (SQLException ex) {
                Logger.getLogger(ItensEntradaDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }    
    public ArrayList<Produto> listarProdutosUnidade(Funcionario funcionario){
        String sql = "SELECT * FROM ITENS_ENTRADA WHERE UNIDADES_ID = ?";
        try{
            ArrayList produtos = new ArrayList();
            pst = new Conexao().prepararStatement(sql);
            pst.setInt(1, funcionario.getUnidade().getId());
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                Produto produto = new ProdutoDao().pesquisarPorId(rs.getInt("PRODUTOS_ID"));
                if(produto != null){
                    produtos.add(produto);
                }
            }
            return produtos;
        } catch (SQLException ex) {
            System.out.println("ERROR SQL: " + ex.getMessage());
        } finally {
            try {
                pst.close();
            } catch (SQLException ex) {
                Logger.getLogger(ItensEntradaDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
    public void consultaritemEntrada(ItemEntrada itemEntrada) {

    }

    public void alteraritemEntrada(ItemEntrada itemEntrada) {

    }

    public void removeritemEntrada(ItemEntrada itemEntrada) {

    }
}
