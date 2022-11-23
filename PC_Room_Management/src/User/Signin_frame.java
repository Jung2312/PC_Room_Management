package User;
import javax.swing.*;	
import java.time.LocalDate;

import Btn_Design.RoundedButton;
import Btn_Design.RoundedButton3;
import Chat.InquiryPage;
import Main.MainLogin;
import Manager.manager_login;
import DB.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// 회원 가입
public class Signin_frame extends JFrame{
	Database db = new Database();
	
	public String Birthcheck(String str, String m, String d)
	{
		int size = str.length();
        
        if(size==7) {
        	if(m.length() == 1)
        	str = str.substring(0,4)+"-0"+str.substring(4,5)+"-"+str.substring(5,7);
        	else if(d.length() == 1)
        	{
        		str = str.substring(0,4)+"-"+str.substring(4,6)+"-0"+str.substring(5,7);
        	}
        }
        else if(size==8) {
            str = str.substring(0,4)+"-"+str.substring(4,6)+"-"+str.substring(6,8);
        }
        else if(size==6) {
        	str = str.substring(0,4)+"-0"+str.substring(4,5)+"-0"+str.substring(5,6);
        }
        System.out.println(str);
        return str;
	}

	
	public static void input_btn(JButton btn, int x, int y, int xsize, int ysize) {
		// 버튼 생성 메소드
		btn.setContentAreaFilled(false);
		btn.setBorderPainted(false); // 버튼 테두리 설정해제
		btn.setFocusPainted(false);
		btn.setBounds(x, y, xsize+2, ysize+2); // 버튼 위치, 사이즈
		
	}
	
	public static void label_text(JLabel label, int x, int y, int size, int font_size) {
		// 레이블 생성 메소드
		label.setFont(new Font("맑은 고딕", Font.BOLD, font_size)); // 폰트
		label.setBounds(x, y, size, font_size+5); // 레이블 위치, 사이즈
		
	}
	
	public static void text_field(JTextField field, int x, int y, int xsize, int ysize) {
		// 텍스트필드 생성 메소드
		field.setBounds(x, y, xsize, ysize); // 텍스트필드 위치, 사이즈
		
	}
	
	public static void birth_combo(JComboBox combo, int x, int y, int xsize, int ysize, int start, int end) {
		// 콤보 박스 생성 메소드
		combo.setBounds(x, y, xsize, ysize); // 콤보 박스 위치, 사이즈
		combo.setBackground(Color.WHITE);
		for(int i = start; i <= end; i++) {
			combo.addItem( Integer.valueOf(i));
		}
		
	}
	
	
	public Signin_frame(){
		
		String[] email = {"직접 입력","naver.com", "gmail.com", "daum.net","hanmail.net"}; // 이메일 콤보 박스 데이터
		// 버튼
		JButton home_btn = new JButton(new ImageIcon("./image/home_btn.png")); //홈버튼 생성
		input_btn(home_btn, 20, 20, 40, 40);
		add(home_btn); // 프레임에 버튼을 붙임
		
		RoundedButton user_inquiry = new RoundedButton("문의"); // 문의 버튼
		input_btn(user_inquiry, 1350,20, 80, 40);
		add(user_inquiry); // 프레임에 버튼을 붙임
		
		JButton setting_icon = new JButton(new ImageIcon("./image/setting_icon.png")); // 관리자 버튼
		input_btn(setting_icon, 1450, 20, 40, 40);
		add(setting_icon); // 프레임에 버튼을 붙임
		
		RoundedButton3 ID_checkicon = new RoundedButton3("중복확인"); // 아이디 중복 확인 버튼
		input_btn(ID_checkicon, 978, 320, 100, 30);
		add(ID_checkicon); // 프레임에 버튼을 붙임
		
		RoundedButton ok_btn = new RoundedButton("확인"); // 확인 버튼
		input_btn(ok_btn, 670, 700, 120, 30);
		add(ok_btn); // 프레임에 버튼을 붙임
		
		RoundedButton cancle_btn = new RoundedButton("취소"); // 취소 버튼
		input_btn(cancle_btn, 830, 700, 120, 30);
		add(cancle_btn); // 프레임에 버튼을 붙임
		
		
		// 레이블
		JLabel sign_label = new JLabel("회원 가입");
		label_text(sign_label,720, 140, 150,30);
		add(sign_label);
		
		JLabel name_label = new JLabel("이름");
		label_text(name_label,540, 260, 100, 20);
		add(name_label);
		
		JLabel ID_label = new JLabel("아이디");
		label_text(ID_label,540, 322, 100, 20);
		add(ID_label);
		
		JLabel PW_label = new JLabel("비밀번호");
		label_text(PW_label,540, 382, 100, 20);
		add(PW_label);
		
		JLabel birth_label = new JLabel("생년월일");
		label_text(birth_label,540, 442, 100, 20);
		add(birth_label);
		
		JLabel phone_label = new JLabel("휴대전화");
		label_text(phone_label,540, 502, 100, 20);
		add(phone_label);
		
		JLabel card_label = new JLabel("카드번호");
		label_text(card_label,540, 562, 100, 20);
		add(card_label);
		
		JLabel email_label = new JLabel("이메일");
		label_text(email_label,540, 622, 100, 20);
		add(email_label);
		
		JLabel email_label2 = new JLabel("@");
		label_text(email_label2,805, 630, 10, 10);
		add(email_label2);
		
		
		// 텍스트 필드 
		JTextField name_field = new JTextField();
		text_field(name_field, 660, 262, 300, 30);
		add(name_field);

		JTextField ID_field = new JTextField();
		text_field(ID_field, 660, 322, 300, 30);
		add(ID_field);

		JPasswordField PW_field = new JPasswordField();
		text_field(PW_field, 660, 382, 300, 30);
		add(PW_field);
		
		// 전화번호 필드
		JTextField phone1_field = new JTextField();
		text_field(phone1_field, 660, 502, 70, 30);
		add(phone1_field);
		
		JLabel line1_label = new JLabel("-"); // 전화번호 -
		label_text(line1_label, 748, 504, 100, 16);
		add(line1_label);
		
		JTextField phone2_field = new JTextField();
		text_field(phone2_field, 770, 502, 70, 30);
		add(phone2_field);
		
		JLabel line2_label = new JLabel("-"); // 전화번호 -
		label_text(line2_label, 862, 504, 100, 16);
		add(line2_label);
		
		JTextField phone3_field = new JTextField();
		text_field(phone3_field, 890, 502, 70, 30);
		add(phone3_field);
		
		//카드 필드
		JTextField card_field1 = new JTextField();
		text_field(card_field1, 660, 562, 60, 30);
		add(card_field1);
		
		JTextField card_field2 = new JTextField();
		text_field(card_field2, 740, 562, 60, 30);
		add(card_field2);
		
		JTextField card_field3 = new JTextField();
		text_field(card_field3, 820, 562, 60, 30);
		add(card_field3);
		
		JTextField card_field4 = new JTextField();
		text_field(card_field4, 900, 562, 60, 30);
		add(card_field4);
		
		//이메일 필드
		JTextField email_field = new JTextField();
		text_field(email_field, 660, 622, 140, 30);
		add(email_field);
		
		JTextField email_field2 = new JTextField();
		text_field(email_field2, 820, 622, 140, 30);
		add(email_field2);
		
		
		//콤보 박스
		JComboBox yearCombo = new JComboBox();
		birth_combo(yearCombo,660, 442, 70, 30,1950, 2010);
		add(yearCombo);
		
		JLabel year_label = new JLabel("년"); // 년 레이블
		label_text(year_label,740, 448, 100, 16);
		add(year_label);
		
		JComboBox monthCombo = new JComboBox();
		birth_combo(monthCombo,770, 442, 60, 30, 1, 12);
		add(monthCombo);
		
		JLabel month_label = new JLabel("월"); // 월 레이블
		label_text(month_label,840, 448, 100, 16);
		add(month_label);
		
		JComboBox dayCombo = new JComboBox();
		birth_combo(dayCombo,870, 442, 60, 30, 1, 31);
		add(dayCombo);
		
		JLabel day_label = new JLabel("일"); // 일 레이블
		label_text(day_label,940, 448, 100, 16);
		add(day_label);
		
		JComboBox email_combo = new JComboBox(email); // 이메일 콤보 박스
		email_combo.setBounds(980, 622, 100, 30);
		email_combo.setBackground(Color.WHITE);
		add(email_combo);
		
		
		//화면 설정
		setLayout(null); // 배치관리자 해제(절대 위치 지정)
		setSize(1530, 920); // 창 사이즈
		setResizable(false);
		setVisible(true); // 프레임 활성화
		setLocationRelativeTo(null); //창 모니터 가운데 정렬
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x를 누를 경우 종료
		getContentPane().setBackground(Color.WHITE); // 프레임 bg color
		
		
		email_combo.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e) {
				
				JComboBox cb = (JComboBox) e.getSource(); // 콤보박스 알아내기
                int index = cb.getSelectedIndex();// 선택된 아이템의 인덱스
				if(email[index] != "직접 입력")
				{
	                 email_field2.setText(email[index]);
				}
				  
			}
			
		});
		
		//이벤트 처리 추가
		ID_checkicon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/* <-- 아이디 중복 체크 이벤트 --> */
				JButton b = (JButton)e.getSource();
				if(b.getText().equals("중복확인")) {
					if(db.findExistID(ID_field.getText())) {
						JOptionPane.showMessageDialog(null, "이미 사용중인 아이디입니다.", "아이디 중복체크", JOptionPane.ERROR_MESSAGE);
						ID_field.grabFocus();
						return;
					}
					else {
						JOptionPane.showMessageDialog(null, "사용가능한 아이디입니다.", "아이디 중복 체크", JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
		});
		
		ok_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton b = (JButton)e.getSource();
				
				/* TextField에 입력된 회원 정보들을 변수에 초기화 */
				String uid = ID_field.getText();
				String upass = "";
				for(int i=0; i<PW_field.getPassword().length; i++) {
					upass = upass + PW_field.getPassword()[i];
				}
				String uname = name_field.getText();
				String uphone = phone1_field.getText() + phone2_field.getText() + phone3_field.getText();
				String ucard = card_field1.getText() + card_field2.getText() + card_field3.getText() + card_field4.getText();
				String uemail = email_field.getText() + "@" + email_field2.getText();
				String uyear = yearCombo.getSelectedItem().toString() + monthCombo.getSelectedItem().toString() + dayCombo.getSelectedItem().toString();
				
				//String uAcc = "0";
				//String uCheck = "0";
				System.out.println(uid);
				System.out.println(upass);
				System.out.println(uname);
				System.out.println(uphone);
				System.out.println(ucard);
				System.out.println(uemail);
				System.out.println(uyear);
				
				LocalDate current_date = LocalDate.now();
				int uage = (current_date.getYear() - (int)yearCombo.getSelectedItem()) + 1;
				
								
				/* 가입하기 버튼 이벤트 */
				// 실패하면 무조건 프로그램이 꺼짐 -> 수정 요망 계속 켜져있도록 해야함
				if(b.getText().equals("확인")) {
					if(uid.equals("") || upass.equals("") || uname.equals("") || uphone.equals("") && ucard.equals("")
		                     || uemail.equals("") || uyear.equals("") || (uage == 0))
					{
						JOptionPane.showMessageDialog(null, "모든 정보를 기입해주세요", "회원가입 실패", JOptionPane.ERROR_MESSAGE);
						System.out.println("회원가입 실패 > 회원정보 미입력");
					}
					
					else
					{
						 
							// 카드번호 전화번호가 존재하는지를 먼저 판별하고 회원 가입하기.
							if((!(ucard.length() == 16) && (!(uphone.length() == 11))))
							{
								JOptionPane.showMessageDialog(null, "카드번호는 16자리, 전화번호는 11자리로 입력하세요.");
							}
							
							else if(!(ucard.length() == 16))
							{
								JOptionPane.showMessageDialog(null, "카드번호는 16자리로 입력하세요.");
								
							}
							
							else if((!(uphone.length() == 11)))
							{
								JOptionPane.showMessageDialog(null, "전화번호는 11자리로 입력하세요.");
							}
							
							else
							{
								if(db.joinCheck(uid, upass, uname, uage, uemail, ucard, Birthcheck(uyear, monthCombo.getSelectedItem().toString() , dayCombo.getSelectedItem().toString()), uphone)) {

										System.out.println("회원가입 성공");
										JOptionPane.showMessageDialog(null, "회원가입 성공!");
										db.dbclose();
										new Loginpage(); //회원가입 성공시 ID로그인 페이지로 이동
										setVisible(false);
									} 
								
								else {
									System.out.println("회원가입 실패");
									JOptionPane.showMessageDialog(null, "회원가입 실패");
									ID_field.setText("");
									}
							
							}
							
					}
						/* 빈칸이 없을시 회원가입이 되는 코드 */
					
					
					
				}
			}
		});
		
		home_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				db.dbclose();
				new MainLogin(); //홈 버튼을 누르면 첫 화면으로 이동
				setVisible(false);
			}
		});

		user_inquiry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				db.dbclose();
				new InquiryPage(); //문의 버튼을 누르면 문의 페이지로 이동
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
		
		cancle_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				db.dbclose();
				new MainLogin(); //취소 버튼을 누르면 로그인 페이지로 이동
				setVisible(false);
			}
		});
		
	}

	public static void main(String[] args) {
		new Signin_frame();

	}

}
