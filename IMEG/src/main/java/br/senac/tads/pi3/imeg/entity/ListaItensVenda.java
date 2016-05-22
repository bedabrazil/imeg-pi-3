/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.imeg.entity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Eilane
 */
public class ListaItensVenda {
    private int id;
    private List<ItemVenda> itens;
    private double total;

    
    
    public void adicionar(ItemVenda item){
      if(this.itens == null){
          this.itens =new ArrayList<ItemVenda>();     
      }
       this.itens.add(item);
    }
    
    public void remover(ItemVenda Itemremove){
      for(Iterator i = itens.iterator();i.hasNext();){
       ItemVenda item = (ItemVenda) i.next();
       
       if(item.getProduto().getId() == Itemremove.getProduto().getId()){
           i.remove();
       }
      }
    }//
    
    public double calculaTotal(){
      double total=0;
      for(ItemVenda item : this.itens){
      
      total += item.getTotal();
      
      }
     return total;
    }
    
    
    
    public int getId() {
        return id;
    }

  
    public List<ItemVenda> getItens() {
        return itens;
    }

}
