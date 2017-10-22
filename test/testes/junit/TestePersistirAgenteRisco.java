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
import modelo.TipoRisco;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author wjnet
 */
public class TestePersistirAgenteRisco {
    EntityManager em;
    public TestePersistirAgenteRisco() {
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
            AgenteRisco ar = new AgenteRisco();
            AgenteRisco ar1 = new AgenteRisco();
            ar.setNome("Ruído");
            ar.setTipoRisco(em.find(TipoRisco.class, 1));
            ar1.setNome("Vibração");
            ar1.setTipoRisco(em.find(TipoRisco.class, 1));
            em.getTransaction().begin();
            em.persist(ar);
            em.persist(ar1);
            em.getTransaction().commit();
        } catch (Exception e){
            exception = true;
            e.printStackTrace();
        }
        Assert.assertEquals(false, exception);
        
    }
    
}
