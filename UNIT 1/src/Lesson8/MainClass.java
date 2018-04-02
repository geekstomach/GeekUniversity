package Lesson8;

import javax.swing.*;
import java.awt.*;

class MyWindow extends JFrame {
    public MyWindow(){
        setTitle("Test Window"); //Устанавливаем заголовок
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //сообщает системе о необходимости завершить работу при закрытии формы
        setBounds(300,300,400,400); //устанавливает координаты формы и ее размер в пикселях

        JButton[] jbs = new JButton[5];
        for (int i = 0; i < 5; i++) {
            jbs[i] = new JButton("#"+i);
        }
        setLayout(new BorderLayout());  // выбор компановщика элесентов (располагает элементы по сторонам света)
        add(jbs[0],BorderLayout.EAST);  // добавление кнопки на форму и ее расположение
        add(jbs[1],BorderLayout.WEST);  // add(элемент_интерфейса, местонахождение)
        add(jbs[2],BorderLayout.SOUTH);
        add(jbs[3],BorderLayout.NORTH);
        add(jbs[4],BorderLayout.CENTER);

        setVisible(true); //Показывает полученную форму (вызываем только после ее настоек)
    }
}

public class MainClass {
    public static void main(String[] args) {
        MyWindow myWindow = new MyWindow();
    }

}