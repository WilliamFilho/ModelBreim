/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author wjnet
 */
@Entity
@Table(name = "empresa")
public class Empresa extends PessoaJuridica implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "nome_fantasia", length = 80)
    private String nomeFantasia;
    @Column(name = "ramo_atividade", length = 50)
    private String ramoAtividade;
    @OneToMany (mappedBy = "empresa", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Filial> filiais = new ArrayList<>();

    public Empresa() {
    }



    /**
     * @return the nomeFantasia
     */
    public String getNomeFantasia() {
        return nomeFantasia;
    }

    /**
     * @param nomeFantasia the nomeFantasia to set
     */
    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    /**
     * @return the ramoAtividade
     */
    public String getRamoAtividade() {
        return ramoAtividade;
    }

    /**
     * @param ramoAtividade the ramoAtividade to set
     */
    public void setRamoAtividade(String ramoAtividade) {
        this.ramoAtividade = ramoAtividade;
    }

    /**
     * @return the filiais
     */
    public List<Filial> getFiliais() {
        return filiais;
    }

    /**
     * @param filiais the filiais to set
     */
    public void setFiliais(List<Filial> filiais) {
        this.filiais = filiais;
    }
    
}
