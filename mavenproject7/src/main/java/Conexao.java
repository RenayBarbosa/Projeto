
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author renay
 */
public class Conexao {
    public static void main(String[] args) {
        
        Connection conexao=null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection Connection = DriverManager.getConnection("jdbc:mysql:\\localhot\banco", "usuario", "senha");
        } catch (ClassNotFoundException ex) {
            System.out.println("Conexao.main() no localizaddo");
        } catch (SQLException ex) {
            System.out.println("erro"+ex.getMessage());
        }
        finally{
          if(conexao !=null){
              conexao.close();
          }
        }
    }
    
}
