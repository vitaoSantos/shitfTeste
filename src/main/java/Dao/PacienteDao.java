package Dao;

import Pojo.Paciente;
import java.sql.ResultSet;
import java.util.List;

public class PacienteDao extends Dao<Paciente> {

    @Override
    public List<Paciente> listar() throws Exception {
        boolean criaConexao = criaConexao();
        try {
            String sql = " SELECT ";

            if (paginacao != null) {
                paginacao.setTotalReg(getTotalRegistro());
            }

            sql += " * FROM " + getNomeTabela() + " \n";

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
    protected String getNomeTabela() {
        return "paciente";
    }

}
