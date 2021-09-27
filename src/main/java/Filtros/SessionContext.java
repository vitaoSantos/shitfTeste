package Filtros;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

public class SessionContext {

    private static SessionContext instance;

    public static SessionContext getInstance() {
        if (instance == null) {
            instance = new SessionContext();

        }

        return instance;
    }

    private SessionContext() {

    }

    public ExternalContext getExternalContext() {
        if (FacesContext.getCurrentInstance() == null) {
            return null;
            //throw new RuntimeException("O FacesContext não pode ser chamado fora de uma requisição HTTP");
        } else {
            return FacesContext.getCurrentInstance().getExternalContext();
        }
    }

}
