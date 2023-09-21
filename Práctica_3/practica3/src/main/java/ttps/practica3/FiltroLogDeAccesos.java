package ttps.practica3;

import jakarta.servlet.Filter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import java.time.*;

/**
 * Servlet Filter implementation class FiltroLogDeAccesos
 */
public class FiltroLogDeAccesos extends HttpFilter implements Filter {
       
    /**
     * @see HttpFilter#HttpFilter()
     */
    public FiltroLogDeAccesos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		//hacer esto para no castear:
		HttpServletRequest req= (HttpServletRequest) request;
		//utilizar system.out
		String ip= request.getRemoteAddr();
		String host= request.getRemoteHost();
		LocalDate dia= LocalDate.now();
		LocalDateTime hora= LocalDateTime.now();
		String metodo= ((HttpServletRequest) request).getMethod();
		String recurso= ((HttpServletRequest) request).getRequestURI();
		String protocolo= request.getProtocol();
		String useragent= req.getHeader("User-Agent");
		System.out.println("la ip es: "+ ip + " - el host es: "+ host);
		System.out.println("dia: "+ dia);
		System.out.println("hora: "+hora);
		System.out.println("Metodo: "+ metodo+ ", recurso: "+ recurso+ ", protocolo: "+ protocolo);
		System.out.println("User-Agent: "+ useragent);
		System.out.println("--------------------------------------");
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
