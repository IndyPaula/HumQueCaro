package ifpb.monteiro.ads.pd.fachadaIF;

import ifpb.monteiro.ads.pd.beans.Cliente;
import ifpb.monteiro.ads.pd.beans.Produto;
import ifpb.monteiro.ads.pd.beans.Usuario;
import ifpb.monteiro.ads.pd.exceptions.HumQueCaroException;



public interface FachadaBancoIF{

	void addUsuario(Usuario usuario) throws HumQueCaroException;

	void removeUsuario (Usuario usario) throws HumQueCaroException;

	Usuario buscaUsuario (String email) throws HumQueCaroException;

	void alteraUsuario (Usuario usuario) throws HumQueCaroException;

	void addProduto (Produto produto) throws HumQueCaroException;

	void removeProduto (Produto produto) throws HumQueCaroException;

	Produto buscaProduto (String codigo) throws HumQueCaroException;

	void alteraProduto (String codigo, String atributo, String novoValor) throws HumQueCaroException;

	void addCliente (Cliente cliente) throws HumQueCaroException;

	void removeCliente (Cliente cliente) throws HumQueCaroException;

	Cliente buscaCliente (String telefone) throws HumQueCaroException;

	void alteraCliente (String telefone, String atributo, String novoValor) throws HumQueCaroException;

}
