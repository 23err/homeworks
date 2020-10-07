package ru.geekbrains.lesson7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Map extends JPanel {
    public static final int GAME_MODE_HUMAN_VS_AI = 1;
    public static final int GAME_MODE_HUMAN_VS_HUMAN = 1;
    private static final int GAP = 3;

    private int countField;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int widthCell = getWidth()/countField;
        int heightCell = getHeight() / countField;
        for (int i = 1; i < countField; i++) {
            int xCell = widthCell * i;
            int yCell = heightCell * i;
            g.drawLine(xCell, 0, xCell, getHeight() );
            g.drawLine(0, yCell, getWidth(), yCell );

        }
    }

    public Map(int size){
        countField = size;

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                System.out.printf("x = %d, y = %d", getX(), getY());
            }
        });
    }




}
