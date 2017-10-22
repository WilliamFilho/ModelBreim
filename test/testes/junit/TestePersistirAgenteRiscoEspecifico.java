/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes.junit;

import javax.persistence.EntityManager;
import jpa.EntityManagerUtil;
import junit.framework.Assert;
import modelo.RiscoEspecifico;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author wjnet
 */
public class TestePersistirAgenteRiscoEspecifico {
    EntityManager em;
    public TestePersistirAgenteRiscoEspecifico() {
    }
    
    @Before
    public void setUp() {
        em = EntityManagerUtil.getEntityManager();
    }
    
    @After
    public void tearDown() {
        em.close();
    }
    
    @Test
    public void teste(){
        boolean exception = false;
        try {
            RiscoEspecifico re = new RiscoEspecifico();
            re.setNome("Ruído");
            //re.setAgenteRisco(em.find(AgenteRisco.class, ));
            //re.setTipoRisco(em.find(Ti"poRisco.class, 3));
            em.getTransaction().begin();
            em.persist(re);
            em.getTransaction().commit();
        } catch (Exception e){
            exception = true;
            e.printStackTrace();
        }
        Assert.assertEquals(false, exception);
        
    }
    
}
