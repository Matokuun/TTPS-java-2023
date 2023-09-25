package clasesDAOImplJdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.mysql.cj.jdbc.Driver;
import clases.Usuario;
import clasesDAO.UsuarioDAO;

public class UsuarioDAOjdbc implements UsuarioDAO{
	
	//devuelve el id de la persona, cuyo email pasado por parametro coincida
	public int encontrar(String email){
		int id= 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/blog_de_mensajes","root","root");
			Statement st= con.createStatement();
			//aca usar la conexion para peticiones o cosas
			ResultSet resul= st.executeQuery("select email, idusuario from usuarios");
			boolean stop= false;
			while(resul.next()&&(stop==false)) {
				if(resul.getString("email").equals(email)) {
					stop=true;
					id= resul.getInt("idusuario");
				}
			}
			//cerramos conexion
			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			 System.out.println("no se encontró el driver");
		} catch (SQLException e) {
			System.out.println("hubo un error con la bd: codigo "+ e.getErrorCode() + ",  "+ e.getMessage());
		}
		return id;
	}
	
	//devuelve el email de la persona, pasando como parametro su id
	public String encontrar(int id) {
		String email= "a";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/blog_de_mensajes","root","root");
			Statement st= con.createStatement();
			//aca usar la conexion para peticiones o cosas
			ResultSet resul= st.executeQuery("select email, idusuario from usuarios");
			boolean stop= false;
			while(resul.next()&&(stop==false)) {
				if(resul.getInt("idusuario")==id) {
					stop=true;
					email= resul.getString("email");
				}
			}
			//cerramos conexion
			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			 System.out.println("no se encontró el driver");
		} catch (SQLException e) {
			System.out.println("hubo un error con la bd: codigo "+ e.getErrorCode() + ",  "+ e.getMessage());
		}
		return email;
	}
}
