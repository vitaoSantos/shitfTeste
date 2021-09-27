package Pojo;

import Conversores.Conversor;
import java.util.Date;

@Conversor(nome = "Conversores.ConversorPaciente")
public class Paciente extends Pojo {

    private String nome;
    private Date data_nascimento;
    private String sexo;
    private String endereco;

    public String getNome() {
        return nome;
    }

    /**
     *
     * @param nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getData_nascimento() {
        return data_nascimento;
    }

    /**
     *
     * @param data_nascimento
     */
    public void setData_nascimento(Date data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public String getSexo() {
        return sexo;
    }

    /**
     *
     * @param sexo
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEndereco() {
        return endereco;
    }

    /**
     *
     * @param endereco
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

}
