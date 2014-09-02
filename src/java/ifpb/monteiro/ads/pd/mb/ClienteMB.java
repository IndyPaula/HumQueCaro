package ifpb.monteiro.ads.pd.mb;

import ifpb.monteiro.ads.pd.beans.Cliente;
import ifpb.monteiro.ads.pd.exceptions.HumQueCaroException;
import ifpb.monteiro.ads.pd.fachada.FachadaBD;
import ifpb.monteiro.ads.pd.messages.Messages;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

@SessionScoped
@ManagedBean(name = "ClienteMB")
public class ClienteMB {

    FachadaBD fachada;
    private Cliente cliente;

    public ClienteMB() {
        cliente = new Cliente();
        fachada = new FachadaBD();
    }

    protected void novo() {
        cliente = new Cliente();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String cadastraCliente(ActionEvent actionEvent) {
        try {
            fachada.addCliente(cliente);
            Messages.mensInfo("Cliente " + cliente.getNome() + " cadastrado(a) com sucesso");
        } catch (HumQueCaroException ex) {
            Messages.mensInfo("Cliente não cadastrado" + ex.getMessage());
        }
        novo();
        return "home.xhtml";
    }

    public String removeCliente(ActionEvent actionEvent) {
        try {
            Cliente clienteTemp = fachada.buscaCliente(cliente.getTelefone());
            if (clienteTemp != null) {
                fachada.removeCliente(clienteTemp);
                Messages.mensInfo("Cliente " + clienteTemp.getNome() + " removido(a) com sucesso");
            }
        } catch (HumQueCaroException ex) {
            Messages.mensInfo("Cliente não cadastrado" + ex.getMessage());
        }
        return "home.xhtml";
    }
}
