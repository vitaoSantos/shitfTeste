package Filtros;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;

abstract class PaginacaoAbstract implements Serializable {

    private int numeroPagina = 1;
    private int totalPaginas = 1;
    /**
     * Total de registros encontrado no banco de dados;
     */
    private int totalReg = 0;
    /**
     * Número de registros por página
     */
    protected int tamanhoPagina = 10;
    /**
     * indica apartir de qual registro iniciara a consulta
     */
    protected int aPartirDe = 0;

    public void setTotalReg(int totalReg) {
        this.totalReg = totalReg;
        calcularTotalDePaginas();
    }

    public void calcularTotalDePaginas() {
        BigDecimal tmp = new BigDecimal(totalReg);
        totalPaginas = tmp.divide(new BigDecimal(tamanhoPagina), RoundingMode.UP).intValue();
        if (totalPaginas == 0) {
            totalPaginas = 1;
        }
    }

    public void reiniciar() {
        numeroPagina = 1;
        aPartirDe = 0;
    }

    public int getTotalReg() {
        return totalReg;
    }

    public int getTamanhoPagina() {
        return tamanhoPagina;
    }

    public void setTamanhoPagina(int tamanhoPagina) {
        this.tamanhoPagina = tamanhoPagina;
        calcularTotalDePaginas();
    }

    /**
     * Move para próxima página
     */
    public void proximo() {
        if (numeroPagina != totalPaginas) {
            aPartirDe += tamanhoPagina;
            numeroPagina += 1;
            if (numeroPagina > totalPaginas) {
                numeroPagina = totalPaginas;
            }
        }
    }

    /**
     * Move para a página anterior
     */
    public void anterior() {
        aPartirDe -= tamanhoPagina;
        if (aPartirDe <= 0) {
            aPartirDe = 0;
        }
        numeroPagina -= 1;
        if (numeroPagina <= 0) {
            numeroPagina = 1;
        }
    }

    /**
     * Retorna o número da página atual.
     *
     * @return inteiro
     */
    public int getNumeroPagina() {
        return numeroPagina;
    }

    /**
     * Retorna o número total de páginas.
     *
     * @return inteiro
     */
    public int getTotalPaginas() {
        return totalPaginas;
    }

    /**
     * retorna uma string contendo parte do sql responsável por paginar.
     *
     * @return
     */
    public abstract String getPaginacao();

    public int getaPartirDe() {
        return aPartirDe;
    }
}
