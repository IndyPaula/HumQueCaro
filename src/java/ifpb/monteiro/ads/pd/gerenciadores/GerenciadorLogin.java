package ifpb.monteiro.ads.pd.gerenciadores;

import ifpb.monteiro.ads.pd.beans.Login;
import ifpb.monteiro.ads.pd.exceptions.HumQueCaroException;
import ifpb.monteiro.ads.pd.messages.Messages;
import ifpb.monteiro.ads.pd.validacao.Validacao;

public class GerenciadorLogin implements GerenciadorLoginIF {

    private Login userLogin;
    private GerenciadorUsuario usuario;

    public GerenciadorLogin() {
        usuario = new GerenciadorUsuario();
    }

    @Override
    public void fazerLogin(String email, String senha) throws HumQueCaroException {
        Validacao.validaEntrada(email, "Login ou senha invalido");
        Validacao.validaEntrada(senha, "Login ou senha invalido");
        Validacao.verifEmail(email, "Login ou senha invalido");
        if (email.equals(usuario.buscaUsuario(email).getEmail())
                && senha.equals(usuario.buscaUsuario(email).getSenha())) {
            Messages.mensInfo("Usuario logado");
            System.out.println("entrou aqui");
        } else {
            System.out.println("nao entrou aqui");
            throw new HumQueCaroException("Usuario nao encontrado");
        }
    }
}
