package com.houarizegai.calculator;

import java.awt.Cursor;
import java.awt.Font;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class divBtn extends optBtn {
	public divBtn(String symbol,int x,int y,int wBtn,int hBtn,Font btnFont,Cursor c, JTextField inText,JFrame window,boolean go[],boolean addWrite[],double val[],char opt[]) {
		super(symbol,x,y,wBtn,hBtn,btnFont,c,inText,window,go,addWrite,val,opt);
	}
	
	@Override
	protected double cal(double x, String input) {
		// TODO Auto-generated method stub
		double y = Double.parseDouble(input);
		chosen=false;
		return x/y;
	}

}
