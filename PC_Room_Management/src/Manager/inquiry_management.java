package Manager;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Btn_Design.RoundedButton;
import Btn_Design.RoundedButton4;

// 문의 내역
public class inquiry_management extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void input_btn(JButton btn, int x, int y, int xsize, int ysize) {
		// 버튼 생성 메소드
		btn.setContentAreaFilled(false);
		btn.setBorderPainted(false); // 버튼 테두리 설정해제
		btn.setFocusPainted(false);
		btn.setBounds(x, y, xsize+2, ysize+2); // 버튼 위치, 사이즈
	}
	
	public inquiry_management() {
		String[] colName = { "날짜", "문의", "상세내용"}; //회원 정보를 나타낼 열 값
		String[][] Info = {
				{"2022-10-23", "로그인 문의", "카드 결제 오류"},
				{"2022-10-23", "회원가입 문의", "결제 취소"},
		};
		
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
	
	public static void main(String[] args) {
		new inquiry_management();

	}

}