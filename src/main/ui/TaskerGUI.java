package ui;

import model.Schedule;
import model.Task;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import java.awt.*;

public class TaskerGUI {

    private JFrame frameMain;
    private JButton saveButton;
    private JButton loadButton;
    private JPanel panel;

    private JButton createButton;
    private JButton modifyButton;
    private JButton displayButton;

    private Schedule schedule;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;
    private static final String JSON_STORE = "./data/schedule.json";

    public static final int WIDTH = 1000;
    public static final int HEIGHT = 700;

    public TaskerGUI() {

        saveButton = new JButton("Save");
        saveButton.setBounds(40, HEIGHT - 80, 110, 30);

        loadButton = new JButton("Load");
        loadButton.setBounds(WIDTH - 150, HEIGHT - 80, 110, 30);

        createButton = new JButton("Create");
        createButton.setBounds(30, 30, 110, 30);

        modifyButton = new JButton("Modify");
        createButton.setBounds(400, 30, 110, 30);

        displayButton = new JButton("Display");
        createButton.setBounds(660, 30, 110, 30);

        frameMain = new JFrame();
        frameMain.setMinimumSize(new Dimension(WIDTH, HEIGHT));
        frameMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameMain.setVisible(true);
        frameMain.setLayout(new BorderLayout());
        frameMain.setLocationRelativeTo(null);

        frameMain.add(saveButton);
        frameMain.add(loadButton);
        frameMain.add(createButton);
        frameMain.add(modifyButton);
        frameMain.add(displayButton);

        panel = new JPanel();
        panel.setBounds(10, 80, WIDTH - 20, HEIGHT);
        panel.setBackground(Color.gray);

        frameMain.add(panel);
    }


    public static void main(String[] args) {
        new TaskerGUI();
    }

}
