import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	
	Connection con = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;
	String path = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/juneuser";
	String user = "root";
	String pass = "Tanuj@123";
	String sql = "select * from student where id = ? and pwd = ?";
	PrintWriter pw = null;
	
	public void init() {
		try {
			Class.forName(path);
			con = DriverManager.getConnection(url,user,pass);
			stmt = con.prepareStatement(sql);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) {
		try {
			
			String id = req.getParameter("uid");
			String pwd = req.getParameter("upwd");
			
			int uid = Integer.parseInt(id);
			int upwd = Integer.parseInt(pwd);
			
			stmt.setInt(1,uid);
			stmt.setInt(2,upwd);
			
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				res.sendRedirect("/GETPOST/dashboard.html");
			}
			else {
				res.sendRedirect("/GETPOST/invalid.html");
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
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
