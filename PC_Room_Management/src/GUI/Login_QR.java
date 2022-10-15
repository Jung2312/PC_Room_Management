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
public class Login_QR {
    public Login_QR() {
        JButton Login = new JButton(new ImageIcon("image/id_login.png")); //ID 로그인 버튼
        JButton QR = new JButton(new ImageIcon("image/qr_login.png")); //QR 로그인 버튼
        JButton home = new JButton(new ImageIcon("image/home_btn.png")); //홈버튼
        JButton inquiry = new JButton(new ImageIcon("image/user_inquiry.png")); //문의 버튼
        JButton setting = new JButton(new ImageIcon("image/setting_icon.png")); //설정 버튼
        JFrame frame = new JFrame();
        JPanel btnPanel = new JPanel();

  /*      btnPanel.add(Login);
        btnPanel.add(QR);
        btnPanel.add(inquiry); //문의 버튼
        btnPanel.add(setting); //설정 버튼
        btnPanel.add(home); // 홈 버튼
*/
        inquiry.setSize(100, 60); //문의 버튼 크기
        inquiry.setLocation(1380, 3); // 문의 버튼 위치
        frame.add(inquiry); //문의 버튼 생성

        Login.setSize(331, 330);
        Login.setLocation(380, 260);
        Login.setBorderPainted(false);
        Login.setFocusPainted(false);
        Login.setContentAreaFilled(false);
        frame.add(Login);

        QR.setSize(331, 330);
        QR.setLocation(380, 260);
        QR.setBorderPainted(false);
        QR.setFocusPainted(false);
        QR.setContentAreaFilled(false);
        frame.add(QR);

        home.setSize(40, 40);
        home.setLocation(14, 3);
        home.setBorderPainted(false);
        home.setFocusPainted(false);
        home.setContentAreaFilled(false);
        frame.add(home);

        inquiry.setSize(80, 40); //문의 버튼 크기
        inquiry.setLocation(1380, 3); // 문의 버튼 위치
        inquiry.setBorderPainted(false); //문의 버튼 테두리(외곽선) 없앰
        inquiry.setFocusPainted(false); //문의 버튼이 선택되었을 때 생기는 테두리 사용 안함
        inquiry.setContentAreaFilled(false); //문의 버튼 영역 채우지 않음
        frame.add(inquiry); //문의 버튼 출력


        setting.setSize(40, 40); //설정 버튼 크기
        setting.setLocation(1470, 5); //설정 버튼 위치
        setting.setBorderPainted(false); //설정 버튼 테두리(외곽선) 없앰
        setting.setFocusPainted(false); //설정 버튼이 선택되었을 때 생기는 테두리 사용 안함
        setting.setContentAreaFilled(false); //설정 버튼 영역 채우지 않음
        frame.add(setting); //설정 버튼 출력

    }
/*
	public static void main(String[] args) {
		new Login_QR();
    }

*/
}

