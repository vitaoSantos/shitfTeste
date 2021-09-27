package Dao;

import Pojo.OrdemServico;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class OrdemServicoDao extends Dao<OrdemServico> {

    @Override
    public List<OrdemServico> listar() throws Exception {
        boolean criaConexao = criaConexao();
        try {
            String sql = " SELECT ";

            if (paginacao != null) {
                paginacao.setTotalReg(getTotalRegistro());
            }

            sql += " * FROM " + getNomeTabela() + " \n";
            sql += "LEFT JOIN dbshift.paciente ON paciente.id = " + getNomeTabela() + ".id_paciente \n"
                    + "LEFT JOIN dbshift.posto_coleta ON posto_coleta.id = " + getNomeTabela() + ".id_posto_coleta \n"
                    + "LEFT JOIN dbshift.medico ON medico.id = " + getNomeTabela() + ".id_medico \n";

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
            sql += "LEFT JOIN dbshift.paciente ON paciente.id = " + getNomeTabela() + ".id_paciente \n"
                    + "LEFT JOIN dbshift.posto_coleta ON posto_coleta.id = " + getNomeTabela() + ".id_posto_coleta \n"
                    + "LEFT JOIN dbshift.medico ON medico.id = " + getNomeTabela() + ".id_medico \n";

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
    public void insert(OrdemServico obj) throws Exception {
        boolean criaConexao = criaConexao();
        try {
            String sql = " INSERT INTO dbshift.ordem_servico (id_paciente, convenio, id_posto_coleta, id_medico) VALUES (?,?,?,?)";
            PreparedStatement ps = getConnection().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            ps.setLong(1, obj.getPaciente().getId());
            ps.setString(2, obj.getConvenio());
            ps.setLong(3, obj.getPosto_coleta().getId());
            ps.setLong(4, obj.getMedico().getId());

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
        return "orderm_servico";
    }

}
