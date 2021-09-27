package Conversores;

import Pojo.PostoColeta;
import java.sql.ResultSet;

public class ConversorPostoColeta extends AbstractConversor<PostoColeta> {

    @Override
    protected PostoColeta getObject(ResultSet rs) throws Exception {
        PostoColeta obj = new PostoColeta();

        obj.setId(rs.getLong("posto_coleta.id"));
        obj.setDescricao(rs.getString("posto_coleta.descricao"));
        obj.setEndereco(rs.getString("posto_coleta.endereco"));

        return obj;
    }

}
