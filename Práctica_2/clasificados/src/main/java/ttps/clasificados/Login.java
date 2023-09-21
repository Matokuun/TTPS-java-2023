package ttps.clasificados;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<Usuario> users; 
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        users= new ArrayList<Usuario>(); 
        Usuario user1= new Usuario("Matias","123123","Administrador");
        Usuario user2= new Usuario("Juli","123123","Publicador");
        Usuario user3= new Usuario("Juan Cruz","123123","Publicador");
        users.add(user1);
        users.add(user2);
        users.add(user3);
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
		String nombre= request.getParameter("user");
		String contra= request.getParameter("contra");
		Usuario userX= this.users.stream().filter(u -> u.validarUsuario(nombre, contra)).findFirst().orElse(null);
		if (userX == null) {
			response.sendRedirect("error.html");
		}
		/*
		else {
			String perfil= userX.getPerfil();
			if(perfil.equals("Publicador")) {
				response.sendRedirect("publicador.html");
			}
			else{
				if(perfil.equals("Administrador")){
					response.sendRedirect("administrador.html");
				}
			}
		}
		*/
		else {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Encabezado");
			request.setAttribute("usuario", userX);
			dispatcher.forward(request, response);
			 //no se puede mandar info de un servlet a otro con send redirect, porque se realiza un nuevo request.
		}
	}

}
