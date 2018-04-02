package Lesson1;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainClass {
    public static void main(String[] args) {
        Flyable f = new Flyable() {
            @Override
            public void fly() {
                System.out.println("fly-fly-fly");
            }
        };
        f.fly();
        System.out.println(f.getClass().getName());

        Flyable f2 = new Flyable() {
            @Override
            public void fly() {
                System.out.println("fly-fly-fly");
            }
        };
        f2.fly();
        System.out.println(f2.getClass().getName());

        JButton jb1 = new JButton("Buttion #1");
        jb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("CLICKED!");
            }
        });
    }
}
