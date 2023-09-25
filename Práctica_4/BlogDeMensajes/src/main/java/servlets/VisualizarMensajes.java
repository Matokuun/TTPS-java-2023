package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import clases.Mensaje;
import clasesDAO.FactoryDAO;

/**
 * Servlet implementation class VisualizarMensajes
 */
public class VisualizarMensajes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VisualizarMensajes() {
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
		//mostrar todos los mensajes publicados y el usuario que lo publicó
		//obteniendo cada mensaje
		List<Mensaje> lista= FactoryDAO.getMensajeDAO().cargar();
		String haIniciado= "<a href='agregarMensaje.html'>Volver</a>";
		HttpSession session = request.getSession(false); // Obtener la sesión sin crear una nueva si no existe
		if (session != null && session.getAttribute("usuarioLogueado") != null && (Boolean) session.getAttribute("usuarioLogueado")) {
		    // El usuario ha iniciado sesión
		    haIniciado= "<a href='agregarMensajeSesionIniciada.html'>Volver</a>";
		} else {
		    // El usuario no ha iniciado sesión
		    response.sendRedirect("error.html");
		}
		PrintWriter out= response.getWriter();
		out.println("<html><head>");
		out.println("<link rel='stylesheet' type='text/css' href='css/styles.css'>");
		out.println("</head><body>");
		out.println(haIniciado);
		lista.stream().forEach(m -> out.println("<div class='mensaje'>" + FactoryDAO.getUsuarioDAO().encontrar(m.getIdpersona()) + " dijo: " + m.getContenido() + "</div>"));
		out.println("</body></html>");
	}

}
