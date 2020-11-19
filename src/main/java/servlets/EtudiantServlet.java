package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.DefaultClientConfig;

import domaine.Etudiant;
import domaine.User;



/**
 * Servlet implementation class EtudiantServlet
 */
//@WebServlet("/Etudiant")
public class EtudiantServlet extends HttpServlet {
	
	//private static final long serialVersionUID = 1L;
	
//	private EtudiantService studentService;
//	private CoursService courseService;
	private RequestDispatcher dispatcher = null;
	private User user = null;
//	private IEtudiantDao etudiantDao = new EtudiantDao();
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EtudiantServlet() {
//		courseService = new CoursService();
//		studentService = new EtudiantService(etudiantDao);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("voilaaaaaaaaaaaaaaaaaaaaaa");
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		///session.setAttribute("student", null);
		user = (User) session.getAttribute("user");
		
		System.out.println("dedanssssssssssssssssssssssssssssss");
		
		session.setAttribute("students", lister());
		//session.setAttribute("courses", getAllCours());
		
		dispatcher = request.getRequestDispatcher("etudiant.jsp");
		dispatcher.forward(request, response);
	}

	public List<Etudiant> lister() {

		System.out.println("maguiiiiiiiiii");
		
//			DefaultClientConfig defaultClientConfig = new DefaultClientConfig();
//			defaultClientConfig.getClasses().add(JacksonJsonProvider.class);
//			Client client = Client.create(defaultClientConfig);
		Client client = Client.create();
//			
			
			WebResource webResource = client.resource("http://localhost:8080/partielwebservice-webservice/rest/json/student/get");

			ClientResponse response2 = webResource.accept("application/json").get(ClientResponse.class);

			return  (List<Etudiant>) response2.getEntity(new GenericType<List<Etudiant>>(){});
					
		
	}


	
}
