package ifpb.monteiro.ads.pd.gerenciadores;

import ifpb.monteiro.ads.pd.beans.Usuario;
import ifpb.monteiro.ads.pd.enumerations.Dados;
import ifpb.monteiro.ads.pd.exceptions.HumQueCaroException;
import ifpb.monteiro.ads.pd.fachada.FachadaBD;
import ifpb.monteiro.ads.pd.validacao.Validacao;

public class GerenciadorUsuario implements GerenciadorUsuarioIF {

    FachadaBD fachadaBd;

    public GerenciadorUsuario() {
        fachadaBd = new FachadaBD();
    }

    @Override
    public void adicionaUsuario(String email, String senha, String nome)
            throws HumQueCaroException {
        Validacao.validaEntrada(email, "Atributo email invalido");
        Validacao.validaSenha(senha, "Atributo senha invalido");
        Validacao.validaEntrada(nome, "Atributo nome invalido");
        Validacao.verifEmail(email, "Atributo email invalido");
        if (!Validacao.contemApenasLetras(nome)) {
            throw new HumQueCaroException("Campo Invalido");
        }
        fachadaBd.addUsuario(new Usuario(email, senha, nome));
    }

    /**
     * M�todo Altera Usu�rio est� alterando normalmente!
     */
    @Override
    public void alteraUsuario(String email, String atributo, String novoValor)
            throws HumQueCaroException {
        Validacao.validaEntrada(atributo, "Atributo invalido");
        Validacao.validaEntrada(novoValor, "NovoValor invalido");
        Usuario usuAntigo = buscaUsuario(email);
        if (atributo.equals(Dados.NOME.getNome())) {
            if(!Validacao.contemApenasLetras(novoValor)){
                throw new HumQueCaroException("Senha ou Email Invalido");
            }
            usuAntigo.setNome(novoValor);
            fachadaBd.alteraUsuario(usuAntigo);

        } else if (atributo.equals(Dados.SENHA.getNome())) {
            Validacao.validaSenha(novoValor, "Atributo Invalido");
            usuAntigo.setSenha(novoValor);
            fachadaBd.alteraUsuario(usuAntigo);
         } else if (atributo.equals(Dados.EMAIL.getNome())) {
            Validacao.verifEmail(novoValor, "Atributo Invalido");
            usuAntigo.setEmail(novoValor);
            fachadaBd.alteraUsuario(usuAntigo);
        }else{
            throw new HumQueCaroException("Atributo invalido");
        }
    }

    @Override
    public void removeUsuario(String email, String senha)
            throws HumQueCaroException {
        if (buscaUsuario(email).getSenha().equals(senha)) {
            fachadaBd.removeUsuario(email);
        } else {
            throw new HumQueCaroException("Senha ou Email Invalido");
        }
    }

    @Override
    public Usuario buscaUsuario(String email) throws HumQueCaroException {
        Usuario user = fachadaBd.buscaUsuario(email);
        if (user != null) {
            return user;
        } else {
            throw new HumQueCaroException("Atribulo email invalido");
        }

    }

}