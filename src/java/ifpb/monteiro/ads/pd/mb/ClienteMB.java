package ifpb.monteiro.ads.pd.mb;

import ifpb.monteiro.ads.pd.beans.Cliente;
import ifpb.monteiro.ads.pd.exceptions.HumQueCaroException;
import ifpb.monteiro.ads.pd.fachada.Fachada;
import ifpb.monteiro.ads.pd.fachadaIF.FachadaIF;
import ifpb.monteiro.ads.pd.messages.Messages;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

@SessionScoped
@ManagedBean(name = "ClienteMB")
public class ClienteMB {

    FachadaIF fachada;
    private Cliente cliente;
    private DataModel model;

    public ClienteMB() {
        cliente = new Cliente();
        fachada = new Fachada();
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

    public DataModel getTodosClientes() throws HumQueCaroException {
        model = new ListDataModel(fachada.getClientes());
        return model;
    }

    public String cadastraCliente(ActionEvent actionEvent) {
        try {
            fachada.adicionaCliente(cliente.getNome(), cliente.getTelefone());
            Messages.mensInfo("Cliente " + cliente.getNome() + " cadastrado(a) com sucesso");
        } catch (HumQueCaroException ex) {
            Messages.mensInfo("Cliente não cadastrado" + ex.getMessage());
        }
        novo();
        return "home.xhtml";
    }

    public String alteraCliente(ActionEvent actionEvent) {
        try {
            Cliente clienteTemp = fachada.buscaCliente(cliente.getTelefone());
            if (clienteTemp != null) {
                fachada.alteraCliente(clienteTemp.getTelefone(), cliente.getNome(), cliente.getCodigo());
                Messages.mensInfo("Cliente alterado com sucesso!");
            } else {
                Messages.mensInfo("Cliente não encontrado!");
            }
        } catch (HumQueCaroException ex) {
            Messages.mensInfo("Cliente não alterado! " + ex.getMessage());
        }
        novo();
        return "home.xhtml";
    }

    public String removeCliente(ActionEvent actionEvent) {
        try {
            Cliente clienteTemp = fachada.buscaCliente(cliente.getTelefone());
            if (clienteTemp != null) {
                fachada.removeCliente(clienteTemp.getTelefone());
                Messages.mensInfo("Cliente " + clienteTemp.getNome() + " removido(a) com sucesso");
            } else {
                Messages.mensInfo("Cliente não encontrado");
            }
        } catch (HumQueCaroException ex) {
            Messages.mensInfo("Cliente não cadastrado" + ex.getMessage());
        }
        return "home.xhtml";
    }
}
