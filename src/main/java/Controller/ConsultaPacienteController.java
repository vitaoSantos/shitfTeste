package Controller;

import Dao.PacienteDao;
import Filtros.FiltroConsultaPaciente;
import Filtros.Paginacao;
import Pojo.Paciente;
import java.io.Serializable;
import java.util.List;

public class ConsultaPacienteController implements Serializable {

    private final PacienteDao dao;

    public ConsultaPacienteController(FiltroConsultaPaciente f, Paginacao p) {
        dao = new PacienteDao();
        dao.setFiltro(f);
        dao.setPaginacao(p);
    }

    public List<Paciente> listarPacientes() throws Exception {
        return dao.listar();
    }

}
