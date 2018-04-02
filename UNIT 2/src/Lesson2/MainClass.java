package Lesson2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class MainClass {
    public static void main(String[] args) {
        // try, catch, finally, throw, throws
        JFrame jf = new JFrame();
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jf.setTitle("Report Maker");
        jf.setBounds(900, 500, 400, 400);
        JButton jButton = new JButton("Save Report");
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ReportMaker.makeReportPDF("text");
                } catch (IOException e1) {
                    JOptionPane.showMessageDialog(null, "Ошибка при сохранении отчета");
                }
            }
        });
        jf.add(jButton, BorderLayout.SOUTH);
        jf.setVisible(true);
    }




}
