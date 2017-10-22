/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes;

import javax.persistence.EntityManager;
import jpa.EntityManagerUtil;
import modelo.EPI;

/**
 *
 * @author wjnet
 */
public class TestePersistirEPI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        EntityManager em = EntityManagerUtil.getEntityManager();
        EPI e = new EPI();
        EPI e1 = new EPI();
        e.setId(35003);
        e.setNome("PROTETOR AUDITIVO");
        e1.setId(14471);
        e1.setNome("PROTETOR AUDITIVO1");   
        em.getTransaction().begin();
        em.persist(e);
        em.persist(e1);
        em.getTransaction().commit();
        em.close();
    }      
}
