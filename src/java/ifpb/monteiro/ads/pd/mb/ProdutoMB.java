/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.monteiro.ads.pd.mb;

import ifpb.monteiro.ads.pd.beans.Produto;
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
@ManagedBean(name = "ProdutoMB")
public class ProdutoMB {

    FachadaIF fachada;
    private Produto produto;
    private DataModel model;

    public ProdutoMB() {
        fachada = new Fachada();
        produto = new Produto();
    }

    protected void novo() {
        produto = new Produto();
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public DataModel getTodosProdutos() throws HumQueCaroException {
        model = new ListDataModel(fachada.getProdutos());
        return model;
    }

    public String cadastraProduto(ActionEvent actionEvent) {
        try {
            fachada.adicionaProduto(produto.getNome(), produto.getCodigoBarras(),
                    produto.getFabricante(), produto.getValor());
            Messages.mensInfo("Produto cadastrado com sucesso");
        } catch (HumQueCaroException ex) {
            Messages.mensInfo("Produto não cadastrado! " + ex.getMessage());
        }
        novo();
        return "home.xhtml";
    }

    public String alterarProduto(ActionEvent actionEvent) {
        try {
            Produto temp = fachada.buscaProduto(produto.getCodigoBarras());
            if (temp != null) {
                fachada.alteraProduto(temp.getCodigoBarras(), produto.getNome(), produto.getFabricante());
                Messages.mensInfo("Produto alterado com sucesso!");
            } else {
                Messages.mensInfo("Produto não encontrado!");
            }
        } catch (HumQueCaroException ex) {
            Messages.mensInfo("Produto não alterado! " + ex.getMessage());
        }
        novo();
        return "home.xhtml";
    }

    public String removerProduto(ActionEvent actionEvent) {
        try {
            Produto temp = fachada.buscaProduto(produto.getCodigoBarras());
            if (temp != null) {
                fachada.removeProduto(temp.getCodigoBarras());
                Messages.mensInfo("Produto removido com sucesso!");
            } else {
                Messages.mensInfo("Produto não encontrado!");
            }
        } catch (HumQueCaroException ex) {
            Messages.mensInfo("Produto não removido! " + ex.getMessage());
        }
        novo();
        return "home.xhtml";
    }
}
