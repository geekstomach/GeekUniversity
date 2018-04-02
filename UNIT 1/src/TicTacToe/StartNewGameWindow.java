package TicTacToe;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;

public class StartNewGameWindow extends JFrame{

    private static final int WIN_HEIGHT = 230;
    private static final int WIN_WIDTH = 350;
    private static final int MIN_WIN_LEN = 3;
    private static final int MAX_WIN_LEN = 10;
    private static final int MIN_FIELD_SIZE = 3;
    private static final int MAX_FIELD_SIZE = 10;
    private static final String STR_WIN_LEN = "Win length";
    private static final String STR_FIELD_SIZE = "Field size";
    //Создаем кнопки
    private JRadioButton jrbHumVSAi = new JRadioButton("Human vs AI", true);
    private JRadioButton jrbHumVSHum = new JRadioButton("Human vs Human");
    private ButtonGroup gameMod = new ButtonGroup();
    private final GameWindow gameWindow;
    //Создаем слайдеры
    private JSlider slFieldSize;
    private JSlider slWinLen;

    StartNewGameWindow(GameWindow gameWindow) {
        this.gameWindow = gameWindow;

        setSize(WIN_WIDTH, WIN_HEIGHT);
        Rectangle gameWindowBounds = gameWindow.getBounds();
        int posX = (int) (gameWindowBounds.getCenterX()-WIN_WIDTH /2);
        int posY = (int) (gameWindowBounds.getCenterY()-WIN_HEIGHT / 2);
        setLocation(posX,posY);
        setTitle("New game parameters");

//делаем сетку из 10 строк
        setLayout(new GridLayout(10,1));

        addGameControlsMode();

        addGameControlsFieldsWinLen();

        JButton btnStartGame = new JButton("Start game");
        btnStartGame.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnStartGameClick();
            }
        });
        add(btnStartGame);



    }

    private void btnStartGameClick() {
    int gameMode;
    if(jrbHumVSAi.isSelected()){
        gameMode = Map.MODE_H_V_A;
    }else {
        gameMode = Map.MODE_H_V_H;
    }
    int fieldSize = slFieldSize.getValue();
    int winLen = slWinLen.getValue();


    gameWindow.startNewGame(gameMode, fieldSize, fieldSize, winLen);
    setVisible(false);
    }

    private void addGameControlsFieldsWinLen() {
// добавляем слайдеры

        add(new JLabel("Choose field size"));

        final JLabel lblFieldSize = new JLabel(STR_FIELD_SIZE+MIN_FIELD_SIZE);

        slFieldSize = new JSlider(MIN_FIELD_SIZE , MAX_FIELD_SIZE, MIN_FIELD_SIZE);

        slFieldSize.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
              //  public void stateChanged (ChangeEvent e){
                    int currentFieldSize = slFieldSize.getValue();
                    lblFieldSize.setText(STR_FIELD_SIZE + currentFieldSize);
                    slFieldSize.setMaximum(currentFieldSize);
                }
            //}
        });

        add(lblFieldSize);
        add(slFieldSize);

        add(new JLabel("Choose win len"));

        final JLabel lblWinLen = new JLabel(STR_WIN_LEN + MIN_WIN_LEN);
        add(lblWinLen);

        slWinLen = new JSlider(MIN_WIN_LEN, MAX_WIN_LEN, MIN_WIN_LEN);
    }

    private void addGameControlsMode() {
add(new JLabel("Choose gaming mode:"));
// добавляем наши радиобаттоны в абстрактную группу чтобы выбирался один вариант
        gameMod.add(jrbHumVSAi);
        gameMod.add(jrbHumVSHum);
        add(jrbHumVSAi);
        add(jrbHumVSHum);
    }
}

