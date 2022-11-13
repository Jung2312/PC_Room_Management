package UserDAO;

import java.sql.*;

public class Database {
	Connection con = null;
	Statement stmt = null;

	String url = "jdbc:mysql://www.jftt.kr:49176/PC";	
	String user = "root";
	String passwd = "jeong_oo";		//본인이 설정한 root 계정의 비밀번호를 입력하면 된다.
	
	public Database() {	//데이터베이스에 연결한다.
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, passwd);
			stmt = con.createStatement();
			System.out.println("MySQL 서버 연동 성공");
		} catch(Exception e) {
			System.out.println("MySQL 서버 연동 실패 > " + e.toString());
		}
	}

	/* 로그인 정보를 확인 */
	public boolean logincheck(String _i, String _p) {
		boolean flag = false;
		
		String id = _i;
		String pw = _p;
		
		try {
			String checkingStr = "SELECT userPassword FROM user WHERE userID='" + id + "'";
			ResultSet result = stmt.executeQuery(checkingStr);
			
			int count = 0;
			while(result.next()) {
				if(pw.equals(result.getString("userPassword"))) {
					flag = true;
					System.out.println("로그인 성공");
				}
				
				else {
					flag = false;
					System.out.println("로그인 실패");
				}
				count++;
			}
		} catch(Exception e) {
			flag = false;
			System.out.println("로그인 실패 > " + e.toString());
		}
		
		return flag;
	}
	
	/* 회원가입 메소드 */
	public boolean joinCheck(String _i, String _p, String _n, String _a, String _e, String _c, String _b, String _h) {
		boolean flag = false;
		
		String id = _i;
		String pw = _p;
		String name = _n;
		String birth = _b;
		String phone = _h;
		String card = _c;
		String email = _e;
		String age = _a;
		//String Accumuate = _t;
		//String loginCheck = _l;
		
		try {
			String insertStr = "INSERT INTO user VALUES('" + id + "', '" + pw + "', '" + name + "', '" + age + "','" + email + "', '" 
					+ card + "', '" + birth + "', '" + phone + "', '" + "0" + "', '" + "0" + "')";
			stmt.executeUpdate(insertStr);
				
			flag = true;
			System.out.println("회원가입 성공");
		} catch(Exception e) {
			flag = false;
			System.out.println("회원가입 실패 > " + e.toString());
		}
			
		return flag;
	}
	
	/* 아이디 중복 메소드 */
	public boolean findExistID(String id)
	 {
		String sql = "SELECT userID from user";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				if (rs.getString("userID").equals(id)) {
						return true;
					}
				}	
		 	} catch (SQLException e) {
		 		e.printStackTrace();
		 	} 	 	
		return false;
	 } //find 

}
