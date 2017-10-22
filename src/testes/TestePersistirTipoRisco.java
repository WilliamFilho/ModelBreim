/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes;

import javax.persistence.EntityManager;
import jpa.EntityManagerUtil;
import modelo.TipoRisco;

/**
 *
 * @author wjnet
 */
public class TestePersistirTipoRisco {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        EntityManager em = EntityManagerUtil.getEntityManager();
        TipoRisco tr = new TipoRisco();
        TipoRisco tr1 = new TipoRisco();
        tr.setNome("Físico");
        tr1.setNome("Químico");
        em.getTransaction().begin();
        em.persist(tr);
        em.persist(tr1);
        em.getTransaction().commit();
        em.close();
    }      
}
