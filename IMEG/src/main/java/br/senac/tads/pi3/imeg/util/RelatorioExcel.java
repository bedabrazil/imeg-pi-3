/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.imeg.util;

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
}
