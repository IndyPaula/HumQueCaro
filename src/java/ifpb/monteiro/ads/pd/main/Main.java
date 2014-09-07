package ifpb.monteiro.ads.pd.main;

import ifpb.monteiro.ads.pd.beans.Produto;
import ifpb.monteiro.ads.pd.exceptions.HumQueCaroException;
import ifpb.monteiro.ads.pd.fachada.Fachada;
import ifpb.monteiro.ads.pd.fachadaIF.FachadaIF;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        FachadaIF fachada = new Fachada();
        try {
            fachada.adicionaCliente("Luiz", "08799999999");
            fachada.adicionaProduto("Bala", "01", "7Bello", "0.10");
            fachada.adicionaProduto("Pelota", "02", "7Bello", "0.50");
            fachada.adicionaProduto("Chocolate", "04", "7Bello", "1.10");
            List<Produto> produtos = fachada.getProdutos();
            fachada.addPedido("08799999999", produtos);
            fachada.setStatusPedido("1", "Cancelado");
        } catch (HumQueCaroException e) {
            System.out.println(e.getMessage());
        }

    }
}
