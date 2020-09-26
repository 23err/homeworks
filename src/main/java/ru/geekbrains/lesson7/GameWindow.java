package ru.geekbrains.lesson7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameWindow extends JFrame {

    private static final int WINDOW_WIDTH = 500;
    private static final int WINDOW_HEIGHT = 500;

    private Map map;


    public GameWindow(){
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setLocationRelativeTo(null);

        setTitle("XO games");

        JPanel footerJPanel = new JPanel();
        footerJPanel.setLayout(new GridLayout(1,2, 5,5));

        JButton buttonStart = new JButton("Start");
        JButton buttonExit = new JButton("Exit");
        footerJPanel.add(buttonStart);
        footerJPanel.add(buttonExit);

        add(footerJPanel, BorderLayout.SOUTH);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        final SettingWindow settingWindow = new SettingWindow(this);
        buttonStart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                settingWindow.setVisible(true);
            }
        });

        buttonExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        setVisible(true);
    }

    public void startGame(int gameMode, int sizeField, int countFieldsForWin) {
        System.out.printf("game mode: %d%nSize: %d%nCount for Win: %d", gameMode,sizeField,countFieldsForWin);
        map = new Map(sizeField);
        add(map, BorderLayout.CENTER);
        getContentPane().setBackground(Color.BLACK);

        validate();


    }
}
