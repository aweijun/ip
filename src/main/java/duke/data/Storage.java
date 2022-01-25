package main.java.duke.data;

import main.java.duke.task.Deadline;
import main.java.duke.task.Event;
import main.java.duke.task.Task;
import main.java.duke.task.ToDo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Storage {

  File storageTaskList;
  TaskList runningTaskList;
  
  public Storage(TaskList runningTaskList) {
    this.storageTaskList = new File("data/command.txt");
    this.runningTaskList = runningTaskList;
  }
  
  public void initaliseStorage() {
    File data = new File("data");
    try {
      if (data.exists()) {
      } else {
        data.mkdir();
      }
      if (storageTaskList.exists()) {
      } else {
        storageTaskList.createNewFile();
      }
      this.loadFromDisk(runningTaskList);
    } catch (Exception e) {
        e.getMessage();
    } 
  }
  
  

  static private boolean storageToMark(String mark) {
    if (mark.equals("1")) {
      return true;
    } else {
      return false;
    }
  }

  static private Task storageToTask(String taskString) {
    String[] commandSplit = taskString.split(" \\| ");
    System.out.println(Arrays.toString(commandSplit));
    switch (commandSplit[0]) {
      case "T":
        return new ToDo(commandSplit[2], storageToMark(commandSplit[1]));
      case "D":
        return new Deadline(commandSplit[2], storageToMark(commandSplit[1]), commandSplit[3]);
      case "E":
        return new Event(commandSplit[2], storageToMark(commandSplit[1]), commandSplit[3]);
      default:
        return null;
    }
  }
  

  public void loadFromDisk(TaskList taskList) throws FileNotFoundException {
    Scanner fileReader = new Scanner(this.storageTaskList);
    while (fileReader.hasNext()) {
      String command = fileReader.nextLine();
      taskList.addTask(storageToTask(command));
    }
  }

  public void loadToDisk(TaskList taskList) throws IOException {
    FileWriter fileWriter = new FileWriter(this.storageTaskList);
    for (int i = 0; i < taskList.taskLength(); i++) {
      fileWriter.write(taskList.getTask(i).toStore() + "\n");
    }
    fileWriter.close();

  }
}
