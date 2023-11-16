package cafeteria.repositorio;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Banco_Dados.Conexao;
import cafeteria.interfaces.InterfaceGeral;
import cafeteria.negocio.Cliente;

public class repositorioCliente implements InterfaceGeral<Cliente> {
	
	Conexao conect = new Conexao();

	@Override
	public void inseri(Cliente a) {
		conect.executarSQL("Insert into cliente (cpf, nome, telefone, rua, cep )values('"+a.getCpf()+"','"+a.getNome()+"', '"+a.getTelefone()+"','"+a.getRua()+"','"+a.getCep()+"')");
	}

	@Override
	public Cliente busca(String b) {
			
		ResultSet rs = conect.executaBusca("select * from cliente where nome='"+b+"'");
		
		try {
			while(rs.next()){
				Cliente c = new Cliente(rs.getString("nome"), rs.getString("cpf"), rs.getString("telefone"), rs.getString("rua"), rs.getString("cep"));
				c.setCodigo(rs.getInt("id_cliente"));
				return c;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public void modificar(Cliente t) {

	}

	@Override
	public void delete(Cliente t) {

		
	}

	@Override
	public ArrayList<Cliente> all() {

		return null;
	}



}
