package Filtros;

import java.io.Serializable;

public class FiltroConsultaExame implements Serializable, Filtro {

    private String descricao;
    private Double preco;

    @Override
    public String getWhere() {
        String filtro = "";
        try {
            if (descricao != null && !descricao.trim().equals("")) {
                filtro = " descricao like '%" + descricao + "%'";
            }

            if (preco != null && !preco.equals(0.0)) {
                filtro = getAND(filtro) + " preco = " + preco;
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

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

}
