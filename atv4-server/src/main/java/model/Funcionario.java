package model;

public class Funcionario {
	
	int id;
    String nome;
    String cargo;
    String dataNascimento;
    String dataEntradaEmpresa;
  
	public Funcionario(int id, String nome, String cargo, String dataNascimento, String dataEntradaEmpresa) {
		super();
		this.id = id;
		this.nome = nome;
		this.cargo = cargo;
		this.dataNascimento = dataNascimento;
		this.dataEntradaEmpresa = dataEntradaEmpresa;
	}

	@Override
	public String toString() {
		return "Funcionario [id=" + id + ", nome=" + nome + ", cargo=" + cargo + ", dataNascimento=" + dataNascimento
				+ ", dataEntradaEmpresa=" + dataEntradaEmpresa + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getDataEntradaEmpresa() {
		return dataEntradaEmpresa;
	}

	public void setDataEntradaEmpresa(String dataEntradaEmpresa) {
		this.dataEntradaEmpresa = dataEntradaEmpresa;
	}
	
}
