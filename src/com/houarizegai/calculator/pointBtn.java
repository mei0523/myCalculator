package com.houarizegai.calculator;

import java.awt.Cursor;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class pointBtn {
	private JButton btn;
	public pointBtn(String symbol,int x,int y,int wBtn,int hBtn,Font btnFont, JTextField inText,JFrame window,boolean go[],boolean addWrite[]) {
		btn=new JButton(symbol);
		 btn.setBounds(x,y,wBtn,hBtn);
	        btn.setFont(new Font("Comic Sans MS", Font.BOLD, 32));
	        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
	        btn.addActionListener(event -> {
	        	inText.setFont(inText.getFont().deriveFont(Font.PLAIN));
	            if (addWrite[0]) {
	                inText.setText(inText.getText() + ".");
	            } else {
	                inText.setText("0.");
	                addWrite[0] = true;
	            }
	            go[0] = true;
	        });
	        window.add(btn);
	}
}
