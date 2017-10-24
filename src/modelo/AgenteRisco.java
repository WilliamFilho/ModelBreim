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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author wjnet
 */
/*
uniqueConstraints = {
                @UniqueConstraint(columnNames = {"agente_risco"})})*/
@Entity
@Table(name = "agente_risco")
public class AgenteRisco implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "nome", length = 60, nullable = false)
    @NotNull(message = "O nome não pode ser nulo")
    @NotBlank(message = "O campo não pode ser vazio")
    private String nome;
    @ManyToOne
    @JoinColumn(name = "tipo_risco", referencedColumnName = "id", nullable = false)
    @NotNull(message = "Tipo deve ser informado")
    private TipoRisco tipoRisco;
    @OneToMany(mappedBy = "agenteRisco", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<RiscoEspecifico> riscoEspecifico = new ArrayList<>();
    @ManyToMany
    @JoinTable(name = "exames_agente_risco",
            joinColumns = @JoinColumn(name = "agente_risco", referencedColumnName = "id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "exame", referencedColumnName = "id", nullable = false))
    private List<Exame> exames = new ArrayList<>();
    @ManyToMany
    @JoinTable(name = "epi_agente_risco",
            joinColumns = @JoinColumn(name = "agente_risco", referencedColumnName = "id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "epi", referencedColumnName = "id", nullable = false))
    private List<EPI> epis = new ArrayList<>();

    public AgenteRisco() {
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
        if (!(object instanceof AgenteRisco)) {
            return false;
        }
        AgenteRisco other = (AgenteRisco) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.AgenteRisco[ id=" + id + " ]";
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
     * @return the tipoRisco
     */
    public TipoRisco getTipoRisco() {
        return tipoRisco;
    }

    /**
     * @param tipoRisco the tipoRisco to set
     */
    public void setTipoRisco(TipoRisco tipoRisco) {
        this.tipoRisco = tipoRisco;
    }

    /**
     * @return the riscoEspecifico
     */
    public List<RiscoEspecifico> getRiscoEspecifico() {
        return riscoEspecifico;
    }

    /**
     * @param riscoEspecifico the riscoEspecifico to set
     */
    public void setRiscoEspecifico(List<RiscoEspecifico> riscoEspecifico) {
        this.riscoEspecifico = riscoEspecifico;
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

}
