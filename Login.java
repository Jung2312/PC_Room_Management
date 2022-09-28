package swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame {
	public Login() {
		JPanel panel = new JPanel();
		JLabel label = new JLabel("ID : ");
		JLabel paswd = new JLabel("Password : ");
		JTextField textID = new JTextField(10);
		JPasswordField textPass = new JPasswordField(10);
		JButton logBtn = new JButton("Log In");
		
		
		panel.add(label);
		panel.add(textID);
		panel.add(paswd);
		panel.add(textPass);
		panel.add(logBtn);
		
		logBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String id = "aadd201";
				String pass = "1111";
				
				if(id.equals(textID.getText()) && pass.equals(textPass.getText())) {
					JOptionPane.showMessageDialog(null, "Success");			
				}
				else {
					JOptionPane.showMessageDialog(null, "Fail");
				}
				
			}
			
		});
		
		add(panel);
		
		
		
		setVisible(true);		
		setSize(600,400);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new Login();
	}
}
