/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.ArrayList;
import java.util.List;
import modelo.AgenteRisco;
import modelo.TipoRisco;

/**
 *
 * @author williamfilho
 */
public class UtilRelatorios {

    public static List<AgenteRisco> listaAgenteRisco(){
        List<AgenteRisco> lista = new ArrayList<>();
        AgenteRisco ar1 = new AgenteRisco();
        AgenteRisco ar2 = new AgenteRisco();
        
        TipoRisco tr = new TipoRisco();
        tr.setNome("Tipo 1");
        
        ar1.setNome("Agente 1");
        ar1.setTipoRisco(tr);
        ar2.setNome("Agente 2");
        ar2.setTipoRisco(tr);
        
        lista.add(ar1);
        lista.add(ar2);
        
        return lista;
    }

}
