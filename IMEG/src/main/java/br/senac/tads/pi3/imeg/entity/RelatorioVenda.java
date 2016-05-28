/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.imeg.entity;

import br.senac.tads.pi3.imeg.dao.RelatorioDao;
import java.util.ArrayList;

/**
 *
 * @author iosato
 */
public class RelatorioVenda implements Relatorio{
    private int qtdeVendida;
    private Produto produto;

    public int getQtdeVendida() {
        return qtdeVendida;
    }

    public void setQtdeVendida(int qtdeVendida) {
        this.qtdeVendida = qtdeVendida;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
}
