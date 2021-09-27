package Pojo;

import Conversores.Conversor;

@Conversor(nome = "Conversores.ConversorMedico")
public class Medico extends Pojo {

    private String nome;
    private String especialidade;

    public String getNome() {
        return nome;
    }

    /**
     * Nome
     *
     * @param nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    /**
     * Função/Trabalho/Especialidade
     *
     * @param especialidade
     */
    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

}
