package com.houarizegai.calculator;

import java.awt.Cursor;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class rootBtn extends optBtn{

	public rootBtn(String symbol, int x, int y, int wBtn, int hBtn, Font btnFont, Cursor c, JTextField inText,
			JFrame window, boolean[] go, boolean[] addWrite, double[] val, char[] opt) {
		super(symbol, x, y, wBtn, hBtn, btnFont, c, inText, window, go, addWrite, val, opt);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected double cal(double x, String input) {
		// TODO Auto-generated method stub
		double y = Double.parseDouble(input);
		chosen=false;
		return Math.pow(x, 1/y);
	}

}
