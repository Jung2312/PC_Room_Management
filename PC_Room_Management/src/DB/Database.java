package DB;

import java.sql.*;
import java.time.LocalDate;

public class Database {
	Connection con = null;
	Statement stmt = null;
	  // 서버 이름
	// 이름, 비밀번호(커넥션 정보는 깃허브에 업로드 하지 말 것)
	 
	String url = "url.";	
	String user = "id.";
	String passwd = "pw.";		//본인이 설정한 root 계정의 비밀번호를 입력하면 된다.
	
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
			String checkingStr = "SELECT userPassword, loginCheck FROM user WHERE userID='" + id + "'";
			String loginupdate = "UPDATE user SET loginCheck = 1 WHERE userID = '" + id + "'";
			ResultSet result = stmt.executeQuery(checkingStr);
			PreparedStatement pstmt = con.prepareStatement(loginupdate); //로그인 체크 1로 업데이트
			
			int count = 0;
			while(result.next()) {
				if(pw.equals(result.getString("userPassword"))) {
					flag = true;
					pstmt.executeUpdate(loginupdate);
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
	public boolean joinCheck(String _i, String _p, String _n, String _e, String _c, String _b, String _h) {
		boolean flag = false;
		
		String id = _i;
		String pw = _p;
		String name = _n;
		String birth = _b;
		String phone = _h;
		String card = _c;
		String email = _e;
		
		try {
			String insertStr = "INSERT INTO user (userID, userPassword, userName, userBrith,"
					+ "userPhone, cardNum, userEmail) VALUES (?, ?, ?, ?, ?, ?, ?)";
			
			PreparedStatement pstmt = con.prepareStatement(insertStr);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			pstmt.setString(3, name);
			pstmt.setString(4, birth);
			pstmt.setString(5, phone);
			pstmt.setString(6, card);
			pstmt.setString(7, email);
			pstmt.executeUpdate();
				
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
		String sql = "SELECT userID from user where userID = ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
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
	
	// 시트 테이블에 아이디 존재 여부 판단
	public boolean seatIDcheck()
	{
		String str = "SELECT seatID, seatRent from seat WHERE seatID IS not null AND seatRent = 0";
		
		try {
			PreparedStatement pstmt = con.prepareStatement(str);
			ResultSet rs = pstmt.executeQuery();
			
			
			while(rs.next()) {
				if (rs.getString("seatID") == null) 
				{
					return false;
					
				}
				else
				{
					return true;
				}
			}	
		 	} catch (SQLException e) {
		 		e.printStackTrace();
		 	} 	
		
		return false;
		
	}
	
	// 예약 시간, 종료 시간 추가
	public boolean timeselect(String start, String end, int won, String now)
	{
		boolean flag = false;
		
		String sql = "UPDATE seat SET seatStart = ?, seatEnd = ? ,seatRent = ? WHERE seatID !='null' AND seatRent = 0";
		
		PreparedStatement ps = null;
		// 쿼리를 넣어주는 부분
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, start);
			ps.setString(2, end);
			ps.setInt(3, 1);
			
			ps.executeUpdate(); 
			
			flag = true;
			
		} catch (SQLException e) {
			e.printStackTrace();
			flag = false;
			System.out.println("실패 > " + e.toString());
		}
			
		return flag;
	}
	
	
	// 회원의 누적 금액을 추가
	public void user_price(int won)
	{
		String sql = "UPDATE user SET userAccumuate = userAccumuate + ? WHERE loginCheck = 1";
		
		PreparedStatement ps = null;
		
		try {
			
			ps = con.prepareStatement(sql);
			ps.setInt(1, won);
			ps.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("실패 > " + e.toString());
		}
		
	}
	
	public void manager_price(String name, String sn, int won)
	{
		String sql = "insert into manager(salesNAme, day, sales) values(?,?,?)";
		
		PreparedStatement ps = null;
		
		try {
			
			ps = con.prepareStatement(sql);
			ps.setString(1,name);
			ps.setString(2,sn);
			ps.setInt(3, won);
			
			ps.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("실패 > " + e.toString());
		}
		
	}
	
	// 홈버튼 누르면 로그아웃
	public boolean logout()
	{
		boolean flag = false;
		
		String sql = "UPDATE user SET loginCheck = ? WHERE loginCheck = 1";
		PreparedStatement ps = null;
		
		// 쿼리를 넣어주는 부분
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, 0);
			ps.executeUpdate(); 
			
			flag = true;
			
		} catch (SQLException e) {
			e.printStackTrace();
			flag = false;
			System.out.println("실패 > " + e.toString());
		}
			
		return flag;
	}
	
	// 홈버튼 누르면 좌석 데이터 삭제
		public boolean seatlogout()
		{
			boolean flag = false;
			
			String sql = "UPDATE seat SET seatID = ? WHERE seatID !='null' AND seatRent = 0";
			PreparedStatement ps = null;
			
			// 쿼리를 넣어주는 부분
			try {
				ps = con.prepareStatement(sql);
				ps.setString(1, null);
				ps.executeUpdate(); 
				
				flag = true;
				
			} catch (SQLException e) {
				e.printStackTrace();
				flag = false;
				System.out.println("실패 > " + e.toString());
			}
			
			return flag;
		}

	
	// 회원 등급 지정
	public String user_grade()
	{
		String sql =  "SELECT userAccumuate from user WHERE loginCheck = 1";
		int userAccumuate = 0;
		String grade = null;
		
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				userAccumuate = rs.getInt("userAccumuate");
				}	
			
			if(userAccumuate >= 5000 && userAccumuate < 10000)
			{
				grade = "WHITE";
			}
			else if(userAccumuate >= 10000 && userAccumuate < 15000)
			{
				grade = "SILVER";
			}
		
			else if(userAccumuate >= 15000 && userAccumuate < 50000)
			{
				grade = "GOLD";
			}
			
			else if(userAccumuate >= 50000)
			{
				grade = "VIP";
			}
			
			else
			{
				grade = "일반";
			}
			
		 	} catch (SQLException e) {
		 		e.printStackTrace();
		 	}
		
		return grade;
	}
	
	// 회원 삭제
	public int userdel(String roleId)
	{
		int deleteCount = 0;
		
		
		try {
			String sql = "delete from user where userId = ?";			
			PreparedStatement ps = con.prepareStatement(sql);			
			ps.setString(1, roleId);			
			deleteCount = ps.executeUpdate();	
			
		} catch(Exception e) {
			System.out.println("실패 > " + e.toString());
		}
			
		return deleteCount;
	}
	
	// 디비 클로즈
		public void dbclose()
		{
		
			try {
				con.close();
				stmt.close();
				
			} catch(Exception e) {
				System.out.println("실패 > " + e.toString());
			}
				
		}

}
