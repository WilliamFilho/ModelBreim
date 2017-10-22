/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author wjnet
 */
public enum TipoEmpresa {
    M("Matriz"), F("Fillial");
    
    private String descricao;

    private TipoEmpresa(String descricao) {
        this.descricao = descricao;
    }

    public String toString() {
        return this.descricao;
    }

}
