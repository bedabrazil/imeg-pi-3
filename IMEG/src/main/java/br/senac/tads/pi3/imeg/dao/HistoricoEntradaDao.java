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

    public void incluirHistoricoEntrada(HistoricoEntrada historicoEntrada) {
        String sql = "INSERT INTO HISTORICOENTRADA(PRODUTOS_ID, FUNCIONARIOS_ID, DATA_TRANSACAO, QTDE_PRODUTOS) VALUES(?,?,?,?)";

        try {
            pst = new Conexao().prepararStatement(sql);
            pst.setInt(1, historicoEntrada.getProdutos_id());
            pst.setInt(2, historicoEntrada.getFuncionarios_id());
            pst.setDate(3, new Date(System.currentTimeMillis()));
            pst.setInt(4, historicoEntrada.getQtde_produtos());

            pst.execute();
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(HistoricoEntradaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void consultarHistoricoEntrada(HistoricoEntrada historicoEntrada) {

    }

    public void alterarHistoricoEntrada(HistoricoEntrada historicoEntrada) {

    }

    public void removerHistoricoEntrada(HistoricoEntrada historicoEntrada) {

    }
}
