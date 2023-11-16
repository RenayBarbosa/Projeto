package cafeteria.repositorio;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import Banco_Dados.Conexao;
import cafeteria.interfaces.InterfaceGeral;
import cafeteria.negocio.Pedido;

public class repositorioPedido implements InterfaceGeral<Pedido>{
	Conexao conect = new Conexao();

	@Override
	public void inseri(Pedido a) {
		

		Date data = new Date();

		
		conect.executarSQL("INSERT INTO pedido (datas,mesa,total,id_cliente) VALUES ('"+new java.sql.Date(data.getTime())+"',"+a.getMesa()+","+a.getTotal()+","+a.getCliente().getCodigo()+")");
	}

	@Override
	public Pedido busca(String b) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modificar(Pedido t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Pedido t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Pedido> all() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public int maxId(){

		ResultSet rs = conect.executaBusca("select * from pedido where id_pedido =(select max(id_pedido) from pedido)");
		
		try {
			while(rs.next()){
			return rs.getInt("id_pedido");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}


	}


