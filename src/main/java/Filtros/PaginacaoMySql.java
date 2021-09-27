package Filtros;

public class PaginacaoMySql extends PaginacaoAbstract {

    @Override
    public String getPaginacao() {
        String pagina = "";
        pagina = " LIMIT " + aPartirDe + "," + tamanhoPagina;
        return pagina;
    }

}
