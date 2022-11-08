package Btn_Design;

import javax.swing.*;

import java.awt.*;
import java.applet.*;


public class RoundedButton4 extends JButton{
	public static void r_btn() {
			
		}

	public RoundedButton4() { super(); decorate(); } 
	public RoundedButton4(String text) { super(text); decorate(); } 
	public RoundedButton4(Action action) { super(action); decorate(); } 
	public RoundedButton4(Icon icon) { super(icon); decorate(); } 
	public RoundedButton4(String text, Icon icon) { super(text, icon); decorate(); } 
	protected void decorate() { setBorderPainted(false); setOpaque(false); }
	
	@Override 
	protected void paintComponent(Graphics g) {
		Color c=new Color(240, 240, 240); //배경색 결정
		Color o=new Color(0,0,0); //글자색 결정
		int width = getWidth(); 
		int height = getHeight(); 
		Graphics2D graphics = (Graphics2D) g; 
		graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); 
		if (getModel().isArmed()) { graphics.setColor(c.darker()); } 
		else if (getModel().isRollover()) { graphics.setColor(c.brighter()); } 
		else { graphics.setColor(c); } 
		graphics.fillRoundRect(0, 0, width, height, 10, 10); 
		FontMetrics fontMetrics = graphics.getFontMetrics(); 
		Rectangle stringBounds = fontMetrics.getStringBounds(this.getText(), graphics).getBounds(); 
		double textX = (width - stringBounds.width) / 3.2; //텍스트 가로 위치, 크기에 따라 조정해야함
		int textY = (height - stringBounds.height) / 2 + fontMetrics.getAscent(); 
		graphics.setColor(o); 
		graphics.setFont(new Font("맑은 고딕", Font.BOLD, 16)); 
		graphics.drawString(getText(), (int)textX, textY); 
		graphics.dispose(); 
		super.paintComponent(g); 
	}
}
