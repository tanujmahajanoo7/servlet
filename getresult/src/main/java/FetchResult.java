
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FetchResult extends HttpServlet {
	Connection con = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;
	String path = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/junekod";
	String user = "root";
	String pass = "Tanuj@123";
	String sql = "select * from student where id = ?";
	PrintWriter pw = null;
	
	@Override
	public void init() throws ServletException {
		try {
			Class.forName(path);
			con = DriverManager.getConnection(url,user,pass);
			stmt = con.prepareStatement(sql);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) {
		try {
			String id = req.getParameter("id");
			int number = Integer.parseInt(id);
			stmt.setInt(1,number);
			pw = res.getWriter();
			rs = stmt.executeQuery();
			pw.println("<!DOCTYPE html>");
			pw.println("<html>");
			pw.println("<head><title>Your Result</title></head>");
			pw.println("<body>");
			pw.println("<h3 style='color:red'>Welcome user check your results</h3>");			
			pw.println("</br>");			
			pw.println("<table><tr><th>Id</th><th>Name</th><th>m1</th><th>m2</th><th>m3</th></tr>");
			if(rs.next()) {
				int id1=rs.getInt(1);
				String name=rs.getString(2);
				int m1=rs.getInt(3);
				int m2=rs.getInt(4);
				int m3=rs.getInt(5);
				pw.println("<tr><td>"+id1+"</td><td>"+name+"</td><td>"+m1+"</td><td>"+m2+"</td><td>"+m3+"</td></tr>");
			}
			else {
				res.sendRedirect("invalidid.html");
			}
			pw.println("</table>");
			pw.println("</body>");
			pw.println("</html>");
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public void destroy() {
		try {
			System.out.println("Done");
			con.close();
			stmt.close();
			rs.close();
			pw.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
