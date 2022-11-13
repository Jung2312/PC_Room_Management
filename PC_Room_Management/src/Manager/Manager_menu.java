package Manager;

import javax.swing.*;

import Btn_Design.RoundedButton4;
import Main.MainLogin;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// 관리자 로그인시 들어오는 첫 화면(좌석 확인)
public class Manager_menu extends JFrame{

	public static void input_btn(JButton btn, int x, int y, int xsize, int ysize) {
		// 버튼 생성 메소드
		btn.setContentAreaFilled(false);
		btn.setBorderPainted(false); // 버튼 테두리 설정해제
		btn.setFocusPainted(false);
		btn.setBounds(x, y, xsize+2, ysize+2); // 버튼 위치, 사이즈
	}
	
	public Manager_menu()
	{
		int cnt = 0;
		String[] btn_Title = { "1", "2", "3",
	            "4", "5", "6", "7", "8", "9","10", "11", "12", 
				"13", "14","15", "16", "17", "18", "19","20", "21", "22", "23", "24",
				 "25","26", "27", "28", "29","30"}; // 버튼 이름 배열
		
		int seat = 0;
		JLabel seat_num = new JLabel("남은 좌석 " + seat + "/" + 30); 
		seat_num.setBounds(334, 80, 200, 30);
		seat_num.setFont(new Font("맑은 고딕", Font.BOLD, 20)); // 폰트
		add(seat_num);
	
		JButton home_btn = new JButton(new ImageIcon("./image/home_btn.png")); //홈버튼 생성
		input_btn(home_btn, 20, 20, 40, 40);
		add(home_btn); // 프레임에 버튼을 붙임
		
		RoundedButton4 user_management = new RoundedButton4("회원 관리"); // 회원 관리 버튼(둥근 테두리 적용하는 클래스 사용)
		input_btn(user_management, 1110 ,20, 90, 40);
		add(user_management); // 프레임에 버튼을 붙임
		
		RoundedButton4 sales_check = new RoundedButton4("매출 확인"); // 매출 확인 버튼(둥근 테두리 적용하는 클래스 사용)
		input_btn(sales_check, 1230 ,20, 90, 40);
		add(sales_check); // 프레임에 버튼을 붙임
		
		RoundedButton4 inquiry_check = new RoundedButton4("문의 확인"); // 문의 확인 버튼(둥근 테두리 적용하는 클래스 사용)
		input_btn(inquiry_check, 1350 ,20, 90, 40);
		add(inquiry_check); // 프레임에 버튼을 붙임
		
		JButton setting_icon = new JButton(new ImageIcon("./image/setting_icon.png")); // 관리자 버튼
		input_btn(setting_icon, 1460, 20, 40, 40);
		add(setting_icon); // 프레임에 버튼을 붙임
		
		// 좌석 버튼
		JButton[] seat_btn = new JButton[30];
		//input_btn(one_seat,330, 140, 92, 86);
		//seat_btn.setFont(new Font("맑은 고딕", Font.BOLD, 24));
		
		for(int i = 0; i < 30; i++) // 버튼 0번 부터 29번까지 붙임
		{
			
			add(seat_btn[i] = new JButton(btn_Title[i]));
	            // 버튼 생성하여 JButton 타입의 배열에 저장
			
			if(i % 6 == 0)
			{
				cnt = 0; // 위치 조정을 위한 변수
			}
        	
			
            if(i <= 5)
            {
            	if(i % 2 != 0 || i == 0)
            	{
            		input_btn(seat_btn[i],330+cnt, 132, 92, 92);
                	seat_btn[i].setFont(new Font("맑은 고딕", Font.BOLD, 24));
                	seat_btn[i].setBackground(new Color(240, 240, 240)); // 이용 중인 좌석일 경우 나타낼 색
                	cnt += 110;
            	}
            	
            	else if(i % 2 == 0)
            	{
            		input_btn(seat_btn[i],330+cnt+100, 132, 92, 92);
                	seat_btn[i].setFont(new Font("맑은 고딕", Font.BOLD, 24));
                	seat_btn[i].setBackground(new Color(240, 240, 240));
                	cnt += 210;
            	}
            	
            }
            
            
            else if(6 <= i && i <= 11)
            {
            	if(i % 2 == 0)
            	{
            		input_btn(seat_btn[i],330+cnt, 242, 92, 92);
                	seat_btn[i].setFont(new Font("맑은 고딕", Font.BOLD, 24));
                	seat_btn[i].setBackground(new Color(240, 240, 240));
                	cnt += 110;
            	}
            	
            	
            	else if(i % 2 != 0)
            	{
            		System.out.println(cnt);
            		input_btn(seat_btn[i],330+cnt, 242, 92, 92);
                	seat_btn[i].setFont(new Font("맑은 고딕", Font.BOLD, 24));
                	seat_btn[i].setBackground(new Color(240, 240, 240));
                	cnt += 210;
            	}
            	
            }
            
            else if(12 <= i && i <= 17)
            {
            	if(i % 2 == 0)
            	{
            		input_btn(seat_btn[i],330+cnt, 350, 92, 92);
                	seat_btn[i].setFont(new Font("맑은 고딕", Font.BOLD, 24));
                	seat_btn[i].setBackground(new Color(240, 240, 240));
                	cnt += 110;
            	}
            	
            	
            	else if(i % 2 != 0)
            	{
            		System.out.println(cnt);
            		input_btn(seat_btn[i],330+cnt, 350, 92, 92);
                	seat_btn[i].setFont(new Font("맑은 고딕", Font.BOLD, 24));
                	seat_btn[i].setBackground(new Color(240, 240, 240));
                	cnt += 210;
            	}
            	
            }
            
            else if(18 <= i && i <= 23)
            {
            	if(i % 2 == 0)
            	{
            		input_btn(seat_btn[i],330+cnt, 460, 92, 92);
                	seat_btn[i].setFont(new Font("맑은 고딕", Font.BOLD, 24));
                	seat_btn[i].setBackground(new Color(240, 240, 240));
                	cnt += 110;
            	}
            	
            	
            	else if(i % 2 != 0)
            	{
            		System.out.println(cnt);
            		input_btn(seat_btn[i],330+cnt, 460, 92, 92);
                	seat_btn[i].setFont(new Font("맑은 고딕", Font.BOLD, 24));
                	seat_btn[i].setBackground(new Color(240, 240, 240));;
                	cnt += 210;
            	}
            	
            }
            
            else
            {
            	if(i % 2 == 0)
            	{
            		input_btn(seat_btn[i],330+cnt, 570, 92, 92);
                	seat_btn[i].setFont(new Font("맑은 고딕", Font.BOLD, 24));
                	seat_btn[i].setBackground(new Color(240, 240, 240));
                	cnt += 110;
            	}
            	
            	
            	else if(i % 2 != 0)
            	{
            		System.out.println(cnt);
            		input_btn(seat_btn[i],330+cnt, 570, 92, 92);
                	seat_btn[i].setFont(new Font("맑은 고딕", Font.BOLD, 24));
                	seat_btn[i].setBackground(new Color(240, 240, 240));
                	cnt += 210;
            	}
            }

		}
		
		
		// 좌석 이미지 레이블
		JLabel seat_image = new JLabel(new ImageIcon("./image/seat_image.png"));
		seat_image.setBounds(150, 30, 1206, 743);
		add(seat_image);
		
		//이벤트 처리 추가
		home_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MainLogin(); //홈버튼을 누르면 첫 화면으로 이동
				setVisible(false);
			}
		});
		
		user_management.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new User_Management(); //회원관리 버튼을 누르면 회원관리 페이지로 이동
				setVisible(false);
			}
		});
		
		sales_check.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Sales_Management(); //매출확인 버튼을 누르면 매출확인 페이지로 이동
				setVisible(false);
			}
		});
		
		inquiry_check.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new inquiry_management(); //문의확인 버튼을 누르면 문의 확인 페이지로 이동
				setVisible(false);
			}
		});
		
		setting_icon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new manager_login(); //설정 버튼을 누르면 메인 로그인 페이지로 이동
				setVisible(false);
			}
		});
		
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
		new Manager_menu();
	}

}
