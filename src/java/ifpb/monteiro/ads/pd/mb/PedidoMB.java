package ifpb.monteiro.ads.pd.mb;

import ifpb.monteiro.ads.pd.beans.Pedido;
import ifpb.monteiro.ads.pd.beans.Produto;
import ifpb.monteiro.ads.pd.exceptions.HumQueCaroException;
import ifpb.monteiro.ads.pd.fachada.Fachada;
import ifpb.monteiro.ads.pd.fachadaIF.FachadaIF;
import ifpb.monteiro.ads.pd.messages.Messages;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

@ViewScoped
@ManagedBean(name = "PedidoMB")
public class PedidoMB {

    FachadaIF fachadaIF;
    private Pedido pedido;
    private DataModel model;
    private List<Produto> produtos;
    private String codigo;

    public PedidoMB() {
        pedido = new Pedido();
        fachadaIF = new Fachada();
        produtos = new ArrayList<Produto>();
    }

    protected void novo() {
        pedido = new Pedido();
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public DataModel getTodosPedidos() throws HumQueCaroException {
        model = new ListDataModel(fachadaIF.getPedidos());
        return model;
    }

    public void addProdutoPedido(ActionEvent actionEvent) {
        try {
            Produto produto = fachadaIF.buscaProduto(codigo);
            produtos.add(produto);
        } catch (HumQueCaroException ex) {
            Messages.mensInfo("Pedido não cadastrado! " + ex.getMessage());
        }

    }

    public String cadastraPedido(ActionEvent actionEvent) {
        try {
            addProdutoPedido(actionEvent);
            fachadaIF.addPedido(pedido.getTelefoneCliente(), produtos);
            Messages.mensInfo("Pedido cadastrado(a) com sucesso");
        } catch (HumQueCaroException ex) {
            Messages.mensInfo("Pedido não cadastrado!!! " + ex.getMessage());
        }
        novo();
        return "home.xhtml";
    }

    public String alteraStatus(ActionEvent actionEvent) {
        try {
            if (pedido.getTelefoneCliente() != null) {
                Pedido pedidoCad = fachadaIF.buscaPedido(pedido.getTelefoneCliente());
                if (pedidoCad != null) {
                    fachadaIF.setStatusPedido(pedidoCad.getCodigo(), pedido.getSituacao());
                    Messages.mensInfo("Status alterado com sucesso!");
                } else {
                    Messages.mensInfo("Pedido não encontrado!");
                }
            } else {
                Messages.mensInfo("Não é possível alterar a situação deste pedido");
            }
        } catch (HumQueCaroException ex) {
            Messages.mensInfo("Status não alterado! " + ex.getMessage());
        }
        novo();
        return "home.xhtml";
    }
}
