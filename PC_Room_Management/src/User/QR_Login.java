package User;

import javax.swing.*;

import Btn_Design.RoundedButton;

import java.awt.*;

// 큐알 로그인
public class QR_Login extends JFrame{
	public static void input_btn(JButton btn, int x, int y, int xsize, int ysize) {
		// 버튼 생성 메소드
		btn.setContentAreaFilled(false);
		btn.setBorderPainted(false); // 버튼 테두리 설정해제
		btn.setFocusPainted(false);
		btn.setBounds(x, y, xsize+2, ysize+2); // 버튼 위치, 사이즈
	}
	
	public QR_Login()
	{
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
		
		RoundedButton ok_btn = new RoundedButton("확인"); // 확인 버튼
		input_btn(ok_btn, 620, 650, 120, 30);
		add(ok_btn); // 프레임에 버튼을 붙임
		
		RoundedButton cancle_btn = new RoundedButton("취소"); // 취소 버튼
		input_btn(cancle_btn, 770, 650, 120, 30);
		add(cancle_btn); // 프레임에 버튼을 붙임
		
		JLabel QR_image = new JLabel(new ImageIcon("./image/QR.jpg"));
		QR_image.setBounds(500,100,500,500);
		
		add(QR_image);
		
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
		new QR_Login();
	}

}
