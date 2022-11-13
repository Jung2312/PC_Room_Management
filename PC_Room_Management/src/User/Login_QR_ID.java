package User;

import java.awt.Color;	
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Btn_Design.RoundedButton;
import Chat.InquiryPage;
import Main.MainLogin;
import Manager.*;

// qr, 일반 로그인 선택
@SuppressWarnings("unused")
public class Login_QR_ID {
    public Login_QR_ID() {
        JButton Login = new JButton(new ImageIcon("image/id_login.png")); //ID 로그인 버튼
        JButton QR = new JButton(new ImageIcon("image/qr_login.png")); //QR 로그인 버튼
        JButton home = new JButton(new ImageIcon("image/home_btn.png")); //홈버튼
        RoundedButton inquiry = new RoundedButton("문의"); //문의 버튼
        JButton setting = new JButton(new ImageIcon("image/setting_icon.png")); //설정 버튼
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
		
		panel.setBackground(Color.WHITE); // 바탕화면 색 흰색으로 설정
        Login.setSize(331, 330);
        Login.setLocation(380, 260);
        Login.setBorderPainted(false);
        Login.setFocusPainted(false);
        Login.setContentAreaFilled(false);
        frame.add(Login);

        QR.setSize(331, 330);
        QR.setLocation(800, 260);
        QR.setBorderPainted(false);
        QR.setFocusPainted(false);
        QR.setContentAreaFilled(false);
        frame.add(QR);

        home.setSize(40, 40); //홈 버튼 크기
        home.setLocation(20, 20); //홈 버튼 위치
        home.setBorderPainted(false); //홈 버튼 태두리 없앰
        home.setFocusPainted(false); //홈 버튼이 선택되었을 때 생기는 테두리 사용 안함
        home.setContentAreaFilled(false); //홈 버튼 출력
        frame.add(home);
        
        
        inquiry.setSize(80, 40); //문의 버튼 크기
		inquiry.setLocation(1350,20); // 문의 버튼 위치
		inquiry.setBorderPainted(false); //문의 버튼 테두리(외곽선) 없앰
		inquiry.setFocusPainted(false); //문의 버튼이 선택되었을 때 생기는 테두리 사용 안함
		inquiry.setContentAreaFilled(false); //문의 버튼 영역 채우지 않음
		frame.add(inquiry);


        setting.setSize(50, 50); //설정 버튼 크기
        setting.setLocation(1450, 20); //설정 버튼 위치
        setting.setBorderPainted(false); //설정 버튼 테두리(외곽선) 없앰
        setting.setFocusPainted(false); //설정 버튼이 선택되었을 때 생기는 테두리 사용 안함
        setting.setContentAreaFilled(false); //설정 버튼 영역 채우지 않음
        frame.add(setting);
        
		frame.add(panel);
		frame.setResizable(false); //창 크기 조절 불가
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setVisible(true); //창을 화면에 나타낼 것인지 설정
		frame.setSize(1530, 920); //창 크기 설정
		//frame.setPreferredSize(new Dimension(1920,1080)); //Dimension객체를 인자로 받으면서 해당 컴포넌트 기본크기를 결정
		frame.setLayout(null); // 배치관리자 해제(절대 위치 지정)
		frame.setLocationRelativeTo(null); //화면을 중간에 띄움
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //창닫기 버튼을 활성화 시켜 X를 누르면 프로그램 종료
		
		//이벤트 처리 추가
		home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MainLogin(); //홈 버튼을 누르면 첫 화면으로 이동
				frame.setVisible(false);
			}
		});
		
		setting.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Manager_menu(); //홈 버튼을 누르면 첫 화면으로 이동
				frame.setVisible(false);
			}
		});

		inquiry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new InquiryPage(); //문의 버튼을 누르면 문의 페이지로 이동
				frame.setVisible(false);
			}
		});
		
		Login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Loginpage(); //ID로그인을 누르면 ID로그인 페이지로 이동
				frame.setVisible(false);
			}
		});	
		
		QR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new QR_Login(); //QR로그인을 누를시 QR로그인 페이지로 이동
				frame.setVisible(false);
			}
		});	
			
    }

    public static void main(String[] args) {
		new Login_QR_ID();

	}
}


