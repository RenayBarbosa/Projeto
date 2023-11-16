package cafeteria.repositorio;

import java.sql.ResultSet;
import java.util.ArrayList;

import Banco_Dados.Conexao;
import cafeteria.interfaces.InterfaceGeral;
import cafeteria.negocio.Bebida;

public class repositorioBebida implements InterfaceGeral<Bebida> {
	
	Conexao conect = new Conexao();

	@Override
	public void inseri(Bebida a) {
		conect.executarSQL("insert into bebida (tipo, preco) values ('"+ a.getNome() +"',"+ a.getPreco()+")");
		// TODO Auto-generated method stub
		
	}

	@Override
	public Bebida busca(String b) {
		ResultSet rs = conect.executaBusca("select * from bebida where tipo='"+b+"'");
		Bebida ac = null;
		
		try {
			
			while(rs.next()){
				ac = new Bebida(rs.getString("tipo"),rs.getDouble("preco"));
				ac.setCodigo(rs.getInt("id_bebida"));
			}
			
		} catch (Exception e) {
			
		}
		
		return ac;
		
	
	}

	@Override
	public void modificar(Bebida t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Bebida t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Bebida> all() {
		ArrayList<Bebida> c = new ArrayList<>();
		ResultSet rs = conect.executaBusca("select * from bebida");
		Bebida ac = null;
		
		try {
			
			while(rs.next()){
				ac = new Bebida(rs.getString("tipo"),rs.getDouble("preco"));
				ac.setCodigo(rs.getInt("id_bebida"));
				c.add(ac);
				
			}
			
		} catch (Exception e) {
			
		}
		return c;
	}
	
	public void inserirBebidaPedido(int bebida_id , int pedido_codigo){
		conect.executarSQL("insert into p_bebida (id_bebida, id_pedido) Values("+bebida_id+","+pedido_codigo+")");
	}



}
