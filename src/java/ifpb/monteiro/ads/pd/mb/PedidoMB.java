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
    private Produto produto;
    private Pedido situacao;
    private DataModel model;
    private List<Produto> produtos;

    public PedidoMB() {
        produto = new Produto();
        situacao = new Pedido();
        pedido = new Pedido();
        fachadaIF = new Fachada();
        produtos = new ArrayList<Produto>();
    }

    protected void novo() {
        pedido = new Pedido();
        situacao = new Pedido();
    }

    public Pedido getSituacao() {
        return situacao;
    }

    public void setSituacao(Pedido situacao) {
        this.situacao = situacao;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public DataModel getTodosPedidos() throws HumQueCaroException {
        model = new ListDataModel(fachadaIF.getPedidos());
        return model;
    }

    public void addProdutoPedido(ActionEvent actionEvent) {
        try {
            Produto prod = fachadaIF.buscaProduto(produto.getCodigoBarras());
            produtos.add(prod);
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
                Pedido pedidoCad = fachadaIF.buscaPedido(pedido.getCodigo());
                if (pedidoCad != null) {
                    fachadaIF.setStatusPedido(pedidoCad.getCodigo(), situacao.getSituacao());
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
