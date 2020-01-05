package com.houarizegai.calculator;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.util.regex.Pattern;

import javax.swing.*;

public abstract class optBtn{
	
	protected JButton btn;
	protected boolean chosen=false;
	protected abstract double cal(double x, String input);
	
	public optBtn(String symbol,int x,int y,int wBtn,int hBtn,Font btnFont,Cursor c, JTextField inText,JFrame window,boolean go[],boolean addWrite[],double val[],char opt[]) {
		btn=new JButton(symbol);
		btn.setBounds(x, y, wBtn, hBtn);
	    btn.setFont(btnFont);
	    btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
	    btn.addActionListener(event -> {
	    	inText.setFont(inText.getFont().deriveFont(Font.PLAIN));
	        if (Pattern.matches("([-]?\\d+[.]\\d*)|(\\d+)", inText.getText()))
	            if (go[0]) {
	            	
	            	val[0]=Double.parseDouble(inText.getText());
	                inText.setFont(inText.getFont().deriveFont(Font.PLAIN));
	                
	                if (Pattern.matches("[-]?[\\d]+[.][0]*", String.valueOf(val[0]))) {
	                    inText.setText(String.valueOf((int) val[0]));
	                } else {
	                    inText.setText(String.valueOf(val[0]));
	                }
	                go[0] = false;
	                addWrite[0] = false;
	                opt[0] = symbol.charAt(0);
	            }
	        opt[0] = symbol.charAt(0);
	        chosen=true;
	    });
	    window.add(btn);
	}
	
	public boolean checkChosen() {
		return chosen;
	}
	public void setBackForeground(Color b,Color f) {
		btn.setBackground(b);
		btn.setForeground(f);
	}
}
 