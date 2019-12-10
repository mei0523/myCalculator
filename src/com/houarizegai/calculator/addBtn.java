package com.houarizegai.calculator;

import java.awt.Cursor;
import java.awt.Font;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class addBtn extends optBtn {
	//private JButton btn;
	public addBtn(String symbol,int x,int y,int wBtn,int hBtn,Font btnFont,Cursor c, JTextField inText,JFrame window) {
		btn=new JButton(symbol);
	btn.setBounds(x, y, wBtn, hBtn);
    btn.setFont(btnFont);
    btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
    btn.addActionListener(event -> {
        //repaintFont();
        /*if (Pattern.matches("([-]?\\d+[.]\\d*)|(\\d+)", inText.getText()))
            if (go) {
                val = calc(val, inText.getText(), opt);
                if (Pattern.matches("[-]?[\\d]+[.][0]*", String.valueOf(val))) {
                    inText.setText(String.valueOf((int) val));
                } else {
                    inText.setText(String.valueOf(val));
                }
                go = false;
                addWrite = false;
            }*/
    });
    window.add(btn);
	}
	
	@Override
	public double cal(double x, String input) {
		// TODO Auto-generated method stub
		double y = Double.parseDouble(input);
		return x+y;
	}

}
