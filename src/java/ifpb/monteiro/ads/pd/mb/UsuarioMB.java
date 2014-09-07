package ifpb.monteiro.ads.pd.mb;

import ifpb.monteiro.ads.pd.beans.Usuario;
import ifpb.monteiro.ads.pd.exceptions.HumQueCaroException;
import ifpb.monteiro.ads.pd.fachada.FachadaBD;
import ifpb.monteiro.ads.pd.messages.Messages;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import static javax.faces.context.FacesContext.getCurrentInstance;

/**
 * Classe que faz o intermedio entre a tela e a camada de negócio. Responsável
 * por ligar os dados na tela e recuperar os dados da tela para a camada de
 * serviços.
 *
 * @author Luiz Antonio
 */
@ManagedBean(name = "usuarioMB") //Nome do ManageBean
@ViewScoped //Faz com que os dados, mesmo com a mudança de tela, estejam presentes no servidor, facilitando edições.
public class UsuarioMB {

    FachadaBD fachadaBD = new FachadaBD();

    private String emailSelecionado;

    //Lista com os usuários apresentados no Datatable.
    private List<Usuario> usuarios;

    //Referência para a usuário utiliza na inclusão (nova) ou edição.
    private Usuario usuario;

    public UsuarioMB() {
    }

    public void setIdSelecionado(String idSelecionado) {
        this.emailSelecionado = idSelecionado;
    }

    public String getIdSelecionado() {
        return emailSelecionado;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void incluir() {
        usuario = new Usuario();
    }

    public void editar() {
        if (emailSelecionado == null) {
            return;
        }
        try {
            usuario = fachadaBD.buscaUsuario(emailSelecionado);
        } catch (HumQueCaroException e) {
            addMessage(getMessageFromI18N("msg.erro.editar.usuario"), e.getMessage());
        }
    }

    public String salvar() {
        try {
            fachadaBD.addUsuario(usuario);
            Messages.mensInfo("Usuario " + usuario.getNome() + " cadastrado(a) com sucesso");
        } catch (HumQueCaroException e) {
            addMessage(getMessageFromI18N("msg.erro.salvar.usuario"), e.getMessage());
            return "";
        }
        return "";
    }

    public String remover() {
        try {
            fachadaBD.removeUsuario(usuario.getEmail());
        } catch (HumQueCaroException e) {
            addMessage(getMessageFromI18N("msg.erro.remover.usuario"), e.getMessage());
            return "";
        }
        return "listaMercadorias";
    }

    /**
     * @param key
     * @return Recupera a mensagem do arquivo properties
     * <code>ResourceBundle</code>.
     */
    private String getMessageFromI18N(String key) {
        ResourceBundle bundle = ResourceBundle.getBundle("messages_labels", getCurrentInstance().getViewRoot().getLocale());
        return bundle.getString(key);
    }

    /**
     * Adiciona um mensagem no contexto do Faces (<code>FacesContext</code>).
     *
     * @param summary
     * @param detail
     */
    private void addMessage(String summary, String detail) {
        getCurrentInstance().addMessage(null, new FacesMessage(summary, summary.concat("<br/>").concat(detail)));
    }
}
