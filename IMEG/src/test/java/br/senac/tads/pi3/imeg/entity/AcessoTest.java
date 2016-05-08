/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import br.senac.tads.pi3.imeg.dao.AcessoDao;
import br.senac.tads.pi3.imeg.entity.Acesso;
import org.junit.Assert;

/**
 *
 * @author marcio.soares <marcio@mail.com>
 */
public class AcessoTest {
    
    public AcessoTest() {
    }
    public void adicionarTest(){
        Acesso acesso = new Acesso("PRESIDENTE", true);
        AcessoDao aDao = new AcessoDao();
        aDao.adicionar(acesso);
        Acesso acessoResult = aDao.pesquisarPorNome(acesso);
        Assert.assertEquals(acessoResult, acesso);
    }
}
