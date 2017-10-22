/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotBlank;




/**
 *
 * @author wjnet
 */
@Entity
@Table(name="cargo")
public class Cargo implements Serializable{
    @Id
    @SequenceGenerator(name = "seq_cargo", sequenceName = "seq_cargo_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_cargo", strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "cargo", length = 60, nullable = false)
    @NotNull(message = "O cargo não pode ser nulo")
    @NotBlank(message = "O cargo não pode está em branco")
    private String nome;
    @Column(name = "cbo_especifico")
    private String cboEspecifico;
    @ManyToOne
    @JoinColumn(name = "cbo", referencedColumnName = "id")
    private Cbo cbo;

    public Cargo() {
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
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
     * @return the cboEspecifico
     */
    public String getCboEspecifico() {
        return cboEspecifico;
    }

    /**
     * @param cboEspecifico the cboEspecifico to set
     */
    public void setCboEspecifico(String cboEspecifico) {
        this.cboEspecifico = cboEspecifico;
    }

    /**
     * @return the cbo
     */
    public Cbo getCbo() {
        return cbo;
    }

    /**
     * @param cbo the cbo to set
     */
    public void setCbo(Cbo cbo) {
        this.cbo = cbo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cargo other = (Cargo) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
}
