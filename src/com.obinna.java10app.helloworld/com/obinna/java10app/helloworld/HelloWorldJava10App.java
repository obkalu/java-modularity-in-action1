package com.obinna.java10app.helloworld;

import javax.swing.JFrame;

import com.obinna.java10app.libs.arithops.ArithOps;

public class HelloWorldJava10App {

    public static void main(String[] args) {
        System.out.println("Hello World Java  10 App!");
        int a = 5;
        int b = 10;
        System.out.printf("%d + %d = %d%n", a, b, ArithOps.add(a, b));
        System.out.printf("%d x %d = %d%n", a, b, ArithOps.mult(a, b));
        
        JFrame mainWindow = new JFrame();
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.setSize(480, 360);
        mainWindow.setTitle("Hello World Java 10 Modular App");
        mainWindow.setVisible(true);
    }

}