package Lesson4DZ;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DimaGrammDesign extends JFrame {
    private JTextField jtf;
    private JTextArea jta;
    StringBuilder stringBuilder = new StringBuilder();
    // создаем конструктор класса
    public DimaGrammDesign (){
        //при при нажатии ка нкнопу крестик приложение закрывается
                setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    //устанавливаем заголовок окна
        setTitle("DimaGramm");
        // устанавливаем начальный размер окна
        setBounds(900,500,400,400);

            //создаем 2 кнопки которые будут отвечать за отправку сообщения и
            //имеем в виду что кнопка создана, но еще не видна на окне, для этого ее необходимо добавить
                JButton jb1 = new JButton("Send");
            //добавляем действие производимое при нажатии кнопки
            jb1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //метод по которому при нажатии кнопки будет отправляться из области в в поле
                    sendMessage();

                }
            });
            jtf = new JTextField(20);
            jtf.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //на уроке почемуто написано MyWindow.this.send();
                    sendMessage();
                }
            });
            //создаем некую облать jPanel где разместим кнопку и текстовое поле
        //Используем диспетчер компановки BorderLayout
        JPanel upJp = new JPanel(new BorderLayout());
        //добавляем на эту панель кнопку и располагает ее на западе, справа
        upJp.add(jb1,BorderLayout.EAST);
        //добавляем тектовое поле ввода текста по центру
        upJp.add(jtf, BorderLayout.CENTER);
        // и наконец добавляем саму панель на окно
        add(upJp, BorderLayout.SOUTH);



                    jta = new JTextArea("Введите ваш текст.",10,20);
                    //Этим методом включаем перенос текста по строкам (по словам)
                    jta.setLineWrap(true);
                    //Т.к. это поле отправленных сообщения запрещаем его редактирование
                    jta.setEditable(false);
                    //Создаем скролл на эту тектовую область.
                    JScrollPane jsp = new JScrollPane(jta);
                    //и добавляем его на окно
                    add(jsp);


        // Показываем окно
        setVisible(true);
    }
public void sendMessage(){
    /*jta.setText("");
    stringBuilder.append(jtf.getText()+"\n");
    //stringBuilder.insert(0,jtf.getText()+"\n");

        jta.append(String.valueOf(stringBuilder));
//jta.setText(jtf.getText()+"\n" + jta.getText());*/
   jta.append("\n"+jtf.getText());

     //делаем так чтобы после отправки сообщения поле ввода обнулялось
        jtf.setText("");
        //и курсор ставался на нем
        jtf.grabFocus();
}
}
