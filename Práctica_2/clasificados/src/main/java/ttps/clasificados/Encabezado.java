package ttps.clasificados;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class Encabezado
 */
public class Encabezado extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Encabezado() {
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
		ServletContext contexto= request.getServletContext();
		SitioClasificado sitio= (SitioClasificado) contexto.getAttribute("sitio");
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Menú");
		response.getWriter().append("<html><body><header><p> Sitio: " + sitio.getNombre() +", email: "+ sitio.getEmail()+", telefono: "+sitio.getTelefono() +"</p></header>");
		dispatcher.include(request, response); //sirve para incluir el encabezado en el contenido del servlet que sigue (menu)
	}

}
