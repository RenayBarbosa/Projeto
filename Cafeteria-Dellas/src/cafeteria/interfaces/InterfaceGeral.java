package cafeteria.interfaces;

import java.util.ArrayList;

public interface InterfaceGeral <T>{
	
	public void inseri (T a);
	
	public T busca (String b);
	
	public void modificar (T t);
	
	public void delete(T t);
	
	public ArrayList<T> all ();

}
