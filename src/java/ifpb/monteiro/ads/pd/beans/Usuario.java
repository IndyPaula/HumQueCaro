package ifpb.monteiro.ads.pd.beans;

public class Usuario {
	private String email, senha, nome;
	private int codigoUsuario;

	
	public Usuario(String email, String senha, String nome, int codigoUsuario) {
		this.email = email;
		this.senha = senha;
		this.nome = nome;
		this.codigoUsuario = codigoUsuario;
	}

	public Usuario(String email, String senha, String nome) {
		this.email = email;
		this.senha = senha;
		this.nome = nome;
	}

	public Usuario(String email, String senha) {
		this.email = email;
		this.senha = senha;
	}

	public int getCodigoUsuario() {
		return codigoUsuario;
	}

	public void setCodigoUsuario(int codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}