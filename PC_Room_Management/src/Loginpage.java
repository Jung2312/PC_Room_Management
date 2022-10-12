import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class Loginpage {
	public Loginpage() {
		JButton okbtn = new JButton(new ImageIcon("image/ok_whitebtn.png")); //확인 버튼 할당
		JButton cancle = new JButton(new ImageIcon("image/cancle_whitebtn.png")); //취소 버튼 할당
		JButton home = new JButton(new ImageIcon("image/home_btn.png")); //홈 버튼 할당
		JButton inquiry = new JButton(new ImageIcon("image/user_inquiry.png")); //문의 버튼 할당
		JButton setting = new JButton(new ImageIcon("image/setting_icon.png")); //설정 버튼 할당
		JButton searchbtn = new JButton(); //아이디, 비밀번호 찾기 버튼 할당
		
		JLabel login = new JLabel("LOGIN"); //로그인창을 알려주는 로그인 라벨
		JLabel IDlabel = new JLabel("아이디"); //아이디 라벨
		JLabel PWlabel = new JLabel("비밀번호"); //비밀번호 라벨
		JLabel search = new JLabel("아이디/비밀번호 찾기"); //아이디, 비밀번호 찾기 라벨
		
		JTextField getID = new JTextField(20); //아이디 입력 필드
		JPasswordField getPW = new JPasswordField(20); //비밀번호 입력 필드
		
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		JPanel btnPanel = new JPanel(); //버튼 패널
		
		panel.setBackground(new Color(246,246,246,255)); //흰색 RGB코드, 불투명하게
		
		btnPanel.add(inquiry); //문의 버튼
		btnPanel.add(setting); //설정 버튼
		btnPanel.add(home); // 홈 버튼
		btnPanel.add(searchbtn); //아이디, 비밀번호 찾기 버튼
		btnPanel.add(okbtn); //확인 버튼
		btnPanel.add(cancle); //취소 버튼
		
		home.setSize(50, 50); //홈 버튼 크기
		home.setLocation(14, 3); //홈 버튼 위치
		home.setBorderPainted(false); //홈 버튼 테두리(외곽선) 없앰
		home.setFocusPainted(false); //홈 버튼이 선택되었을 때 생기는 테두리 사용 안함
		home.setContentAreaFilled(false); //홈 버튼 영역 채우지 않음
		frame.add(home); //홈 버튼 출력
		
		inquiry.setSize(100, 60); //문의 버튼 크기
		inquiry.setLocation(1380, 3); // 문의 버튼 위치
		inquiry.setBorderPainted(false); //문의 버튼 테두리(외곽선) 없앰
		inquiry.setFocusPainted(false); //문의 버튼이 선택되었을 때 생기는 테두리 사용 안함
		inquiry.setContentAreaFilled(false); //문의 버튼 영역 채우지 않음
		frame.add(inquiry); //문의 버튼 출력
		
		
		setting.setSize(60, 60); //설정 버튼 크기
		setting.setLocation(1470, 5); //설정 버튼 위치
		setting.setBorderPainted(false); //설정 버튼 테두리(외곽선) 없앰
		setting.setFocusPainted(false); //설정 버튼이 선택되었을 때 생기는 테두리 사용 안함
		setting.setContentAreaFilled(false); //설정 버튼 영역 채우지 않음
		frame.add(setting); //설정 버튼 출력
		
		okbtn.setSize(110,50);
		okbtn.setLocation(635, 700);
		okbtn.setBorderPainted(false); //확인 버튼 테두리(외곽선) 없앰
		okbtn.setFocusPainted(false); //확인 버튼이 선택되었을 때 생기는 테두리 사용 안함
		okbtn.setContentAreaFilled(false); //확인 버튼 영역 채우지 않음
		frame.add(okbtn); //확인 버튼 출력
		
		cancle.setSize(110, 50);
		cancle.setLocation(785, 700);
		cancle.setBorderPainted(false); //취소 버튼 테두리(외곽선) 없앰
		cancle.setFocusPainted(false); //취소 버튼이 선택되었을 때 생기는 테두리 사용 안함
		cancle.setContentAreaFilled(false); //취소 버튼 영역 채우지 않음
		frame.add(cancle); //취소 버튼 출력
		
		searchbtn.setSize(230, 30);
		searchbtn.setLocation(580, 537);
		searchbtn.setBorderPainted(false); //찾기 버튼 테두리(외곽선) 없앰
		searchbtn.setFocusPainted(false); //찾기 버튼이 선택되었을 때 생기는 테두리 사용 안함
		searchbtn.setContentAreaFilled(false); //찾기 버튼 영역 채우지 않음
		frame.add(searchbtn);
		
		
		getID.setFont(new Font("맑은 고딕", Font.PLAIN, 38)); //로그인 입력 창 글씨체, 굵기, 크기 설정
		getID.setSize(615, 55); //로그인 입력 창 크기
		getID.setLocation(580, 355); //로그인 입력 창 위치
		frame.add(getID); //로그인 입력 창 출력
		
		getPW.setFont(new Font("맑은 고딕", Font.PLAIN, 38)); //비밀번호 입력 창 글씨체, 굵기, 크기 설정
		getPW.setSize(615, 55); //비밀번호 입력 창 크기
		getPW.setLocation(580, 455); //비밀번호 입력 창 위치
		frame.add(getPW); //비밀번호 입력 창 출력
		
		
		
		login.setFont(new Font("맑은 고딕", Font.BOLD, 58)); //로그인 라벨 글씨체, 굵기, 크기 설정
		login.setSize(200,200); //로그인 라벨 크기 설정
		login.setLocation(675, 90); //로그인 라벨 위치 설정
		frame.add(login); //로그인 라벨 출력
		
		IDlabel.setFont(new Font("맑은 고딕", Font.BOLD, 45)); //아이디 라벨 글씨체, 긁기, 크기 설정
		IDlabel.setSize(200, 200); //아이디 라벨 크기 설정
		IDlabel.setLocation(340, 280); //아이디 라벨 위치 설정
		frame.add(IDlabel); //아이디 라벨 출력
		
		PWlabel.setFont(new Font("맑은 고딕", Font.BOLD, 45)); //비밀번호 라벨 글씨체, 굵기, 크기 설정
		PWlabel.setSize(200, 200); //비밀번호 라벨 크기 설정
		PWlabel.setLocation(340, 380); //비밀번호 라벨 위치 설정
		frame.add(PWlabel);
		
		search.setFont(new Font("맑은 고딕", Font.BOLD, 23)); //아이디, 비밀번호 찾기 글씨체, 굵기, 크기 설정
		search.setSize(800, 200); //아이디, 비밀번호 찾기 크기 설정
		search.setLocation(580, 450); //아이디, 비밀번호 찾기 위치 설정
		frame.add(search); //아이디, 비밀번호 찾기 위치 출력
		
		
		frame.add(panel);
		
		frame.setResizable(false); //창 크기 조절 불가
		frame.setVisible(true); //창을 화면에 나타낼 것인지 설정
		frame.setSize(1920,1080); //창 크기 설정
		frame.setPreferredSize(new Dimension(1920,1080)); //Dimension객체를 인자로 받으면서 해당 컴포넌트 기본크기를 결정
		frame.setLocationRelativeTo(null); //화면을 중간에 띄움
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //창닫기 버튼을 활성화 시켜 X를 누르면 프로그램 종료
	}
	
	public static void main(String[] args) {
		new Loginpage();
	}
}