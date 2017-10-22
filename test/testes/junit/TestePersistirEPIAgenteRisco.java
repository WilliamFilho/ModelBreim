/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes.junit;

import javax.persistence.EntityManager;
import jpa.EntityManagerUtil;
import junit.framework.Assert;
import modelo.AgenteRisco;
import modelo.EPI;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author wjnet
 */
public class TestePersistirEPIAgenteRisco {
    EntityManager em;
    public TestePersistirEPIAgenteRisco() {
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
            AgenteRisco ar = em.find(AgenteRisco.class, 1);
            EPI e = em.find(EPI.class, 14471);
            ar.getEpis().add(e);
            em.getTransaction().begin();
            em.persist(ar);
            em.getTransaction().commit();
        } catch (Exception e){
            exception = true;
            e.printStackTrace();
        }
        Assert.assertEquals(false, exception);
        
    }
    
}
