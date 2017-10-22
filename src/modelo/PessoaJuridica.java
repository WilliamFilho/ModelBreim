package modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CNPJ;

/**
 *
 * @author Prof. Me. Jorge Luis Boeira Bavaresco
 * @email jorge.bavaresco@passofundo.ifsul.edu.br
 * @organization IFSUL - Campus Passo Fundo
 */
@Entity
@Table(name = "pessoa_juridica")
public class PessoaJuridica extends Pessoa implements Serializable {

    @Length(max = 15, message = "A inscrição estadual deve possuir {max} caracteres.")
    @NotBlank(message = "Informe a incrição estadual")
    @NotNull(message = "A Inscrição estadual não pode ser nula")
    @Column(name = "ie", length = 15, nullable = false)
    private String ie;
    @CNPJ(message = "CNPJ inválido")
    @Length(max = 18, min = 18, message = "O CNPJ deve possuir {max} caracteres.")
    @NotBlank(message = "Informe o CNPJ")
    @NotNull(message = "O CNPJ não pode ser nulo")
    @Column(name = "cnpj", length = 18, nullable = false)
    private String cnpj;
    

    public PessoaJuridica() {
    }

    /**
     * @return the ie
     */
    public String getIe() {
        return ie;
    }

    /**
     * @param ie the ie to set
     */
    public void setIe(String ie) {
        this.ie = ie;
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

    

}
