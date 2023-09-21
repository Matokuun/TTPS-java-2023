package ttps.clasificados;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextAttributeListener;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

/**
 * Application Lifecycle Listener implementation class ListenerSitioClasificado
 *
 */
public class ListenerSitioClasificado implements ServletContextAttributeListener, ServletContextListener {

    /**
     * Default constructor. 
     */
    public ListenerSitioClasificado() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    	ServletContext contexto= sce.getServletContext();
    	String nombre= contexto.getInitParameter("nombreSitio");
    	String email= contexto.getInitParameter("emailSitio");
    	String telefono= contexto.getInitParameter("telefonoContacto");
    	
    	SitioClasificado sitio= new SitioClasificado(nombre,email,telefono);
    	
    	contexto.setAttribute("sitio", sitio);

    }


	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }
	
}
