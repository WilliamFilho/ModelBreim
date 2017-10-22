package testes.junit;


import java.util.List;
import javax.persistence.EntityManager;
import jpa.EntityManagerUtil;
import modelo.AgenteRisco;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author jorge
 */
public class TesteListarExamesAgenteRisco {

    EntityManager em;

    public TesteListarExamesAgenteRisco() {
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
    public void teste() {
        // o teste não deve gerar exceção se tudo estiver correto
        boolean exception = false;
        try {
            String jpql = "FROM AgenteRisco ar WHERE ar.id = 5";
            List<AgenteRisco> lista = em.createQuery(jpql).getResultList();
            for (AgenteRisco ar : lista){
                System.out.println("ID: "+ar.getId()+ " Exames: "+ ar.getExames() + "Tipo " + ar.getTipoRisco().getNome() +" ");
            }
 
        } catch (Exception e) {
            // se gerar exceção 
            exception = true;
            e.printStackTrace();
        }
        // compara se não ocorreu erro
        Assert.assertEquals(false, exception);
    }

}
