package Manager;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Btn_Design.RoundedButton;
import Btn_Design.RoundedButton4;
import Main.MainLogin;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// 회원 관리
public class User_Management extends JFrame {
	public static void input_btn(JButton btn, int x, int y, int xsize, int ysize) {
		// 버튼 생성 메소드
		btn.setContentAreaFilled(false);
		btn.setBorderPainted(false); // 버튼 테두리 설정해제
		btn.setFocusPainted(false);
		btn.setBounds(x, y, xsize+2, ysize+2); // 버튼 위치, 사이즈
	}
	
	public User_Management() {
		String[] colName = { "회원 ID", "회원명", "생년월일", "전화번호", "이메일" }; //회원 정보를 나타낼 열 값
		String[][] Info = {
				{"A0001", "홍길동", "000101", "010-1111-1111", "hong1@gmail.com"},
				{"A0002", "아무개", "000102", "010-2222-2222", "mu2@gmail.com"}, //회원 정보
				{"A0003", "김이박", "000103", "010-3333-3333", "kim3@gmail.com"}
		};
		
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
		
		RoundedButton ok_btn = new RoundedButton("삭제"); // 삭제 버튼
		input_btn(ok_btn, 620, 700, 120, 30);
		add(ok_btn); // 프레임에 버튼을 붙임
		
		RoundedButton cancle_btn = new RoundedButton("뒤로"); // 뒤로가기 버튼
		input_btn(cancle_btn, 770, 700, 120, 30);
		add(cancle_btn); // 프레임에 버튼을 붙임
		
		// 뒤로 가기 버튼 이벤트
		cancle_btn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				if(e.getSource() == cancle_btn) {
					new Manager_menu();
					setVisible(false); // 프레임 비활성화
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
		
		//이벤트 처리 추가
		home_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MainLogin(); //홈버튼을 누르면 첫 화면으로 이동
			}
		});
		
		user_management.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new User_Management(); //회원관리 버튼을 누르면 회원관리 페이지로 이동
			}
		});
		
		sales_check.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Sales_Management(); //매출확인 버튼을 누르면 매출확인 페이지로 이동
			}
		});
		
		inquiry_check.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new inquiry_management(); //문의확인 버튼을 누르면 문의 확인 페이지로 이동
			}
		});
		
		setting_icon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new manager_login(); //설정 버튼을 누르면 관리자 로그인 페이지로 이동
			}
		});
	}

	public static void main(String[] args) {
		new User_Management();
	}
}
