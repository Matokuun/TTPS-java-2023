package clasesDAO;

import clasesDAOImplJdbc.MensajeDAOjdbc;
import clasesDAOImplJdbc.UsuarioDAOjdbc;

public class FactoryDAO {
	public static UsuarioDAO getUsuarioDAO() {
		return new UsuarioDAOjdbc();
	}
	public static MensajeDAO getMensajeDAO() {
		return new MensajeDAOjdbc();
	}
}
