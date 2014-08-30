package ifpb.monteiro.ads.pd.beans;

public class Cliente {

	private String codigo;
	private String nome;
	private String telefone;

	public Cliente(String nome, String telefone) {
		this.nome = nome;
		this.telefone = telefone;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	@Override
	public String toString() {
		return getTelefone() + ", " + getNome();
	}
}
