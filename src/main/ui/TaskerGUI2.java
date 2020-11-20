package ui;

import model.Schedule;
import model.Task;
import persistence.JsonReader;
import persistence.JsonWriter;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Scanner;

public class TaskerGUI2 {

    private JPanel panelMain;
    private JTabbedPane tabbedPane1;
    private JButton saveButton;
    private JButton loadButton;
    private JTextField taskNameTextField;
    private JButton makeTaskButton;
    private JButton displayTasksButton;
    private JTextArea displayTasksTextArea;
    private ImageIcon image1;
    private JLabel imageLabel;

    private static final String JSON_STORE = "./data/schedule.json";
    private static Schedule schedule;
    private Scanner input;
    private static JsonWriter jsonWriter;
    private static JsonReader jsonReader;


    public TaskerGUI2() {

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Tasker");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(600, 600);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        frame.add(panel);

        jsonReader = new JsonReader(JSON_STORE);
        jsonWriter = new JsonWriter(JSON_STORE);
        schedule = new Schedule("Main");

        JButton saveButton = new JButton("Save");
        saveButton.setBounds(20, 20, 200, 30);
        panel.add(saveButton);
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                saveSchedule();
            }
        });

        JButton loadButton = new JButton("Load");
        loadButton.setBounds(300, 20, 200, 30);
        panel.add(loadButton);
        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadSchedule();
            }
        });

        JLabel taskNameLabel = new JLabel("Enter Task Name:");
        taskNameLabel.setBounds(40, 100, 300, 30);
        panel.add(taskNameLabel);

        JTextField taskNameTextField = new JTextField();
        taskNameTextField.setBounds(40, 150, 500, 30);
        panel.add(taskNameTextField);

        JButton makeTaskButton = new JButton("Create Task");
        makeTaskButton.setBounds(40, 190, 300, 30);
        panel.add(makeTaskButton);
        makeTaskButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                makeTask(taskNameTextField);
            }
        });

        JTextArea displayTasksTextArea = new JTextArea();
        displayTasksTextArea.setBounds(40, 350, 500, 500);
        panel.add(displayTasksTextArea);

        JButton displayTasksButton = new JButton("Display Created Tasks");
        displayTasksButton.setBounds(40, 300, 300, 30);
        panel.add(displayTasksButton);
        displayTasksButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayTasks(displayTasksTextArea);
            }
        });


        frame.setVisible(true);
    }

    private static void saveSchedule() {
        try {
            jsonWriter.open();
            jsonWriter.write(schedule);
            jsonWriter.close();
            System.out.println("Saved " + schedule.getName() + " to " + JSON_STORE);
            playAudio("./Success1.wav");
        } catch (FileNotFoundException p) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

    private static void loadSchedule() {
        try {
            schedule = jsonReader.read();
            System.out.println("Loaded " + schedule.getName() + " from " + JSON_STORE);
            playAudio("./Success1.wav");
        } catch (IOException p) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }

    private static void makeTask(JTextField taskNameTextField) {
        Task newTask = new Task(taskNameTextField.getText());
        schedule.addTask(newTask);
    }

    private static void displayTasks(JTextArea displayTasksTextArea) {
        String tasks = "";

        for (int i = 0; i < schedule.getTasks().size(); i++) {
            tasks += (i + 1) + "." + schedule.getTasks().get(i).getName() + ":\n"
                    + "Status: " + schedule.getTasks().get(i).getStatus() + "\n";
        }

        displayTasksTextArea.setText(tasks);
    }

    public static void playAudio(String filepath) {

        InputStream music;
        try {
            music = new FileInputStream(new File(filepath));
            AudioStream successSound = new AudioStream(music);
            AudioPlayer.player.start(successSound);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error");
        }
    }



}
