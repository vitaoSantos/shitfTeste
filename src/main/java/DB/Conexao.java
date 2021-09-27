package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Conexao {

    private static final String ip = "127.0.0.1";

    public Conexao() {
    } //Possibilita instancias

    public static Connection Conectar() {
        try {
            return DriverManager.getConnection("jdbc:mysql://" + ip + "/dbshift?useSSL=false", "root", "basquete");
        } catch (SQLException e) {
            System.out.println("Erro");
        }
        return null;
    }

    public ResultSet retornaRSMySQL(String sql, Connection cn) throws Exception {

        if (cn == null) {
            throw new Exception("ConexÃ£o fechada em retornaRS");
        }

        sql = sql.replace("%\"", "");
        sql = sql.replace("\"%", "");

        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery(sql);

        return rs;
    }

    public void executarSql(String sql, Connection cn) throws Exception {
        List<String> l = new ArrayList<>();
        l.add(sql);
        executarSql(l, cn);
    }

    public void executarSql(List<String> listaSql, Connection cn) throws Exception {
        Boolean fecharCn = false;

        if (cn == null) {
            fecharCn = true;
            cn = Conexao.Conectar();
        }

        boolean testb = cn.getAutoCommit();
        Integer count = 0;

        if (testb == true) {
            cn.setAutoCommit(false);
        }
        // Statement st = cn.createStatement();
        PreparedStatement ps = null;
        try {
            //st.execute("BEGIN;");

            for (String s : listaSql) {
                ps = cn.prepareStatement(s);
                ps.executeUpdate();
                count++;
            }
            //st.execute("COMMIT;");
            cn.commit();
        } catch (SQLException ex) {
            cn.rollback();

            System.out.println("Exception no executar lista de sql\n" + listaSql.get(count));
            System.out.println(ex);

        } finally {

            if (testb) {
                cn.setAutoCommit(true);
            }

            if (fecharCn == true) {
                cn.close();
            }

        }

    }

}
