import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/Greet")
public class Greet extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse res) {
		try {
			PrintWriter pw = res.getWriter();
			pw.println("<!DOCTYPE html>");
			pw.println("<html>");
			pw.println("<head><title>Greeting</title></head>");
			pw.println("<body>");
			pw.println("<h1>Hello Users<h1>");
			pw.println("</body>");
			pw.println("</html>");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
