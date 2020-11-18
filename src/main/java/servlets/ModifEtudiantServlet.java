package servlets;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
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

/**
 * Servlet implementation class ModifEtudiantServlet
 */
public class ModifEtudiantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EtudiantService studentService;
	private RequestDispatcher dispatcher = null;
	private CoursService courseService;
	private User user = null;
	private IEtudiantDao etudiantDao = new EtudiantDao();
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ModifEtudiantServlet() {
		studentService = new EtudiantService(etudiantDao);
		courseService = new CoursService();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		dispatcher = request.getRequestDispatcher("etudiantAjout.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Etudiant student = new Etudiant(
				
				request.getParameter("firstName"), 
				request.getParameter("lastName"),
				request.getParameter("mailAdresse"), 
				request.getParameter("adress"),
				request.getParameter("numberPhone"),
				new Date());
		
		int idEtudiant = Integer.valueOf(request.getParameter("id"));

		HttpSession session = request.getSession();
		session.setAttribute("student", null);
		user = (User) session.getAttribute("user");
		
		studentService.updateStudent((long) idEtudiant, student);

		session.setAttribute("student", null);
		session.setAttribute("students", lister());
		session.setAttribute("courses", getAllCours());
		
		dispatcher = request.getRequestDispatcher("etudiant.jsp");
		dispatcher.forward(request, response);
	}

	private List<Etudiant> lister() {

		List<Etudiant> students = Collections.emptyList();
		try {			
			
			students = studentService.getAllStudent();
			
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
