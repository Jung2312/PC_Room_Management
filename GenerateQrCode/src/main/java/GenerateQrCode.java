import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class dbconnection {
	public static void main(String[] args) {
		DBConnection dbConn = new DBConnection();

		
		dbConn.connect();
		dbConn.insert("INSERT INTO member_register SET User_Phone = '01012345678';");

		dbConn.close();
		
	}
}

class DBConnection {
	Connection connection;

	public void connect() {
		String url = "jdbc:mysql://localhost:3306/member_register?useUnicode=true&characterEncoding=UTF-8";
		String user = "root";
		String password = "ejqmftnld1!";
		String driverName = "com.mysql.cj.jdbc.Driver";

		try {
			// ① 로드(카카오 택시에 `com.mysql.cj.jdbc.Driver` 라는 실제 택시 드라이버를 등록)
			// 하지만 개발자는 실제로 `com.mysql.cj.jdbc.Driver`를 다룰 일은 없다.
			// 내부적으로 JDBC가 알아서 다 해주기 때문에 우리는 JDBC의 DriverManager 를 통해서 DB와의 연결을 얻으면 된다.
			Class.forName(driverName);

			// ② 연결
			connection = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			// `com.mysql.cj.jdbc.Driver` 라는 클래스가 라이브러리로 추가되지 않았다면 오류발생
			System.out.println("[로드 오류]\n" + e.getStackTrace());
		} catch (SQLException e) {
			// DB접속정보가 틀렸다면 오류발생
			System.out.println("[연결 오류]\n" + e.getStackTrace());
		}
	}
	
	public int insert(String sql) {
		int id = -1;

		// SQL을 적는 문서파일
		Statement statement = null;
		// SQL의 실행결과 보고서
		ResultSet rs = null;

		try {
			statement = connection.createStatement();
			statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
			rs = statement.getGeneratedKeys();
			if (rs.next()) {
				id = rs.getInt(1);
			}
		} catch (SQLException e) {
			System.out.println("[INSERT 쿼리 오류]\n" + e.getStackTrace());
		}

		try {
			if (statement != null) {
				statement.close();
			}

			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			System.out.println("[INSERT 종료 오류]\n" + e.getStackTrace());
		}

		return id;
	}

	public void close() {
		try {
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			System.out.println("[닫기 오류]\n" + e.getStackTrace());
		}
	}
}