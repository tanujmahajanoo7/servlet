import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//@WebServlet("/SecondServlet")
public class SecondServlet extends HttpServlet {
	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) {
		try {
			HttpSession hs = req.getSession();
			int m1 = (int) hs.getAttribute("m1");
			int m2 = (int) hs.getAttribute("m2");
			int m3 = (int) hs.getAttribute("m3");
			
			float per;
			per=((float)(m1+m2+m3)/300)*100;
			
			PrintWriter pw = res.getWriter();
			
			pw.println("</br>");
			pw.println("Percentage is: " + per);
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	

}
