package Main;
import Btn_Design.*;	

import java.awt.Color;
import java.awt.*;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import User.*;
import Chat.*;
import Manager.*;
import DB.*;

// 메인 화면 로그인
public class MainLogin {
	public MainLogin() {
		Database db = new Database();
		final JButton signin = new JButton(new ImageIcon("image/user_sign_in.png")); //회원가입 버튼 배경 이미지 설정
		JButton login = new JButton(new ImageIcon("image/user_login.png")); //로그인 버튼 배경 이미지 설정
		RoundedButton inquiry = new RoundedButton("문의"); //문의 버튼
		JButton setting = new JButton(new ImageIcon("image/setting_icon.png")); //설정 버튼 배경 이미지 설정
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		JPanel btnPanel = new JPanel();
		
		panel.setBackground(Color.WHITE); // 바탕화면 색 흰색으로 설정
		
		btnPanel.add(inquiry); //문의 버튼
		btnPanel.add(setting); //설정 버튼
		btnPanel.add(signin); //회원가입 버튼
		btnPanel.add(login); //로그인 버튼
		
		inquiry.setSize(80, 40); //문의 버튼 크기
		inquiry.setLocation(1350,20); // 문의 버튼 위치
		frame.add(inquiry); //문의 버튼 생성

		setting.setSize(50, 50); //설정 버튼 크기
        setting.setLocation(1450, 20); //설정 버튼 위치
		frame.add(setting);
		
		signin.setSize(331, 330);
		signin.setLocation(380, 260);
		frame.add(signin);
		
		login.setSize(331, 330);
		login.setLocation(820, 260);
		frame.add(login);
		
		signin.setBorderPainted(false); // 회원가입 버튼 테두리(외곽선) 없앰
		signin.setFocusPainted(false); // 회원가입 버튼이 선택되었을 때 생기는 테두리 사용 안함
		signin.setContentAreaFilled(false); //회원가입 버튼 영역 채우지 않음

		login.setBorderPainted(false);
		login.setFocusPainted(false);
		login.setContentAreaFilled(false);
		
		inquiry.setBorderPainted(false);
		inquiry.setFocusPainted(false);
		inquiry.setContentAreaFilled(false);

		setting.setBorderPainted(false);
		setting.setFocusPainted(false);
		setting.setContentAreaFilled(false);
		
		//이벤트 처리 추가
		signin.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				new Signin_frame(); //회원가입 버튼을 누르면 회원가입 페이지로 이동
				frame.setVisible(false);
				
			}
		});
	
		login.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				new Login_QR_ID(); //로그인 버튼을 누르면 로그인 페이지로 이동
				frame.setVisible(false);
			}
		});
		
		inquiry.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				new InquiryPage(); //문의 버튼을 누르면 문의 페이지로 이동
				frame.setVisible(false);
			}
		});
		
		setting.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				new manager_login(); //설정 버튼을 누르면 관리자 로그인 페이지로 이동
				frame.setVisible(false);
			}
			
		});
		
		frame.add(panel);
		
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setSize(1530, 920);
		frame.setPreferredSize(new Dimension(1920,1080));
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new MainLogin();
	}
}

