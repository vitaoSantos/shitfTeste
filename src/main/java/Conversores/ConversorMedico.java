package Conversores;

import Pojo.Medico;
import java.sql.ResultSet;

public class ConversorMedico extends AbstractConversor<Medico> {

    @Override
    protected Medico getObject(ResultSet rs) throws Exception {
        Medico obj = new Medico();

        obj.setId(rs.getLong("medico.id"));
        obj.setNome(rs.getString("medico.nome"));
        obj.setEspecialidade(rs.getString("medico_especialidade"));

        return obj;
    }

}
