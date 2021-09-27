package Dao;

import Pojo.OrdemServicoExame;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class OrdemServicoExameDao extends Dao<OrdemServicoExame> {
    
    @Override
    public List<OrdemServicoExame> listar() throws Exception {
        boolean criaConexao = criaConexao();
        try {
            String sql = " SELECT ";
            
            if (paginacao != null) {
                paginacao.setTotalReg(getTotalRegistro());
            }
            
            sql += " * FROM " + getNomeTabela() + " \n";
            sql += "LEFT JOIN dbshift.ordem_servico ON ordem_servico.id = " + getNomeTabela() + ".id_ordem_servico \n"
                    + "LEFT JOIN dbshift.exame ON exame.id = " + getNomeTabela() + ".id_exame \n";
            
            sql += filtro != null ? filtro.getWhere() : "";
            
            sql += " ORDER BY " + getNomeTabela() + ".id DESC";
            
            sql += paginacao != null ? paginacao.getPaginacao() : "";
            
            return conversor.convert(con.retornaRSMySQL(sql, getConnection()));
        } finally {
            if (criaConexao) {
                fechaConexao();
            }
        }
    }
    
    @Override
    public int getTotalRegistro() throws Exception {
        boolean criaConexao = criaConexao();
        try {
            String sql = " SELECT COUNT(*) FROM " + getNomeTabela() + " \n";
            sql += "LEFT JOIN dbshift.ordem_servico ON ordem_servico.id = " + getNomeTabela() + ".id_ordem_servico \n"
                    + "LEFT JOIN dbshift.exame ON exame.id = " + getNomeTabela() + ".id_exame \n";
            
            sql += filtro != null ? filtro.getWhere() : "";
            
            ResultSet rs = con.retornaRSMySQL(sql, getConnection());
            
            if (rs.first()) {
                return rs.getInt(1);
            }
            
            return 0;
        } finally {
            if (criaConexao) {
                fechaConexao();
            }
        }
    }
    
    @Override
    public void insert(OrdemServicoExame obj) throws Exception {
        boolean criaConexao = criaConexao();
        try {
            String sql = " INSERT INTO dbshift.ordem_servico_exame (id_ordem_servico, id_exame) VALUES (?,?)";
            PreparedStatement ps = getConnection().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            
            ps.setLong(1, obj.getOrdem_servico().getId());
            ps.setLong(2, obj.getExame().getId());
            
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                obj.setId(rs.getLong(1));
            }
        } finally {
            if (criaConexao) {
                fechaConexao();
            }
        }
    }
    
    @Override
    protected String getNomeTabela() {
        return "ordem_servico_exame";
    }
    
}
