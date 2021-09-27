package Conversores;

import Pojo.Medico;
import Pojo.OrdemServico;
import Pojo.Paciente;
import Pojo.PostoColeta;
import java.sql.ResultSet;

public class ConversorOrdemServico extends AbstractConversor<OrdemServico> {

    @Override
    protected OrdemServico getObject(ResultSet rs) throws Exception {
        OrdemServico obj = new OrdemServico();

        obj.setId(rs.getLong("ordem_servico.id"));

        if (contain(rs, "paciente.id")) {
            obj.setPaciente(new ConversorPaciente().getObject(rs));
        } else {
            obj.setPaciente(new Paciente());
            obj.getPaciente().setId(rs.getLong("ordem_servico.id_paciente"));
        }

        obj.setConvenio(rs.getString("ordem_servico.convenio"));

        if (contain(rs, "posto_coleta.id")) {
            obj.setPosto_coleta(new ConversorPostoColeta().getObject(rs));
        } else {
            obj.setPosto_coleta(new PostoColeta());
            obj.getPosto_coleta().setId(rs.getLong("ordem_servico.id_posto_coleta"));
        }

        if (contain(rs, "medico.id")) {
            obj.setMedico(new ConversorMedico().getObject(rs));
        } else {
            obj.setMedico(new Medico());
            obj.getMedico().setId(rs.getLong("ordem_servico.id_medico"));
        }

        return obj;
    }
}
