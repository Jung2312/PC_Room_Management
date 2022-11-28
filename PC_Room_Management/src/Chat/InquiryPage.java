package Chat;

import java.awt.*;		
import javax.swing.*;

import Main.MainLogin;
import Manager.manager_login;

import java.awt.event.*;
import java.time.LocalDate;

import Btn_Design.*;
import DB.Database;

public class InquiryPage extends JFrame {
	
	Database db = new Database();
	
	public static void input_btn(JButton btn, int x, int y, int xsize, int ysize) {
		// 버튼 생성 메소드
		btn.setContentAreaFilled(false);
		btn.setBorderPainted(false); // 버튼 테두리 설정해제
		btn.setFocusPainted(false);
		btn.setBounds(x, y, xsize+2, ysize+2); // 버튼 위치, 사이즈
	}
	
	public InquiryPage() {
		//Container c = getContentPane();
		//c.setLayout(new FlowLayout());
		
		JLabel inquiry = new JLabel(new ImageIcon("./image/inquiry_image.png")); //문의 아이콘 생성
		inquiry.setBounds(810, 380, 55, 35); //문의 아이콘 위치, 사이즈
		add(inquiry); //프레임에 버튼을 붙임
		
		JLabel in_label1 = new JLabel(); //안내 메세지
		JLabel in_label2 = new JLabel(); //안내 메세지
		in_label1.setFont(new Font("맑은 고딕", Font.BOLD, 24)); 
		in_label2.setFont(new Font("맑은 고딕", Font.BOLD, 24));
		in_label1.setBounds(810, 400, 600, 100);
		in_label2.setBounds(810, 430, 600, 100);
		add(in_label1); //안내 메세지 출력
		add(in_label2); //안내 메세지 출력
		
		//화면 상단 버튼
		JButton home_btn = new JButton(new ImageIcon("./image/home_btn.png")); //홈버튼 생성
		input_btn(home_btn, 20, 20, 40, 40);
		add(home_btn); // 프레임에 버튼을 붙임
		
		JButton inquiry_btn = new JButton(new ImageIcon("./image/user_inquiry.png")); //문의 버튼 생성
		input_btn(inquiry_btn, 1350, 15, 98, 58);
		add(inquiry_btn); // 프레임에 버튼 붙임
		
		JButton setting_icon = new JButton(new ImageIcon("./image/setting_icon.png")); // 설정 버튼
		input_btn(setting_icon, 1450, 20, 50, 50);
		add(setting_icon); // 프레임에 버튼을 붙임
		
		
		//상세 문의 버튼
		JButton[] btn = new JButton[4]; //디폴트 상세 선택 버튼
		
		String[] pm = new String[] { "1. 결제 불가", "2. 카드 인식 불가", "3. 좌석 인식 불가", "4. 음식 결제 문의" }; //결제 문의 상세 버튼 이름
		String[] lgin = new String[] { "1. ID 로그인 불가", "2. QR 로그인 불가", "3. 아이디 찾기 문의", "4. 비밀번호 찾기 오류" }; //로그인 문의 상세 버튼 이름
		String[] sgin = new String[] { "1. 회원가입 오류", "2. 회원가입 화면 오류", "3. 회원정보 수정", "4. 회원탈퇴 문의" }; //회원가입 문의 상세 버튼 이름
				
		for(int i =0; i < 4; i++)
		{
			btn[i] = new JButton(pm[i]); //결제 문의 상세 버튼 
			btn[i].setFont(new Font("맑은 고딕", Font.BOLD, 20)); //결제 문의 상세 버튼 글씨체 설정
			btn[i].setBackground(Color.WHITE); //결제 문의 상세 버튼 배경색 설정
			btn[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					switch(e.getActionCommand()) {
					case "1. 결제 불가":
						db.inquiryInput(LocalDate.now().toString(),"결제 문의","결제 불가");
						in_label1.setText("결제가 안되는 경우");
						in_label2.setText("재로그인 후 결제 해주세요");
						break;
					case "2. 카드 인식 불가":
						db.inquiryInput(LocalDate.now().toString(),"결제 문의","카드 인식 불가");
						in_label1.setText("카드를 리더기에 재접촉 하거나");
						in_label2.setText("관리자를 호출 해주세요");
						break;
					case "3. 좌석 인식 불가":
						db.inquiryInput(LocalDate.now().toString(),"결제 문의","좌석 인식 불가");
						in_label1.setText("관리자를 호출 해주세요");
						in_label2.setText("");
						break;
					case "4. 음식 결제 문의":
						db.inquiryInput(LocalDate.now().toString(),"결제 문의","음식 결제 문의");
						in_label1.setText("재로그인 후 음식 결제 창을 다시 열거나");
						in_label2.setText("관리자를 호출 해주세요");
						break;
					}
				}
			});
		}
		btn[0].setBounds(810, 580, 310, 100); //결제 문의 상세 버튼 위치, 사이즈
		btn[1].setBounds(1120, 580, 310, 100); //결제 문의 상세 버튼 위치, 사이즈
		btn[2].setBounds(810, 680, 310, 100); //결제 문의 상세 버튼 위치, 사이즈
		btn[3].setBounds(1120, 680, 310, 100); //결제 문의 상세 버튼 위치, 사이즈
		add(btn[0]); //결제 문의 상세 버튼 붙임
		add(btn[1]); //결제 문의 상세 버튼 붙임
		add(btn[2]); //결제 문의 상세 버튼 붙임
		add(btn[3]); //결제 문의 상세 버튼 붙임
		
				
		//문의 선택 버튼
		JButton[] choose_inquiry = new JButton[4]; //문의 선택 버튼
		String[] CI = new String[] {"1. 결제 문의", "2. 로그인 문의", "3. 회원가입 문의", "4. 관리자 호출"}; //문의 버튼 생성 시 버튼 이름
		for(int i = 0; i < 4; i++) {
			choose_inquiry[i] = new JButton(CI[i]); //문의 선택 버튼 생성
			choose_inquiry[i].setFont(new Font("맑은 고딕", Font.BOLD, 40)); //문의 선택 버튼 글씨체 설정
			choose_inquiry[i].setBackground(Color.WHITE); //문의 선택 버튼 배경색 설정
			choose_inquiry[i].setBounds(90, (380+i*100), 650, 100); //문의 선택 버튼 위치, 사이즈 설정
			add(choose_inquiry[i]); //문의 선택 버튼 붙임
			
			choose_inquiry[i].addActionListener(new ActionListener() { //문의 버튼 선택 시 이벤트 처리
				public void actionPerformed(ActionEvent e) {
					JButton CIbtn = (JButton)e.getSource();
					if(CIbtn == choose_inquiry[0]) { //결제 문의 버튼 선택 시
						for(int i = 0; i < 4; i++)
						{
							btn[0].setBounds(810, 580, 310, 100); //결제 문의 상세 버튼 위치, 사이즈
							btn[i].setText(pm[i]);
							btn[i].addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									switch(e.getActionCommand()) {
									case "1. 결제 불가":
										db.inquiryInput(LocalDate.now().toString(),"결제 문의","결제 불가");
										in_label1.setText("결제가 안되는 경우");
										in_label2.setText("재로그인 후 결제 해주세요");
										break;
									case "2. 카드 인식 불가":
										db.inquiryInput(LocalDate.now().toString(),"결제 문의","카드 인식 불가");
										in_label1.setText("카드를 리더기에 재접촉 하거나");
										in_label2.setText("관리자를 호출 해주세요");
										break;
									case "3. 좌석 인식 불가":
										db.inquiryInput(LocalDate.now().toString(),"결제 문의","좌석 인식 불가");
										in_label1.setText("관리자를 호출 해주세요");
										in_label2.setText("");
										break;
									case "4. 음식 결제 문의":
										db.inquiryInput(LocalDate.now().toString(),"결제 문의","음식 결제 문의");
										in_label1.setText("재로그인 후 음식 결제 창을 다시 열거나");
										in_label2.setText("관리자를 호출 해주세요");
										break;
									}
								}
							});
						}
					}
					else if(CIbtn == choose_inquiry[1]) { //로그인 문의 버튼 선택 시
						for(int i = 0; i < 4; i++)
						{
							btn[0].setBounds(810, 580, 310, 100); //결제 문의 상세 버튼 위치, 사이즈
							btn[i].setText(lgin[i]);
							btn[i].addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									switch(e.getActionCommand()) {
										case "1. ID 로그인 불가":
											db.inquiryInput(LocalDate.now().toString(),"로그인 문의","ID 로그인 불가");
											in_label1.setText("아이디/비밀번호를 맞게 입력했는지 확인하거나");
											in_label2.setText("관리자를 호출 해주세요");
											break;
										case "2. QR 로그인 불가":
											db.inquiryInput(LocalDate.now().toString(),"로그인 문의","QR 로그인 불가");
											in_label1.setText("QR 로그인 창을 다시 열거나");
											in_label2.setText("관리자를 호출 해주세요");
											break;
										case "3. 아이디 찾기 문의":
											db.inquiryInput(LocalDate.now().toString(),"로그인 문의","아이디 찾기 문의");
											in_label1.setText("관리자를 호출 해주세요");
											in_label2.setText("");
											break;
										case "4. 비밀번호 찾기 오류":
											db.inquiryInput(LocalDate.now().toString(),"로그인 문의","비밀번호 찾기 오류");
											in_label1.setText("아이디/전화번호를 맞게 입력했는지 확인하거나");
											in_label2.setText("관리자를 호출 해주세요");
											break;
									}
								}
							});
						}
					}
					else if(CIbtn == choose_inquiry[2]) { //회원가입 문의 버튼 선택 시
						for(int i = 0; i < 4; i++)
						{
							btn[0].setBounds(810, 580, 310, 100); //첫번째 상세 버튼 위치, 사이즈
							btn[i].setText(sgin[i]);
							btn[i].addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									switch(e.getActionCommand()) {
										case "1. 회원가입 오류":
											db.inquiryInput(LocalDate.now().toString(),"회원가입 문의","회원가입 오류");
											in_label1.setText("아이디 중복을 확인 해주시고");
											in_label2.setText("비밀번호를 맞게 입력했는지 확인 해주세요");
											break;
										case "2. 회원가입 화면 오류":
											db.inquiryInput(LocalDate.now().toString(),"회원가입 문의","회원가입 화면 오류");
											in_label1.setText("관리자를 호출 해주세요");
											in_label2.setText("");
											break;
										case "3. 회원정보 수정":
											db.inquiryInput(LocalDate.now().toString(),"회원가입 문의","회원정보 수정");
											in_label1.setText("관리자를 호출 해주세요");
											in_label2.setText("");
											break;
										case "4. 회원탈퇴 문의":
											db.inquiryInput(LocalDate.now().toString(),"회원가입 문의","회원탈퇴 문의");
											in_label1.setText("회원 탈퇴 시 관리자를 호출 해주세요");
											in_label2.setText("회원 탈퇴 시 회원 등급이 리셋됩니다");
											break;
									}
								}
							});
						}
							
					}
					else if(CIbtn == choose_inquiry[3]) { //관리자 호출 버튼 선택 시
						btn[0].setBounds(810, 580, 620, 200); //결제 문의 상세 버튼 위치, 사이즈
						btn[0].setText("관리자 호출");
						btn[0].addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								switch(e.getActionCommand()) {
								case "관리자 호출":
									db.inquiryInput(LocalDate.now().toString(),"관리자 호출","관리자 호출");
									in_label1.setText("관리자를 호출하였습니다");
									in_label2.setText("잠시만 기다려주세요");
									break;
								}
							}
						});
					}
				}
			});
		}
		
		
		//이벤트 처리 추가
		home_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				db.logout();
				db.dbclose();
				new MainLogin(); //홈 버튼을 누르면 첫 화면으로 이동
				setVisible(false);
			}
		});
		
		setting_icon.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				db.dbclose();
				new manager_login(); //설정 버튼을 누르면 관리자 로그인 페이지로 이동
				setVisible(false);
			}
		});
		
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
		new InquiryPage();
	}
}
