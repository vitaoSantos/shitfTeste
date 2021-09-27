package Bean;

import Controller.ConsultaOrdemServicoController;
import Filtros.FiltroConsultaOrdemServico;
import Filtros.Paginacao;
import Pojo.OrdemServico;
import java.io.Serializable;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class ConsultaOrdemServicoBean implements Serializable {

    private final FiltroConsultaOrdemServico filtro;
    private final Paginacao paginacao;
    private final ConsultaOrdemServicoController controller;

    private List<OrdemServico> listaOrdemServicos;

    public ConsultaOrdemServicoBean() {
        filtro = new FiltroConsultaOrdemServico();
        paginacao = new Paginacao(Paginacao.tipoPaginacao.MySQL);
        controller = new ConsultaOrdemServicoController(filtro, paginacao);
    }
    
        public void listarOrdemServicos(boolean primeiraPagina) {
        try {
            listaOrdemServicos = controller.listarOrdemServicos();
        } catch (Exception ex) {
            System.out.println("Erro ao listar ordens de servicos" + ex.getMessage());
        }
    }

    public void listarPaginaAnteriorBean() {
        paginacao.anterior();
        listarOrdemServicos(false);
    }

    public void listarPaginaProximoBean() {
        paginacao.proximo();
        listarOrdemServicos(false);
    }

    public FiltroConsultaOrdemServico getFiltro() {
        return filtro;
    }

    public Paginacao getPaginacao() {
        return paginacao;
    }

    public List<OrdemServico> getListaOrdemServicos() {
        return listaOrdemServicos;
    }
    
    

}
