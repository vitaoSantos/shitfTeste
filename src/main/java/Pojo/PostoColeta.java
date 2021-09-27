package Pojo;

import Conversores.Conversor;

@Conversor(nome = "Conversores.ConversorPostoColeta")
public class PostoColeta extends Pojo {

    private String descricao;
    private String endereco;

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
