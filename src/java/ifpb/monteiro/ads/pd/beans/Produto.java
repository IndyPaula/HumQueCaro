package ifpb.monteiro.ads.pd.beans;

public class Produto {

    private int codigoProduto;
    private String nome;
    private String codigo;
    private String fabricante;
    private String valor;

    public Produto(String nome, String codigo, String fabricante, String valor) {
        this.nome = nome;
        this.codigo = codigo;
        this.fabricante = fabricante;
        this.valor = valor;
    }

    public Produto() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(int codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
}
