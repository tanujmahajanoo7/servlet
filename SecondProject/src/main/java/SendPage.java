

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SendPage
 */
//@WebServlet("/SendPage")
public class SendPage extends HttpServlet {
	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) {
		try {
//			logic to redirect already present html page
			res.sendRedirect("/SecondProject/dashboard.html");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
