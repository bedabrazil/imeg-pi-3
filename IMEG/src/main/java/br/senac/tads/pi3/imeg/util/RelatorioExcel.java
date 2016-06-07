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
    public HSSFWorkbook relatorio(Date dtInicio, Date dtFim) {

        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet sheet = wb.createSheet("produtos");

        try {

            // popula primeira linha 
            HSSFRow rowhead = sheet.createRow(0);
            rowhead.createCell(0).setCellValue("id");
            rowhead.createCell(1).setCellValue("categorias_id");
            rowhead.createCell(2).setCellValue("nome");
            rowhead.createCell(3).setCellValue("descrição");
            rowhead.createCell(4).setCellValue("descrição_curta");
            rowhead.createCell(5).setCellValue("PRECO_CUSTO");
            rowhead.createCell(6).setCellValue("PRECO_VENDA");
            rowhead.createCell(7).setCellValue("STATUS");
            rowhead.createCell(8).setCellValue("DESCRICAO_CURTA");

            ArrayList<Produto> lista;

            ProdutoDao prod = new ProdutoDao();
            lista = prod.listarMatriz();

            int index = 1;
            for (Produto produto : lista) {
                rowhead = sheet.createRow(index);
                rowhead.createCell(0).setCellValue(produto.getId());
                rowhead.createCell(1).setCellValue(produto.getNome());
                rowhead.createCell(2).setCellValue(produto.getQtdeMin());
                rowhead.createCell(3).setCellValue(produto.getQtdeMax());
                rowhead.createCell(4).setCellValue(produto.isStatus());
                rowhead.createCell(5).setCellValue(produto.getPrecoCusto());
                rowhead.createCell(6).setCellValue(produto.getPrecoVenda());
                rowhead.createCell(7).setCellValue(produto.getDescricao());
                rowhead.createCell(8).setCellValue(produto.getDescricaoCurta());
                index++;
            }

        } catch (Exception e) {
        }

        return wb;
    }
    
    public HSSFWorkbook BAIXO_ESTOQUE () {

        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet sheet = wb.createSheet("Baixa de estoque");

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
            String sql ="SELECT * FROM ADM.BAIXO_ESTOQUE_E";
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
                
            }
           

        } catch (Exception e) {
        }

        return wb;
    }
    public HSSFWorkbook MAIS_VENDIDOS_E () {

        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet sheet = wb.createSheet("Mais vendidos");

        try {

            // popula primeira linha 
            HSSFRow rowhead = sheet.createRow(0);
            rowhead.createCell(0).setCellValue("qtd_venda");
            rowhead.createCell(1).setCellValue("produto_id");
            rowhead.createCell(2).setCellValue("produto");
            rowhead.createCell(3).setCellValue("categoria");
            rowhead.createCell(4).setCellValue("data_transacao");

            int index = 1;
            String sql ="SELECT * FROM ADM.MAIS_VENDIDOS_E";
            pst = new Conexao().prepararStatement(sql);
            ResultSet rs = pst.executeQuery(sql);
            while (rs.next()) {                
                rowhead = sheet.createRow(index);
                rowhead.createCell(0).setCellValue(rs.getInt(1));
                rowhead.createCell(1).setCellValue(rs.getInt(2));
                rowhead.createCell(2).setCellValue(rs.getString(3));
                rowhead.createCell(3).setCellValue(rs.getString(4));
                rowhead.createCell(4).setCellValue(rs.getDate(5));
                
            }
           

        } catch (Exception e) {
        }

        return wb;
    }
}
