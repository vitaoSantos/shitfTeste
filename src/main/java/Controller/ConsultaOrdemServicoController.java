package Controller;

import Dao.OrdemServicoDao;
import Filtros.FiltroConsultaOrdemServico;
import Filtros.Paginacao;
import Pojo.OrdemServico;
import java.io.Serializable;
import java.util.List;

public class ConsultaOrdemServicoController implements Serializable{
    private final OrdemServicoDao dao;
    
    public ConsultaOrdemServicoController (FiltroConsultaOrdemServico f, Paginacao p){
        dao = new OrdemServicoDao();
        dao.setFiltro(f);
        dao.setPaginacao(p);
    }
    
        public List<OrdemServico> listarOrdemServicos() throws Exception {
        return dao.listar();
    }
}
