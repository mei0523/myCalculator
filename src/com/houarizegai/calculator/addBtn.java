package com.houarizegai.calculator;

public class addBtn extends optBtn {

	@Override
	public double cal(double x, String input) {
		// TODO Auto-generated method stub
		double y = Double.parseDouble(input);
		return x+y;
	}

}
