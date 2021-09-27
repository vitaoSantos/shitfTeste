package Pojo;

import Conversores.Conversor;

@Conversor(nome = "Conversores.ConversorOrdemServico")
public class OrdemServico extends Pojo {

    private Paciente paciente;
    private String convenio;
    private PostoColeta posto_coleta;
    private Medico medico;

    public Paciente getPaciente() {
        return paciente;
    }

    /**
     *
     * @param paciente
     */
    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public String getConvenio() {
        return convenio;
    }

    /**
     *
     * @param convenio
     */
    public void setConvenio(String convenio) {
        this.convenio = convenio;
    }

    public PostoColeta getPosto_coleta() {
        return posto_coleta;
    }

    /**
     *
     * @param posto_coleta
     */
    public void setPosto_coleta(PostoColeta posto_coleta) {
        this.posto_coleta = posto_coleta;
    }

    public Medico getMedico() {
        return medico;
    }

    /**
     *
     * @param medico
     */
    public void setMedico(Medico medico) {
        this.medico = medico;
    }

}
