package ifpb.monteiro.ads.pd.gerenciadores;

import ifpb.monteiro.ads.pd.beans.Usuario;
import ifpb.monteiro.ads.pd.exceptions.HumQueCaroException;

public interface GerenciadorUsuarioIF {


	/**
	 * Esse metodo cria um Usuário com os atributos passados como parametros.
	 * 
	 * @param senha
	 *            A senha utilizada para acessar o sistema.
	 * @param nome
	 *            O nome do usuario.
	 *@param nome
	 *            Email do usuario.
	 * @throws HumQueCaroException
	 *             Caso email (!email@algumaCoisa.com), nome(Apenas letras) ou senha possuam valores invalidos, como nulo ou "",
	 *             devem ser apresentados as mensagens  <i>Campo email invalido <i>,<i>Campo nome
	 *             invalido</i> e <i>Campo senha invalida</i> respectivamente.
	 * 
	 */
	public void adicionaUsuario(String email, String senha, String nome)
			throws HumQueCaroException;
	
	/**
	 * Ajusta o atributo para o novo valor passado como parametro. O usuario podera
	 * alterar apenas o campo nome ou senha.
	 * 
	 * @param atributo
	 *
	 *            O atributo que deve ser alterado. Pode ser "senha" ou "nome".
	 * @param novoValor
	 *            O novo valor do atributo
	 * @throws HumQueCaroException
	 *             Caso o campo atributo seja nulo ou vazio ou diferente de
	 *             senha ou nome, deve ser apresentada a mensagem
	 *             "Campo atributo invalido". Caso atributo seja senha e o novo
	 *             valor sendo nulo ou vazio, deve ser apresentada a mensagem
	 *             "Campo novo valor invalido."
	 */
	public void alteraUsuario(String email, String atributo, String novoValor)
			throws HumQueCaroException;

	/**
	 * Remove o usuario cujo cpf e senha foram passados como parametro.
	 * 
	 * @param email
	 *            O email do usuario que deve ser removido.
	 * @param senha
	 *            A senha do usuario que deve ser removido.
	 * 			
	 * @throws HumQueCaroException
	 *             Caso o email seja invalido, deve ser apresentada a mensagem
	 *             "Campo email invalido". Caso a senha nao seja a mesma que o usuario cadastrou, deve
	 *             ser apresentada a mensagem de erro "Operacao invalida"
	 */
	public void removeUsuario(String email, String senha)
			throws HumQueCaroException;

	/**
	 * Busca o usuario no banco.
	 * 
	 * @param email
	 * 		email do usuario.
	 * @return Usuario
	 *
	 * @throws HumQueCaroException
	 */
	public Usuario buscaUsuario(String email)
			throws HumQueCaroException;
	
	
}
