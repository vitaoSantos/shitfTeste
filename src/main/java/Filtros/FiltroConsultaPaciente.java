package Filtros;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FiltroConsultaPaciente implements Serializable, Filtro {

    private String nome;
    private Date dataNascimento;
    private String sexo;
    private String endereco;

    @Override
    public String getWhere() {
        String filtro = "";
        try {
            if (nome != null && !nome.trim().equals("")) {
                filtro = " nome like '%" + nome + "%'";
            }

            if (dataNascimento != null) {
                DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
                String dataFormatada = dateFormat.format(dataNascimento);
                filtro = getAND(filtro) + " data_nascimento = '" + dataFormatada + "'";
            }
            
            if (sexo != null && !sexo.trim().equals("")) {
                filtro = getAND(filtro) + " sexo = '" + sexo + "'";
            }
            
            if (endereco != null && !endereco.trim().equals("")) {
                filtro = getAND(filtro) + " sexo like '%" + endereco + "%'";
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

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

}
