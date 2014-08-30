package ifpb.monteiro.ads.pd.gerenciadores;

import ifpb.monteiro.ads.pd.beans.Cliente;
import ifpb.monteiro.ads.pd.exceptions.HumQueCaroException;
import ifpb.monteiro.ads.pd.fachada.FachadaBD;

public class GerenciadorCliente implements GerenciadorClienteIF {

	private FachadaBD cliDAO;

	public GerenciadorCliente() {
		cliDAO = new FachadaBD();
	}

	@Override
	public void adicionaCliente(String nome, String telefone)
			throws HumQueCaroException {
		if (cliDAO.buscaCliente(telefone) == null
				&& verificaAtributos(nome, telefone)) {
			cliDAO.addCliente(new Cliente(nome, telefone));
		} else {
			throw new HumQueCaroException("Cliente já cadastrado");
		}
	}

	public boolean verificaAtributos(String nome, String telefone)
			throws HumQueCaroException {
		if (nome == null || nome.equals("")) {
			throw new HumQueCaroException("Campo nome do cliente inválido");
		}
		if (telefone == null || telefone.equals("") || telefone.length() != 11) {
			throw new HumQueCaroException("Campo telefone inválido");
		}
		return true;

	}

	@Override
	public void alteraCliente(String telefone, String atributo, String novoValor)
			throws HumQueCaroException {
		cliDAO.alteraCliente(telefone, atributo, novoValor);
	}

	@Override
	public void removeCliente(String telefone) throws HumQueCaroException {
		if (telefone == null || telefone.equals("")) {
			throw new HumQueCaroException("Campo telefone inválido");
		}
		if (buscaCliente(telefone) != null) {
			cliDAO.removeCliente(new Cliente(null, telefone));
		} else {
			throw new HumQueCaroException("Cliente não cadastrado");
		}
	}

	@Override
	public Cliente buscaCliente(String telefone) throws HumQueCaroException {
		Cliente cliente = cliDAO.buscaCliente(telefone);
		if (cliente != null) {
			return cliente;
		} else {
			throw new HumQueCaroException("Cliente naõ cadastrado");
		}
	}

}
