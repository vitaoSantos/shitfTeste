package Controller;

import Dao.PostoColetaDao;
import Filtros.FiltroConsultaPostoColeta;
import Filtros.Paginacao;
import Pojo.PostoColeta;
import java.io.Serializable;
import java.util.List;

public class ConsultaPostoColetaController implements Serializable {

    private final PostoColetaDao dao;

    public ConsultaPostoColetaController(FiltroConsultaPostoColeta f, Paginacao p) {
        dao = new PostoColetaDao();
        dao.setFiltro(f);
        dao.setPaginacao(p);
    }

    public List<PostoColeta> listarPostosColeta() throws Exception {
        return dao.listar();
    }
}
