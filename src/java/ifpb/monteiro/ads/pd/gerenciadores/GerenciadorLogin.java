package ifpb.monteiro.ads.pd.gerenciadores;

import ifpb.monteiro.ads.pd.beans.Login;
import ifpb.monteiro.ads.pd.beans.Usuario;
import ifpb.monteiro.ads.pd.exceptions.HumQueCaroException;
import ifpb.monteiro.ads.pd.messages.Messages;
import ifpb.monteiro.ads.pd.validacao.Validacao;

public class GerenciadorLogin implements GerenciadorLoginIF {

    private Usuario userLogado;
    private GerenciadorUsuario usuario;
    private static GerenciadorLoginIF instance = null;

    private GerenciadorLogin() {
        usuario = new GerenciadorUsuario();
    }

    public static GerenciadorLoginIF getInstance() {
        if (instance == null) {
            instance = new GerenciadorLogin();
        }
        return instance;
    }

    @Override
    public void fazerLogin(String email, String senha) throws HumQueCaroException {
        Validacao.validaEntrada(email, "Login ou senha invalido");
        Validacao.validaEntrada(senha, "Login ou senha invalido");
        Validacao.verifEmail(email, "Login ou senha invalido");
        userLogado = usuario.buscaUsuario(email);
        if (email.equals(userLogado.getEmail())
                && senha.equals(userLogado.getSenha())) {
            setUserLogado(userLogado);
        } else {
            setUserLogado(null);
            throw new HumQueCaroException("Usuario nao encontrado");
        }
    }

    public Usuario getUserLogado() {
        return userLogado;
    }

    @Override
    public void logado() throws HumQueCaroException {
        if (userLogado == null) {
            throw new HumQueCaroException("Erro");
        }
    }

    public void setUserLogado(Usuario userLogado) {
        this.userLogado = userLogado;
    }
}
