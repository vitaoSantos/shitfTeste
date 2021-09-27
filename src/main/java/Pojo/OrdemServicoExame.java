package Pojo;

import Conversores.Conversor;

@Conversor(nome = "Conversores.ConversorOrdemServicoExame")
public class OrdemServicoExame extends Pojo {

    private OrdemServico ordem_servico;
    private Exame exame;

    public OrdemServico getOrdem_servico() {
        return ordem_servico;
    }

    /**
     *
     * @param ordem_servico
     */
    public void setOrdem_servico(OrdemServico ordem_servico) {
        this.ordem_servico = ordem_servico;
    }

    public Exame getExame() {
        return exame;
    }

    /**
     *
     * @param exame
     */
    public void setExame(Exame exame) {
        this.exame = exame;
    }

}
