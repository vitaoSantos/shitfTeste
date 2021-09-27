package Filtros;

import java.io.Serializable;

public class FiltroConsultaPostoColeta implements Serializable, Filtro {

    private String descricao;
    private String endereco;

    @Override
    public String getWhere() {
        String filtro = "";
        try {
            if (descricao != null && !descricao.trim().equals("")) {
                filtro = " descricao like '%" + descricao + "%'";
            }

            if (endereco != null && !endereco.trim().equals("")) {
                filtro = getAND(filtro) + " endereco like '%" + endereco + "%'";
            }

        } catch (Exception ex) {
            System.out.println("Erro ao montar filtro de pesquisa." + ex.getMessage());
        }
        return !filtro.equals("") ? filtro : "";
    }

    private String getAND(String s) {
        if (!s.isEmpty()) {
            s += " and ";
        }
        return s;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

}
