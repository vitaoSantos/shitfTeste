package Filtros;

import java.io.Serializable;

public class FiltroConsultaMedico implements Serializable, Filtro {

    private String nome;
    private String especialidade;

    @Override
    public String getWhere() {
        String filtro = "";
        try {
            if (nome != null && !nome.trim().equals("")) {
                filtro = " nome like '%" + nome + "%'";
            }

            if (especialidade != null && !especialidade.trim().equals("")) {
                filtro = getAND(filtro) + " especialidade like '%" + especialidade + "%'";
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

}
