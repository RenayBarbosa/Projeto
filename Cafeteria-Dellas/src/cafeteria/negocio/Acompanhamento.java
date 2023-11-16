package cafeteria.negocio;

public class Acompanhamento {
	private int codigo;
	private String nome;
	private String tipo;
	private double preco;
	
	public Acompanhamento(String nome, String tipo, double preco){
		this.nome = nome;
		this.tipo = tipo;
		this.codigo = codigo;
		this.preco = preco;
		
	}
	public int getCodigo(){
		return codigo;
	}
	public void setCodigo(int codigo){
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	

}
