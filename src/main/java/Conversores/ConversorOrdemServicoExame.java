/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conversores;

import Pojo.Exame;
import Pojo.OrdemServico;
import Pojo.OrdemServicoExame;
import java.sql.ResultSet;

/**
 *
 * @author 55359
 */
public class ConversorOrdemServicoExame extends AbstractConversor<OrdemServicoExame> {

    @Override
    protected OrdemServicoExame getObject(ResultSet rs) throws Exception {
        OrdemServicoExame obj = new OrdemServicoExame();

        obj.setId(rs.getLong("ordem_servico_exame.id"));

        if (contain(rs, "ordem_servico.id")) {
            obj.setOrdem_servico(new ConversorOrdemServico().getObject(rs));
        } else {
            obj.setOrdem_servico(new OrdemServico());
            obj.getOrdem_servico().setId(rs.getLong("ordem_servico_exame.id_ordem_servico"));
        }

        if (contain(rs, "exame.id")) {
            obj.setExame(new ConversorExame().getObject(rs));
        } else {
            obj.setExame(new Exame());
            obj.getExame().setId(rs.getLong("ordem_servico_exame.id_exame"));
        }

        return obj;
    }
}
