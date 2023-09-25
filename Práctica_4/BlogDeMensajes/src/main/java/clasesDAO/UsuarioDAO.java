package clasesDAO;

import java.sql.SQLException;

import clases.Usuario;

public interface UsuarioDAO {
	
	public int encontrar(String email) ;
	public String encontrar(int email) ;
	
}
