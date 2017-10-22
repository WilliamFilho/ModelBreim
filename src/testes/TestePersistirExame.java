/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes;

import javax.persistence.EntityManager;
import jpa.EntityManagerUtil;
import modelo.Exame;

/**
 *
 * @author wjnet
 */
public class TestePersistirExame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        EntityManager em = EntityManagerUtil.getEntityManager();
        Exame e = new Exame();
        Exame e1 = new Exame();
        e.setNome("Urina");
        e1.setNome("Sangue");
        em.getTransaction().begin();
        em.persist(e);
        em.persist(e1);
        em.getTransaction().commit();
        em.close();
    }
}
