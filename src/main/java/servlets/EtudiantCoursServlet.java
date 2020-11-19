package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class EtudiantCoursServlet
 */
public class EtudiantCoursServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
//	private EtudiantService studentService;
//	private CoursService courseService;
	private RequestDispatcher dispatcher = null;
//	private IEtudiantDao etudiantDao = new EtudiantDao();

	/**
	 * Default constructor.
	 */
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EtudiantCoursServlet() {
        super();
        // TODO Auto-generated constructor stub
//        studentService = new EtudiantService(etudiantDao);
//        courseService = new CoursService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		methode(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String email = request.getParameter("mail") ;
		String course = request.getParameter("listeCours");		
//		Etudiant student = studentService.getEtudiantByEmail(email);
		HttpSession session = request.getSession();
		
//		System.out.println(course + " " +student.getId());
		
//		courseService.associateCourse(course, student.getId());	
		dispatcher = request.getRequestDispatcher("etudiant.jsp");
		dispatcher.forward(request, response);
	}
	
	public void methode(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		String object = request.getParameter("id");
		int id = Integer.valueOf(object);
				
//		Etudiant student = studentService.getEtudiant((long) id);
//		List<Cours> listCours=courseService.getAllCours();

		dispatcher = request.getRequestDispatcher("etudiantCours.jsp");
//		session.setAttribute("student", student);
//		session.setAttribute("courses", listCours);

		dispatcher.forward(request, response);
	}

}
