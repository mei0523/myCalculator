package com.houarizegai.calculator;
import java.awt.Cursor;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class backBtn extends otherBtn{
	public backBtn(String symbol,int x,int y,int wBtn,int hBtn,Font btnFont, JTextField inText,JFrame window) {
		btn=new JButton(symbol);
		btn.setBounds(x,y,wBtn,hBtn);
        btn.setFont(btnFont);
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn.addActionListener(event -> {
        	inText.setFont(inText.getFont().deriveFont(Font.PLAIN));
            String str = inText.getText();
            StringBuilder str2 = new StringBuilder();
            for (int i = 0; i < (str.length() - 1); i++) {
                str2.append(str.charAt(i));
            }
            if (str2.toString().equals("")) {
                inText.setText("0");
            } else {
                inText.setText(str2.toString());
            }
        });
        window.add(btn);
		}
}
