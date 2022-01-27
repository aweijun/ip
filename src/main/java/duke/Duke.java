package main.java.duke;
import main.java.duke.command.ByeCommand;
import main.java.duke.command.Command;
import main.java.duke.data.Storage;
import main.java.duke.data.TaskList;
import main.java.duke.dukeexceptions.DukeException;
import main.java.duke.parser.Parser;
import main.java.duke.responses.Response;
import main.java.duke.ui.Ui;

/**
 * Duke is a program that takes in user inputs and stores them as Tasks
 */

public class Duke {
  TaskList taskList;
  Storage store;
  Parser commandHandler;
  Ui cmdLine;

  boolean isRunning = true;

  /**
   * Constructor for Duke Chatbot
   */
  Duke() {
    this.taskList = new TaskList();
    this.store = new Storage(taskList);
    this.commandHandler = new Parser();
    this.cmdLine = new Ui();
  }

  /**
   * Starts Duke
   */
  public void run() {
    
    store.initialiseStorage();
    taskList = store.loadFromDisk();
    cmdLine.callResponse(commandHandler.welcome());
    cmdLine.callResponse(commandHandler.start());
    
    while(isRunning) {
      try {
        String stringCmd = cmdLine.getNextLine();
        Command cmd = commandHandler.getCommand(stringCmd);
        cmd.getResources(store, taskList);
        if (cmd instanceof ByeCommand) {
          isRunning = false;
        }
        Response feedback = cmd.execute();
        cmdLine.callResponse(feedback);
      } catch (DukeException e) {
        e.callback();
      }
    }

  }
  /**
   * Method that stops the Chatbot;
   */
  public void stop() {
    this.isRunning = false;
  }

  public static void main(String[] args) {
    new Duke().run();
  }
}
