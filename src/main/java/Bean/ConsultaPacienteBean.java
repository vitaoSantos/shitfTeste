package Bean;

import Controller.ConsultaPacienteController;
import Filtros.FiltroConsultaPaciente;
import Filtros.Paginacao;
import Pojo.Paciente;
import java.io.Serializable;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class ConsultaPacienteBean implements Serializable {

    private final FiltroConsultaPaciente filtro;
    private final Paginacao paginacao;
    private final ConsultaPacienteController controller;

    private List<Paciente> listaPacientes;

    public ConsultaPacienteBean() {
        filtro = new FiltroConsultaPaciente();
        paginacao = new Paginacao(Paginacao.tipoPaginacao.MySQL);
        controller = new ConsultaPacienteController(filtro, paginacao);
    }
    
        public void listarPacientes(boolean primeiraPagina) {
        try {
            listaPacientes = controller.listarPacientes();
        } catch (Exception ex) {
            System.out.println("Erro ao listar pacientes" + ex.getMessage());
        }
    }

    public void listarPaginaAnteriorBean() {
        paginacao.anterior();
        listarPacientes(false);
    }

    public void listarPaginaProximoBean() {
        paginacao.proximo();
        listarPacientes(false);
    }

    public FiltroConsultaPaciente getFiltro() {
        return filtro;
    }

    public Paginacao getPaginacao() {
        return paginacao;
    }

    public List<Paciente> getListaPacientes() {
        return listaPacientes;
    }

}
