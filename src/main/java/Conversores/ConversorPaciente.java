package Conversores;

import Pojo.Paciente;
import java.sql.ResultSet;

public class ConversorPaciente extends AbstractConversor<Paciente> {

    @Override
    protected Paciente getObject(ResultSet rs) throws Exception {
        Paciente obj = new Paciente();

        obj.setId(rs.getLong("paciente.id"));
        obj.setNome(rs.getString("paciente.nome"));
        obj.setData_nascimento(rs.getDate("paciente.data_nascimento"));
        obj.setSexo(rs.getString("paciente.sexo"));
        obj.setEndereco(rs.getString("paciente.endereco"));

        return obj;
    }

}
