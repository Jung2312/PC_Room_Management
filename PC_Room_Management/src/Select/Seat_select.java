package Select;

import java.awt.*;
import javax.swing.*;

import Btn_Design.RoundedButton;

// 좌석 선택
public class Seat_select extends JFrame{
	
	
	public static void input_btn(JButton btn, int x, int y, int xsize, int ysize) {
		// 버튼 생성 메소드
		btn.setContentAreaFilled(false);
		btn.setBorderPainted(false); // 버튼 테두리 설정해제
		btn.setFocusPainted(false);
		btn.setBounds(x, y, xsize+2, ysize+2); // 버튼 위치, 사이즈
	}
	
	public Seat_select()
	{
		int cnt = 0;
		String[] btn_Title = { "1", "2", "3",
	            "4", "5", "6", "7", "8", "9","10", "11", "12", 
				"13", "14","15", "16", "17", "18", "19","20", "21", "22", "23", "24",
				 "25","26", "27", "28", "29","30"}; // 버튼 이름 배열


	
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
		input_btn(ok_btn, 620, 700, 120, 30);
		add(ok_btn); // 프레임에 버튼을 붙임
		
		RoundedButton cancle_btn = new RoundedButton("취소"); // 취소 버튼
		input_btn(cancle_btn, 770, 700, 120, 30);
		add(cancle_btn); // 프레임에 버튼을 붙임
		
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
		new Seat_select();

	}

}
