package Bean;

import Controller.ConsultaExameController;
import Filtros.FiltroConsultaExame;
import Filtros.Paginacao;
import Pojo.Exame;
import java.io.Serializable;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class ConsultaExameBean implements Serializable {

    private final FiltroConsultaExame filtro;
    private final Paginacao paginacao;
    private final ConsultaExameController controller;

    private List<Exame> listaExames;

    public ConsultaExameBean() {
        filtro = new FiltroConsultaExame();
        paginacao = new Paginacao(Paginacao.tipoPaginacao.MySQL);
        controller = new ConsultaExameController(filtro, paginacao);
    }

    public void listarExames(boolean primeiraPagina) {
        try {
            listaExames = controller.listarExames();
        } catch (Exception ex) {
            System.out.println("Erro ao listar exames" + ex.getMessage());
        }
    }

    public void listarPaginaAnteriorBean() {
        paginacao.anterior();
        listarExames(false);
    }

    public void listarPaginaProximoBean() {
        paginacao.proximo();
        listarExames(false);
    }

    public FiltroConsultaExame getFiltro() {
        return filtro;
    }

    public List<Exame> getListaExames() {
        return listaExames;
    }

    public Paginacao getPaginacao() {
        return paginacao;
    }

}
