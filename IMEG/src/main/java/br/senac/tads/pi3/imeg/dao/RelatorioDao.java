/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.imeg.dao;

import br.senac.tads.pi3.imeg.entity.RelatorioVenda;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author iosato
 */
public class RelatorioDao {
    
    private PreparedStatement pst;

    //Lista produtos mais vendidos
    public ArrayList<RelatorioVenda> listarMaisVendidos() {
        String sql = "SELECT * FROM TRES_MAIS_VENDIDOS";
        ArrayList<RelatorioVenda> rVenda = new ArrayList<>();
        try {

            pst = new Conexao().prepararStatement(sql);
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                RelatorioVenda r = new RelatorioVenda();
                ProdutoDao p = new ProdutoDao();
                r.setQtdeVendida(res.getInt("QTD_VENDA"));
                r.setProduto(p.pesquisarPorId(res.getInt("PRODUTO")));

                rVenda.add(r);
            }
            return rVenda;
        } catch (SQLException e) {
            System.out.println("ERROR SQL: " + e.getMessage() + "\n" + e.getSQLState());
        } finally {
            try {
                pst.close();
            } catch (SQLException e) {
                Logger.getLogger(CategoriaDao.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return null;
    }    
}
