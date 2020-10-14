package ui;

import model.Lab;
import model.Schedule;
import model.Task;
import model.Tutorial;

import java.util.Scanner;

// Course administration application
public class TaskerApp {

    private Schedule schedule;
    private Scanner input;

    public TaskerApp() {
        runTasker();
    }

    // MODIFIES: this
    // EFFECTS: processes user inputs
    private void runTasker() {
        boolean running = true;
        String command;

        init();
        System.out.println("Welcome to (TA)sker");
        while (running) {
            selectModeMenu();
            command = input.next();
            command = command.toLowerCase();

            if (command.equals("quit")) {
                running = false;
            } else {
                processCommands(command);
            }
        }

        System.out.println("\n Thank you for using Tasker!");

    }

    // MODIFIES: this
    // EFFECTS: processes user commands
    private void processCommands(String command) {
        if (command.equals("cr")) {
            createModeMenu();
            String createModeSelect = input.next();
            if (createModeSelect.equals("cr--task")) {
                makeTask();
            } else if (createModeSelect.equals("cr--lab")) {
                makeLab();
            } else if (createModeSelect.equals("cr--tutorial")) {
                makeTutorial();
            }

        } else if (command.equals("dp")) {
            displayModeMenu();
            String displayModeSelect = input.next();
            if (displayModeSelect.equals("dp--task")) {
                displayTasks();
            } else if (displayModeSelect.equals("dp--lab")) {
                displayLabs();
            } else if (displayModeSelect.equals("dp-tutorials")) {
                displayTutorials();
            }
        }
    }

    // EFFECTS: displays main menu
    //private void mainMenu() {
        //System.out.println("\t mk--task         -> Create Task");
        //System.out.println("\t mk--lab          -> Create Lab");
        //System.out.println("\t mk--tutorial     -> Create Tutorial");
        //System.out.println("\t quit             -> Exit Application");



    // MODIFIES: this
    // EFFECTS: creates a new task with specified name
    private void makeTask() {
        Task newTask = new Task("");
        System.out.println("Please enter task name: ");
        String name = input.next();
        newTask.setName(name);

        schedule.addTask(newTask);

        System.out.println("Tasks scheduled:");
        for (int i = 0; i < schedule.getTasks().size(); i++) {
            System.out.println(schedule.getTasks().get(i).getName());
        }

    }

    // MODIFIES: this
    // EFFECTS: creates a new lab with specified course name,
    // course number, and lab name
    private void makeLab() {
        Lab newLab = new Lab("", 0, "");
        System.out.println("Please enter course name: ");
        String courseName = input.next();
        System.out.println("Please enter course number: ");
        int courseNum = input.nextInt();
        System.out.println("Please enter lab name");
        String labName = input.next();
        newLab.setCourseName(courseName);
        newLab.setCourseNum(courseNum);
        newLab.setLabName(labName);

        schedule.addLab(newLab);

        // TODO: For loop to print out names for each lab.
    }

    // MODIFIES: this
    // EFFECTS: creates a new tutorial with specified course name,
    // course number, and tutorial name
    private void makeTutorial() {
        Tutorial newTutorial = new Tutorial("", 0, "");
        System.out.println("Please enter course name: ");
        String courseName = input.next();
        System.out.println("Please enter course number: ");
        int courseNum = input.nextInt();
        System.out.println("Please enter tutorial name");
        String tutorialName = input.next();
        newTutorial.setCourseName(courseName);
        newTutorial.setCourseNum(courseNum);
        newTutorial.setTutorialName(tutorialName);

        schedule.addTutorial(newTutorial);

        // TODO: For loop to print out names for each Tutorial.
    }

    // MODIFIES: this
    // EFFECTS: initializes schedule and Scanner
    private void init() {
        schedule = new Schedule("Schedule 1");
        input = new Scanner(System.in);
        input.useDelimiter("\n");
    }

    // EFFECTS: displays list of user options to enter a mode
    private void selectModeMenu() {
        System.out.println("\nSelect a mode:\n");
        System.out.println("\tcr       -> Create Mode");
        System.out.println("\tdp       -> Display Mode");
        System.out.println("\tquit     -> Quit Application");
        // TODO System.out.println("\t Modify");
    }

    // EFFECTS: displays list of user options when in Create mode
    private void createModeMenu() {
        System.out.println("\nSelect an action\n");
        System.out.println("\tcr--task          -> Create New Task");
        System.out.println("\tcr--lab           -> Create new Lab");
        System.out.println("\tcr--tutorial      -> Create new Tutorial");
    }

    // EFFECTS: displays list of user options when in Display mode
    private void displayModeMenu() {
        System.out.println("\nSelect an action\n");
        System.out.println("\tdp--task          -> Display Tasks");
        System.out.println("\tdp--lab           -> Display Labs");
        System.out.println("\tdp--tutorial      -> Display Tutorials");
    }

    // EFFECTS: displays list of user options when in Modify mode
    private void modifyModeMenu() {
        System.out.println("\nSelect an action\n");
        System.out.println("\tmf--task          -> Modify Task");
        System.out.println("\tmf--lab           -> Modify Lab");
        System.out.println("\tmf--tutorial      -> Modify Tutorial");
    }

    // EFFECTS: prints out names of all the tasks currently in the schedule
    private void displayTasks() {
        System.out.println("Tasks scheduled:");
        for (int i = 0; i < schedule.getTasks().size(); i++) {
            System.out.println(schedule.getTasks().get(i).getName());
        }
    }

    // EFFECTS: prints out course names, course numbers, and lab names
    // of all the labs currently in the schedule
    private void displayLabs() {
        System.out.println("Labs scheduled:");
        for (int i = 0; i < schedule.getLabs().size(); i++) {
            System.out.printf(schedule.getLabs().get(i).getCourseName(),
                              schedule.getLabs().get(i).getCourseNum(),
                              schedule.getLabs().get(i).getLabName(),
                              "\n");
        }
    }

    // EFFECTS: prints out course names, course numbers, and lab names
    // of all the tutorials currently in the schedule
    private void displayTutorials() {
        System.out.println("Tutorials scheduled:");
        for (int i = 0; i < schedule.getTutorials().size(); i++) {
            System.out.printf(schedule.getTutorials().get(i).getCourseName(),
                              schedule.getTutorials().get(i).getCourseNum(),
                              schedule.getTutorials().get(i).getTutorialName(),
                              "\n");
        }
    }

    private void completeTask() {

    }
}

