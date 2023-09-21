package ttps.clasificados;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class Menú
 */
public class Menú extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Menú() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Usuario user= (Usuario) request.getAttribute("usuario");
		String perfil= user.getPerfil();
		//response.getWriter().append("<html><h1>").append("bienvenido "+ perfil+ " ¿como andas?</h1></html>");
		if (perfil.equals("Publicador")) {
			response.getWriter().append("<h1>Bienvenido Publicador!</h1>"
					+ "	<ul>"
					+ "	<li>Actualizar datos de contacto</li>"
					+ "	<li>ABM de Publicaciones</li>"
					+ "	<li>Contestar consultas</li>"
					+ "	</ul>"
					+ "</body>"
					+ "</html>");
		}
		else {
			if(perfil.equals("Administrador")) {
				response.getWriter().append("<h1>Bienvenido Administrador!</h1>"
						+ "<ul><li>Listar usuarios publicadores</li><li>ABM Administradores</li><li>Ver estadisticas</li></ul>"
						+ "</body></html>");
			}
		}
	}

}
