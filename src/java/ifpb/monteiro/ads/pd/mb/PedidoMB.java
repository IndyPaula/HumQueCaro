package ifpb.monteiro.ads.pd.mb;

import ifpb.monteiro.ads.pd.beans.Pedido;
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
@ManagedBean(name = "PedidoMB")
public class PedidoMB {

    FachadaIF fachadaIF;
    private Pedido pedido;
    private DataModel model;

    public PedidoMB() {
        pedido = new Pedido();
        fachadaIF = new Fachada();
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

    //TODO Fiz uma mudança aqui para receber um List<Produto>, pois recebia apenas
    //um código. POR FAVOR, AGORA NO COMENTÁRIO, FICANDO ASSIM REGISTRADO, QUE 
    //APENAS MODIFIQUEI PARA NÃO CONTINUAR O ERRO, MESMO PODENDO ESTÁ INCORRETO.
    //CABE A QUEM FOR O RESPONSAVEL PELO METODO, MODIFICAR E POR O CORRETO, NAO
    //SEGIR O INCORRETO.
    public String cadastraPedido(ActionEvent actionEvent) {
        try {
            fachadaIF.addPedido(pedido.getTelefoneCliente(), pedido.getProdutos());
            Messages.mensInfo("Pedido cadastrado(a) com sucesso");
        } catch (HumQueCaroException ex) {
            Messages.mensInfo("P não cadastrado" + ex.getMessage());
        }
        novo();
        return "home.xhtml";
    }

    public String alteraStatus(ActionEvent actionEvent) {
        try {
            Pedido pedidoCad = fachadaIF.buscaPedido(pedido.getTelefoneCliente());
            if (pedidoCad != null) {
                fachadaIF.setStatusPedido(pedidoCad.getCodigo(), pedido.getSituacao());
                Messages.mensInfo("Status alterado com sucesso!");
            } else {
                Messages.mensInfo("Pedido não encontrado!");
            }
        } catch (HumQueCaroException ex) {
            Messages.mensInfo("Status não alterado! " + ex.getMessage());
        }
        novo();
        return "home.xhtml";
    }
}
