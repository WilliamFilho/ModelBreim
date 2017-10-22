/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes;

import javax.persistence.EntityManager;
import jpa.EntityManagerUtil;
import modelo.Pais;

/**
 *
 * @author wjnet
 */
public class TestePersistirPais {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        EntityManager em = EntityManagerUtil.getEntityManager();
        Pais p = new Pais();
        p.setNome("Brasil");
        p.setIso("BRA");
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
        em.close();
    }      
}
