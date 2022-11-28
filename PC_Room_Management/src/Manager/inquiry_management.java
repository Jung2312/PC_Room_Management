package Manager;

import java.awt.*;		
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Btn_Design.RoundedButton;
import Btn_Design.RoundedButton4;
import Chat.InquiryPage;
import Main.*;
import DB.*;

// 문의 내역
public class inquiry_management extends JFrame{
	Connection conn = null;
	Database db = new Database();
	
	private static final long serialVersionUID = 1L;
	public static void input_btn(JButton btn, int x, int y, int xsize, int ysize) {
		// 버튼 생성 메소드
		btn.setContentAreaFilled(false);
		btn.setBorderPainted(false); // 버튼 테두리 설정해제
		btn.setFocusPainted(false);
		btn.setBounds(x, y, xsize+2, ysize+2); // 버튼 위치, 사이즈
	}
	
	public inquiry_management() {
		try { 
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 System.out.println("드라이버 검색 성공");
		 }catch(ClassNotFoundException e) {
			 System.err.println("드라이버 검색 실패");
			 System.exit(0);
		 }
		 try {
			 conn = DriverManager.getConnection(
					 "url"  // 서버 이름
					 ,"root","pw" // 이름, 비밀번호(커넥션 정보는 깃허브에 업로드 하지 말 것)
					 );
			 System.out.println("데이터베이스 연결 성공");
		 }catch (SQLException e) {
			 System.out.println(e);
			 System.err.println("데이터베이스 연결 실패");
			 System.exit(0);
		 }
		String[] colName = { "날짜", "문의", "상세내용"}; //회원 정보를 나타낼 열 값
		int num = db_amount();
		String[][] Info = new String[num][3];
		inquiry_check(Info);
		
		@SuppressWarnings("serial")
		DefaultTableModel user = new DefaultTableModel(Info, colName)
		{
			 public boolean isCellEditable(int i, int c) {
	                return false; // 셀 내용 수정 불가
			 }
		}; //user와 데이터 연결
		
		
		//테이블에 scroll 구현
		JTable userinfo = new JTable(user); //테이블에 정보, 회원 정보를 나타낼 열 이름 넘겨줌
		JScrollPane scroll = new JScrollPane(userinfo); //스크롤테이블에 정보 넘겨줌
		
		userinfo.setRowHeight(30); //행 너비 조절
		userinfo.getTableHeader().setReorderingAllowed(false); //이동불가
		userinfo.getTableHeader().setResizingAllowed(false); //크기 조절 불가
		userinfo.getTableHeader().setBackground(Color.white); // 회원 정보 나타낼 행 배경 색 변경
		userinfo.getTableHeader().setFont(new Font("맑은 고딕", Font.BOLD, 20)); //회원정보 나타낼 행 글씨체, 굵기, 크기 변경
		userinfo.setFont(new Font("맑은 고딕", Font.BOLD, 15)); //회원정보 나타낼 행 글씨체, 굵기, 크기 변경
		userinfo.getParent().setBackground(Color.white); //테이블 배경 색 변경
		scroll.setBounds(75, 130, 1390, 500); //테이블 위치, 크기 설정
		add(scroll); //프레임에 테이블 추가
		
		
		JButton home_btn = new JButton(new ImageIcon("./image/home_btn.png")); //홈버튼 생성
		input_btn(home_btn, 20, 20, 40, 40);
		add(home_btn); // 프레임에 버튼을 붙임
		
		RoundedButton4 user_management = new RoundedButton4("회원 관리"); // 회원 관리 버튼(둥근 테두리 적용하는 클래스 사용)
		input_btn(user_management, 1110 ,20, 90, 40);
		add(user_management); // 프레임에 버튼을 붙임
		
		RoundedButton4 sales_check = new RoundedButton4("매출 확인"); // 매출 확인 버튼(둥근 테두리 적용하는 클래스 사용)
		input_btn(sales_check, 1230 ,20, 90, 40);
		add(sales_check); // 프레임에 버튼을 붙임
		
		RoundedButton4 inquiry_check = new RoundedButton4("문의 확인"); // 문의 확인 버튼(둥근 테두리 적용하는 클래스 사용)
		input_btn(inquiry_check, 1350 ,20, 90, 40);
		add(inquiry_check); // 프레임에 버튼을 붙임
		
		JButton setting_icon = new JButton(new ImageIcon("./image/setting_icon.png")); // 설정 버튼
		input_btn(setting_icon, 1460, 20, 40, 40);
		add(setting_icon); // 프레임에 버튼을 붙임
		
		RoundedButton ok_btn = new RoundedButton("확인"); // 삭제 버튼
		input_btn(ok_btn, 720, 700, 120, 30);
		add(ok_btn); // 프레임에 버튼을 붙임
		
		//이벤트 처리 추가
		home_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					 if(conn != null) {
						 conn.close();
						 System.out.println("닫기 성공");
					 }
				 }catch (SQLException e1) {
					 e1.printStackTrace();
				 }
				if(db.logout())
				{
					db.seatlogout(); // 아이디 삭제
					JOptionPane.showMessageDialog(null, "로그아웃 되었습니다.");
				}
				new MainLogin(); //홈버튼을 누르면 첫 화면으로 이동
				setVisible(false);
			}
		});
		
		user_management.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new User_Management(); //회원관리 버튼을 누르면 회원관리 페이지로 이동
				setVisible(false);
				try {
					 if(conn != null) {
						 conn.close();
						 System.out.println("닫기 성공");
					 }
				 }catch (SQLException e1) {
					 e1.printStackTrace();
				 }
			}
		});
		
		sales_check.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Sales_Management(); //매출확인 버튼을 누르면 매출확인 페이지로 이동
				setVisible(false);
				try {
					 if(conn != null) {
						 conn.close();
						 System.out.println("닫기 성공");
					 }
				 }catch (SQLException e1) {
					 e1.printStackTrace();
				 }
			}
		});
		
		inquiry_check.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new inquiry_management(); //문의확인 버튼을 누르면 문의 확인 페이지로 이동
				setVisible(false);
			}
		});
		
		setting_icon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new manager_login(); //설정 버튼을 누르면 관리자 로그인 페이지로 이동
				setVisible(false);
			}
		});
		
		ok_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Manager_menu(); //확인 버튼을 누르면 매니저 메뉴 페이지로 이동
				setVisible(false);
				try {
					 if(conn != null) {
						 conn.close();
						 System.out.println("닫기 성공");
					 }
				 }catch (SQLException e1) {
					 e1.printStackTrace();
				 }
			}
		});
				
		//화면 설정
		//setUndecorated(true); //엑스창 없앰
		setLayout(null); // 배치관리자 해제(절대 위치 지정)
		setSize(1530,920); // 창 사이즈
		setResizable(false);
		setVisible(true); // 프레임 활성화
		setLocationRelativeTo(null); //창 모니터 가운데 정렬
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x를 누를 경우 종료
		getContentPane().setBackground(Color.WHITE); // 프레임 bg color
	}
	public int db_amount() {
		String sql = "select count(*) from manager where inquiry is not null;";
		PreparedStatement pstmt = null;
		int count = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				count = rs.getInt(1);
			}
		} catch (Exception e) {
            System.out.println("select 메서드 예외발생");
        }
		return count;
	}
	
	public void inquiry_check(String [][] a) {
		String sql = "select day, inquiry, detailedInquiry from manager where inquiry is not null;";
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            List<String[]> jobList = new ArrayList<String[]>();
            while (rs.next()) {
              String[] arrStr = {rs.getString("day"),rs.getString("inquiry"),rs.getString("detailedInquiry")};
              jobList.add(arrStr);
            }
            for (int i = 0; i < jobList.size(); i++) {
            		a[i][0] = jobList.get(i)[0];
            		a[i][1] = jobList.get(i)[1];
            		a[i][2] = jobList.get(i)[2];
            	}
  
        } catch (Exception e) {
            System.out.println("select 메서드 예외발생");
        }
	}
	public static void main(String args[]) {
		new inquiry_management();
	}
}