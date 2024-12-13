import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/SignupController")
public class SignupController extends HttpServlet {
	Model model;
	public void init() {
		model = new Model();
	}
	public void service(HttpServletRequest req, HttpServletResponse res) {
		try {
			String id = req.getParameter("kodid");
			String pass = req.getParameter("password");
			String name = req.getParameter("name");
			String email = req.getParameter("email");
			String gender = req.getParameter("gender");
			String phone = req.getParameter("phone");
			int ph=Integer.parseInt(phone);
			
			boolean success = model.performSignup(id, pass, name, email, gender, ph);
			
			if(success) {
				res.sendRedirect("/MVCArchitecture/Login.html");
			}
			else {
				res.sendRedirect("/MVCArchitecture/Signup.html");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void destroy() {
		
	}
}
