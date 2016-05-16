/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.imeg.dao;

import br.senac.tads.pi3.imeg.entity.HistoricoEntrada;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.sql.Date;

/**
 *
 * @author diogo.lsousa
 */
public class HistoricoEntradaDao {

    private PreparedStatement pst;

    public boolean adicionar(HistoricoEntrada historicoEntrada) {
        String sql = "INSERT INTO ITENS_ENTRADA(DATA_TRANSACAO, QTDE_PRODUTOS, PRECO_CUSTO) VALUES(?,?,?)";

        try {
            pst = new Conexao().prepararStatement(sql);
            pst.setDate(1, new Date(System.currentTimeMillis()));
            pst.setInt(2, historicoEntrada.getQtde_produtos());
            pst.setDouble(3, historicoEntrada.getPreco_custo());

            pst.execute();
            
            return true;
            
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(HistoricoEntradaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
         return false;
    }

    public void consultarHistoricoEntrada(HistoricoEntrada historicoEntrada) {

    }

    public void alterarHistoricoEntrada(HistoricoEntrada historicoEntrada) {

    }

    public void removerHistoricoEntrada(HistoricoEntrada historicoEntrada) {

    }
}
