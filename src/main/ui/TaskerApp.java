package ui;

import model.Lab;
import model.Schedule;
import model.Task;
import model.Tutorial;

import java.util.Scanner;

// Course administration application. Allows the user to add/remove/modify
// course-related tasks, labs, and tutorials to a schedule.
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

        System.out.println("\n Thank you for using (TA)sker!");

    }

    // MODIFIES: this
    // EFFECTS: processes user commands
    private void processCommands(String command) {
        if (command.equals("cr")) {
            createItem();

        } else if (command.equals("dp")) {
            displayItem();

        } else if (command.equals("mf")) {
            modifyItem();
        }
    }

    // EFFECTS: processes user commands used to modify a new item on schedule

    private void modifyItem() {
        modifyModeMenu();
        String modifyModeSelect = input.next();
        if (modifyModeSelect.equals("mf--task")) {
            modifyTask();
        } else if (modifyModeSelect.equals("mf--lab")) {
            // TODO
        } else if (modifyModeSelect.equals(("mf--tutorial"))) {
            // TODO
        }
    }

    // EFFECTS: processes user commands used to display items on schedule

    private void displayItem() {
        displayModeMenu();
        String displayModeSelect = input.next();
        if (displayModeSelect.equals("dp--task")) {
            displayTasks();
        } else if (displayModeSelect.equals("dp--lab")) {
            displayLabs();
        } else if (displayModeSelect.equals("dp--tutorial")) {
            displayTutorials();
        }
    }

    // EFFECTS: processes user commands used to create a new item on schedule
    private void createItem() {
        createModeMenu();
        String createModeSelect = input.next();
        if (createModeSelect.equals("cr--task")) {
            makeTask();
        } else if (createModeSelect.equals("cr--lab")) {
            makeLab();
        } else if (createModeSelect.equals("cr--tutorial")) {
            makeTutorial();
        }
    }


    // MODIFIES: this
    // EFFECTS: creates a new task with specified name
    private void makeTask() {
        Task newTask = new Task("");
        System.out.println("Please enter task name: ");
        String name = input.next();
        newTask.setName(name);

        schedule.addTask(newTask);

        displayTasks();
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
        System.out.println("Please enter section name: ");
        String sectionName = input.next();
        newLab.setCourseName(courseName);
        newLab.setCourseNum(courseNum);
        newLab.setSectionName(sectionName);

        schedule.addLab(newLab);

        displayLabs();
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
        System.out.println("Please enter section name: ");
        String sectionName = input.next();
        newTutorial.setCourseName(courseName);
        newTutorial.setCourseNum(courseNum);
        newTutorial.setSectionName(sectionName);

        schedule.addTutorial(newTutorial);

        displayTutorials();
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
        System.out.println("\tmf       -> Modify Mode");
        System.out.println("\tquit     -> Quit Application");
    }

    // EFFECTS: displays list of user options when in Create mode
    private void createModeMenu() {
        System.out.println("\nSelect an action:\n");
        System.out.println("\tcr--task          -> Create New Task");
        System.out.println("\tcr--lab           -> Create new Lab");
        System.out.println("\tcr--tutorial      -> Create new Tutorial");
    }

    // EFFECTS: displays list of user options when in Display mode
    private void displayModeMenu() {
        System.out.println("\nSelect an action:\n");
        System.out.println("\tdp--task          -> Display Tasks");
        System.out.println("\tdp--lab           -> Display Labs");
        System.out.println("\tdp--tutorial      -> Display Tutorials");
    }

    // EFFECTS: displays list of user options when in Modify mode
    private void modifyModeMenu() {
        System.out.println("\nSelect an action:\n");
        System.out.println("\tmf--task          -> Modify Task");
        System.out.println("\tmf--lab           -> Modify Lab           (Under Construction)");
        System.out.println("\tmf--tutorial      -> Modify Tutorial      (Under Construction)");
    }

    // EFFECTS: prints out names of all the tasks currently in the schedule
    private void displayTasks() {
        System.out.println("Tasks scheduled:");
        for (int i = 0; i < schedule.getTasks().size(); i++) {
            System.out.printf("%s %s \n",
                    ((i + 1) + ")"),
                    schedule.getTasks().get(i).getName());
        }
    }

    // EFFECTS: prints out course names, course numbers, and lab names
    // of all the labs currently in the schedule
    private void displayLabs() {
        System.out.println("Labs scheduled:");
        for (int i = 0; i < schedule.getLabs().size(); i++) {
            System.out.printf("%s %s %d %s \n",
                    ((i + 1) + ")"),
                    schedule.getLabs().get(i).getCourseName(),
                    schedule.getLabs().get(i).getCourseNum(),
                    schedule.getLabs().get(i).getSectionName());
        }
    }

    // EFFECTS: prints out course names, course numbers, and lab names
    // of all the tutorials currently in the schedule
    private void displayTutorials() {
        System.out.println("Tutorials scheduled:");
        for (int i = 0; i < schedule.getTutorials().size(); i++) {
            System.out.printf("%s %s %d %s \n",
                    ((i + 1) + ")"),
                    schedule.getTutorials().get(i).getCourseName(),
                    schedule.getTutorials().get(i).getCourseNum(),
                    schedule.getTutorials().get(i).getSectionName());
        }
    }

    // MODIFIES: this
    // EFFECTS: allows the user to select a task from the list of tasks;
    // selected task can then be deleted, marked as complete/incomplete
    private void modifyTask() {
        displayTasks();
        System.out.println();
        System.out.printf("Select a task:");
        int taskNumber = input.nextInt();
        Task taskSelected = schedule.getTasks().get(taskNumber - 1);
        System.out.println("\nSelect an action:\n");
        System.out.println("\trm--task          -> Delete Task");
        System.out.println("\tcp--task          -> Mark Task as Complete");
        System.out.println("\tun--task          -> Mark Task as Incomplete");
        String modifyTaskAction = input.next();
        if (modifyTaskAction.equals("rm--task")) {
            schedule.removeTask(taskSelected);
            System.out.println("Task Deleted!");
        } else if (modifyTaskAction.equals("cp--task")) {
            taskSelected.completeTask();
            System.out.println("Task Marked Completed!");
        } else if (modifyTaskAction.equals("un--task")) {
            taskSelected.undoTask();
        }
    }

}

