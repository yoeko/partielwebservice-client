package servlets;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ensup.partiel.dao.EtudiantDao;
import com.ensup.partiel.dao.IEtudiantDao;
import com.ensup.partiel.domaine.Cours;
import com.ensup.partiel.domaine.Etudiant;
import com.ensup.partiel.domaine.User;
import com.ensup.partiel.service.CoursService;
import com.ensup.partiel.service.EtudiantService;
import com.ensup.partiel.service.UserService;

/**
 * Servlet implementation class EtudiantServlet
 */
//@WebServlet("/Etudiant")
public class EtudiantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private EtudiantService studentService;
	private CoursService courseService;
	private RequestDispatcher dispatcher = null;
	private User user = null;
	private IEtudiantDao etudiantDao = new EtudiantDao();
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EtudiantServlet() {
		courseService = new CoursService();
		studentService = new EtudiantService(etudiantDao);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		session.setAttribute("student", null);
		user = (User) session.getAttribute("user");
		

		session.setAttribute("students", lister());
		session.setAttribute("courses", getAllCours());
		
		dispatcher = request.getRequestDispatcher("etudiant.jsp");
		dispatcher.forward(request, response);
	}

	private List<Etudiant> lister() {

		List<Etudiant> students = Collections.emptyList();
		try {
			if(user.getProfil().equalsIgnoreCase("D")) {
			students = studentService.getAllStudent();
			} 
		} catch (Exception e) {

		}
		return students;
	}

	private List<Cours> getAllCours() {

		List<Cours> courses = Collections.emptyList();
		try {

			courses = courseService.getAllCours();
		} catch (Exception e) {

		}
		return courses;
	}
}
