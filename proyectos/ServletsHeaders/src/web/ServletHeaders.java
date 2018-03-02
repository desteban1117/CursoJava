package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletHeaders
 */
@WebServlet("/ServletHeaders")
public class ServletHeaders extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ServletHeaders() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out = response.getWriter();
		
		String metodo = request.getMethod();
		String url = request.getRequestURI();
		
		out.println("metodo: " + metodo);
		out.println("url: " + url);
		
		out.println("Host: " + request.getHeader("Host"));
		
		out.println("Navegador: " + request.getHeader("User-Agent"));
		
		Enumeration cabeceros = request.getHeaderNames();
		while(cabeceros.hasMoreElements()) {
			String nombreCabecero = (String) cabeceros.nextElement();
			out.println(nombreCabecero + ": " + 
					request.getHeader(nombreCabecero));
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
