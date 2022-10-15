package GUI;

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

@SuppressWarnings("unused")
public class Login_ID_QR {
    public Login_ID_QR() {
        JButton Login = new JButton(new ImageIcon("image/id_login.png")); //ID 로그인 버튼
        JButton QR = new JButton(new ImageIcon("image/qr_login.png")); //QR 로그인 버튼
        JButton home = new JButton(new ImageIcon("image/home_btn.png")); //홈버튼
        JButton inquiry = new JButton(new ImageIcon("image/user_inquiry.png")); //문의 버튼
        JButton setting = new JButton(new ImageIcon("image/setting_icon.png")); //설정 버튼
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        JPanel btnPanel = new JPanel();
        
        panel.setBackground(Color.WHITE);
    
        btnPanel.add(Login); //로그인 버튼
        btnPanel.add(QR); //QR 버튼
        btnPanel.add(inquiry); //문의 버튼
        btnPanel.add(setting); //설정 버튼
        btnPanel.add(home); // 홈 버튼
        
        inquiry.setSize(100, 60);
        inquiry.setLocation(1380,3);
        frame.add(inquiry);
        
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
        home.setLocation(20, 3); //홈 버튼 위치
        home.setBorderPainted(false); //홈 버튼 태두리 없앰
        home.setFocusPainted(false); //홈 버튼이 선택되었을 때 생기는 테두리 사용 안함
        home.setContentAreaFilled(false); //홈 버튼 출력
        frame.add(home);
        
        
        inquiry.setSize(100, 60); //문의 버튼 크기
		inquiry.setLocation(1380, 3); // 문의 버튼 위치
		inquiry.setBorderPainted(false); //문의 버튼 테두리(외곽선) 없앰
		inquiry.setFocusPainted(false); //문의 버튼이 선택되었을 때 생기는 테두리 사용 안함
		inquiry.setContentAreaFilled(false); //문의 버튼 영역 채우지 않음
		frame.add(inquiry);


        setting.setSize(50, 50); //설정 버튼 크기
        setting.setLocation(1470, 3); //설정 버튼 위치
        setting.setBorderPainted(false); //설정 버튼 테두리(외곽선) 없앰
        setting.setFocusPainted(false); //설정 버튼이 선택되었을 때 생기는 테두리 사용 안함
        setting.setContentAreaFilled(false); //설정 버튼 영역 채우지 않음
        frame.add(setting);
        
        frame.add(panel);
		
		frame.setResizable(false); //창 크기 조절 불가
		frame.setVisible(true); //창을 화면에 나타낼 것인지 설정
		frame.setSize(1920,1080); //창 크기 설정
		frame.setPreferredSize(new Dimension(1920,1080)); //Dimension객체를 인자로 받으면서 해당 컴포넌트 기본크기를 결정
		frame.setLocationRelativeTo(null); //화면을 중간에 띄움
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //창닫기 버튼을 활성화 시켜 X를 누르면 프로그램 종료
    }


	public static void main(String[] args) {
		new Login_ID_QR();
    }


}


