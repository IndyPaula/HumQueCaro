package ifpb.monteiro.ads.pd.beans;

/**
 */
public class Pedido {

    private String codigo;
    private String telefoneCliente;
    private String codigoProduto;
    private String situacao;

    public Pedido() {
    }

    public Pedido(String telefoneCliente, String codigoProduto, String situacao) {
        this.telefoneCliente = telefoneCliente;
        this.codigoProduto = codigoProduto;
        this.situacao = situacao;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(String codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    public String getTelefoneCliente() {
        return telefoneCliente;
    }

    public void setTelefoneCliente(String telefoneCliente) {
        this.telefoneCliente = telefoneCliente;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }
}
