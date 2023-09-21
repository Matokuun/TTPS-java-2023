package ttps.practica3;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Servlet implementation class LoginMultilenguaje
 */
public class LoginMultilenguaje extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginMultilenguaje() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Locale lenguaje = (Locale) request.getAttribute("idiomaCliente");
		String lang= lenguaje.getCountry().toLowerCase();
		
		ResourceBundle bundle;
		if (lang.equals("es")) {
			bundle = ResourceBundle.getBundle("textos", new Locale("es"));
		} else {
			if(lang.equals("it")) {
				bundle = ResourceBundle.getBundle("textos", new Locale("it"));
			}
			else {
				bundle = ResourceBundle.getBundle("textos", new Locale("en"));
			}
		}
		String titulo = bundle.getString("titulo");
		String usuario = bundle.getString("labelusuario");
		String contrasena = bundle.getString("labelpassword");

		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		out.println("<html><body>");
		out.println("<h2> " + titulo + " </h2>");
		out.println("<form action=\"Login\" method=\"POST\">");
		out.println(usuario + ": <input type=\"text\" name=\"nombre\"><br>");
		out.println(contrasena + ": <input type=\"password\" name=\"clave\"><br>");
		out.println("<input type=\"submit\" name=\"b1\" value=\":D\"><br>");
		out.println("</form>");
		out.println("</body></html>");
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

}
