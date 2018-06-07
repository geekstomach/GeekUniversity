package TicTacToe.GameOfTheYear;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;


public class Map extends JPanel {

    public static final int MODE_H_V_A = 0;
    public static final int MODE_H_V_H = 1;






//Недостающие
    private static final int emptyCheck = -1;
    private static final char playersMark = 1;
    private static final int computersMark = 0;
    private static Random rand = new Random();
    private int gameMode;
    private int hVh = 0;
    private boolean isTheGameEnds = false;

    // 24.1 чтобы заполнить поле
    private int[][] field; // Создаем массив представляющий собой игровое поле
    private int fieldSizeX;
    private int fieldSizeY;
    private int winLenght;

    // 25 высота и ширина каждоый ячейки
    private int cellHeight;
    private int cellWidth;



    // 27 если ничего не нарисовано
    boolean isInitialized = false;

    // 10 создаем конструктор и задаем цвет поля
    Map() {
        setBackground(Color.orange);
        // 30 создаем слушателя шелчка мышки
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                update(e);
            }
        });

    }
    
    // 31 создаем метод который определяем куда челкнули
    void update(MouseEvent e) {
        // пиксели делим на ширину и высоту
        int cellX = e.getX() / cellWidth;
        int cellY = e.getY() / cellHeight;



        System.out.println("x: " + cellX + " y: " + cellY);
        // после каждого действия перерисовываем
        isTheGameEnds = false;

if (gameMode == MODE_H_V_A) {

    playersTurn(cellX, cellY, playersMark);

    if (checkWin(playersMark)) {

        JOptionPane.showMessageDialog(null,"Вы выиграли!");
        isTheGameEnds = true;

        ifEndGame();

    }
 else {if (fullField()){

     JOptionPane.showMessageDialog(null,"Ничья!");
        isTheGameEnds = true;
        ifEndGame();
        }}
/*

    if (checkWin(playersMark)) {
        if (JOptionPane.showConfirmDialog(null, "Вы выиграли! Начать новую игру?", "Победитель", JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE) == 0){

        } else {System.exit(0);}
    } else {if (fullField()) if (JOptionPane.showConfirmDialog(null, "Ничья! Начать новую игру?", "Ничья", JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE) == 0) {

    } else {System.exit(0);}
    }
*/

  if (!isTheGameEnds) { computersTurn();}


    if (checkWin(computersMark)) {

        JOptionPane.showMessageDialog(null,"Компьютер победил(!");
        isTheGameEnds = true;
        ifEndGame();
        }
else {if (fullField()){

    JOptionPane.showMessageDialog(null,"Ничья!");
        isTheGameEnds = true;
        ifEndGame();
        }}
    /*{
        if (JOptionPane.showConfirmDialog(null, "Выиграл Комп! Начать новую игру?", "Победитель", JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE) == 0) {

        } else {System.exit(0);}
    } else {if (fullField()) if (JOptionPane.showConfirmDialog(null, "Ничья! Начать новую игру?", "Ничья", JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE) == 0) {

    } else {System.exit(0);}}
*/
    } else {
    if (hVh%2==0) {

        playersTurn(cellX, cellY, playersMark);


        if (checkWin(playersMark)) {
            JOptionPane.showMessageDialog(null,"Выиграл игрок с крестиками!!");
                isTheGameEnds = true;
                ifEndGame();
            }
        } else {
            if (fullField()){
                JOptionPane.showMessageDialog(null,"Ничья! ");

                    isTheGameEnds = true;
                    ifEndGame();
                }
        }
        if (!(hVh % 2 == 0)) {
            if (!isTheGameEnds) { playersTurn(cellX, cellY, computersMark);}


            if (checkWin(computersMark)) {
                JOptionPane.showMessageDialog(null,"Выиграл игрок с ноликами!");

                    isTheGameEnds = true;
                    ifEndGame();
                }
            } else {
                if (fullField()){
                    JOptionPane.showMessageDialog(null,"\"Ничья!");
                    isTheGameEnds = true;
                        ifEndGame();
                    }
            }
        }



        hVh++;

    }

    // 24 метод для рисования нашего поля в целом
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);


        render(g);
    }


    // 11 создаем метод который говорит о типе игры, размеры поля, и выиграшная длина
    void startNewGame(int mode, int fieldSizeX, int fieldSizeY, int winLength){
       // заглушка
        System.out.println("mode = " + mode +
                " fsX = " + fieldSizeX +
                " fsy = " + fieldSizeY +
                " winlen = " + winLength);
        setVisible(true);
       //25 запоняем поля при старте новой игры
        this.fieldSizeX = fieldSizeX;
        this.fieldSizeY = fieldSizeY;
        this.winLenght = winLength;
        field = new int[fieldSizeY][fieldSizeX]; //создаем массив требуемых размеров
        emtpyField(field); //заполняем массив пустыми клетками
        gameMode = mode;

        isInitialized = true;
        // 28 говорим панели перерисоваться
        repaint();
    }

    // 24.1 метод для рисования
    //в этом методе мы отрисовываем все меняющиеся и не меняющиеся элементы игры
    void render(Graphics g) {
        if(!isInitialized) return;

        int panelWidth = getWidth();
        int panelHeight = getHeight();
        // узнаем кол-во ечеек
        cellHeight = panelHeight /fieldSizeY;
        cellWidth = panelWidth / fieldSizeX;

        // 26 отрисовываем по Y (горизонтальные полоски)
        for(int i = 0; i < fieldSizeY; i++) {
            int y = i * cellHeight;
            g.drawLine(0, y, panelWidth, y);
        }

        // 29 отрисовываем по X (вертикальные полоски)
        for(int i = 0; i < fieldSizeX; i++) {
            int x = i * cellWidth;
            g.drawLine(x, 0, x, panelHeight);
        }
        //отрисовываем крестики и нолики. где что рисовать берем из массива
        for (int i = 0; i <fieldSizeY ; i++) {
            for (int j = 0; j <fieldSizeX ; j++) {
                if (field[i][j] == playersMark){
                    int x1 =i*cellWidth+(cellWidth/6);
                    int x2 = (i+1)*cellWidth-(cellWidth/6);
                    int y1 = j*cellHeight+(cellWidth/6);
                    int y2 = (j+1)*cellHeight-(cellHeight/6);

                 Graphics2D g2d = (Graphics2D) g;
                    g2d.setStroke(new BasicStroke(8, BasicStroke.CAP_ROUND,
                            BasicStroke.JOIN_ROUND));
                    g2d.setColor(Color.RED);


                    g2d.drawLine(y1, x1, y2, x2);//сначала напутал иксами и угриками
                    g2d.drawLine(y2, x1, y1, x2);
                }
                if (field[i][j] == computersMark){
                    int x0 = i*cellWidth+(cellWidth/6);
                    int y0 = j*cellHeight+(cellWidth/6);
                    int rW = cellWidth - (cellWidth/3);
                    int rH = cellHeight - (cellHeight/3);
                    Graphics2D g2d = (Graphics2D) g;
                    g2d.setStroke(new BasicStroke(8, BasicStroke.CAP_ROUND,
                            BasicStroke.JOIN_ROUND));
                    g2d.setColor(Color.RED);
                    g2d.drawOval(y0,x0, rW, rH);
                }
            }
        }


    }
/**  Прикручиваем логику игры */
    //заполняем поле пустыми клетками
    void emtpyField (int[][] fieldCons) {

        for (int i=0; i<fieldSizeY; i++) {
            for (int j=0; j<fieldSizeX; j++) {
                fieldCons [i][j] = emptyCheck;
            }
        }
    }
    //Записываем  ход на поле
    //на вход задаем координаты и сивол, которым заполняем(в данном случае 0 или 1)
     void fillCheck(int x, int y, int sym){
        field[y][x] = sym;
    }
    public  boolean isCheckEmpty(int x, int y){
        // проверяем лежат ли в пределах поля введенные игроком значения
        //Врядли нужно , т .к используем все поле
        if ((x < 0 || x >= fieldSizeX)||(y < 0 || y >= fieldSizeY)){return false;}

        // проверяем пустое ли поле
        if (field[y][x] == emptyCheck) {

            return true;
        }
        return false;
    }
    //проверка на ничью (все  ячейки поля заполнены ходами)
    private   boolean fullField() {
        for (int i=0; i< fieldSizeY; i++) {
            for (int j=0; j<fieldSizeX; j++) {
                if (field[i][j] == emptyCheck) return false;
            }
        }
        System.out.println("Игра закончилась в ничью");
        return true;
    }
    //Проверка победы
    private boolean checkWin(int nym) {
        for (int v = 0; v<fieldSizeY; v++){
            for (int h= 0; h<fieldSizeX; h++) {
                //анализ наличие поля для проверки
                if (h + winLenght <= fieldSizeX) {                           //по горизонтали
                    if (checkLineHorisont(v, h, nym) >= winLenght) return true;

                    if (v - winLenght > -2) {                            //вверх по диагонали
                        if (checkDiaUp(v, h, nym) >= winLenght) return true;
                    }
                    if (v + winLenght <= fieldSizeY) {                       //вниз по диагонали
                        if (checkDiaDown(v, h, nym) >= winLenght) return true;
                    }
                }
                if (v + winLenght <= fieldSizeY) {                       //по вертикали
                    if (checkLineVertical(v, h, nym) >= winLenght) return true;
                }
            }
        }
        return false;
    }
    //Описываем ход игрока
    //Раньше мы вводили координаты внутри метода, теперь мы из получаем от клика мыши
    public void playersTurn(int x, int y, int sym){

        while (!isCheckEmpty(x, y) == true);
        // playField[y][x] = playersMark;
        fillCheck(x,y,sym);
        repaint();
    }
    public  void computersTurn() {
        int x, y;
        //блокировка ходов человека
        for (int v = 0; v<fieldSizeY; v++) {
            for (int h = 0; h < fieldSizeX; h++) {
                //анализ наличие поля для проверки
                if (h+winLenght<=fieldSizeX) {                           //по горизонтале
                    if (checkLineHorisont(v, h, playersMark) == winLenght - 1) {
                        if (MoveAiLineHorisont(v, h, computersMark)) return;
                    }

                    if (v - winLenght > -2) {                            //вверх по диагонале
                        if (checkDiaUp(v, h, playersMark) == winLenght - 1) {
                            if (MoveAiDiaUp(v, h, computersMark)) return;
                        }
                    }
                    if (v + winLenght <= fieldSizeY) {                       //вниз по диагонале
                        if (checkDiaDown(v, h, playersMark) == winLenght - 1) {
                            if (MoveAiDiaDown(v, h, computersMark)) return;
                        }
                    }
                }
                if (v+winLenght<=fieldSizeY) {                       //по вертикале
                    if (checkLineVertical(v,h,playersMark) ==winLenght-1) {
                        if(MoveAiLineVertical(v,h,computersMark)) return;
                    }
                }
            }
        }
        //игра на победу
        for (int v = 0; v<fieldSizeY; v++) {
            for (int h = 0; h < fieldSizeX; h++) {
                //анализ наличие поля для проверки
                if (h+winLenght<=fieldSizeX) {                           //по горизонтали
                    if (checkLineHorisont(v,h,computersMark) == winLenght-1) {
                        if (MoveAiLineHorisont(v,h,computersMark)) return;
                    }

                    if (v-winLenght>-2) {                            //вверх по диагонали
                        if (checkDiaUp(v, h, computersMark) == winLenght-1) {
                            if (MoveAiDiaUp(v,h,computersMark)) return;
                        }
                    }
                    if (v+winLenght<=fieldSizeY) {                       //вниз по диагонали
                        if (checkDiaDown(v, h, computersMark) == winLenght-1) {
                            if (MoveAiDiaDown(v,h,computersMark)) return;
                        }
                    }

                }
                if (v+winLenght<=fieldSizeY) {                       //по вертикали
                    if (checkLineVertical(v,h,computersMark) ==winLenght-1) {
                        if(MoveAiLineVertical(v,h,computersMark)) return;
                    }
                }
            }
        }

        //слйчайный ход
        do {
            y = rand.nextInt(fieldSizeY) - 1;
            x = rand.nextInt(fieldSizeX) - 1;

        } while (!isCheckEmpty(x, y) == true);
        System.out.println("Ход компьютера - "+(x+1)+" "+(y+1));//оставлю на всякий случай
        fillCheck(x,y,computersMark);
        repaint();
    }
    //проверка заполнения всей линии по диагонале вверх
    private int checkDiaUp(int v, int h, int sym) {
        int count=0;
        for (int i = 0, j = 0; j < winLenght; i--, j++) {
            if ((field[v+i][h+j] == sym)) count++;
        }
        return count;
    }
    //проверка заполнения всей линии по диагонале вниз

    private  int checkDiaDown(int v, int h, int sym) {
        int count=0;
        for (int i = 0; i < winLenght; i++) {
            if ((field[i+v][i+h] == sym)) count++;
        }
        return count;
    }

    private  int checkLineHorisont(int v, int h, int sym) {
        int count=0;
        for (int j = h; j < winLenght + h; j++) {
            if ((field[v][j] == sym)) count++;
        }
        return count;
    }
    //проверка заполнения всей линии по вертикале
    private  int checkLineVertical(int v, int h, int sym) {
        int count=0;
        for (int i = v; i< winLenght + v; i++) {
            if ((field[i][h] == sym)) count++;
        }
        return count;
    }
    //ход компьютера по горизонтале
    private boolean MoveAiLineHorisont(int v, int h, int sym) {
        for (int j = h; j < winLenght; j++) {
            if ((field[v][j] == emptyCheck)) {
                field[v][j] = sym;
                return true;
            }
        }
        return false;
    }
    //ход компьютера по вертикале
    private  boolean MoveAiLineVertical(int v, int h, int sym) {
        for (int i = v; i<winLenght; i++) {
            if ((field[i][h] == emptyCheck)) {
                field[i][h] = sym;
                return true;
            }
        }
        return false;
    }
    //проверка заполнения всей линии по диагонале вверх

    private  boolean MoveAiDiaUp(int v, int h, int sym) {
        for (int i = 0, j = 0; j < winLenght; i--, j++) {
            if ((field[v+i][h+j] == emptyCheck)) {
                field[v+i][h+j] = sym;
                return true;
            }
        }
        return false;
    }
    //проверка заполнения всей линии по диагонале вниз

    private  boolean MoveAiDiaDown(int v, int h, int sym) {

        for (int i = 0; i < winLenght; i++) {
            if ((field[i+v][i+h] == emptyCheck)) {
                field[i+v][i+h] = sym;
                return true;
            }
        }
        return false;
    }
    private void ifEndGame(){

        emtpyField(field);
        setVisible(false);
     //repaint();
    }
}
//при использовании диалогового окна для создания нового gamewindow постоянные ошибки
//не очень понимаю почему(
