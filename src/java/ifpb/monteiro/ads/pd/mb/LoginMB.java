package ifpb.monteiro.ads.pd.mb;

import ifpb.monteiro.ads.pd.beans.Login;
import ifpb.monteiro.ads.pd.exceptions.HumQueCaroException;
import ifpb.monteiro.ads.pd.fachada.Fachada;
import ifpb.monteiro.ads.pd.messages.Messages;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

@SessionScoped
@ManagedBean(name = "LoginMB")
public class LoginMB {

    private Login userLogin;
    private Fachada fachada;

    public LoginMB() {
        userLogin = new Login();
        fachada = new Fachada();
    }

    public String logarUsuario(ActionEvent actionEvent) {
        try {
            fachada.fazerLogin(userLogin.getEmail(), userLogin.getSenha());
        } catch (HumQueCaroException ex) {
            Messages.mensInfo("Usuario não cadastrado" + ex.getMessage());
        }
        return "home.xhtml";
    }

    public Login getUserLogin() {
        return userLogin;
    }
}
