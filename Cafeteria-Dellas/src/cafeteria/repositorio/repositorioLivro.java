package cafeteria.repositorio;

import java.sql.ResultSet;
import java.util.ArrayList;

import Banco_Dados.Conexao;
import cafeteria.interfaces.InterfaceGeral;
import cafeteria.negocio.Bebida;
import cafeteria.negocio.Livro;

public class repositorioLivro implements 	InterfaceGeral<Livro> {

	Conexao conect = new Conexao();
	@Override
	public void inseri(Livro a) {
		conect.executarSQL("insert into livro (nome, genero, preco) values ('"+a.getNome()+"', '"+a.getGenero()+"', "+a.getPreco()+")");
		// TODO Auto-generated method stub
		
	}

	@Override
	public Livro busca(String b) {
		ResultSet rs = conect.executaBusca("select * from livro where nome='"+b+"'");
		Livro ac = null;
		
		try {
			while(rs.next()){
				ac = new Livro(rs.getString("nome"), rs.getString("genero") , rs.getDouble("preco"));
				ac.setCodigo(rs.getInt("id_livro"));
			}
			
		} catch (Exception e) {
			
		}
		
		return ac;
		
	}

	@Override
	public void modificar(Livro t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Livro t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Livro> all() {
		ArrayList<Livro> c = new ArrayList<>();
		ResultSet rs = conect.executaBusca("select * from livro");
		Livro ac = null;
		
		try {
			
			while(rs.next()){
				ac = new Livro(rs.getString("nome"),rs.getString("genero"), rs.getDouble("preco"));
				ac.setCodigo(rs.getInt("id_livro"));
				c.add(ac);
				System.out.println(c.get(0).getNome());
				
			}
			
		} catch (Exception e) {
			
		}
		return c;
		
	}
	
	public void inseriLivroPedido(int codigo_livro ,int codigo_pedido ){
		conect.executarSQL("insert into p_livro (id_livro,id_pedido) Values ("+codigo_livro+","+codigo_pedido+")");
	}



	}


