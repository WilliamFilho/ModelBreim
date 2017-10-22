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
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CNPJ;
import util.TipoEmpresa;

/**
 *
 * @author wjnet
 */
@Entity
@Table(name = "filial")
public class Filial implements Serializable {
    @Id
    @SequenceGenerator(name = "seq_filial", sequenceName = "seq_filial_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_filial", strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "nome", length = 80)
    private String nome;
    @Column(name = "nome_fantasia", length = 80)
    private String nomeFantasia;
    @CNPJ(message = "CNPJ inválido")
    @Length(max = 18, min = 18, message = "O CNPJ deve possuir {max} caracteres.")
    @NotBlank(message = "Informe o CNPJ")
    @NotNull(message = "O CNPJ não pode ser nulo")
    @Column(name = "cnpj", length = 18, nullable = false)
    private String cnpj;
    @Column(name = "ramo_atividade", length = 50)
    private String ramoAtividade;
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo", nullable = false, length = 1, columnDefinition="char(1)")
    private TipoEmpresa tipo;
    @ManyToOne
    @JoinColumn(name = "empresa", referencedColumnName = "id", nullable = false)
    @ForeignKey(name = "fk_empresa_id")    
    private Empresa empresa;

    public Filial() {
        
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
     * @return the cnpj
     */
    public String getCnpj() {
        return cnpj;
    }

    /**
     * @param cnpj the cnpj to set
     */
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
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
     * @return the tipo
     */
    public TipoEmpresa getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(TipoEmpresa tipo) {
        this.tipo = tipo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.id);
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
        final Filial other = (Filial) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    /**
     * @return the empresa
     */
    public Empresa getEmpresa() {
        return empresa;
    }

    /**
     * @param empresa the empresa to set
     */
    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

   
    
}
