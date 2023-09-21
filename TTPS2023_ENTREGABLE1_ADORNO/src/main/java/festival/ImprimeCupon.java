package festival;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.ThreadLocalRandom;

import javax.imageio.ImageIO;


/**
 * Servlet implementation class ImprimeCupon
 */
public class ImprimeCupon extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImprimeCupon() {
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
		ServletOutputStream output= response.getOutputStream();
		String textoRemera= request.getParameter("textoRemera");
		int codigoRetiro= ThreadLocalRandom.current().nextInt(1000000,9999999);
		String codigoRetiroString= String.valueOf(codigoRetiro);
		//obtengo imagen
		URL urlImagen= this.getServletContext().getResource("/cupon3.jpg");
		BufferedImage imagen= ImageIO.read(urlImagen);
		Graphics2D graficos= imagen.createGraphics();
		//configuro fuente, color, etc
		graficos.setFont(new Font("TimesRoman", Font.BOLD, 30));
		graficos.setColor(Color.WHITE);
		graficos.drawString(textoRemera, 380, 700);
		graficos.drawString(codigoRetiroString, 1120, 860);
		ImageIO.write(imagen, "png", output);
		output.close();

	}

}
