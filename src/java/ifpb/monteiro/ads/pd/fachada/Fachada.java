package ifpb.monteiro.ads.pd.fachada;

import ifpb.monteiro.ads.pd.beans.Cliente;
import ifpb.monteiro.ads.pd.beans.Produto;
import ifpb.monteiro.ads.pd.beans.Usuario;
import ifpb.monteiro.ads.pd.exceptions.HumQueCaroException;
import ifpb.monteiro.ads.pd.fachadaIF.FachadaIF;
import ifpb.monteiro.ads.pd.gerenciadores.GerenciadorCliente;
import ifpb.monteiro.ads.pd.gerenciadores.GerenciadorClienteIF;
import ifpb.monteiro.ads.pd.gerenciadores.GerenciadorProduto;
import ifpb.monteiro.ads.pd.gerenciadores.GerenciadorProdutoIF;
import ifpb.monteiro.ads.pd.gerenciadores.GerenciadorUsuario;
import ifpb.monteiro.ads.pd.gerenciadores.GerenciadorUsuarioIF;

public class Fachada implements FachadaIF {

	GerenciadorProdutoIF gProduto = new GerenciadorProduto();
	GerenciadorUsuarioIF gUsuario = new GerenciadorUsuario();
	GerenciadorClienteIF gCliente = new GerenciadorCliente();

	@Override
	public void adicionaUsuario(String email, String senha, String nome)
			throws HumQueCaroException {
		gUsuario.adicionaUsuario(email, senha, nome);
	}

	@Override
	public void alteraUsuario(String email, String atributo, String novoValor)
			throws HumQueCaroException {
		gUsuario.alteraUsuario(email, atributo, novoValor);
	}

	@Override
	public void removeUsuario(String email, String senha)
			throws HumQueCaroException {
		gUsuario.removeUsuario(email, senha);
	}

	@Override
	public Usuario buscaUsuario(String email) throws HumQueCaroException {
		return gUsuario.buscaUsuario(email);
	}

	@Override
	public void adicionaProduto(String nomeProduto, String codigo,
			String fabricante) throws HumQueCaroException {
		gProduto.adicionaProduto(nomeProduto, codigo, fabricante);
	}

	@Override
	public void alteraProduto(String codigo, String atributo, String novoValor)
			throws HumQueCaroException {
		gProduto.alteraProduto(codigo, atributo, novoValor);
	}

	@Override
	public void removeProduto(String codigo) throws HumQueCaroException {
		gProduto.removeProduto(codigo);
	}

	@Override
	public Produto buscaProduto(String codigo) throws HumQueCaroException {
		return gProduto.buscaProduto(codigo);
	}

	@Override
	public void adicionaCliente(String nome, String telefone)
			throws HumQueCaroException {
		gCliente.adicionaCliente(nome, telefone);
	}

	@Override
	public void alteraCliente(String telefone, String atributo, String novoValor)
			throws HumQueCaroException {
		gCliente.alteraCliente(telefone, atributo, novoValor);

	}

	@Override
	public void removeCliente(String telefone) throws HumQueCaroException {
		gCliente.removeCliente(telefone);

	}

	@Override
	public Cliente buscaCliente(String telefone) throws HumQueCaroException {
		return gCliente.buscaCliente(telefone);
	}

}
