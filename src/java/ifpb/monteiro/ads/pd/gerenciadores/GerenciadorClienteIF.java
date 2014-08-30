package ifpb.monteiro.ads.pd.gerenciadores;

import ifpb.monteiro.ads.pd.beans.Cliente;
import ifpb.monteiro.ads.pd.exceptions.HumQueCaroException;

public interface GerenciadorClienteIF {

	public void adicionaCliente(String nome, String telefone)
			throws HumQueCaroException;

	public void alteraCliente(String telefone, String atributo, String novoValor)
			throws HumQueCaroException;

	public void removeCliente(String telefone) throws HumQueCaroException;

	public Cliente buscaCliente(String telefone) throws HumQueCaroException;

}
