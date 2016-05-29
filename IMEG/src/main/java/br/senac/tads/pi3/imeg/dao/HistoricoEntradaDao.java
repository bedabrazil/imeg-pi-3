/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.imeg.dao;

import br.senac.tads.pi3.imeg.entity.HistoricoEntrada;
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
public class HistoricoEntradaDao {

    private PreparedStatement pst;

    public boolean adicionar(HistoricoEntrada historicoEntrada) {
        String sql = "INSERT INTO ITENS_ENTRADA(PRODUTOS_ID, FUNCIONARIOS_ID, DATA_TRANSACAO, QTDE_PRODUTOS,PRECO_CUSTO, PRECO_VENDA) VALUES(?,?,?,?,?,?)";

        try {
            pst = new Conexao().prepararStatement(sql);
            pst.setInt(1, historicoEntrada.getProduto().getId());
            pst.setInt(2, historicoEntrada.getFuncionario().getId());
            pst.setDate(3, new Date(System.currentTimeMillis()));
            pst.setInt(4, historicoEntrada.getQtdeProduto());
            pst.setDouble(5, historicoEntrada.getPrecoCusto());
            pst.setDouble(6, historicoEntrada.getPrecoVenda());
            pst.execute();

            return true;

        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(HistoricoEntradaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public void atualizarSaldoPrecoVenda(HistoricoEntrada historicoEntrada) {

        String sql = "UPDATE PRODUTOS\n"
                + "SET  SALDO = ?, PRECO_VENDA=?, PRECO_CUSTO=? \n"
                + "WHERE ID = ?";
        try {

            pst = new Conexao().prepararStatement(sql);
            pst.setInt(1, historicoEntrada.getProduto().getSaldo() + historicoEntrada.getQtdeProduto());
            pst.setDouble(2, historicoEntrada.getPrecoVenda());
            pst.setDouble(3, historicoEntrada.getPrecoCusto());
            pst.setInt(4, historicoEntrada.getProduto().getId());

            pst.execute();
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(HistoricoSaidaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void consultarHistoricoEntrada(HistoricoEntrada historicoEntrada) {

    }

    public void alterarHistoricoEntrada(HistoricoEntrada historicoEntrada) {

    }

    public void removerHistoricoEntrada(HistoricoEntrada historicoEntrada) {

    }
}
