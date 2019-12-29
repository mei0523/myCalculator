package com.houarizegai.calculator;

import java.awt.Color;
import javax.swing.*;

public abstract class optBtn{
	protected JButton btn;
	protected boolean chosen=false;
	protected abstract double cal(double x, String input);
	public boolean checkChosen() {
		return chosen;
	}
	public void setBackForeground(Color b,Color f) {
		btn.setBackground(b);
		btn.setForeground(f);
	}
}
 