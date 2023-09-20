package visitas25;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class Premio
 */
public class Premio extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private int contadorVisitas= 0;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Premio() {
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
		contadorVisitas++;
		response.setContentType("text/html");
		String nombre= request.getParameter("nombre");
		String numero= Integer.toString(contadorVisitas);
		String cadena= "¡Felicitaciones @! eres el visitante número # de nuestro sitio y has sido seleccionado para el gran premio TTPS - Cursada APROBADA"
				.replace("@", nombre).replace("#", numero);
		PrintWriter out= response.getWriter(); //nos va a permitir escribir en el html
		out.println("<html><body>");
		out.println("<p>"+ cadena + "</p>");
		out.println("</body></html>");
		out.close();
		//doGet(request, response);
	}

}
