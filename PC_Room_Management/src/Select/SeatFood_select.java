package Select;
import javax.swing.*;

import Btn_Design.RoundedButton;
import Chat.InquiryPage;
import Main.MainLogin;
import Manager.manager_login;
import User.QR_Login;
import DB.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.applet.*;

// 좌석 or 틈색 선택
public class SeatFood_select extends JFrame{
	public static void input_btn(JButton btn, int x, int y, int xsize, int ysize) {
		// 버튼 생성 메소드
		btn.setContentAreaFilled(false);
		btn.setBorderPainted(false); // 버튼 테두리 설정해제
		btn.setFocusPainted(false);
		btn.setBounds(x, y, xsize+2, ysize+2); // 버튼 위치, 사이즈
	}

	Database db = new Database();
	public SeatFood_select() {
		// 버튼
		JButton home_btn = new JButton(new ImageIcon("./image/home_btn.png")); //홈버튼 생성
		input_btn(home_btn, 20, 20, 40, 40);
		add(home_btn); // 프레임에 버튼을 붙임
		
		RoundedButton user_inquiry = new RoundedButton("문의"); // 문의 버튼(둥근 테두리 적용하는 클래스 사용)
		input_btn(user_inquiry, 1350 ,20, 80, 40);
		add(user_inquiry); // 프레임에 버튼을 붙임
		
		JButton setting_icon = new JButton(new ImageIcon("./image/setting_icon.png")); // 관리자 버튼
		input_btn(setting_icon, 1450, 20, 40, 40);
		add(setting_icon); // 프레임에 버튼을 붙임
		
		JButton seat_select = new JButton(new ImageIcon("./image/seat_select_btn.png")); // 좌석선택 버튼
		input_btn(seat_select, 380, 260,331, 330);
		add(seat_select); // 프레임에 버튼을 붙임
		
		JButton food_select = new JButton(new ImageIcon("./image/food_select_btn.png")); // 음식 선택 버튼
		input_btn(food_select,820, 260, 331, 330);
		add(food_select); // 프레임에 버튼을 붙임
		
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
				if(db.logout())
				{
					db.seatlogout(); // 아이디 삭제
					JOptionPane.showMessageDialog(null, "로그아웃 되었습니다.");
				}
				new MainLogin(); //홈 버튼을 누르면 첫 화면으로 이동
				setVisible(false);
			}
		});

		user_inquiry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new InquiryPage(); //문의 버튼을 누르면 문의 페이지로 이동
				setVisible(false);
			}
		});
		
		setting_icon.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				new manager_login(); //설정 버튼을 누르면 관리자 로그인 페이지로 이동
				setVisible(false);
			}
			
		});
		
		seat_select.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Seat_select(); //좌석 선택 버튼을 누르면 좌석선택 페이지로 이동 
				setVisible(false);
			}
		});
		food_select.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Menu_select(); //음식 주문 버튼을 누르면 음식선택 페이지로 이동
				setVisible(false);
			}
		});
		
	}

	public static void main(String[] args) {
		new SeatFood_select();
	}

}
