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

        while (running) {
            mainMenu();
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

    private void processCommands(String command) {
        if (command.equals("mk--task")) {
            makeTask();
        } else if (command.equals("mk--lab")) {
            makeLab();
        } else if (command.equals("mk--tutorial")) {
            makeTutorial();
        }
    }

    private void mainMenu() {
        System.out.println("\n Welcome to Tasker. Please select one of the following commands:\n");
        System.out.println("\t mk--task -> Create Task");
        System.out.println("\t mk--lab -> Create Lab");
        System.out.println("\t mk--tutorial -> Create Tutorial");
        System.out.println("\t quit -> Exit Application");

    }

    private void makeTask() {
        Task newTask = new Task("");
        System.out.println("Please enter task name: ");
        String name = input.next();
        newTask.setName(name);

        schedule.addTask(newTask);
        // TODO: For loop to print out names for each task.

        System.out.println("Tasks scheduled:");
        for (int i = 0; i < schedule.getTasks().size(); i++) {
            System.out.println(schedule.getTasks().get(i).getName());
        }

    }

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

    private void init() {
        schedule = new Schedule("Schedule 1");
        input = new Scanner(System.in);
        input.useDelimiter("\n");
    }

    private void selectModeMenu() {
        System.out.println("\nSelect a mode:\n");
        System.out.println("\t Create");
        System.out.println("\t Display");
        System.out.println("\t Modify");
    }

    private void createModeMenu() {
        System.out.println("\nSelect an action\n");
        System.out.println("\tmk--task          -> Create New Task");
        System.out.println("\tmk--lab           -> Create new Lab");
        System.out.println("\tmk--tutorial      -> Create new Tutorial");
    }

    private void displayModeMenu() {
        System.out.println("\nSelect an action\n");
        System.out.println("\tdp--task          -> Display Tasks");
        System.out.println("\tdp--lab           -> Display Labs");
        System.out.println("\tdp--tutorial      -> Display Tutorials");
    }

    private void modifyModeMenu() {
        System.out.println("\nSelect an action\n");
        System.out.println("\tmf--task          -> Modify Task");
        System.out.println("\tmf--lab           -> Modify Lab");
        System.out.println("\tmf--tutorial      -> Modify Tutorial");
    }

    private void displayTasks() {
        System.out.println("Tasks scheduled:");
        for (int i = 0; i < schedule.getTasks().size(); i++) {
            System.out.println(schedule.getTasks().get(i).getName());
        }
    }

    private void displayLabs() {
        System.out.println("Labs scheduled:");
        for (int i = 0; i < schedule.getLabs().size(); i++) {
            System.out.printf(schedule.getLabs().get(i).getCourseName(),
                              schedule.getLabs().get(i).getCourseNum(),
                              schedule.getLabs().get(i).getLabName(),
                              "\n");
        }
    }

    private void displayTutorials() {
        System.out.println("Tutorials scheduled:");
        for (int i = 0; i < schedule.getTutorials().size(); i++) {
            System.out.printf(schedule.getTutorials().get(i).getCourseName(),
                              schedule.getTutorials().get(i).getCourseNum(),
                              schedule.getTutorials().get(i).getTutorialName(),
                              "\n");
        }
    }
}

