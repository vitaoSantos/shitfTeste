package Filtros;

import java.io.Serializable;

public class FiltroConsultaOrdemServico implements Serializable, Filtro {

    private int id;
    private String convenio;
    private String nomePaciente;
    private String descricaoPostoColeta;
    private String nomeMedico;

    @Override
    public String getWhere() {
        String filtro = "";
        try {
            if (id != 0) {
                filtro = " ordem_servico.id = " + id;
            }

            if (convenio != null && !convenio.trim().equals("")) {
                filtro = getAND(filtro) + " orderm_servico like '%" + convenio + "%'";
            }
            if (nomePaciente != null && !nomePaciente.trim().equals("")) {
                filtro = getAND(filtro) + " paciente nome '%" + nomePaciente + "%'";
            }

            if (descricaoPostoColeta != null && !descricaoPostoColeta.trim().equals("")) {
                filtro = getAND(filtro) + " posto_coleta.descricao like '%" + descricaoPostoColeta + "%'";
            }
            if (nomeMedico != null && !nomeMedico.trim().equals("")) {
                filtro = getAND(filtro) + " medico.nome like '%" + nomeMedico + "%'";
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getConvenio() {
        return convenio;
    }

    public void setConvenio(String convenio) {
        this.convenio = convenio;
    }

    public String getNomePaciente() {
        return nomePaciente;
    }

    public void setNomePaciente(String nomePaciente) {
        this.nomePaciente = nomePaciente;
    }

    public String getDescricaoPostoColeta() {
        return descricaoPostoColeta;
    }

    public void setDescricaoPostoColeta(String descricaoPostoColeta) {
        this.descricaoPostoColeta = descricaoPostoColeta;
    }

    public String getNomeMedico() {
        return nomeMedico;
    }

    public void setNomeMedico(String nomeMedico) {
        this.nomeMedico = nomeMedico;
    }
    
    

}
