package ru.geekbrains.lesson7;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingWindow extends JFrame {
    private static final int WINDOW_WIDTH = 300;
    private static final int WINDOW_HEIGHT = 300;
    public static final int MIN_COUNT_FIELD = 3;
    public static final int MAX_COUNT_FIELD = 10;
    public static final int MIN_COUNT_WIN = 3;
    public static final String FIELD_SIZE_PREFIX = "Количество ячеек: ";
    public static final String WIN_FIELD_SIZE_PREFIX = "Количество ячеек для победы: ";



    private GameWindow gameWindow;
    private final JSlider sliderCountForWin;
    private final JSlider sliderCountField;
    private ButtonGroup groupGameMode;
    private JRadioButton radioHumanVSAI;
    private JRadioButton radioHumanVSHuman;


    @Override
    public void setVisible(boolean b) {
        super.setVisible(b);
        setLocationRelativeTo(gameWindow);
    }

    public SettingWindow(GameWindow gameWindow){
        this.gameWindow = gameWindow;
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setResizable(false);
        setLocationRelativeTo(gameWindow);

        setTitle("Настройки игры в крестики нолики");

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(10,1));
        add(mainPanel, BorderLayout.CENTER);

        //select game mod
        JLabel labelGameMode = new JLabel("Режим игры:");
        mainPanel.add(labelGameMode);


        groupGameMode = new ButtonGroup();
        radioHumanVSAI = new JRadioButton("Human vs. Ai");
        radioHumanVSAI.setSelected(true);

        radioHumanVSHuman = new JRadioButton("Human vs. Human");
        groupGameMode.add(radioHumanVSAI);
        groupGameMode.add(radioHumanVSHuman);

        mainPanel.add(radioHumanVSAI);
        mainPanel.add(radioHumanVSHuman);

        //count field for game
        final JLabel labelCountField = new JLabel(FIELD_SIZE_PREFIX + MIN_COUNT_FIELD);
        mainPanel.add(labelCountField);
        sliderCountField = new JSlider(MIN_COUNT_FIELD, MAX_COUNT_FIELD, MIN_COUNT_FIELD);
        mainPanel.add(sliderCountField);
        sliderCountField.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                labelCountField.setText(FIELD_SIZE_PREFIX + sliderCountField.getValue());
                sliderCountForWin.setMaximum(sliderCountField.getValue());
            }
        });

        //count for win group
        final JLabel labelCountForWin = new JLabel(WIN_FIELD_SIZE_PREFIX + MIN_COUNT_WIN);
        mainPanel.add(labelCountForWin);

        sliderCountForWin = new JSlider(MIN_COUNT_WIN, sliderCountField.getValue(), MIN_COUNT_WIN);
        sliderCountForWin.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                labelCountForWin.setText(WIN_FIELD_SIZE_PREFIX + sliderCountForWin.getValue());
            }
        });
        mainPanel.add(sliderCountForWin);


        JPanel footerPanel = new JPanel();
        add(footerPanel, BorderLayout.SOUTH);

        JButton startButton = new JButton("Start");
        footerPanel.add(startButton);
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                saveSettingsAndStartGame();
                setVisible(false);
            }
        });

        JButton closeButton = new JButton("Close");
        footerPanel.add(closeButton);

        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

    }

    public void saveSettingsAndStartGame(){
        int gameMode = 1;
        if (radioHumanVSAI.isSelected())
            gameMode = Map.GAME_MODE_HUMAN_VS_AI;
        else if (radioHumanVSHuman.isSelected())
            gameMode = Map.GAME_MODE_HUMAN_VS_HUMAN;
        else
            throw new RuntimeException("Выбран не существующий режим игры");

        gameWindow.startGame(gameMode, sliderCountField.getValue(), sliderCountForWin.getValue());
    }

}
