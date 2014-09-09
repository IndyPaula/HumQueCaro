package ifpb.monteiro.ads.pd.gerenciadores;

import ifpb.monteiro.ads.pd.beans.Usuario;
import ifpb.monteiro.ads.pd.exceptions.HumQueCaroException;

public interface GerenciadorLoginIF {

    public void fazerLogin(String email, String senha) throws HumQueCaroException;
    
    public void logado() throws HumQueCaroException;
}
