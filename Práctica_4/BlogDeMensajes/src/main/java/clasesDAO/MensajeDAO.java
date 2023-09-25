package clasesDAO;

import java.sql.SQLException;
import java.util.List;

import clases.Mensaje;

public interface MensajeDAO {

	public int eliminar(Mensaje m);
	
	public int guardar(Mensaje m);
	
	public List<Mensaje> cargar();
}
