/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author wjnet
 */
@Entity
@Table(name = "risco_especifico")
public class RiscoEspecifico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "nome", length = 60, nullable = false)
    @NotNull(message = "O nome não pode ser nulo")
    @NotBlank(message = "O campo não pode ser vazio")
    private String nome;
    @ManyToOne
    @JoinColumn(name = "agente_risco", referencedColumnName = "id")
    @ForeignKey(name = "fk_agente_risco_id")
    private AgenteRisco agenteRisco;
    @ManyToMany
    @JoinTable(name = "epi_risco_especifico",
            joinColumns = @JoinColumn(name = "risco_especifico", referencedColumnName = "id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "epi", referencedColumnName = "id", nullable = false))
    private List<EPI> epis = new ArrayList<>();
    @ManyToMany
    @JoinTable(name = "exame_risco_especifico",
            joinColumns = @JoinColumn(name = "risco_especifico", referencedColumnName = "id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "exame", referencedColumnName = "id", nullable = false))
    private List<Exame> exames = new ArrayList<>();

    public RiscoEspecifico() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RiscoEspecifico)) {
            return false;
        }
        RiscoEspecifico other = (RiscoEspecifico) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.RiscoEspecifico[ id=" + id + " ]";
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the agenteRisco
     */
    public AgenteRisco getAgenteRisco() {
        return agenteRisco;
    }

    /**
     * @param agenteRisco the agenteRisco to set
     */
    public void setAgenteRisco(AgenteRisco agenteRisco) {
        this.agenteRisco = agenteRisco;
    }

    /**
     * @return the exames
     */
    public List<Exame> getExames() {
        return exames;
    }

    /**
     * @param exames the exames to set
     */
    public void setExames(List<Exame> exames) {
        this.exames = exames;
    }

    /**
     * @return the epis
     */
    public List<EPI> getEpis() {
        return epis;
    }

    /**
     * @param epis the epis to set
     */
    public void setEpis(List<EPI> epis) {
        this.epis = epis;
    }

    
    

   

}
