import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// mysql 연결 확인
public class MySQL_connection {

	public static void main(String[] args) {
		 try { 
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 System.out.println("드라이버 검색 성공");
		 }catch(ClassNotFoundException e) {
			 System.err.println("드라이버 검색 실패");
			 System.exit(0);
		 }
		 
		 Connection conn = null;
		 try {
			 conn = DriverManager.getConnection(
					 "jdbc:mysql://localhost:3306/sys"
					 ,"root","2312"
					 );
			 System.out.println("데이터베이스 연결 성공");
		 }catch (SQLException e) {
			 System.out.println(e);
			 System.err.println("데이터베이스 연결 실패");
			 System.exit(0);
		 }
		 try {
			 if(conn != null) {
				 conn.close();
			 }
		 }catch (SQLException e) {
			 e.printStackTrace();
		 }
	}

}