package Select;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

import javax.swing.*;

import Btn_Design.RoundedButton;
import Chat.InquiryPage;
import DB.Database;
import Main.MainLogin;
import Manager.manager_login;

// 좌석 선택
public class Payment_page {
	
	int won_check = 0;
	String today = null;
	String end = null;
	String grade = null;
	Database db = new Database();
	
	public int pay_grade(int won) // 회원 등급에 따른 금액 추산
	{
		if(db.user_grade().equals("WHITE"))
		{
			int won2 = (int) (won * 0.01);
			won_check = won - won2;
		}
		else if(db.user_grade().equals("SILVER"))
		{
			int won2 = (int) (won * 0.02);
			won_check = won - won2;
		}
		else if(db.user_grade().equals("GOLD"))
		{
			int won2 = (int) (won * 0.04);
			won_check = won - won2;
		}
		else if(db.user_grade().equals("VIP"))
		{
			int won2 = (int) (won * 0.05);
			won_check = won - won2;
		}
		
		return won_check;
	}
	
	public void payment(int time) // 예악한 시간을 확인하는 메소드
	{
		Date date = new Date();
		 
        // 포맷 정의하기
        SimpleDateFormat sdformat = new SimpleDateFormat("HHmmss");
        
        // 포맷 적용하기
        Calendar cal = Calendar.getInstance();

        cal.setTime(date);

        today = sdformat.format(cal.getTime());  
        
        cal.add(Calendar.MINUTE, time);
        
        end = sdformat.format(cal.getTime());
	}
	
	public Payment_page() {
		JButton home = new JButton(new ImageIcon("image/home_btn.png")); //홈 버튼 할당
		RoundedButton inquiry = new RoundedButton("문의"); //문의 버튼 할당
		JButton setting = new JButton(new ImageIcon("image/setting_icon.png")); //설정 버튼 할당
		JButton payment = new JButton(); //결제 버튼 할당
		JButton paycancle = new JButton(); //결제 취소 버튼 할당
		final JButton[] wonbtn = new JButton[6]; //시간(가격)선택 버튼 할당

		String[] won = {"1000원", "2000원", "3000원", "4000원", "5000원", "8000원"}; //라벨 내용
		JLabel[] wonlabel = new JLabel[6]; //가격 라벨
		JLabel paymentlabel = new JLabel("결제"); //결제창임을 알려주는 라벨
		JLabel seltime = new JLabel("시간 선택"); //시간 선택 라벨
		JLabel usergrade = new JLabel("회원 등급"); //회원 등급 라벨
		JLabel gradelabel = new JLabel(grade); //회원 등급을 나타내는 라벨
		JLabel seat_price = new JLabel(new ImageIcon("image/Seatprice.png")); //좌석 시간 결제 백그라운드 라벨
		
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		JPanel btnPanel = new JPanel(); //버튼 패널
		
		
		
		//배경, 좌석 결제
		panel.setBackground(Color.WHITE); //배경 색 흰색
		seat_price.setBounds(118,120,1300,700); //좌석 x, y, 가로 세로 설정
		
		
		//버튼 설정
		btnPanel.add(inquiry); //문의 버튼
		btnPanel.add(setting); //설정 버튼
		btnPanel.add(home); // 홈 버튼
				
		home.setSize(50, 50); //홈 버튼 크기
		home.setLocation(14, 2); //홈 버튼 위치
		home.setBorderPainted(false); //홈 버튼 테두리(외곽선) 없앰
		home.setFocusPainted(false); //홈 버튼이 선택되었을 때 생기는 테두리 사용 안함
		home.setContentAreaFilled(false); //홈 버튼 영역 채우지 않음
		frame.add(home); //홈 버튼 출력
				
		inquiry.setSize(80, 40); //문의 버튼 크기
		inquiry.setLocation(1350 ,20); // 문의 버튼 위치
		inquiry.setBorderPainted(false); //문의 버튼 테두리(외곽선) 없앰
		inquiry.setFocusPainted(false); //문의 버튼이 선택되었을 때 생기는 테두리 사용 안함
		inquiry.setContentAreaFilled(false); //문의 버튼 영역 채우지 않음
		frame.add(inquiry); //문의 버튼 출력
				
		setting.setSize(40, 40); //설정 버튼 크기
		setting.setLocation(1450, 20); //설정 버튼 위치
		setting.setBorderPainted(false); //설정 버튼 테두리(외곽선) 없앰
		setting.setFocusPainted(false); //설정 버튼이 선택되었을 때 생기는 테두리 사용 안함
		setting.setContentAreaFilled(false); //설정 버튼 영역 채우지 않음
		frame.add(setting); //설정 버튼 출력
				
		payment.setSize(315, 85); //결제 버튼 크기
		payment.setLocation(1045, 510); //결제 버튼 위치
		payment.setBorderPainted(false); //결제 버튼 테두리(외곽선) 없앰
		payment.setFocusPainted(false); //결제 버튼이 선택되었을 때 생기는 테두리 사용 안함
		payment.setContentAreaFilled(false); //결제 버튼 영역 채우지 않음
		frame.add(payment); //결제 버튼 출력
				
		paycancle.setSize(315, 85); //결제 취소 버튼 크기
		paycancle.setLocation(1045, 635); //결제 취소 버튼 위치
		paycancle.setBorderPainted(false); //결제 취소 버튼 테두리(외곽선) 없앰
		paycancle.setFocusPainted(false); //결제 취소 버튼이 선택되었을 때 생기는 테두리 사용 안함
		paycancle.setContentAreaFilled(false); //결제 취소 버튼 영역 채우지 않음
		frame.add(paycancle); //결제 취소 버튼 출력
	
		for(int i = 0; i < 6; i++) //시간 선택 버튼
		{
			wonbtn[i] = new JButton(won[i]); //시간 선택 버튼 초기화
			wonbtn[i].setLocation(1045, 510); //시간 선택 버튼 위치
			wonbtn[i].setBorderPainted(false); //시간 선택 버튼 테두리(외곽선) 없앰
			wonbtn[i].setFocusPainted(false); //시간 선택 버튼이 선택되었을 때 생기는 테두리 사용 안함
			wonbtn[i].setContentAreaFilled(false); //시간 선택 버튼 영역 채우지 않음
			wonbtn[i].setHorizontalAlignment(SwingConstants.LEFT);
			wonbtn[i].setVerticalAlignment(SwingConstants.BOTTOM);
			
			wonbtn[i].setForeground(Color.BLACK);
			frame.add(wonbtn[i]); //시간 선택 버튼 출력
			
			wonbtn[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					switch(e.getActionCommand()){
					
					//TODO getActionCommand() 버튼의 텍스트를 얻어옵니다
					case "1000원": 
						pay_grade(1000);
						payment(60);
						break;
						
					case "2000원": 
						pay_grade(2000);
						payment(120);
						break;
						
					case "3000원": 
						pay_grade(3000);
						payment( 180);
						break;
						
					case "4000원": 
						pay_grade(4000);
						payment( 240);
						break;	
						
					case "5000원": 
						pay_grade(5000);
						payment( 300);
						break;	
						
					case "6000원": 
						pay_grade(6000);
						payment(360);
						break;
						
					} 
				}
				
			});
			
		}
		
		wonbtn[0].setBounds(180, 200, 230, 150); //1000원 버튼 위치, 크기
		wonbtn[1].setBounds(528, 200, 230, 150); //2000원 버튼 위치, 크기
		wonbtn[2].setBounds(180, 383, 230, 150); //3000원 버튼 위치, 크기
		wonbtn[3].setBounds(528, 383, 230, 150); //4000원 버튼 위치, 크기
		wonbtn[4].setBounds(180, 568, 230, 150); //5000원 버튼 위치, 크기
		wonbtn[5].setBounds(528, 568, 230, 150); //8000원 버튼 위치, 크기
		

		//라벨 설정
		seltime.setFont(new Font("맑은 고딕", Font.BOLD, 40)); //시간 선택 라벨 글씨체, 굵기, 크기 설정
		seltime.setSize(615, 55); //시간 선택 라벨 크기
		seltime.setLocation(180, 90); //시간 선택 라벨 위치
		frame.add(seltime); //시간 선택 라벨 출력
		
		paymentlabel.setFont(new Font("맑은 고딕", Font.BOLD, 40)); //결제 라벨 글씨체, 굵기, 크기 설정
		paymentlabel.setSize(615, 55); //결제 라벨 크기
		paymentlabel.setLocation(1042, 90); //결제 라벨 위치
		frame.add(paymentlabel); //결제 라벨 출력

		usergrade.setFont(new Font("맑은 고딕", Font.BOLD, 40)); //회원등급 라벨 글씨체, 굵기, 크기 설정
		usergrade.setSize(615, 55); //회원등급 라벨 크기
		usergrade.setLocation(1042, 300); //회원등급 라벨 위치
		frame.add(usergrade); //회원등급 라벨 출력
		
		gradelabel.setFont(new Font("맑은 고딕", Font.BOLD, 30)); //회원등급 나타내는 라벨 글씨체, 굵기, 크기 설정
		gradelabel.setSize(615, 55); //회원등급 나타내는 라벨 크기
		gradelabel.setLocation(1042, 350); //회원등급 나타내는 라벨 위치
		frame.add(gradelabel); //회원등급 나타내는 라벨 출력
		
		for(int i = 0; i < 6; i++)
		{
			wonlabel[i] = new JLabel(won[i]); //가격 라벨 초기화
			wonlabel[i].setFont(new Font("맑은 고딕", Font.BOLD, 27)); //가격 라벨 글씨체, 굵기, 크기 설정
			wonlabel[i].setForeground(Color.WHITE); //가격 라벨 글씨색
			frame.add(wonlabel[i]); //가격 라벨 출력
			
		}
		wonlabel[0].setBounds(300, 270, 100, 100); //1000원 라벨 위치
		wonlabel[1].setBounds(645, 270, 100, 100); //2000원 라벨 위치
		wonlabel[2].setBounds(300, 450, 100, 100); //3000원 라벨 위치
		wonlabel[3].setBounds(645, 450, 100, 100); //4000원 라벨 위치
		wonlabel[4].setBounds(300, 640, 100, 100); //5000원 라벨 위치
		wonlabel[5].setBounds(645, 640, 100, 100); //8000원 라벨 위치
		
		//이벤트 처리 추가
		home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(db.logout())
				{
					JOptionPane.showMessageDialog(null, "로그아웃 되었습니다.");
				}
				new MainLogin(); //홈 버튼을 누르면 첫 화면으로 이동
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
		
		payment.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(won_check == 0) // 금액 버튼을 선택 안 한 경우
				{
					JOptionPane.showMessageDialog(null, "금액을 선택하세요.");
				}
				
				else
				{
					if(db.seatIDcheck() == true)
					{
						LocalDate now = LocalDate.now();
						String sn = now.toString();
						if(db.timeselect(today, end, won_check, sn))
						{
							db.user_price(won_check);
							JOptionPane.showMessageDialog(null, "결제 완료되었습니다.");
							new SeatFood_select();
							frame.setVisible(false);
						}
					}
					else
					{
						JOptionPane.showMessageDialog(null, "오류");
					}
					
				}
				
				
			}
			
		});
		
		paycancle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				new Seat_select();
				frame.setVisible(false);
			}
		});

				
		//프레임 설정
		frame.add(seat_price); //좌석 시간 결제 출력
		frame.add(panel);
		
		frame.setResizable(false); //창 크기 조절 불가
		frame.setVisible(true); //창을 화면에 나타낼 것인지 설정
		frame.setSize(1530, 920); //창 크기 설정
		frame.setPreferredSize(new Dimension(1920,1080)); //Dimension객체를 인자로 받으면서 해당 컴포넌트 기본크기를 결정
		frame.setLocationRelativeTo(null); //화면을 중간에 띄움
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //창닫기 버튼을 활성화 시켜 X를 누르면 프로그램 종료
	}
	
	public static void main(String[] args) {
		new Payment_page();
	}
}
