package Controller;

import Dao.MedicoDao;
import Filtros.FiltroConsultaMedico;
import Filtros.Paginacao;
import Pojo.Medico;
import java.io.Serializable;
import java.util.List;

public class ConsultaMedicoController implements Serializable{
    private final MedicoDao dao;
    
    public ConsultaMedicoController(FiltroConsultaMedico f, Paginacao p) {
        dao = new MedicoDao();
        dao.setFiltro(f);
        dao.setPaginacao(p);
    }
    
    public List<Medico> listarMedicos() throws Exception{
        return dao.listar();
    }
}
