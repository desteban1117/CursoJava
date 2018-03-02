package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet
 */
@WebServlet(name="Servlet", urlPatterns= {"/Servlet"})
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet() {
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
		PrintWriter out = response.getWriter();
		String user = request.getParameter("usuario");
		String pass = request.getParameter("password");
		String[] tegnologiasArray = request.getParameterValues("tecnologia");
		String genero = request.getParameter("genero");
		String ocupacion = request.getParameter("ocupacion");
		String[] musica = request.getParameterValues("musica");
		String comentarios = request.getParameter("comentarios");
		
		out.println("Usuario: " + user);
		StringBuilder tecnologias = new StringBuilder();
		for(String t : tegnologiasArray) {
			tecnologias.append(t + ", ");
		}
		tecnologias.delete(tecnologias.length() - 2, tecnologias.length());
		
		out.println("Tecnologias: " + tecnologias);
		
		out.println("Genero: " + genero);
		
		out.println("Ocupacion: " + ocupacion);
		
		StringBuilder music = new StringBuilder();
		for(String m : musica) {
			music.append(m + ", ");
		}
		
		music.delete(music.length() - 2, music.length());
		
		out.println("Musica: " + music.toString());
		
		out.println("Comentarios: " + comentarios);

		
	}

}
