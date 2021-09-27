package Conversores;

import Pojo.Exame;
import java.sql.ResultSet;

public class ConversorExame extends AbstractConversor<Exame> {

    @Override
    protected Exame getObject(ResultSet rs) throws Exception {
        Exame obj = new Exame();

        obj.setId(rs.getLong("exame.id"));
        obj.setDescricao(rs.getString("exame.descricao"));
        obj.setPreco(rs.getDouble("exame.preco"));

        return obj;
    }

}
