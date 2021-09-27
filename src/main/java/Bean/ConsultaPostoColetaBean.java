package Bean;

import Controller.ConsultaPostoColetaController;
import Filtros.FiltroConsultaPostoColeta;
import Filtros.Paginacao;
import Pojo.PostoColeta;
import java.io.Serializable;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class ConsultaPostoColetaBean implements Serializable {

    private final FiltroConsultaPostoColeta filtro;
    private final Paginacao paginacao;
    private final ConsultaPostoColetaController controller;

    private List<PostoColeta> listaPostosColeta;

    public ConsultaPostoColetaBean() {
        filtro = new FiltroConsultaPostoColeta();
        paginacao = new Paginacao(Paginacao.tipoPaginacao.MySQL);
        controller = new ConsultaPostoColetaController(filtro, paginacao);
    }

    public void listarPostosColeta(boolean primeiraPagina) {
        try {
            listaPostosColeta = controller.listarPostosColeta();
        } catch (Exception ex) {
            System.out.println("Erro ao listar postos de coleta" + ex.getMessage());
        }
    }

    public void listarPaginaAnteriorBean() {
        paginacao.anterior();
        listarPostosColeta(false);
    }

    public void listarPaginaProximoBean() {
        paginacao.proximo();
        listarPostosColeta(false);
    }

    public FiltroConsultaPostoColeta getFiltro() {
        return filtro;
    }

    public Paginacao getPaginacao() {
        return paginacao;
    }

    public List<PostoColeta> getListaPostosColeta() {
        return listaPostosColeta;
    }

}
