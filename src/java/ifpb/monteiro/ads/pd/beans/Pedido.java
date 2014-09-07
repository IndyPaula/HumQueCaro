package ifpb.monteiro.ads.pd.beans;

import java.util.List;

/**
 */
public class Pedido {

    private String codigo;
    private String telefoneCliente;
    private List<Produto> produtos;
    private String situacao;
    private float valor;

    public Pedido() {
    }

    public Pedido(String telefoneCliente, List<Produto> produtos, String situacao, float valor) {
        this.telefoneCliente = telefoneCliente;
        this.produtos = produtos;
        this.situacao = situacao;
        this.valor = valor;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
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

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }
}
