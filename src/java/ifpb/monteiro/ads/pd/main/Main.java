package ifpb.monteiro.ads.pd.main;

import ifpb.monteiro.ads.pd.exceptions.HumQueCaroException;
import ifpb.monteiro.ads.pd.fachada.Fachada;
import ifpb.monteiro.ads.pd.fachadaIF.FachadaIF;

public class Main {

    public static void main(String[] args) {
        FachadaIF fachada = new Fachada();
        try {
            fachada.alteraProduto("123123", "fabricante", "fabricante");
        } catch (HumQueCaroException e) {
            e.printStackTrace();
        }

    }
}
