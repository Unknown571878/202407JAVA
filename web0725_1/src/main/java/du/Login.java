package du;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf8");
		PrintWriter out = response.getWriter();
		
		
		String iname = request.getParameter("name");
		String issn = request.getParameter("ssn");
		
		String URL = "jdbc:mysql://localhost:3307/spring5fs";
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "select * from account where name = ? and ssn = ?";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(URL, "root", "mysql");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, iname);
			pstmt.setString(2, issn);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()){
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String ssn = rs.getString("ssn");
				String tel = rs.getString("tel");
				int balance = rs.getInt("balance");
				String str = String.format("%d, %s, %s, %s, %d\n", id, name, ssn, tel, balance);
				out.println("로그인 성공");
				out.println(str);
				LoginSession.id = id;
				LoginSession.name = name;
				LoginSession.ssn = ssn;
				LoginSession.tel = tel;
				LoginSession.balance = balance;
				
			} else {
				out.print("로그인 실패");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
