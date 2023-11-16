package cafeteria.negocio;

public class Cliente {
	private int codigo;
	private String nome;
	private String cpf;
	private String telefone;
	private String rua;
	private String cep;
	
	public Cliente(String nome, String cpf, String telefone, String rua, String cep) {
		
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.rua = rua;
		this.cep = cep;
	}
	

	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getNome(){
		return nome;
	}
	public void setNome(String nome){
		this.nome = nome;
	}
	public String getCpf(){
		return cpf;
	}
	public void setCpf(String cpf){
		this.cpf = cpf;
	}
	public String getTelefone(){
		return telefone;
	}
	public void setTeleforne(String telefone){
		this.telefone = telefone;
	}
	
    public String getRua(){
    	return rua;
    }
    public void setRua(String rua){
    	this.rua = rua;
    }
    
    public String getCep(){
    	return cep;
    }
    public void setCep(String cep){
    	this.cep = cep;
    }
	
	

}
