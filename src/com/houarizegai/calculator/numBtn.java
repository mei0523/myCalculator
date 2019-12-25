package com.houarizegai.calculator;

import java.awt.Cursor;
import java.awt.Font;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class numBtn {
	private JButton btn;
	public numBtn(String number,int x,int y,int wBtn,int hBtn,Font btnFont,
			JTextField inText,JFrame window,boolean go[],boolean addWrite[]){
		btn = new JButton(number);
        btn.setBounds(x,y,wBtn,hBtn);
        btn.setFont(btnFont);
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn.addActionListener(event -> {
        	inText.setFont(inText.getFont().deriveFont(Font.PLAIN));
            if (addWrite[0]) {
                if (Pattern.matches("[0]*", inText.getText())) {
                    inText.setText(number);
                } else {
                    inText.setText(inText.getText() + number);
                }
            } else {
                inText.setText(number);
                addWrite[0] = true;
            }
            go[0] = true;
        });
        window.add(btn);
	}

}
