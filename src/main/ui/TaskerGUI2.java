package ui;

import model.Schedule;
import model.Task;
import model.TeachingAssistant;
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

    private static JComboBox<String> taskSelector;
    private static JFrame frame;
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

    // EFFECTS: constructor
    public TaskerGUI2() {

    }

    // EFFECTS: handles the code for all created components
    public static void main(String[] args) {
        frame = new JFrame("Tasker");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(600, 600);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        frame.add(panel);

        jsonReader = new JsonReader(JSON_STORE);
        jsonWriter = new JsonWriter(JSON_STORE);
        schedule = new Schedule("Main");

        saveAndLoadButton(panel);

        JLabel taskNameLabel = new JLabel("Enter Task Name:");
        taskNameLabel.setBounds(40, 70, 300, 30);
        panel.add(taskNameLabel);

        JTextField taskNameTextField = new JTextField();
        taskNameTextField.setBounds(40, 110, 240, 30);
        panel.add(taskNameTextField);

        JLabel taLabel = new JLabel("Enter TA Name: ");
        taLabel.setBounds(300, 70, 240, 30);
        panel.add(taLabel);

        JTextField taNameTextField = new JTextField();
        taNameTextField.setBounds(300, 110, 240, 30);
        panel.add(taNameTextField);

        JButton taAssignmentButton = new JButton("Assign TA");
        taAssignmentButton.setBounds(350, 150, 100, 30);
        panel.add(taAssignmentButton);
        taAssignmentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                schedule.getTasks().get((taskSelector.getSelectedIndex() - 1)).addTeachingAssistant(
                        new TeachingAssistant(taNameTextField.getText()));
            }
        });


        makeTaskButton(panel, taskNameTextField);

        JTextArea displayTasksTextArea = new JTextArea();
        displayTasksTextArea.setBounds(40, 350, 300, 500);
        panel.add(displayTasksTextArea);

        displayTaskButton(panel, displayTasksTextArea);

        JLabel taskSelectorLabel = new JLabel("Select Task:");
        taskSelectorLabel.setBounds(360, 300, 100, 30);
        panel.add(taskSelectorLabel);

        taskSelector = new JComboBox<String>();
        taskSelector.setBounds(460, 300, 100, 30);
        taskSelector.addItem("Choose");

        panel.add(taskSelector);

        JButton completeTask = new JButton("Mark Complete");
        completeTask.setBounds(360, 350, 200, 30);
        panel.add(completeTask);
        completeTask.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                schedule.getTasks().get((taskSelector.getSelectedIndex() - 1)).completeTask();
                displayTasks(displayTasksTextArea);
                // TODO
            }
        });

        JButton deleteTask = new JButton("Delete Task");
        deleteTask.setBounds(360, 400, 200, 30);
        panel.add(deleteTask);
        deleteTask.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                schedule.removeTask(schedule.getTasks().get((taskSelector.getSelectedIndex() - 1)));
                taskSelector.removeItemAt(taskSelector.getSelectedIndex());

                displayTasks(displayTasksTextArea);
            }
        });




        frame.setVisible(true);
    }

    private static void makeTaskButton(JPanel panel, JTextField taskNameTextField) {
        JButton makeTaskButton = new JButton("Create Task");
        makeTaskButton.setBounds(40, 150, 300, 30);
        panel.add(makeTaskButton);
        makeTaskButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                makeTask(taskNameTextField);
            }
        });
    }

    private static void displayTaskButton(JPanel panel, JTextArea displayTasksTextArea) {
        JButton displayTasksButton = new JButton("Display Created Tasks");
        displayTasksButton.setBounds(40, 300, 300, 30);
        panel.add(displayTasksButton);
        displayTasksButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayTasks(displayTasksTextArea);
            }
        });
    }

    private static void saveAndLoadButton(JPanel panel) {
        JButton saveButton = new JButton("Save");
        saveButton.setBounds(40, 20, 200, 30);
        panel.add(saveButton);
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                saveSchedule();

                for (Task task : schedule.getTasks()) {
                    taskSelector.addItem(task.getName());
                }

                frame.revalidate();
                frame.repaint();
            }
        });

        JButton loadButton = new JButton("Load");
        loadButton.setBounds(350, 20, 200, 30);
        panel.add(loadButton);
        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadSchedule();

                for (Task task : schedule.getTasks()) {
                    taskSelector.addItem(task.getName());
                }

                frame.revalidate();
                frame.repaint();

            }
        });
    }

    // EFFECTS: saves the created tasks into the schedule.
    //          plays audio if save successful.

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

    // EFFECTS: loads tasks created in previous sessions,
    //          plays audio if load successful.
    private static void loadSchedule() {
        try {
            schedule = jsonReader.read();
            System.out.println("Loaded " + schedule.getName() + " from " + JSON_STORE);
            playAudio("./Success1.wav");
        } catch (IOException p) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }

    // EFFECTS: creates a new task
    private static void makeTask(JTextField taskNameTextField) {
        Task newTask = new Task(taskNameTextField.getText());
        schedule.addTask(newTask);
        taskSelector.addItem(newTask.getName());

        frame.revalidate();
        frame.repaint();
    }

    // EFFECTS: displays the tasks created
    private static void displayTasks(JTextArea displayTasksTextArea) {
        String tasks = "";
        String tas = "";

//        for (int i = 0; i < schedule.getTasks().size(); i++) {
//            tasks += (i + 1) + "." + schedule.getTasks().get(i).getName() + ":\n"
//                    + "Status: " + schedule.getTasks().get(i).getStatus() + "\n"
//                    + "TA's Assigned: " + schedule.getTasks().get(i).getTeachingAssistant().getName() + "\n";
//        }

        for (int i = 0; i < schedule.getTasks().size(); i++) {
            for (int j = 0; i < schedule.getTasks().get(i).getTeachingAssistants().size(); j++) {
                tas += schedule.getTasks().get(i).getTeachingAssistants().get(j).getName() + ", ";
            }

            tasks += (i + 1) + "." + schedule.getTasks().get(i).getName() + ":\n"
                    + "Status: " + schedule.getTasks().get(i).getStatus() + "\n"
                    + "TA's Assigned: " + tas + "\n";
        }

        displayTasksTextArea.setText(tasks);
    }

    // EFFECTS: plays a success sound on event
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
