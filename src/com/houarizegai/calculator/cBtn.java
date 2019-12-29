package com.houarizegai.calculator;
import java.awt.Cursor;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class cBtn extends otherBtn{
	public cBtn(String symbol,int x,int y,int wBtn,int hBtn,Font btnFont, JTextField inText,JFrame window,boolean go[],boolean addWrite[],double val[],char opt[]) {
		btn=new JButton(symbol);
		btn.setBounds(x,y,wBtn,hBtn);
        btn.setFont(btnFont);
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn.addActionListener(event -> {
        	inText.setFont(inText.getFont().deriveFont(Font.PLAIN));
            inText.setText("0");
            opt[0] = ' ';
            val[0] = 0;
        });
        window.add(btn);
	}
}
