package Manager;
import javax.management.relation.Role;
import javax.swing.*;		
import java.sql.*;
import java.util.*;
import java.util.List;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import Btn_Design.RoundedButton;
import Btn_Design.RoundedButton4;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import Main.MainLogin;
import DB.*;

// 회원 관리
public class User_Management extends JFrame {
	String db_id = null;
	int row;
	Connection conn = null;
	Statement stmt = null;
	Database db = new Database();
	DefaultTableModel tableModel= null;
	public static void input_btn(JButton btn, int x, int y, int xsize, int ysize) {
		// 버튼 생성 메소드
		btn.setContentAreaFilled(false);
		btn.setBorderPainted(false); // 버튼 테두리 설정해제
		btn.setFocusPainted(false);
		btn.setBounds(x, y, xsize+2, ysize+2); // 버튼 위치, 사이즈
	}
	
	public String Phonecheck(String num)
	{
		String pnum = num.substring(0,3)+"-"+num.substring(3,7)+"-"+num.substring(7,11);
		return pnum;
		
	}
	
	public User_Management() {
		String[] colName = { "회원 ID", "회원명", "생년월일", "전화번호", "이메일" }; //회원 정보를 나타낼 열 값
		tableModel = new DefaultTableModel(colName, 0);
		
		try
		{
			Connection conn = DriverManager.getConnection(
					"#"  // 서버 이름
					 ,"#","#" // 이름, 비밀번호(커넥션 정보는 깃허브에 업로드 하지 말 것)
					 );
			Statement stmt = null;
			ResultSet rs = null;
			
			stmt = conn.createStatement(); //쿼리 준비 단계
	        String selectSql = "SELECT userID, userName, userBrith, userPhone, userEmail FROM user"; //전송할 쿼리문
	        stmt.executeQuery(selectSql); //쿼리문 전송
	        
			rs = stmt.executeQuery(selectSql);
			while (rs.next()) {
			    // create a single array of one row's worth of data
			    String[] data = { rs.getString("userID"), rs.getString("userName"), rs.getString("userBrith"),
			    		Phonecheck(rs.getString("userPhone")) ,rs.getString("userEmail")} ;
			    
			    Phonecheck(rs.getString("userPhone"));
			    // and add this row of data into the table model
			    tableModel.addRow(data);
			    tableModel.fireTableDataChanged();
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		//테이블에 scroll 구현
		JTable userinfo = new JTable(tableModel); //테이블에 정보, 회원 정보를 나타낼 열 이름 넘겨줌
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
		
		RoundedButton del_btn = new RoundedButton("삭제"); // 삭제 버튼
		input_btn(del_btn, 620, 700, 120, 30);
		add(del_btn); // 프레임에 버튼을 붙임
		
		RoundedButton cancle_btn = new RoundedButton("뒤로"); // 뒤로가기 버튼
		input_btn(cancle_btn, 770, 700, 120, 30);
		add(cancle_btn); // 프레임에 버튼을 붙임
		
		//이벤트 처리 추가
		
		userinfo.addMouseListener(new MouseAdapter() {

//			마우스 클릭시 처리를 담당하는 메소드 재정의
			@Override
			public void mouseClicked(MouseEvent e) {
				row = userinfo.getSelectedRow();
				int col = userinfo.getSelectedColumn();
				db_id = (String) userinfo.getModel().getValueAt(row, 0 ); 
				System.out.println(db_id);
			}

		});
		
		home_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(db.logout())
				{
					db.seatlogout(); // 아이디 삭제
					JOptionPane.showMessageDialog(null, "로그아웃 되었습니다.");
				}
				try {
					conn.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				db.dbclose();
				new MainLogin(); //홈버튼을 누르면 첫 화면으로 이동
				setVisible(false);
			}
		});
		
		user_management.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					conn.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				db.dbclose();
				new User_Management(); //회원관리 버튼을 누르면 회원관리 페이지로 이동
				setVisible(false);
			}
		});
		
		sales_check.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					conn.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				db.dbclose();
				new Sales_Management(); //매출확인 버튼을 누르면 매출확인 페이지로 이동
				setVisible(false);
			}
		});
		
		inquiry_check.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					conn.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				db.dbclose();
				new inquiry_management(); //문의확인 버튼을 누르면 문의 확인 페이지로 이동
				setVisible(false);
			}
		});
		
		setting_icon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					conn.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				db.dbclose();
				new manager_login(); //설정 버튼을 누르면 관리자 로그인 페이지로 이동
				setVisible(false);
			}
		});
		
		del_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int reply = JOptionPane.showConfirmDialog(null, "ID : " + db_id + "회원을 삭제 하시겠습니까?", "회원 삭제", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
				if (reply == JOptionPane.YES_OPTION)
				{
					int deleteCount = db.userdel(db_id);
					//List<Role> list = db.getRoles();
					System.out.println(deleteCount);
					tableModel.removeRow(row); 
				}
				
				else
				{
					JOptionPane.showMessageDialog(null, "삭제를 취소했습니다.", "회원 삭제 취소", JOptionPane.INFORMATION_MESSAGE);
				}
					
			}
		});
		
		
				
		//화면 설정
		//setUndecorated(true); //엑스창 없앰
		setLayout(null); // 배치관리자 해제(절대 위치 지정)
		setSize(1530, 920); // 창 사이즈
		setResizable(false);
		setVisible(true); // 프레임 활성화
		setLocationRelativeTo(null); //창 모니터 가운데 정렬
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x를 누를 경우 종료
		getContentPane().setBackground(Color.WHITE); // 프레임 bg color
	}

	public static void main(String[] args) {
		new User_Management();
	}
}
