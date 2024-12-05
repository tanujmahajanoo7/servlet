

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LifeCycleMethods
 */
//@WebServlet("/LifeCycleMethods")
public class LifeCycleMethods extends HttpServlet {
	public void init() {
		System.out.println("Server Started and Init method get executed");
	}
	public void service(HttpServletRequest req, HttpServletResponse res) {
		
		System.out.println("Service method executed");
	}
	public void destroy() {
		System.out.println("Destroy method got executed");
	}
}
