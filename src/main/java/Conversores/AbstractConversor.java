package Conversores;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractConversor<T> implements Serializable {

    public final List<T> convert(ResultSet rs) throws Exception {
        List<T> lista = new ArrayList<>();

        while (rs.next()) {
            lista.add(getObject(rs));
        }

        return lista;
    }

    public final T getObject(ResultSet rs, Integer linha) throws Exception {
        if (rs.absolute(linha)) {
            return getObject(rs);
        }
        return null;
    }

    protected abstract T getObject(ResultSet rs) throws Exception;

    final Boolean contain(ResultSet rs, String coluna) {
        try {
            Integer pos = rs.findColumn(coluna);
            return Boolean.TRUE;
        } catch (SQLException e) {
            return Boolean.FALSE;
        }
    }

}
