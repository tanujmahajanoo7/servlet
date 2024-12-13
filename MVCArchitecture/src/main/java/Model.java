import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Model {

	Connection con = null;
	PreparedStatement ps = null;
	PreparedStatement ps2 = null;
	ResultSet rs = null;
	String path = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/kodapp";
	String user = "root";
	String pass = "Tanuj@123";
	String sql = "select * from koduser where kodid = ? and password = ?";
	String sql2 = "insert into koduser values(?,?,?,?,?,?)";

//	PrintWriter pw = null;

	public Model() {
		try {
			Class.forName(path);
			con = DriverManager.getConnection(url,user,pass);
		} catch(Exception e) {
			e.printStackTrace();
		}

	}
	public boolean performLogin(String id, String pass) {
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, pass);
			rs = ps.executeQuery();
			if(rs.next()) {
				return true;
			}
		}  catch(Exception e) {
			e.printStackTrace();
			System.out.println("Error ho gaya");
		}
		return false;
	}
	
	public boolean performSignup(String id,String pass, String name, String email, String gender, int phoneno) {
		try {
			ps2 = con.prepareStatement(sql2);
			ps2.setString(1, id);
			ps2.setString(2, pass);
			ps2.setString(3, name);
			ps2.setString(4, email);
			ps2.setString(5, gender);
			ps2.setInt(6, phoneno);
			int nora= ps2.executeUpdate();
			if(nora==1) {
				return true;
			}
		}  catch(Exception e) {
			e.printStackTrace();
			System.out.println("Error");
		}
		return false;
	}
}
