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
		Validacao.validaEntrada(senha, "Atributo senha invalido");
		Validacao.validaEntrada(nome, "Atributo nome invalido");
		fachadaBd.addUsuario(new Usuario(email, senha, nome));
	}

	@Override
	public void alteraUsuario(String email, String atributo, String novoValor)
			throws HumQueCaroException {
		//TODO Procurar uma forma eficiente de fazer isso
		if(Dados.NOME.getNome().equals(atributo)){
			fachadaBd.alteraUsuario(new Usuario(email, null, novoValor));
		}else if (Dados.SENHA.getNome().equals(atributo)){
			fachadaBd.alteraUsuario(new Usuario(email, novoValor,null));
		}
	}

	@Override
	public void removeUsuario(String email, String senha)
			throws HumQueCaroException {
		if (buscaUsuario(email).getSenha().equals(senha))
			fachadaBd.removeUsuario(new Usuario(email, senha));
		else
			throw new HumQueCaroException("Senha ou Email Invalido");
	}

	@Override
	public Usuario buscaUsuario(String email) throws HumQueCaroException {
		Usuario user = fachadaBd.buscaUsuario(email);
		if(user!= null){
			return user; 
		}else{
			throw new HumQueCaroException("Atribulo email invalido");
		}
		
	}

}