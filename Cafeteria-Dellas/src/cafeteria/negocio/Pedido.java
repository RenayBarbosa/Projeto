package cafeteria.negocio;

import java.util.ArrayList;

public class Pedido {
	private int codigo;
	private String data;
	private ArrayList<Acompanhamento> acompanhamento;
	private ArrayList<Bebida> bebida;
	private ArrayList<Livro> livro;
	private Cliente cliente;
	private double total;
	private int mesa;
	
	public Pedido(){
		acompanhamento = new ArrayList<>();
		bebida = new ArrayList<>();
		livro = new ArrayList<>();
		
		this.total =0;
				
	}
	
	public void calcularTotal(){
		
		for (int i = 0; i < acompanhamento.size(); i++) {
			this.total += acompanhamento.get(i).getPreco();	
		}
		
		for (int j = 0; j < livro.size(); j++) {
			this.total += livro.get(j).getPreco();
			
		}
		for (int h = 0; h < bebida.size(); h++) {
			this.total += bebida.get(h).getPreco();
			
		}
	}

	public void addAcompanhamento(Acompanhamento comida){
		acompanhamento.add(comida);
		
	}
	public void addBebida(Bebida liquido){
		bebida.add(liquido);
		
	}
	public void addLivro(Livro ler){
		livro.add(ler);
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public ArrayList<Acompanhamento> getAcompanhamento() {
		return acompanhamento;
	}

	public void setAcompanhamento(ArrayList<Acompanhamento> acompanhamento) {
		this.acompanhamento = acompanhamento;
	}

	public ArrayList<Bebida> getBebida() {
		return bebida;
	}

	public void setBebida(ArrayList<Bebida> bebida) {
		this.bebida = bebida;
	}

	public ArrayList<Livro> getLivro() {
		return livro;
	}

	public void setLivro(ArrayList<Livro> livro) {
		this.livro = livro;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public int getMesa() {
		return mesa;
	}

	public void setMesa(int mesa) {
		this.mesa = mesa;
	}
	
	
	
}
