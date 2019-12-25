package com.houarizegai.calculator;

import java.awt.Cursor;
import java.awt.Font;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class addBtn extends optBtn {
	public addBtn(String symbol,int x,int y,int wBtn,int hBtn,Font btnFont,Cursor c, 
			JTextField inText,JFrame window,boolean go[],boolean addWrite[],double val[],char opt[]) {
		btn=new JButton(symbol);
		btn.setBounds(x, y, wBtn, hBtn);
	    btn.setFont(btnFont);
	    btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
	    btn.addActionListener(event -> {
	    	inText.setFont(inText.getFont().deriveFont(Font.PLAIN));
	        if (Pattern.matches("([-]?\\d+[.]\\d*)|(\\d+)", inText.getText()))
	            if (go[0]) {
	            	System.out.println("Enter sub go in");
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
	
	@Override
	protected double cal(double x, String input) {
		// TODO Auto-generated method stub
		double y = Double.parseDouble(input);
		chosen=false;
		return x+y;
	}

}
