package Bean;

import Filtros.SessionContext;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class LoginBean implements Serializable {

    public LoginBean() {

    }
    
    public void entrarSistema(){
        try {
            SessionContext.getInstance().getExternalContext().redirect("/Telas/home.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(LoginBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
