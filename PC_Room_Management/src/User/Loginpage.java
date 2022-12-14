package User;
import java.awt.*;	
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import Btn_Design.*;
import Chat.InquiryPage;
import Main.MainLogin;
import Manager.manager_login;
import DB.*;
import Select.*;

// 회원 로그인
public class Loginpage {
	Database db = new Database();
	
	public Loginpage() {
		RoundedButton okbtn = new RoundedButton("확인"); // 확인 버튼
		RoundedButton cancle = new RoundedButton("취소"); // 취소 버튼
		JButton home = new JButton(new ImageIcon("image/home_btn.png")); //홈 버튼 할당
		RoundedButton inquiry = new RoundedButton("문의"); // 문의 버튼
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
		
		panel.setBackground(Color.WHITE); //흰색 RGB코드, 불투명하게
		
		btnPanel.add(inquiry); //문의 버튼
		btnPanel.add(setting); //설정 버튼
		btnPanel.add(home); // 홈 버튼
		btnPanel.add(searchbtn); //아이디, 비밀번호 찾기 버튼
		btnPanel.add(okbtn); //확인 버튼
		btnPanel.add(cancle); //취소 버튼
		
		home.setSize(50, 50); //홈 버튼 크기
		home.setLocation(20, 20); //홈 버튼 위치
		home.setBorderPainted(false); //홈 버튼 테두리(외곽선) 없앰
		home.setFocusPainted(false); //홈 버튼이 선택되었을 때 생기는 테두리 사용 안함
		home.setContentAreaFilled(false); //홈 버튼 영역 채우지 않음
		frame.add(home); //홈 버튼 출력
		
		inquiry.setSize(80, 40); //문의 버튼 크기
		inquiry.setLocation(1350, 30); // 문의 버튼 위치
		inquiry.setBorderPainted(false); //문의 버튼 테두리(외곽선) 없앰
		inquiry.setFocusPainted(false); //문의 버튼이 선택되었을 때 생기는 테두리 사용 안함
		inquiry.setContentAreaFilled(false); //문의 버튼 영역 채우지 않음
		frame.add(inquiry); //문의 버튼 출력
		
		
		setting.setSize(60, 60); //설정 버튼 크기
		setting.setLocation(1450, 20); //설정 버튼 위치
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
		cancle.setLocation(795, 700);
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
		login.setLocation(680, 90); //로그인 라벨 위치 설정
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
		frame.setSize(1530, 920); //창 크기 설정
		frame.setPreferredSize(new Dimension(1920,1080)); //Dimension객체를 인자로 받으면서 해당 컴포넌트 기본크기를 결정
		frame.setLocationRelativeTo(null); //화면을 중간에 띄움
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //창닫기 버튼을 활성화 시켜 X를 누르면 프로그램 종료
		
		//이벤트 처리 추가
		home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				db.dbclose();
				new MainLogin(); //홈 버튼을 누르면 첫 화면으로 이동
				frame.setVisible(false);
			}
		});
		
		setting.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				db.dbclose();
				new manager_login(); //설정 버튼을 누르면 관리자 로그인 페이지로 이동
				frame.setVisible(false);
			}
			
		});

		inquiry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				db.dbclose();
				new InquiryPage(); //문의 버튼을 누르면 문의 페이지로 이동
				frame.setVisible(false);
			}
		});
		
		searchbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				db.dbclose();
				new SearchIDPW(); //아이디 찾기를 누를시 아이디 찾는 페이지로 이동
				frame.setVisible(false);
			}
		});
		
		okbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton b = (JButton)e.getSource();
				
				/* TextField에 입력된 아이디와 비밀번호를 변수에 초기화 */
				String uid = getID.getText();
				String upass = "";
				for(int i=0; i<getPW.getPassword().length; i++) {
					upass = upass + getPW.getPassword()[i];
				}
							
				
				/* 로그인 버튼 이벤트 */
				if(b.getText().equals("확인")) {
					if(uid.equals("") || upass.equals("")) {
						JOptionPane.showMessageDialog(null, "아이디와 비밀번호 모두 입력해주세요", "로그인 실패", JOptionPane.ERROR_MESSAGE);
						System.out.println("로그인 실패 > 로그인 정보 미입력");
					}
					
					else if(uid != null && upass != null) {
						/* 로그인 데이터를 DB와 비교하는 문장 */
						if(db.logincheck(uid, upass)) {	
							System.out.println("로그인 성공");
							JOptionPane.showMessageDialog(null, "로그인에 성공하였습니다");
							db.dbclose();
							new SeatFood_select(); //로그인 성공시 자리배치 페이지로 이동
							frame.setVisible(false);
						} else {
							System.out.println("로그인 실패 > 로그인 정보 불일치");
							JOptionPane.showMessageDialog(null, "로그인에 실패하였습니다");
						}
					}
				}
			}
		});
		
		cancle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				db.dbclose();
				new Login_QR_ID(); //취소 버튼을 누르면 로그인선택 페이지로 이동
				frame.setVisible(false);
			}
		});
	}
	
	public static void main(String[] args) {
		new Loginpage();
	}
}