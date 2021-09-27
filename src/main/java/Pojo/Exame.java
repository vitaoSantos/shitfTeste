package Pojo;

import Conversores.Conversor;

@Conversor(nome = "Conversores.ConversorExame")
public class Exame extends Pojo {

    private String descricao;
    private Double preco;

    public String getDescricao() {
        return descricao;
    }

    /**
     *
     * @param descricao
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPreco() {
        return preco;
    }

    /**
     *
     * @param preco
     */
    public void setPreco(Double preco) {
        this.preco = preco;
    }

}
