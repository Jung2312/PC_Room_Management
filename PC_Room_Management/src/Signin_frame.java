import javax.swing.*;
import java.awt.*;

public class Signin_frame extends JFrame{
	public static void input_text(JLabel label, int x, int y, int size, int font_size) {
		// 레이블 생성 메소드
		label.setFont(new Font("맑은 고딕", Font.BOLD, font_size)); // 폰트
		label.setBounds(x, y, size, font_size+5); // 레이블 위치, 사이즈
		
	}
	
	public static void input_btn(JButton btn, int x, int y, int xsize, int ysize) {
		// 버튼 생성 메소드
		btn.setContentAreaFilled(false);
		btn.setBorderPainted(false); // 버튼 테두리 설정해제
		btn.setFocusPainted(false);
		btn.setBounds(x, y, xsize+2, ysize+2); // 버튼 위치, 사이즈
		
	}
	
	public Signin_frame(){
		
		JButton home_btn = new JButton(new ImageIcon("./image/home_btn.png")); //홈버튼 생성
		input_btn(home_btn, 20, 20, 40, 40);
		add(home_btn); // 프레임에 버튼을 붙임
		JButton home_btn2 = new JButton(new ImageIcon("./image/그룹.svg")); //홈버튼 생성
		input_btn(home_btn2, 20, 20, 100, 100);
		add(home_btn2); // 프레임에 버튼을 붙임
		JButton user_inquiry = new JButton(new ImageIcon("./image/user_inquiry.png"));
		input_btn(user_inquiry, 1370,20, 80, 40);
		add(user_inquiry); // 프레임에 버튼을 붙임
		
		JButton setting_icon = new JButton(new ImageIcon("./image/setting_icon.png"));
		input_btn(setting_icon, 1470, 20, 40, 40);
		add(setting_icon); // 프레임에 버튼을 붙임
		
		
		JLabel sign_label = new JLabel("회원 가입");
		input_text(sign_label,700, 160, 150,30);
		add(sign_label);
		
		JLabel name_label = new JLabel("이름");
		input_text(name_label,540, 302, 100, 20);
		add(name_label);
		
		JLabel ID_label = new JLabel("아이디");
		input_text(ID_label,540, 362, 100, 20);
		add(ID_label);
		
		JLabel PW_label = new JLabel("비밀번호");
		input_text(PW_label,540, 422, 100, 20);
		add(PW_label);
		
		JLabel birth_label = new JLabel("생년월일");
		input_text(birth_label,540, 482, 100, 20);
		add(birth_label);
		
		JLabel phone_label = new JLabel("휴대전화");
		input_text(phone_label,540, 542, 100, 20);
		add(phone_label);
		
		JLabel card_label = new JLabel("카드번호");
		input_text(card_label,540, 602, 100, 20);
		add(card_label);
		
		setLayout(null); // 배치관리자 해제(절대 위치 지정)
		setSize(1920,1080); // 창 사이즈
		setResizable(false);
		setVisible(true); // 프레임 활성화
		setLocationRelativeTo(null); //창 모니터 가운데 정렬
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x를 누를 경우 종료
		getContentPane().setBackground(Color.WHITE); // 프레임 bg color
		
	}
	/*
	public static void main(String[] args) {
		new Signin_frame();

	}*/

}
