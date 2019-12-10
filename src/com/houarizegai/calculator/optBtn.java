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
	protected JButton btn;
	protected double val;
	public abstract double cal(double x, String input);
	/*private void repaintFont() {
        inText.setFont(inText.getFont().deriveFont(Font.PLAIN));
    }*/
}
 