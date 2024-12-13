import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//@WebServlet("/Controller")
public class LoginController extends HttpServlet {
	Model model;
	@Override
	public void init() {
		model = new Model();
	}

	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) {
		try {
			String id = req.getParameter("kid");
			String password = req.getParameter("pwd");

			boolean success = model.performLogin(id,password);

			if(success) {
				res.sendRedirect("/MVCArchitecture/Welcome.html");
			}
			else {
				res.sendRedirect("/MVCArchitecture/invalid.html");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void destroy() {

	}
}
