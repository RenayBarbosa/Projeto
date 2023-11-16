package cafeteria.repositorio;

import java.sql.ResultSet;
import java.util.ArrayList;

import Banco_Dados.Conexao;
import cafeteria.interfaces.InterfaceGeral;
import cafeteria.negocio.Acompanhamento;
import cafeteria.negocio.Bebida;

public class repositorioAcompanhamento implements InterfaceGeral<Acompanhamento>{
	
	Conexao conect = new Conexao();

	@Override
	public void inseri(Acompanhamento a) {
		conect.executarSQL("insert into acompanhamento (nome, preco)values ('"+ a.getNome()+"', "+ a.getPreco()+")");
		// TODO Auto-generated method stub
		
	}

	@Override
	public Acompanhamento busca(String b) {
		
		ResultSet rs =	conect.executaBusca("select * from acompanhamento where nome='"+b+"'");
		
		Acompanhamento ac = null;
		
		try {
			
			while(rs.next()){
			    ac = new Acompanhamento(rs.getString("nome"), "", rs.getDouble("preco"));
				ac.setCodigo(rs.getInt("id_acompanhamento"));
			}
			
		} catch (Exception e) {
		
		}
		
		
		return ac;
	}

	@Override
	public void modificar(Acompanhamento t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Acompanhamento t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Acompanhamento> all() {
		ArrayList<Acompanhamento> c = new ArrayList<>();
		ResultSet rs = conect.executaBusca("select * from acompanhamento");
		
		
     try {
    	 
    	 while(rs.next()){
    		 Acompanhamento ac = new Acompanhamento(rs.getString("nome"),"", rs.getDouble("preco"));
				ac.setCodigo(rs.getInt("id_acompanhamento"));
				c.add(ac);
				
			}
			
		} catch (Exception e) {
			
		}
		return c;
		
	}
	
	public void iserirAcompanhamentoPedido(int id_acompanhamento, int id_pedido){
		conect.executarSQL("insert into p_acompanhamento (id_acompanhamento, id_pedido) values("+id_acompanhamento+", "+id_pedido+")");
		
	}


	}


