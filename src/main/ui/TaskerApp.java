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
        System.out.println(schedule.getTasks());

        // TODO: For loop to print out names for each task.
    }

    private void makeLab() {
        Lab newLab = new Lab("", 0, "");
        System.out.println("Please enter course name: ");
        String courseName = input.nextLine();
        System.out.println("Please enter course number: ");
        int courseNum = input.nextInt();
        System.out.println("Please enter lab name");
        String labName = input.nextLine();
        newLab.setCourseName(courseName);
        newLab.setCourseNum(courseNum);
        newLab.setLabName(labName);

        schedule.addLab(newLab);

        // TODO: For loop to print out names for each lab.
    }

    private void makeTutorial() {
        Tutorial newTutorial = new Tutorial("", 0, "");
        System.out.println("Please enter course name: ");
        String courseName = input.nextLine();
        System.out.println("Please enter course number: ");
        int courseNum = input.nextInt();
        System.out.println("Please enter tutorial name");
        String tutorialName = input.nextLine();
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


}

