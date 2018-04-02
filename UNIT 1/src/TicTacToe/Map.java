package TicTacToe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Map extends JPanel {

    int [][] field;
    int fieldSizeX;
    int fieldSizeY;

    int cellHeight;
    int cellWidth;
    int winLen;

    boolean isInitialized = false;

    public  static final int MODE_H_V_A =0;
    public  static final int MODE_H_V_H =1;

    Map() {
        setBackground(Color.orange);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                update(e);
            }
        });
    }
void update(MouseEvent e){
        int cellX = e.getX()/cellWidth;
        int cellY = e.getY()/cellHeight;

    System.out.println("x: " + cellX + "y: " + cellY);

    repaint();
}

/*@Override
protected void paintComponent (GraphicsConfigTemplate) {
    //render(g);
    }*/

    void startNewGame(int mode, int fieldSizeX, int fieldSizeY, int winLen) {
        System.out.println(mode + " " + fieldSizeX + " " + fieldSizeY + " " + winLen);
        this.fieldSizeX = fieldSizeX;
        this.fieldSizeY = fieldSizeY;
        this.winLen = winLen;

        field = new int [fieldSizeX][fieldSizeY];
        isInitialized = true;

        repaint();
    }

    void render(Graphics g){
        if(!isInitialized) return;;

        int panelWidth = getWidth();
        int panelHeight = getHeight();

        for (int i = 0; i < fieldSizeY ; i++) {
            int y = i*cellHeight;
            g.drawLine(0,y,panelWidth,y);
        }
        for (int i = 0; i < fieldSizeX ; i++) {
            int x = i*cellWidth;
            g.drawLine(0,x,panelHeight,x);
        }
    }
}
