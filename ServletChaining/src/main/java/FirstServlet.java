import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.server.ServerCloneException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
	Connection con = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;
	String path = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/juneuser";
	String user = "root";
	String pass = "Tanuj@123";
	String sql = "select * from students where id = ?";
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
	
	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) {
		try {
			String id = req.getParameter("uid");
			int uid = Integer.parseInt(id);
			stmt.setInt(1,uid);
			rs = stmt.executeQuery();
			pw = res.getWriter();
			while(rs.next()) {
				int i = rs.getInt(1);
				String name = rs.getString(2);
				int m1 = rs.getInt(3);
				int m2 = rs.getInt(4);
				int m3 = rs.getInt(5);
				
				HttpSession hs = req.getSession(true);
				hs.setAttribute("id",i);
				hs.setAttribute("name",name);
				hs.setAttribute("m1",m1);
				hs.setAttribute("m2",m2);
				hs.setAttribute("m3",m3);
				
				pw.println(i + " " + name + " " + m1 + " " + m2 + " " + m3);
			}
			
//			1) servlet context()
//			2) get request dispatcher
//			3) forward the request

//			ServletContext sc = req.getServletContext();
//			RequestDispatcher rd = sc.getRequestDispatcher("/ServletChainning/SecondServlet");
//			rd.forward(req, res);
			
//			req.getServletContext().getRequestDispatcher("/SecondServlet").forward(req, res);

			req.getServletContext().getRequestDispatcher("/SecondServlet").include(req, res);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
