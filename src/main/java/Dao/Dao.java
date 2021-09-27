package Dao;

import Conversores.AbstractConversor;
import Conversores.FactoryConversor;
import DB.Conexao;
import Filtros.Filtro;
import Filtros.Paginacao;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public abstract class Dao<T> implements Serializable {

    protected AbstractConversor conversor;
    protected final Conexao con;
    protected Filtro filtro;
    protected Paginacao paginacao;
    private Connection connection;

    public Dao() {
        con = new Conexao();
        connection = null;
        criarConversor();
    }

    public int getTotalRegistro() throws Exception {
        throw new UnsupportedOperationException("Método não implementado");
    }

    public List<T> listar() throws Exception {
        throw new UnsupportedOperationException("Método não implementado");
    }

    public T getObjeto(Filtro f) throws Exception {
        throw new UnsupportedOperationException("Método não implementado");
    }

    public void delete(T obj) throws Exception {
        throw new UnsupportedOperationException("Método não implementado");
    }

    public void insert(T obj) throws Exception {
        throw new UnsupportedOperationException("Método não implementado");
    }

    public void update(T obj) throws Exception {
        throw new UnsupportedOperationException("Método não implementado");
    }

    protected abstract String getNomeTabela();

    public void setFiltro(Filtro filtro) {
        this.filtro = filtro;
    }

    public void setPaginacao(Paginacao paginacao) {
        this.paginacao = paginacao;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public boolean criaConexao() throws SQLException {
        if (connection == null || connection.isClosed()) {
            this.connection = Conexao.Conectar();
            return true;
        } else {
            return false;
        }
    }

    public void fechaConexao() throws SQLException {
        if (connection != null) {
            this.connection.close();
            this.connection = null;
        }
    }

    private void criarConversor() {
        try {
            FactoryConversor fc = new FactoryConversor();
            Class<T> obj = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
            conversor = fc.fabricarConversor(obj);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException ex) {
//            System.out.println("metodo não implementado");
        }
    }

}
