package ifpb.monteiro.ads.pd.enumerations;

public enum Dados {
	NOME("nome"), SENHA("senha"), FABRICANTE("fabricante"),EMAIL("email"), VALOR("valor");

	private String nome;

	private Dados(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}
	
	
}