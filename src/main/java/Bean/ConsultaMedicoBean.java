package Bean;

import Controller.ConsultaMedicoController;
import Filtros.FiltroConsultaMedico;
import Filtros.Paginacao;
import Pojo.Medico;
import java.io.Serializable;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class ConsultaMedicoBean implements Serializable{
    private final FiltroConsultaMedico filtro;
    private final Paginacao paginacao;
    private final ConsultaMedicoController controller;
    
    private List<Medico> listaMedicos;
    
    public ConsultaMedicoBean (){
        filtro = new FiltroConsultaMedico();
        paginacao = new Paginacao(Paginacao.tipoPaginacao.MySQL);
        controller = new ConsultaMedicoController(filtro, paginacao);
    }
    
        public void listarMedicos(boolean primeiraPagina) {
        try {
            listaMedicos = controller.listarMedicos();
        } catch (Exception ex) {
            System.out.println("Erro ao listar medicos" + ex.getMessage());
        }
    }

    public void listarPaginaAnteriorBean() {
        paginacao.anterior();
        listarMedicos(false);
    }

    public void listarPaginaProximoBean() {
        paginacao.proximo();
        listarMedicos(false);
    }

    public Paginacao getPaginacao() {
        return paginacao;
    }

    public FiltroConsultaMedico getFiltro() {
        return filtro;
    }

    public List<Medico> getListaMedicos() {
        return listaMedicos;
    }
    
    
}
