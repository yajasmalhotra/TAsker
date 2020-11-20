package ui;

import model.Schedule;
import model.Task;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class TaskerGUI {
    private JButton buttonMsg;
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
    private Schedule schedule;
    private Scanner input;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;


    public TaskerGUI() {

        schedule = new Schedule("Main");
        jsonReader = new JsonReader(JSON_STORE);
        jsonWriter = new JsonWriter(JSON_STORE);

        saveSchedule();
        loadSchedule();


        makeTaskButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                makeTask();
            }
        });
        displayTasksButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tasks = "";

                for (int i = 0; i < schedule.getTasks().size(); i++) {
                    tasks += (i + 1) + "." + schedule.getTasks().get(i).getName() + ":\n"
                            + "Status: " + schedule.getTasks().get(i).getStatus() + "\n";
                }

                displayTasksTextArea.setText(tasks);
            }
        });
    }

    private void makeTask() {
        Task newTask = new Task(taskNameTextField.getText());
        schedule.addTask(newTask);
    }

    private void loadSchedule() {
        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    schedule = jsonReader.read();
                    System.out.println("Loaded " + schedule.getName() + " from " + JSON_STORE);
                } catch (IOException p) {
                    System.out.println("Unable to read from file: " + JSON_STORE);
                }
            }
        });
    }

    private void saveSchedule() {
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    jsonWriter.open();
                    jsonWriter.write(schedule);
                    jsonWriter.close();
                    System.out.println("Saved " + schedule.getName() + " to " + JSON_STORE);
                } catch (FileNotFoundException p) {
                    System.out.println("Unable to write to file: " + JSON_STORE);
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Tasker");
        frame.setContentPane(new TaskerGUI().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
