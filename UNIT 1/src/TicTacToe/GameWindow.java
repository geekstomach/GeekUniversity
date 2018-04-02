package TicTacToe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameWindow extends JFrame{

    private static final int WIN_HEIGHT = 555;
    private static final int WIN_WIDTH = 509;
    private static final int WIN_POS_X = 800;
    private static final int WIN_POS_Y = 300;

    private static Map field;
    private static StartNewGameWindow startNewGameWindow;


    public GameWindow() {

        setTitle("Tic Tac Toe"); //Устанавливаем заголовок
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setBounds(WIN_POS_X,WIN_POS_Y, WIN_WIDTH,WIN_HEIGHT);

        setResizable(false);

        JPanel bottomPanel = new JPanel(new GridLayout(1,2));

        startNewGameWindow = new StartNewGameWindow(this);

        JButton btnNewGame = new JButton("Start new Game");
        JButton btnExitGame = new JButton("Exit Game");

        bottomPanel.add(btnNewGame);
        bottomPanel.add(btnExitGame);

        btnExitGame.addActionListener(new ActionListener() { //первый обработчик

            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        btnNewGame.addActionListener(new ActionListener() { //второй обработчик

            public void actionPerformed(ActionEvent e) {
                startNewGameWindow.setVisible(true);
            }
        });

        field = new Map();
        add(field, BorderLayout.CENTER);

        add(bottomPanel, BorderLayout.SOUTH);

        setVisible(true);
    }
    void startNewGame (int mode, int fieldSizeX, int fieldSizeY, int winLen){
        this.startNewGame(mode,fieldSizeX,fieldSizeY,winLen);
    }
}
