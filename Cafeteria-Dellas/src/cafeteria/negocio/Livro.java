package cafeteria.negocio;

public class Livro {
	private String nome;
	private String genero;
	private int codigo;
	private double preco;
	
	public Livro(String nome, String genero,  double preco) {
		
		this.nome = nome;
		this.genero = genero;
		this.preco = preco;
	}
	public String getNome(){
		return nome;
	}
	public void setNome(String nome){
		this.nome = nome;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	

}
