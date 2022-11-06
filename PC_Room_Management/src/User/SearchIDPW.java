package User;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Btn_Design.RoundedButton;

// 아이디 비밀번호 찾기
public class SearchIDPW {
	public SearchIDPW() {
		RoundedButton okbtn = new RoundedButton("확인"); // 확인 버튼
		RoundedButton backbtn = new RoundedButton("뒤로"); // 취소 버튼
		
		JLabel SearchIDPW = new JLabel("아이디/비밀번호 찾기");
		JLabel IDlabel = new JLabel("아이디");
		JLabel Tellabel = new JLabel("전화번호");
		
		JTextField getID = new JTextField(20);
		JTextField getTel = new JTextField();
		
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		JPanel btnPanel = new JPanel();
		
		panel.setBackground(Color.WHITE); //흰색 배경으로 설정
		btnPanel.add(okbtn); //확인 버튼
		btnPanel.add(backbtn); //뒤로가기 버튼
		
		okbtn.setSize(110,50);
		okbtn.setLocation(635, 640);
		okbtn.setBorderPainted(false); //확인 버튼 테두리(외곽선) 없앰
		okbtn.setFocusPainted(false); //확인 버튼이 선택되었을 때 생기는 테두리 사용 안함
		okbtn.setContentAreaFilled(false); //확인 버튼 영역 채우지 않음
		frame.add(okbtn); //확인 버튼 출력
		
		backbtn.setSize(110, 50);
		backbtn.setLocation(795, 640);
		backbtn.setBorderPainted(false); //뒤로가기 버튼 테두리(외곽선) 없앰
		backbtn.setFocusPainted(false); //뒤로가기 버튼이 선택되었을 때 생기는 테두리 사용 안함
		backbtn.setContentAreaFilled(false); //뒤로가기 버튼 영역 채우지 않음
		frame.add(backbtn); //뒤로가기 버튼 출력

		
		
		getID.setFont(new Font("맑은 고딕", Font.PLAIN, 38)); //로그인 입력 창 글씨체, 굵기, 크기 설정
		getID.setSize(615, 55); //로그인 입력 창 크기
		getID.setLocation(580, 355); //로그인 입력 창 위치
		frame.add(getID); //로그인 입력 창 출력
		
		getTel.setFont(new Font("맑은 고딕", Font.PLAIN, 38)); //전화번호 입력 창 글씨체, 굵기, 크기 설정
		getTel.setSize(615, 55); //전화번호 입력 창 크기
		getTel.setLocation(580, 455); //전화번호 입력 창 위치
		frame.add(getTel); //전화번호 입력 창 출력
		
		
		
		SearchIDPW.setFont(new Font("맑은 고딕", Font.BOLD, 58)); //아이디, 비밀번호 찾기 라벨 글씨체, 굵기, 크기 설정
		SearchIDPW.setSize(800,200); //아이디, 비밀번호 찾기 라벨 크기 설정
		SearchIDPW.setLocation(485, 90); //아이디, 비밀번호 찾기 라벨 위치 설정
		frame.add(SearchIDPW); //아이디, 비밀번호 찾기 라벨 출력
		
		IDlabel.setFont(new Font("맑은 고딕", Font.BOLD, 45)); //아이디 라벨 글씨체, 긁기, 크기 설정
		IDlabel.setSize(200, 200); //아이디 라벨 크기 설정
		IDlabel.setLocation(340, 280); //아이디 라벨 위치 설정
		frame.add(IDlabel); //아이디 라벨 출력
		
		Tellabel.setFont(new Font("맑은 고딕", Font.BOLD, 45)); //전화번호 라벨 글씨체, 굵기, 크기 설정
		Tellabel.setSize(200, 200); //전화번호 라벨 크기 설정
		Tellabel.setLocation(340, 380); //전화번호 라벨 위치 설정
		frame.add(Tellabel); //전화번호 라벨 출력
		
		frame.add(panel);
		frame.setResizable(false); //창 크기 조절 불가
		frame.setVisible(true); //창을 화면에 나타낼 것인지 설정
		frame.setSize(1530, 920); //창 크기 설정
		frame.setPreferredSize(new Dimension(1920,1080)); //Dimension객체를 인자로 받으면서 해당 컴포넌트 기본크기를 결정
		frame.setLocationRelativeTo(null); //화면을 중간에 띄움
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //창닫기 버튼을 활성화 시켜 X를 누르면 프로그램 종료
	}
	
	
	public static void main(String[] args) {
		new SearchIDPW();
	}
}
