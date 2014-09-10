package ifpb.monteiro.ads.pd.fachadaIF;

import ifpb.monteiro.ads.pd.beans.Cliente;
import ifpb.monteiro.ads.pd.beans.Pedido;
import ifpb.monteiro.ads.pd.beans.Produto;
import ifpb.monteiro.ads.pd.beans.Usuario;
import ifpb.monteiro.ads.pd.exceptions.HumQueCaroException;
import java.util.List;

/**
 * Instituto Federal de Educacao, Ciencia e Tecnologia da Paraiba Curso ADS
 * Projeto: Hum...QueCaro!!!
 *
 * @author Prof. Mirna Maia Disciplina: Processo de Desenvolvimento
 */
/**
 * Essa Interface consiste na Fachada com as funcionalidades a serem
 * desenvolvidas da primeira sprint do projeto da disciplina de Processo de
 * Desenvolvimento.
 */
public interface FachadaIF {

    /**
     * Esse metodo cria um Usuário com os atributos passados como parametros.
     *
     * @param senha A senha utilizada para acessar o sistema.
     * @param nome O nome do usuario.
     * @param nome Email do usuario.
     * @throws HumQueCaroException Caso email (!email@algumaCoisa.com),
     * nome(Apenas letras) ou senha possuam valores invalidos, como nulo ou "",
     * devem ser apresentados as mensagens <i>Campo email invalido
     * <i>,<i>Campo nome invalido</i> e <i>Campo senha invalida</i>
     * respectivamente.
     *
     */
    public void adicionaUsuario(String email, String senha, String nome)
            throws HumQueCaroException;

    /**
     * Ajusta o atributo para o novo valor passado como parametro. O usuario
     * podera alterar apenas o campo nome ou senha.
     *
     * @param atributo
     *
     * O atributo que deve ser alterado. Pode ser "senha" ou "nome".
     * @param novoValor O novo valor do atributo
     * @throws HumQueCaroException Caso o campo atributo seja nulo ou vazio ou
     * diferente de senha ou nome, deve ser apresentada a mensagem "Campo
     * atributo invalido". Caso atributo seja senha e o novo valor sendo nulo ou
     * vazio, deve ser apresentada a mensagem "Campo novo valor invalido."
     */
    public void alteraUsuario(String email, String atributo, String novoValor)
            throws HumQueCaroException;

    /**
     * Remove o usuario cujo cpf e senha foram passados como parametro.
     *
     * @param email O email do usuario que deve ser removido.
     * @param senha A senha do usuario que deve ser removido.
     *
     * @throws HumQueCaroException Caso o email seja invalido, deve ser
     * apresentada a mensagem "Campo email invalido". Caso a senha nao seja a
     * mesma que o usuario cadastrou, deve ser apresentada a mensagem de erro
     * "Operacao invalida"
     */
    public void removeUsuario(String email, String senha)
            throws HumQueCaroException;

    /**
     * Busca o usuario no banco.
     *
     * @param email email do usuario.
     * @return Usuario
     *
     * @throws HumQueCaroException
     */
    public Usuario buscaUsuario(String email) throws HumQueCaroException;

    /**
     * Esse metodo adiciona produtos.
     *
     * @param nomeProduto nome do produto
     * @param codigo Codigo de identificacao do produto
     * @param fabricante Nome do fabricante do produto.
     * @throws HumQueCaroException Caso nomeProduto, codigo ou o fabricante
     * possuam valores invalidos, como nulo ou "", devem ser apresentados as
     * mensagens <i>Campo nome do produto invalido <i>,<i>Campo codigo
     * invalido</i> e <i>Campo Fabricante invalido</i>
     * respectivamente
     * @return <i>true</i> caso o produto tenha sido cadastrado com sucesso e
     * <i>false</i> caso o sistema ja possua um produto com o mesmo codigo
     * identificador.
     */
    public void adicionaProduto(String nomeProduto, String codigo,
            String fabricante, String valor) throws HumQueCaroException;

    /**
     * Ajusta o atributo para o novo valor passado como parametro. Pedera altera
     * apenas os campos nome do Produto ou a empresa Fabricante.
     *
     * @param atributo O atributo que deve ser alterado. Pode ser "nomeProduto"
     * ou "empresa".
     * @param novoValor O novo valor do atributo
     * @param codigo o codigo do produto
     * @throws HumQueCaroException Caso o campo atributo seja nulo ou vazio ou
     * diferente de nomeProduto ou fabricante, deve ser apresentada a mensagem
     * "Campo atributo invalido". "Caso o campo codigo seja nulo ou vazio ou nao
     * exista, deve ser apresentada a mensagem "Campo codigo invalido"
     */
    public void alteraProduto(String codigo, String atributo, String novoValor)
            throws HumQueCaroException;

    /**
     * Remove um produto cujo codigo de identificacao.
     *
     * @param codigo O codigo do produto que deve ser removido.
     *
     * @throws HumQueCaroException Caso o codigo seja invalido, deve ser
     * apresentada a mensagem "Campo codigo de identificacao invalido".
     *
     */
    public void removeProduto(String codigo) throws HumQueCaroException;

    /**
     * Busca o produto no banco.
     *
     * @param codigo Codigo de identificacao do produto.
     * @return Produto
     * @throws HumQueCaroException Caso o codigo seja inexistente, deve ser
     * apresentada a mensagem "Campo codigo de identificacao invalido".
     */
    public Produto buscaProduto(String codigo) throws HumQueCaroException;

    /**
     * Esse método retornará todos os produtos cadastrados no banco.
     *
     * @return List<Produto>
     * Lista com produtos cadastrados no sistema.
     */
    public List<Produto> getProdutos() throws HumQueCaroException;

    /**
     * Esse metodo adiciona Cliente.
     *
     * @param nome nome do Cliente
     * @param telefone Numero do telefone do Cliente
     * @throws HumQueCaroException Caso nome, telefone possuam valores
     * invalidos, como nulo ou "", devem ser apresentados as mensagens <i>Campo
     * nome do Cliente invalido <i>,<i>Campo telefone invalido</i>
     * respectivamente
     */
    public void adicionaCliente(String nome, String telefone)
            throws HumQueCaroException;

    /**
     * Ajusta o Cliente para o novo valor passado como parametro. Pedera altera
     * apenas os campos nome do Cliente ou numero de telefone.
     *
     * @param atributo O atributo que deve ser alterado. Pode ser "telefone" ou
     * "nome".
     * @param novoValor O novo valor do atributo
     * @throws HumQueCaroException Caso o campo atributo seja nulo ou vazio ou
     * diferente de nome , deve ser apresentada a mensagem "Campo atributo
     * invalido".
     */
    public void alteraCliente(String telefone, String atributo, String novoValor)
            throws HumQueCaroException;

    /**
     * Remove um Cliente cujo telefone foi passado como parametro.
     *
     * @param telefone O telefone do cliente que deve ser removido.
     * @throws HumQueCaroException Caso o telefone seja invalido, deve ser
     * apresentada a mensagem "Campo telefone invalido".
     */
    public void removeCliente(String telefone) throws HumQueCaroException;

    /**
     * Busca o Cliente no banco.
     *
     * @param telefone telefone fo Cliente.
     * @return Cliente
     * @throws HumQueCaroException
     */
    public Cliente buscaCliente(String telefone) throws HumQueCaroException;

    /**
     * Esse metodo retornara todos os clientes cadastrados no banco.
     *
     * @return List<Cliente>
     * Lista com clientes cadastrados no sistema.
     */
    public List<Cliente> getClientes() throws HumQueCaroException;

    /**
     * Esse metodo adcionira um pedido ao sistema. Lembre-se que quando adcio-
     * nado, mostrara uma tela que notificara o usuario qual o codigo do pedido.
     *
     * @param telefoneCliente telefone do Cliente.
     * @param List<Produto>
     * lista de produtos solicitados no pedido
     *
     * @throws HumQueCaroException Excecao lancada caso o cliente ou o produto
     * nao esteja cadastrado no banco.
     */
    public void addPedido(String telefoneCliente, List<Produto> produtos) throws HumQueCaroException;

    /**
     * Esse metodo serve para mudar o status de algum pedido registrado no
     * sistema.
     *
     * @param codigo Codigo de identificacao do produto.
     * @param novoStatus Status a qual o pedido agora pertence.
     * @throws HumQueCaroException Excecao lancada caso o pedido ainda nao
     * esteja cadastrado no sistema ou o novo status nao corresponda aos
     * esperados pelo sistema(Pendente, Entregue, ou Cancelado).
     */
    public void setStatusPedido(String codigo, String novoStatus) throws HumQueCaroException;

    /**
     * Esse metodo retornara todos os pedidos com status pedentes do sistema.
     *
     * @return List<Pedido>
     * Lista de pedidos com status Pedente.
     */
    public List<Pedido> getPedidos() throws HumQueCaroException;

    /**
     * Busca o pedido cadastrado no sistema.
     *
     * @param codigo Identificador de pedido que é o ID do banco.
     * @return Pedido
     * @throws HumQueCaroException
     */
    //TODO SERIA NECESSARIO ESSE METODO AQUI NA FACHADA JA QUE ELE NAO SERA 
    //UTILIZADO POR NOSSO SISTEMA EM QUALQUER QUE SEJA A INTERFACE? POIS, 
    //LEMBRO-ME QUE FICOU DECIDIDO QUE SO HAVERIA UM ADCIONA PEDIDO, UM BUSCA
    //TODOS OS PEDIDOS E UM ALTERA STATUS DO PEDIDO NA INTERFACE...
    //NAO EXCLUI E DEIXEI A CRITERIO DE VOCES DECIDIREM, POR MIM, TIRA.
    public Pedido buscaPedido(String codigo) throws HumQueCaroException;

    public void fazerLogin(String email, String senha) throws HumQueCaroException;

    /**
     * Esse método verifica se ha algum usuario logado no sistema.
     *
     * @return
     * <i>true</i> caso haja algum usuario logado no sistema.
     * <i>false</i> caso não haja algum usuario logado no sistema.
     */
    public boolean isLogged();

    /**
     * Esse metodo disconectara qualquer usuario que por ventura esteja logado
     * no sistema.
     *
     * @throws HumQueCaroException Excecao lancada caso alguma operacao do
     * sistema impeca o usuario de disconectar do sistema.
     */
    public void disconnect() throws HumQueCaroException;

    /**
     * Método para gerar comprovante de pedidos de acordo com o tipo de
     * comprovante especificado no atributo, que poderá receber os valores "sms"
     * o "impresso". De acordo com este parâmetro é que serão feitas as devidas
     * formas de gerar o comprovante para o cliente.
     *
     * @param tipoComprovante pode ser apenas "sms" ou "impresso";
     * @param pedido cadastrado
     * @throws HumQueCaroException caso algum erro aconteça ao gerar o
     * comprovante do Pedido
     */
    public void gerarComprovante(String tipoComprovante, Pedido pedido) throws HumQueCaroException;

    /**
     * Método para gerar uma 2ª via de comprovante impresso, onde é necessário o
     * identificador do cliente deste pedido.
     *
     * @param identificadorCliente
     * @throws HumQueCaroException
     */
    public void gerarSegundaVia(String identificadorCliente) throws HumQueCaroException;
}
