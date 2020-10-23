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
        switch (command) {
            case "cr":
                createItem();
                break;
            case "dp":
                displayItem();
                break;
            case "mf":
                modifyItem();
                break;
        }
    }

    // EFFECTS: processes user commands used to modify a new item on schedule

    private void modifyItem() {
        modifyModeMenu();
        String modifyModeSelect = input.next();
        switch (modifyModeSelect) {
            case "mf--task":
                modifyTask();
                break;
            case "mf--lab":
                modifyLab();
                break;
            case ("mf--tutorial"):
                modifyTutorial();
                break;
        }
    }

    // EFFECTS: processes user commands used to display items on schedule

    private void displayItem() {
        displayModeMenu();
        String displayModeSelect = input.next();
        switch (displayModeSelect) {
            case "dp--task":
                displayTasks();
                break;
            case "dp--lab":
                displayLabs();
                break;
            case "dp--tutorial":
                displayTutorials();
                break;
        }
    }

    // EFFECTS: processes user commands used to create a new item on schedule
    private void createItem() {
        createModeMenu();
        String createModeSelect = input.next();
        switch (createModeSelect) {
            case "cr--task":
                makeTask();
                break;
            case "cr--lab":
                makeLab();
                break;
            case "cr--tutorial":
                makeTutorial();
                break;
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
            System.out.printf("%s %s %s %s %s\n",
                    ((i + 1) + ")"),
                    schedule.getTasks().get(i).getName() + "\n",
                    "\tTime: " + schedule.getTasks().get(i).getTime() + "\n",
                    "\tTA: " + schedule.getTasks().get(i).getTeachingAssistant() + "\n",
                    "\tStatus: " + schedule.getTasks().get(i).getStatus());
        }
    }

    // EFFECTS: prints out course names, course numbers, and lab names
    // of all the labs currently in the schedule
    private void displayLabs() {
        System.out.println("Labs scheduled:");
        for (int i = 0; i < schedule.getLabs().size(); i++) {
            System.out.printf("%s %s %s %s %s %s \n",
                    ((i + 1) + ")"),
                    "\tCourse name: "     + schedule.getLabs().get(i).getCourseName() + "\n",
                    "\tCourse number: "   + schedule.getLabs().get(i).getCourseNum() + "\n",
                    "\tSection name: "    + schedule.getLabs().get(i).getSectionName() + "\n",
                    "\tTime: "            + schedule.getLabs().get(i).getTime() + "\n",
                    "\tLocation: "        + schedule.getLabs().get(i).getBuilding() + " "
                                        + schedule.getLabs().get(i).getRoomNumber());
        }
    }

    // EFFECTS: prints out course names, course numbers, and lab names
    // of all the tutorials currently in the schedule
    private void displayTutorials() {
        System.out.println("Tutorials scheduled:");
        for (int i = 0; i < schedule.getTutorials().size(); i++) {
            System.out.printf("%s %s %s %s %s %s \n",
                    ((i + 1) + ")"),
                    "\tCourse name: "     + schedule.getTutorials().get(i).getCourseName() + "\n",
                    "\tCourse number: "   + schedule.getTutorials().get(i).getCourseNum() + "\n",
                    "\tSection name: "    + schedule.getTutorials().get(i).getSectionName() + "\n",
                    "\tTime: "            + schedule.getTutorials().get(i).getTime() + "\n",
                    "\tLocation: "        + schedule.getTutorials().get(i).getBuilding() + " "
                            + schedule.getTutorials().get(i).getRoomNumber());
        }
    }

    // MODIFIES: this
    // EFFECTS: allows the user to select a task from the list of tasks;
    // selected task can then be deleted, marked as complete/incomplete
    private void modifyTask() {
        displayTasks();
        System.out.println("Select a task:");
        int taskNumber = input.nextInt();
        Task taskSelected = schedule.getTasks().get(taskNumber - 1);
        System.out.println("\nSelect an action:\n");
        System.out.println("\tcp--task          -> Mark Task as Complete");
        System.out.println("\tun--task          -> Mark Task as Incomplete");
        System.out.println("\ted--task          -> Edit Task Details");
        System.out.println("\trm--task          -> Delete Task");
        String modifyTaskAction = input.next();
        if (modifyTaskAction.equals("rm--task")) {
            schedule.removeTask(taskSelected);
            System.out.println("Task Deleted!");
        } else if (modifyTaskAction.equals("cp--task")) {
            taskSelected.completeTask();
            System.out.println("Task Marked Completed!");
        } else if (modifyTaskAction.equals("un--task")) {
            taskSelected.undoTask();
        } else if (modifyTaskAction.equals("ed--task")) {
            editTaskDetails(taskSelected);
        }
    }

    // MODIFIES: this
    // EFFECTS: allows the user to edit individual properties of a selected task
    private void editTaskDetails(Task taskSelected) {
        System.out.println("\nSelect an action:\n");
        System.out.println("\tch--name          -> Change task name");
        System.out.println("\tch--time          -> Change task time");
        System.out.println("\tch--ta            -> Change teaching assistant");
        String taskCommand = input.next();
        if (taskCommand.equals("ch--name")) {
            System.out.println("Enter new task name: ");
            String newName = input.next();
            taskSelected.setName(newName);
        } else if (taskCommand.equals("ch--time")) {
            System.out.println("Enter new time: ");
            String newTime = input.next();
            taskSelected.setTime(newTime);
        } else if (taskCommand.equals("ch--ta")) {
            System.out.println("Enter new TA name: ");
            String newTA = input.next();
            taskSelected.setTeachingAssistant(newTA);
        }
    }

    // MODIFIES: this
    // EFFECTS: allows the user to select a lab from the list of labs;
    // selected task can then be deleted or edited
    private void modifyLab() {
        displayLabs();
        System.out.println("Select a lab:");
        int labNumber = input.nextInt();
        Lab labSelected = schedule.getLabs().get(labNumber - 1);
        System.out.println("\nSelect an action:\n");
        System.out.println("\tch--cname         -> Change Lab Course Name");
        System.out.println("\tch--cnum          -> Change Lab Course Number");
        System.out.println("\tch--sect          -> Change Lab Section");
        System.out.println("\tch--time          -> Change Lab Time");
        System.out.println("\tch--bldg          -> Change Lab Location (Building)");
        System.out.println("\tch--room          -> Change Lab Location (Room)");

        editLabDetails(labSelected);
    }

    // MODIFIES: this
    // EFFECTS: allows the user to edit individual properties of a selected lab
    private void editLabDetails(Lab labSelected) {
        String modifyLabAction = input.next();
        if (modifyLabAction.equals("ch--cname")) {
            System.out.println("Enter new course name: ");
            String newName = input.next();
            labSelected.setCourseName(newName);
        } else if (modifyLabAction.equals("ch--cnum")) {
            System.out.println("Enter new course number: ");
            int newNum = input.nextInt();
            labSelected.setCourseNum(newNum);
        } else if (modifyLabAction.equals("ch--sect")) {
            System.out.println("Enter new section name: ");
            String newSection = input.next();
            labSelected.setSectionName(newSection);
        } else {
            editLabDetailsPart2(labSelected, modifyLabAction);
        }
    }

    private void editLabDetailsPart2(Lab labSelected, String modifyLabAction) {
        if (modifyLabAction.equals("ch--time")) {
            System.out.println("Enter new lab time: ");
            String newTime = input.next();
            labSelected.setTime(newTime);
        } else if (modifyLabAction.equals("ch--bldg")) {
            System.out.println("Enter new lab building: ");
            String newBuilding = input.next();
            labSelected.setBuilding(newBuilding);
        } else if (modifyLabAction.equals("ch--room")) {
            System.out.println("Enter new lab room: ");
            int newRoom = input.nextInt();
            labSelected.setRoomNumber(newRoom);
        }
    }

    // MODIFIES: this
    // EFFECTS: allows the user to select a tutorial from the list of labs;
    // selected task can then be deleted or edited
    private void modifyTutorial() {
        displayTutorials();
        System.out.println("Select a tutorial:");
        int tutorialNumber = input.nextInt();
        Tutorial tutorialSelected = schedule.getTutorials().get(tutorialNumber - 1);
        System.out.println("\nSelect an action:\n");
        System.out.println("\tch--cname         -> Change Tutorial Course Name");
        System.out.println("\tch--cnum          -> Change Tutorial Course Number");
        System.out.println("\tch--sect          -> Change Tutorial Section");
        System.out.println("\tch--time          -> Change Tutorial Time");
        System.out.println("\tch--bldg          -> Change Tutorial Location (Building)");
        System.out.println("\tch--room          -> Change Tutorial Location (Room)");

        editTutorialDetails(tutorialSelected);
    }

    private void editTutorialDetails(Tutorial tutorialSelected) {
        String modifyTutorialAction = input.next();
        if (modifyTutorialAction.equals("ch--cname")) {
            System.out.println("Enter new course name: ");
            String newName = input.next();
            tutorialSelected.setCourseName(newName);
        } else if (modifyTutorialAction.equals("ch--cnum")) {
            System.out.println("Enter new course number: ");
            int newNum = input.nextInt();
            tutorialSelected.setCourseNum(newNum);
        } else if (modifyTutorialAction.equals("ch--sect")) {
            System.out.println("Enter new section name: ");
            String newSection = input.next();
            tutorialSelected.setSectionName(newSection);
        } else {
            editTutorialDetailsPart2(tutorialSelected, modifyTutorialAction);
        }
    }

    private void editTutorialDetailsPart2(Tutorial tutorialSelected, String modifyTutorialAction) {
        if (modifyTutorialAction.equals("ch--time")) {
            System.out.println("Enter new tutorial time: ");
            String newTime = input.next();
            tutorialSelected.setTime(newTime);
        } else if (modifyTutorialAction.equals("ch--bldg")) {
            System.out.println("Enter new tutorial building: ");
            String newBuilding = input.next();
            tutorialSelected.setBuilding(newBuilding);
        } else if (modifyTutorialAction.equals("ch--room")) {
            System.out.println("Enter new tutorial room: ");
            int newRoom = input.nextInt();
            tutorialSelected.setRoomNumber(newRoom);
        }
    }

}

