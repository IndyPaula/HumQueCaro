package ifpb.monteiro.ads.pd.mb;

import ifpb.monteiro.ads.pd.beans.Login;
import ifpb.monteiro.ads.pd.exceptions.HumQueCaroException;
import ifpb.monteiro.ads.pd.fachada.Fachada;
import ifpb.monteiro.ads.pd.messages.Messages;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.primefaces.context.RequestContext;

@SessionScoped
@ManagedBean(name = "LoginMB")
public class LoginMB implements Serializable {

    private Login userLogin;
    private Fachada fachada;

    public LoginMB() {
        userLogin = new Login();
        fachada = new Fachada();
    }

    public String logarUsuario(ActionEvent actionEvent) {
        try {
            fachada.fazerLogin(userLogin.getEmail(), userLogin.getSenha());
            String msg = "Bem Vindo!";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, msg, "Você está logado no HumQueCaro!"));
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
            return "home?faces-redirect=true";
        } catch (HumQueCaroException ex) {
            String msg = "Erro! Usuario ou senha invalido!";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, ""));
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
            return "index?faces-redirect=true";
        }
    }

    public String deslogarUsuario(ActionEvent actionEvent) {
        try {
            fachada.disconnect();
            String msg = "Você saiu do HumQueCaro!";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, msg, "Você saiu do HumQueCaro!"));
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
            return "index?faces-redirect=true";
        } catch (HumQueCaroException ex) {
            return null;
        }
    }

    public Login getUserLogin() {
        return userLogin;
    }
}
