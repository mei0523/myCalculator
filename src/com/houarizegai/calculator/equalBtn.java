package com.houarizegai.calculator;

import java.awt.Cursor;
import java.awt.Font;
import java.util.List;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class equalBtn extends otherBtn{
	public equalBtn(String symbol,int x,int y,int wBtn,int hBtn,Font btnFont,Cursor c, 
			JTextField inText,JFrame window,boolean go[],boolean addWrite[],double val[],
			char opt[],List<optBtn> operateBtn) {
		btn=new JButton(symbol);
		btn.setBounds(x, y, wBtn, hBtn);
	    btn.setFont(btnFont);
	    btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
	    btn.addActionListener(event -> {
	    	inText.setFont(inText.getFont().deriveFont(Font.PLAIN));
	    	if (Pattern.matches("([-]?\\d+[.]\\d*)|(\\d+)", inText.getText()))
                if (go[0]) {
                	for(int i=0;i<operateBtn.size();++i) {
                		if(operateBtn.get(i).checkChosen()) {
                			val[0]=operateBtn.get(i).cal(val[0], inText.getText());
                		}
                	}
                    if (Pattern.matches("[-]?[\\d]+[.][0]*", String.valueOf(val[0]))) {
                        inText.setText(String.valueOf((int) val[0]));
                    } else {
                        inText.setText(String.valueOf(val[0]));
                    }
                    opt[0] = '=';
                    addWrite[0] = false;
                }
	    });
	    window.add(btn);
	}
}
