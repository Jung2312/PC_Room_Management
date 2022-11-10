package Chat;

import java.awt.*;	
import javax.swing.*;

import Main.MainLogin;
import Manager.manager_login;

import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;

import Btn_Design.*;

public class InquiryPage extends JFrame {
	Connection conn = null;
	String a = "1. 결제 문의";
	String b = "";
	public static void input_btn(JButton btn, int x, int y, int xsize, int ysize) {
		// 버튼 생성 메소드
		btn.setContentAreaFilled(false);
		btn.setBorderPainted(false); // 버튼 테두리 설정해제
		btn.setFocusPainted(false);
		btn.setBounds(x, y, xsize+2, ysize+2); // 버튼 위치, 사이즈
	}
	
	public InquiryPage() {
		try { 
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 System.out.println("드라이버 검색 성공");
		 }catch(ClassNotFoundException e) {
			 System.err.println("드라이버 검색 실패");
			 System.exit(0);
		 }
		 

		 try {
			 conn = DriverManager.getConnection(
					 "jdbc:mysql://localhost:3306/connectdb?serverTimezone=UTC"  // 서버 이름
					 ,"root","ejqmftnld1!" // 이름, 비밀번호(커넥션 정보는 깃허브에 업로드 하지 말 것)
					 );
			 System.out.println("데이터베이스 연결 성공");
		 }catch (SQLException e) {
			 System.out.println(e);
			 System.err.println("데이터베이스 연결 실패");
			 System.exit(0);
		 }
		//Container c = getContentPane();
		//c.setLayout(new FlowLayout());
		
		JLabel inquiry = new JLabel(new ImageIcon("./image/inquiry_image.png")); //문의 아이콘 생성
		inquiry.setBounds(810, 380, 55, 35); //문의 아이콘 위치, 사이즈
		add(inquiry); //프레임에 버튼을 붙임
		
		JLabel firstPayment1 = new JLabel("결제가 안되는 경우"); //1. 결제 불가 선택시 나타나는 안내 메세지 (디폴트)
		JLabel firstPayment2 = new JLabel("재로그인 후 결제 해주세요"); //1. 결제 불가 선택시 나타나는 안내 메세지 (디폴트)
		firstPayment1.setFont(new Font("맑은 고딕", Font.BOLD, 24)); 
		firstPayment2.setFont(new Font("맑은 고딕", Font.BOLD, 24));
		firstPayment1.setBounds(810, 400, 250, 100);
		firstPayment2.setBounds(810, 430, 300, 100);
		add(firstPayment1); //안내 메세지 출력
		add(firstPayment2); //안내 메세지 출력
		
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
		//JButton managercall = new JButton("관리자 호출"	); //관리자 호출 버튼
		JButton[] btn = new JButton[4]; //문의 상세 선택 버튼
		String[] pm = new String[] { "1. 결제 불가", "2. 카드 인식 불가", "3. 좌석 인식 불가", "4. 음식 결제 문의" }; //결제 문의 상세 버튼 이름
		String[] lgin = new String[] { "1. 로그인", "2. 로그인", "3. 로그인", "4. 로그인" }; //로그인 문의 상세 버튼 이름
		String[] sgin = new String[] { "1. 회원가입", "2. 회원가입", "3. 회원가입", "4. 회원가입" }; //회원가입 문의 상세 버튼 이름
				
		for(int i =0; i < 4; i++)
		{
			btn[i] = new JButton(pm[i]); //결제 문의 상세 버튼 
			btn[i].setFont(new Font("맑은 고딕", Font.BOLD, 20)); //결제 문의 상세 버튼 글씨체 설정
			btn[i].setBackground(Color.WHITE); //결제 문의 상세 버튼 배경색 설정
			btn[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
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
				@Override
				public void actionPerformed(ActionEvent e) {
					JButton CIbtn = (JButton)e.getSource();
					if(CIbtn == choose_inquiry[0]) { //결제 문의 버튼 선택 시
						a = CIbtn.getText();
						for(int i = 0; i < 4; i++) 
							btn[i].setText(pm[i]);					
						btn[0].setBounds(810, 580, 310, 100); //첫번째 상세 버튼 위치, 사이즈 (추가)
					}
					else if(CIbtn == choose_inquiry[1]) { //로그인 문의 버튼 선택 시
						a = CIbtn.getText();
						for(int i = 0; i < 4; i++)
							btn[i].setText(lgin[i]);
						btn[0].setBounds(810, 580, 310, 100); //첫번째 상세 버튼 위치, 사이즈 (추가)
					}
					else if(CIbtn == choose_inquiry[2]) { //회원가입 문의 버튼 선택 시
						a = CIbtn.getText();
						for(int i = 0; i < 4; i++)
							btn[i].setText(sgin[i]);
						btn[0].setBounds(810, 580, 310, 100); //첫번째 상세 버튼 위치, 사이즈 (추가)
					}
					else if(CIbtn == choose_inquiry[3]) { //관리자 호출 버튼 선택 시
						a = CIbtn.getText();
						btn[0].setBounds(810, 580, 620, 200); //결제 문의 상세 버튼 위치, 사이즈
						btn[0].setText("관리자 호출");
					}	
				}	
			});
		}
		for(int i = 0; i < 4; i++) {
			btn[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JButton btn2 = (JButton)e.getSource();
					b = btn2.getText();
					insert(a,b);
				}
			});
		}
		
		home_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MainLogin(); //홈버튼을 누르면 첫 화면으로 이동
				 try {
					 if(conn != null) {
						 conn.close();
						 System.out.println("닫기 성공");
					 }
				 }catch (SQLException e1) {
					 e1.printStackTrace();
				 }
			}
		});
		

		
		//이벤트 처리 추가
		home_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MainLogin(); //홈 버튼을 누르면 첫 화면으로 이동
				setVisible(false);
			}
		});
		
		setting_icon.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
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
	
	public void insert(String inquiry, String inquiry_detail) {
		SimpleDateFormat a = new SimpleDateFormat("yyyy-MM-dd");
		Date now = new Date();
		String now1 = a.format(now);
        String sql = "insert into inquiry(day, inquiry, detailedInquiry) values(?,?,?)";
        PreparedStatement pstmt = null;
        try {
        	pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, now1);
            pstmt.setString(2, inquiry);
            pstmt.setString(3, inquiry_detail);
            
            int result = pstmt.executeUpdate();
            if(result==1) {
                System.out.println("데이터 삽입 성공!");
                
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("실패");
        }
    }

	public static void main(String[] args) {
		new InquiryPage();
	}
}
