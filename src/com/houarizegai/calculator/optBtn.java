package com.houarizegai.calculator;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;
import java.awt.Color;
import java.awt.Component;
import javax.swing.*;

public abstract class optBtn{
	private JButton btn;
	public abstract double cal(double x, String input);
}
