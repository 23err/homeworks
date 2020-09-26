package ru.geekbrains.lesson7;

import javax.swing.*;
import java.awt.*;

public class Map extends JPanel {
    public static final int GAME_MODE_HUMAN_VS_AI = 1;
    public static final int GAME_MODE_HUMAN_VS_HUMAN = 1;
    private static final int GAP = 3;

    public Map(int size){
        setLayout(new GridLayout(size, size, GAP, GAP));

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                JPanel cell = new JPanel();
                cell.setBackground(Color.green.darker());
                cell.setBorder(BorderFactory.createLineBorder(Color.black));
                add(cell);
            }
        }

    }
}
