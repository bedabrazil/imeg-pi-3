/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.imeg.dao;

import br.senac.tads.pi3.imeg.entity.ItemSaida;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;

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

    public void consultaritemSaida(ItemSaida itemSaida) {

    }

    public void alteraritemSaida(ItemSaida itemSaida) {

    }

    public void removeritemSaida(ItemSaida itemSaida) {

    }
}
