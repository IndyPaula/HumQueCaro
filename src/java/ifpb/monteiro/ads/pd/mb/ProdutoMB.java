/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.monteiro.ads.pd.mb;

import ifpb.monteiro.ads.pd.DAO.ProdutoDAO;
import ifpb.monteiro.ads.pd.beans.Produto;
import ifpb.monteiro.ads.pd.exceptions.HumQueCaroException;
import ifpb.monteiro.ads.pd.fachada.FachadaBD;
import ifpb.monteiro.ads.pd.messages.Messages;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

@SessionScoped
@ManagedBean(name = "ProdutoMB")
public class ProdutoMB {

    FachadaBD fachada;
    private Produto produto;
    private DataModel model;
    private String codigo, atributo, novoValor;
    ProdutoDAO pDAO;

    public ProdutoMB() {
        fachada = new FachadaBD();
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

    public DataModel todosProdutos() {
        return model;
    }

    public String getNovoValor() {
        return novoValor;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getAtributo() {
        return atributo;
    }

    public DataModel getTodosProdutos() throws HumQueCaroException {
        model = new ListDataModel(pDAO.getProdutos());
        return model;
    }

    public String cadastraProduto(ActionEvent actionEvent) {
        try {
            fachada.addProduto(produto);
            Messages.mensInfo("Produto cadastrado com sucesso");
        } catch (HumQueCaroException ex) {
            Messages.mensInfo("Produto não cadastrado! Tente novamente!" + ex.getMessage());
        }
        novo();
        return "home.xhtml";
    }

    public String alterarProduto(ActionEvent actionEvent) {
        try {
            fachada.alteraProduto(codigo, atributo, novoValor);
            Messages.mensInfo("Produto alterado com sucesso!");
        } catch (HumQueCaroException ex) {
            Messages.mensInfo("Produto não alterado! Tente Novamente!" + ex.getMessage());
        }
        return "home.xhtml";
    }
}
