
package com.houarizegai.calculator;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;
import java.awt.Color;
import java.awt.Component;

import javax.swing.*;
import java.util.*;

public class Calculator {

    private JFrame window; // This is Main Window
    private JTextField inText, affichageCalc; // Input Text
    private JButton btnC, btnBack, btnMod, btnDiv, btnMul, btnSub, btnAdd, btnPoint, btnEqual, choixColor;
    private List<JButton> numBtn;
    private char opt = ' ';             // Storage Oparator
    private boolean go = true,          // Faire Calcule Avec Opt != (=)
            addWrite = true;    // Racordé des Nombres dans l'Affichage
    private double val = 0; // Storage Values For Calcule
    private boolean bool = false;
    //private int num=1;
    /*
        Mx Calculator: 
        X = Ligne
        Y = Column
    
        +-------------------+
        |   +-----------+   |   y[0]
        |   |           |   |
        |   +-----------+   |
        |                   |
        |   C  <-   %   /   |   y[1]
        |   7   8   9   *   |   y[2]
        |   4   5   6   -   |   y[3]
        |   1   2   3   +   |   y[4]
        |   .   0     =     |   y[5]
        +-------------------+
         x[0] x[1] x[2] x[3]
    
    */
    
    /*    
        +-------------------+
        |   +-----------+   |   y[0]
        |   |           |   |
        |   +-----------+   |
        |                   |
        |   0   1   1   3   |   y[1]
        |   4   5   6   7   |   y[2]
        |   8   9   10  11  |   y[3]
        |   12  13  14  15  |   y[4]
        |   16  17    18    |   y[5]
        +-------------------+
         x[0] x[1] x[2] x[3]
    
    */

    private Calculator() {
    	numBtn= new ArrayList<>();
    	
        window = new JFrame("Calculator");
        window.setSize(410,600); // Height And Width Of Window
        window.setLocationRelativeTo(null); // Move Window To Center
        
        Font btnFont = new Font("Comic Sans MS", Font.PLAIN, 28);
        
        choixColor = new JButton();
        choixColor.setBounds(200, 30, 140, 18);
        choixColor.setText("Toggle colors");
        choixColor.setBackground(Color.GREEN.darker());
        choixColor.setForeground(Color.WHITE);
        choixColor.setCursor(new Cursor(Cursor.HAND_CURSOR));
        choixColor.addActionListener(event -> themeColor());
        window.add(choixColor);

        int wBtn = 80;// Width Button
        // Height Button
        int hBtn = 70;
        int marginX = 20;
        int marginY = 60;
        int[] x = {marginX, marginX + 90, 200, 290};
        int[] y = {marginY, marginY + 100, marginY + 180, marginY + 260, marginY + 340, marginY + 420};

        inText = new JTextField("0");
        inText.setBounds(x[0],y[0],350,70);
        inText.setEditable(false);
        inText.setBackground(Color.WHITE);
        inText.setFont(new Font("Comic Sans MS", Font.PLAIN, 33));
        window.add(inText);
        
        btnC = new JButton("C");
        btnC.setBounds(x[0],y[1],wBtn,hBtn);
        btnC.setFont(btnFont);
        btnC.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnC.addActionListener(event -> {
            repaintFont();
            inText.setText("0");
            opt = ' ';
            val = 0;
        });
        window.add(btnC);
                
        btnBack = new JButton("<-");
        btnBack.setBounds(x[1],y[1],wBtn,hBtn);
        btnBack.setFont(btnFont);
        btnBack.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnBack.addActionListener(event -> {
            repaintFont();
            String str = inText.getText();
            StringBuilder str2 = new StringBuilder();
            for (int i = 0; i < (str.length() - 1); i++) {
                str2.append(str.charAt(i));
            }
            if (str2.toString().equals("")) {
                inText.setText("0");
            } else {
                inText.setText(str2.toString());
            }
        });
        window.add(btnBack);
        
        btnMod = new JButton("%");
        btnMod.setBounds(x[2],y[1],wBtn,hBtn);
        btnMod.setFont(btnFont);
        btnMod.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnMod.addActionListener(event -> {
            repaintFont();
            if (Pattern.matches("([-]?\\d+[.]\\d*)|(\\d+)", inText.getText()))
                if (go) {
                    val = calc(val, inText.getText(), opt);
                    if (Pattern.matches("[-]?[\\d]+[.][0]*", String.valueOf(val))) {
                        inText.setText(String.valueOf((int) val));
                    } else {
                        inText.setText(String.valueOf(val));
                    }
                    opt = '%';
                    go = false;
                    addWrite = false;
                }
        });
        window.add(btnMod);
        
        btnDiv = new JButton("/");
        btnDiv.setBounds(x[3],y[1],wBtn,hBtn);
        btnDiv.setFont(btnFont);
        btnDiv.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnDiv.addActionListener(event -> {
            repaintFont();
            if (Pattern.matches("([-]?\\d+[.]\\d*)|(\\d+)", inText.getText()))
                if (go) {
                    val = calc(val, inText.getText(), opt);
                    if (Pattern.matches("[-]?[\\d]+[.][0]*", String.valueOf(val))) {
                        inText.setText(String.valueOf((int) val));
                    } else {
                        inText.setText(String.valueOf(val));
                    }
                    opt = '/';
                    go = false;
                    addWrite = false;
                } else {
                    opt = '/';
                }
        });
        window.add(btnDiv);
        
        
        btnMul = new JButton("*");
        btnMul.setBounds(x[3],y[2],wBtn,hBtn);
        btnMul.setFont(btnFont);
        btnMul.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnMul.addActionListener(event -> {
            repaintFont();
            if (Pattern.matches("([-]?\\d+[.]\\d*)|(\\d+)", inText.getText()))
                if (go) {
                    val = calc(val, inText.getText(), opt);
                    if (Pattern.matches("[-]?[\\d]+[.][0]*", String.valueOf(val))) {
                        inText.setText(String.valueOf((int) val));
                    } else {
                        inText.setText(String.valueOf(val));
                    }
                    opt = '*';
                    go = false;
                    addWrite = false;
                } else {
                    opt = '*';
                }
        });
        window.add(btnMul);
        
        btnSub = new JButton("-");
        btnSub.setBounds(x[3],y[3],wBtn,hBtn);
        btnSub.setFont(btnFont);
        btnSub.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnSub.addActionListener(event -> {
            repaintFont();
            if (Pattern.matches("([-]?\\d+[.]\\d*)|(\\d+)", inText.getText()))
                if (go) {
                    val = calc(val, inText.getText(), opt);
                    if (Pattern.matches("[-]?[\\d]+[.][0]*", String.valueOf(val))) {
                        inText.setText(String.valueOf((int) val));
                    } else {
                        inText.setText(String.valueOf(val));
                    }

                    opt = '-';
                    go = false;
                    addWrite = false;
                } else {
                    opt = '-';
                }
        });
        window.add(btnSub);
        
       /* btnAdd = new JButton("+");
        btnAdd.setBounds(x[3], y[4], wBtn, hBtn);
        btnAdd.setFont(btnFont);
        btnAdd.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnAdd.addActionListener(event -> {
            repaintFont();
            if (Pattern.matches("([-]?\\d+[.]\\d*)|(\\d+)", inText.getText()))
                if (go) {
                    val = calc(val, inText.getText(), opt);
                    if (Pattern.matches("[-]?[\\d]+[.][0]*", String.valueOf(val))) {
                        inText.setText(String.valueOf((int) val));
                    } else {
                        inText.setText(String.valueOf(val));
                    }
                    opt = '+';
                    go = false;
                    addWrite = false;
                } else {
                    opt = '+';
                }
        });
        window.add(btnAdd);*/
        optBtn addB=new addBtn("+",x[3], y[4],wBtn, hBtn,btnFont,new Cursor(Cursor.HAND_CURSOR), inText,window);
        //window.add();
        
        btnPoint = new JButton(".");
        btnPoint.setBounds(x[0],y[5],wBtn,hBtn);
        btnPoint.setFont(new Font("Comic Sans MS", Font.BOLD, 32));
        btnPoint.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnPoint.addActionListener(event -> {
            repaintFont();
            if (addWrite) {
                inText.setText(inText.getText() + ".");
            } else {
                inText.setText("0.");
                addWrite = true;
            }
            go = true;
        });
        window.add(btnPoint);
        

        
        btnEqual = new JButton("=");
        btnEqual.setBounds(x[2],y[5],2*wBtn+10,hBtn);
        btnEqual.setFont(btnFont);
        btnEqual.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnEqual.addActionListener(event -> {
            if (Pattern.matches("([-]?\\d+[.]\\d*)|(\\d+)", inText.getText()))
                if (go) {
                    val = calc(val, inText.getText(), opt);
                    if (Pattern.matches("[-]?[\\d]+[.][0]*", String.valueOf(val))) {
                        inText.setText(String.valueOf((int) val));
                    } else {
                        inText.setText(String.valueOf(val));
                    }
                    opt = '=';
                    addWrite = false;
                }
        });
        window.add(btnEqual);
        window.setLayout(null);
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // If Click into The Red Button => End The Processus
        window.setVisible(true);
        
        //�Ʀr���s��l��
        JButton btn0 = new JButton("0");
        btn0.setBounds(x[1],y[5],wBtn,hBtn);
        btn0.setFont(btnFont);
        btn0.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn0.addActionListener(event -> {
            repaintFont();
            if (addWrite) {
                if (Pattern.matches("[0]*", inText.getText())) {
                    inText.setText("0");
                } else {
                    inText.setText(inText.getText() + "0");
                }
            } else {
                inText.setText("0");
                addWrite = true;
            }
            go = true;
        });
        numBtn.add(btn0);
        window.add(btn0);
        int num=1;
    	for(int i=4;i>1;--i) {
    		for(int j=0;j<3;++j) {
    			JButton btn = new JButton(Integer.toString(num));
                btn.setBounds(x[j],y[i],wBtn,hBtn);
                btn.setFont(btnFont);
                btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
                btn.addActionListener(event -> {
                    repaintFont();
                    if (addWrite) {
                        if (Pattern.matches("[0]*", inText.getText())) {
                            inText.setText( btn.getText());
                        } else {
                            inText.setText(inText.getText() +  btn.getText());
                        }
                    } else {
                        inText.setText( btn.getText());
                        addWrite = true;
                    }
                    go = true;
                });
                numBtn.add(btn);
                window.add(btn);
    			num=num+1;
    		}
    	}
    }

    private double calc(double x, String input, char opt) {
        inText.setFont(inText.getFont().deriveFont(Font.BOLD));
        double y = Double.parseDouble(input);
        if (opt == '+') {
            return x + y;
        } else if (opt == '-') {
            return x - y;
        } else if (opt == '*') {
            return x * y;
        } else if (opt == '/') {
            return x / y;
        } else if (opt == '%') {
            return x % y;
        }
        inText.setFont(inText.getFont().deriveFont(Font.PLAIN));
        return y;
    }

    private void repaintFont() {
        inText.setFont(inText.getFont().deriveFont(Font.PLAIN));
    }

    private void themeColor() {

        if (bool) {
            choixColor.setText("Toggle colors");
            choixColor.setBackground(Color.GREEN.darker());
            choixColor.setForeground(Color.WHITE);
            btnC.setBackground(null);
            btnBack.setBackground(null);
            btnMod.setBackground(null);
            btnDiv.setBackground(null);
            btnMul.setBackground(null);
            btnSub.setBackground(null);
            btnAdd.setBackground(null);
            btnEqual.setBackground(null);
            /*btn0.setBackground(null);
            btn1.setBackground(null);
            btn2.setBackground(null);
            btn3.setBackground(null);
            btn4.setBackground(null);
            btn5.setBackground(null);
            btn6.setBackground(null);
            btn7.setBackground(null);
            btn8.setBackground(null);
            btn9.setBackground(null);*/
            btnPoint.setBackground(null);

            btnC.setForeground(Color.BLACK);
            btnBack.setForeground(Color.BLACK);
            btnMod.setForeground(Color.BLACK);
            btnDiv.setForeground(Color.BLACK);
            btnMul.setForeground(Color.BLACK);
            btnSub.setForeground(Color.BLACK);
            btnAdd.setForeground(Color.BLACK);
            btnEqual.setForeground(Color.BLACK);

            bool = false;
        } else {
            choixColor.setText("Untoggle colors");
            choixColor.setBackground(null);
            choixColor.setForeground(Color.BLACK);
            btnC.setBackground(Color.RED);
            btnBack.setBackground(Color.ORANGE);
            btnMod.setBackground(Color.GREEN);
            btnDiv.setBackground(Color.PINK);
            btnMul.setBackground(Color.PINK);
            btnSub.setBackground(Color.PINK);
            btnAdd.setBackground(Color.PINK);
            btnEqual.setBackground(Color.BLUE);
            /*btn0.setBackground(Color.WHITE);
            btn1.setBackground(Color.WHITE);
            btn2.setBackground(Color.WHITE);
            btn3.setBackground(Color.WHITE);
            btn4.setBackground(Color.WHITE);
            btn5.setBackground(Color.WHITE);
            btn6.setBackground(Color.WHITE);
            btn7.setBackground(Color.WHITE);
            btn8.setBackground(Color.WHITE);
            btn9.setBackground(Color.WHITE);*/
            btnPoint.setBackground(Color.WHITE);

            btnC.setForeground(Color.WHITE);
            btnBack.setForeground(Color.WHITE);

            btnMod.setForeground(Color.WHITE);
            btnDiv.setForeground(Color.WHITE);
            btnMul.setForeground(Color.WHITE);
            btnSub.setForeground(Color.WHITE);
            btnAdd.setForeground(Color.WHITE);
            btnEqual.setForeground(Color.WHITE);
            bool = true;
        }
        
}
   
    public static void main(String[] args) {
        new Calculator();
    }
}