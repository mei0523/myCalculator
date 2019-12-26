
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
    private JTextField inText; // Input Text
    private JButton btnC, btnBack, btnMod, btnDiv, btnMul, btnSub, btnAdd, btnPoint, btnEqual, choixColor;
    private List<optBtn> operateBtn;
    private char opt[] = {' '};            
    private boolean go[] = {true},         
            addWrite[] = {true};    
    private double val[] = {0};
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
    	operateBtn=new ArrayList<>();
    	
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
        
        cBtn cB=new cBtn("C",x[0],y[1],wBtn,hBtn,btnFont,inText,window,go,addWrite,val,opt);
        
        backBtn backB=new backBtn("<-",x[1],y[1],wBtn,hBtn,btnFont,inText,window);
        
        equalBtn equalB=new equalBtn("=",x[2],y[5],2*wBtn+10, hBtn,btnFont,new Cursor(Cursor.HAND_CURSOR), inText,window,go,addWrite,val,opt,operateBtn);
      
        optBtn addB=new addBtn("+",x[3], y[4],wBtn, hBtn,btnFont,new Cursor(Cursor.HAND_CURSOR), inText,window,go,addWrite,val,opt);
        operateBtn.add(addB);
        optBtn subB=new subBtn("-",x[3], y[3],wBtn, hBtn,btnFont,new Cursor(Cursor.HAND_CURSOR), inText,window,go,addWrite,val,opt);
        operateBtn.add(subB);
        optBtn mulB=new mulBtn("*",x[3], y[2],wBtn, hBtn,btnFont,new Cursor(Cursor.HAND_CURSOR), inText,window,go,addWrite,val,opt);
        operateBtn.add(mulB);
        optBtn divB=new divBtn("/",x[3], y[1],wBtn, hBtn,btnFont,new Cursor(Cursor.HAND_CURSOR), inText,window,go,addWrite,val,opt);
        operateBtn.add(divB);
        optBtn modB=new modBtn("%",x[2], y[1],wBtn, hBtn,btnFont,new Cursor(Cursor.HAND_CURSOR), inText,window,go,addWrite,val,opt);
        operateBtn.add(modB);
        
        pointBtn pointB=new pointBtn(".",x[0],y[5],wBtn,hBtn,btnFont,inText,window, go,addWrite);
        
        window.setLayout(null);
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // If Click into The Red Button => End The Processus
        window.setVisible(true);
        
        //¼Æ¦r«ö¶sªì©l¤Æ
        numBtn btn0=new numBtn("0",x[1],y[5],wBtn,hBtn,btnFont,inText,window,go,addWrite);
        numBtn btn1=new numBtn("1",x[0],y[4],wBtn,hBtn,btnFont,inText,window,go,addWrite);
        numBtn btn2=new numBtn("2",x[1],y[4],wBtn,hBtn,btnFont,inText,window,go,addWrite);
        numBtn btn3=new numBtn("3",x[2],y[4],wBtn,hBtn,btnFont,inText,window,go,addWrite);
        numBtn btn4=new numBtn("4",x[0],y[3],wBtn,hBtn,btnFont,inText,window,go,addWrite);
        numBtn btn5=new numBtn("5",x[1],y[3],wBtn,hBtn,btnFont,inText,window,go,addWrite);
        numBtn btn6=new numBtn("6",x[2],y[3],wBtn,hBtn,btnFont,inText,window,go,addWrite);
        numBtn btn7=new numBtn("7",x[0],y[2],wBtn,hBtn,btnFont,inText,window,go,addWrite);
        numBtn btn8=new numBtn("8",x[1],y[2],wBtn,hBtn,btnFont,inText,window,go,addWrite);
        numBtn btn9=new numBtn("9",x[2],y[2],wBtn,hBtn,btnFont,inText,window,go,addWrite);
       
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