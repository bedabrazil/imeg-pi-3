/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.imeg.util;

import br.senac.tads.pi3.imeg.dao.Conexao;
import br.senac.tads.pi3.imeg.entity.Produto;
import br.senac.tads.pi3.imeg.dao.ProdutoDao;
import java.util.ArrayList;
import java.util.Date;
import java.sql.*;
import java.text.SimpleDateFormat;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFCell;

/**
 *
 * @author Mssouza
 */
public class RelatorioExcel {

    private PreparedStatement pst;

    SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");

    public HSSFWorkbook FUNCIONARIO_MAIS_VENDEU_E(String dtInicio, String dtFim) {

        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet sheet = wb.createSheet("produtos");

        try {

            // popula primeira linha 
            HSSFRow rowhead = sheet.createRow(0);
            rowhead.createCell(0).setCellValue("DATA_TRANSACAO");
            rowhead.createCell(1).setCellValue("FUNCIONARIO_ID");
            rowhead.createCell(2).setCellValue("NOME");
            rowhead.createCell(3).setCellValue("UNIDADE_ID");
            rowhead.createCell(4).setCellValue("VENDA");

            int index = 1;
            String sql = "select * from ADM.FUNCIONARIO_MAIS_VENDEU_E WHERE DATA_TRANSACAO BETWEEN '?' AND '?'";
            pst = new Conexao().prepararStatement(sql);

            Date dt_inicio = null;
            Date dt_fim = null;
            dt_inicio = (Date) format.parse(dtInicio);
            dt_fim = (Date) format.parse(dtFim);

            pst.setDate(1, new java.sql.Date(dt_inicio.getTime()));
            pst.setDate(2, new java.sql.Date(dt_fim.getTime()));
            
            ResultSet rs = pst.executeQuery(sql);
            while (rs.next()) {
                rowhead = sheet.createRow(index);
                rowhead.createCell(0).setCellValue(rs.getInt(1));
                rowhead.createCell(1).setCellValue(rs.getString(2));
                rowhead.createCell(2).setCellValue(rs.getString(3));
                rowhead.createCell(3).setCellValue(rs.getDouble(4));
                index++;
            }

        } catch (Exception e) {
        }

        return wb;
    }

    public HSSFWorkbook BAIXO_ESTOQUE() {

        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet sheet = wb.createSheet("Baixa de estoque");// DA NOME PARA PLANILHA

        try {

            // popula primeira linha 
            HSSFRow rowhead = sheet.createRow(0);
            rowhead.createCell(0).setCellValue("id");
            rowhead.createCell(1).setCellValue("produto_id");
            rowhead.createCell(2).setCellValue("Categoria_id");
            rowhead.createCell(3).setCellValue("preco_custo");
            rowhead.createCell(4).setCellValue("preco_venda");
            rowhead.createCell(5).setCellValue("qtde_min");
            rowhead.createCell(6).setCellValue("qtd_max");
            rowhead.createCell(7).setCellValue("saldo");
            rowhead.createCell(8).setCellValue("DESCRICAO_CURTA");

            int index = 1;
            String sql = "SELECT * FROM ADM.BAIXO_ESTOQUE_E";
            pst = new Conexao().prepararStatement(sql);
            ResultSet rs = pst.executeQuery(sql);
            while (rs.next()) {
                rowhead = sheet.createRow(index);
                rowhead.createCell(0).setCellValue(rs.getInt(1));
                rowhead.createCell(1).setCellValue(rs.getInt(2));
                rowhead.createCell(2).setCellValue(rs.getInt(3));
                rowhead.createCell(3).setCellValue(rs.getDouble(4));
                rowhead.createCell(4).setCellValue(rs.getDouble(5));
                rowhead.createCell(5).setCellValue(rs.getInt(6));
                rowhead.createCell(6).setCellValue(rs.getInt(7));
                rowhead.createCell(7).setCellValue(rs.getInt(8));
                index++;
            }

        } catch (Exception e) {
        }

        return wb;
    }

    public HSSFWorkbook MAIS_VENDIDOS_E(String dtInicio, String dtFim) {
        HSSFWorkbook wb = new HSSFWorkbook();
        try {

            // popula primeira linha 
            
            HSSFSheet sheet = wb.createSheet("Mais vendidos");
            HSSFRow rowhead = sheet.createRow(0);
            rowhead.createCell(0).setCellValue("qtd_venda");
            rowhead.createCell(1).setCellValue("produto_id");
            rowhead.createCell(2).setCellValue("produto");
            rowhead.createCell(3).setCellValue("categoria");
            rowhead.createCell(4).setCellValue("data_transacao");

            
            String sql = "SELECT * FROM ADM.MAIS_VENDIDOS_E WHERE DATA_TRANSACAO BETWEEN '?' AND '?'";
            
            pst = new Conexao().prepararStatement(sql);
            
            Date dt_inicio = null;
            Date dt_fim = null;
            dt_inicio = (Date) format.parse(dtInicio);
            dt_fim = (Date) format.parse(dtFim);
            
            pst.setDate(1, new java.sql.Date(dt_inicio.getTime()));
            pst.setDate(2, new java.sql.Date(dt_fim.getTime()));

            ResultSet rs;
            rs = pst.executeQuery(sql);
            int index = 1;
            while (rs.next()) {
                rowhead = sheet.createRow(index);
                rowhead.createCell(0).setCellValue(rs.getInt(1));
                rowhead.createCell(1).setCellValue(rs.getInt(2));
                rowhead.createCell(2).setCellValue(rs.getString(3));
                rowhead.createCell(3).setCellValue(rs.getString(4));
                rowhead.createCell(4).setCellValue(rs.getDate(5));
                index++;
            }

        } catch (Exception e) {
        }

        return wb;
    }
}
