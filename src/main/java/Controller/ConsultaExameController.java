package Controller;

import Dao.ExameDao;
import Filtros.FiltroConsultaExame;
import Filtros.Paginacao;
import Pojo.Exame;
import java.io.Serializable;
import java.util.List;

public class ConsultaExameController implements Serializable {

    private final ExameDao dao;

    public ConsultaExameController(FiltroConsultaExame f, Paginacao p) {
        dao = new ExameDao();
        dao.setFiltro(f);
        dao.setPaginacao(p);
    }

    public List<Exame> listarExames() throws Exception {
        return dao.listar();
    }
}
