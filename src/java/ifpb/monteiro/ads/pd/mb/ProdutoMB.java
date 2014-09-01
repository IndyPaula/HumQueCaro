/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.monteiro.ads.pd.controler;

import ifpb.monteiro.ads.pd.beans.Produto;
import ifpb.monteiro.ads.pd.exceptions.HumQueCaroException;
import ifpb.monteiro.ads.pd.fachada.FachadaBD;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

@SessionScoped
@ManagedBean
public class ProdutoMB {

    FachadaBD fachada = new FachadaBD();
    private Produto produto = new Produto();
    private DataModel model;

    public ProdutoMB() {
    }

    protected void novo() {
        produto = new Produto();
    }

    public String cadastraCliente(ActionEvent actionEvent) throws HumQueCaroException {
        fachada.addProduto(produto);
        novo();
        return "home.xhtml";
    }
}
