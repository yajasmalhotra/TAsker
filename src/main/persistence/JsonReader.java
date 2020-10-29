package persistence;

// Represents a reader that reads schedule from JSON data stored in file

import model.Lab;
import model.Schedule;
import model.Task;
import model.Tutorial;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads schedule from file and returns it
    // throws IOException if an error occurs reading data from file
    public Schedule read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseSchedule(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder =  new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses workroom from JSON object and returns it
    private Schedule parseSchedule(JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        Schedule schedule = new Schedule(name);
        addTasks(schedule, jsonObject);
        addLabs(schedule, jsonObject);
        addTutorials(schedule, jsonObject);
        return schedule;
    }

    // MODIFIES: schedule
    // EFFECTS: parses task from JSON object and adds it to schedule
    private void addTask(Schedule schedule, JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        Task task = new Task(name);
        schedule.addTask(task);
    }

    // MODIFIES: schedule
    // EFFECTS: parses tasks from JSON object and adds them to schedule
    private void addTasks(Schedule schedule, JSONObject jsonObject) {
        JSONArray taskJsonArray = jsonObject.getJSONArray("tasks");

        for (Object json : taskJsonArray) {
            JSONObject nextTask = (JSONObject) json;
            addTask(schedule, nextTask);
        }

    }

    // MODIFIES: schedule
    // EFFECTS: parses lab from JSON object and adds it to schedule
    private void addLab(Schedule schedule, JSONObject jsonObject) {
        String courseName = jsonObject.getString("courseName");
        int courseNum = jsonObject.getInt("courseNum");
        String sectionName = jsonObject.getString("sectionName");
        Lab lab = new Lab(courseName, courseNum, sectionName);
        schedule.addLab(lab);
    }

    // MODIFIES: schedule
    // EFFECTS: parses labs from JSON object and adds them to schedule
    private void addLabs(Schedule schedule, JSONObject jsonObject) {
        JSONArray labJsonArray = jsonObject.getJSONArray("labs");
        for (Object json : labJsonArray) {
            JSONObject nextLab = (JSONObject) json;
            addLab(schedule, nextLab);
        }
    }

    // MODIFIES: schedule
    // EFFECTS: parses lab from JSON object and adds it to schedule
    private void addTutorial(Schedule schedule, JSONObject jsonObject) {
        String courseName = jsonObject.getString("courseName");
        int courseNum = jsonObject.getInt("courseNum");
        String sectionName = jsonObject.getString("sectionName");
        Tutorial tutorial = new Tutorial(courseName, courseNum, sectionName);
        schedule.addTutorial(tutorial);
    }

    // MODIFIES: schedule
    // EFFECTS: parses labs from JSON object and adds them to schedule
    private void addTutorials(Schedule schedule, JSONObject jsonObject) {
        JSONArray tutorialJsonArray = jsonObject.getJSONArray("labs");
        for (Object json : tutorialJsonArray) {
            JSONObject nextTutorial = (JSONObject) json;
            addTutorial(schedule, nextTutorial);
        }
    }


}
