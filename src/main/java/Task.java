package main.java;

import java.time.format.DateTimeFormatter;

/**
 * Task that
 */

public class Task {
  /**
   * String that represent if Task is done
   */
  boolean isMarked = false;

  /**
   * String represent the name of the task.
   */
  String name;


  /**
   * DateTimeFormator for the incoming dates
   */
  DateTimeFormatter dateTimeFormatIn = DateTimeFormatter.ofPattern("d/M/y kkmm");
  DateTimeFormatter dateTimeFormatterOut = DateTimeFormatter.ofPattern("MMM d y");
  
  /**
   * Constructs a Task from the given name.
   * 
   * @param name given name of the task.
   */
  Task(String name) {
    this.name = name;
  }

  /**
   * Void methods that sets the completeness of the task based on the input.
   * 
   * @param bool representing the completeness of the task.
   */

  void setMark(boolean bool) {
    this.isMarked = bool;
    MarkResponse(this.isMarked);
  }

  /**
   * Void methods that inform the user when the state of completeness has been
   * toggled.
   * 
   * @param val representing the completeness of the task.
   */

  void MarkResponse(boolean val) {
    System.out.println(
        "____________________________________________________________");
    if (val) {
      System.out.println("Nice! I've marked this task as done:\n");
    } else {
      System.out.println("OK, I've marked this task as not done yet:\n");
    }

    System.out.println(this.display());
    System.out.println(
        "____________________________________________________________");
  }

  String markDisplay() {
    if (this.isMarked) {
      return "X";
    } else {
      return " ";
    }
  }

  String markStore() {
    if (this.isMarked) {
      return "1";
    } else {
      return "0";
    }
  }

  String toStore() {
    return "";
  }

  /**
   * method that returns the string representation of the Task
   * 
   * @return a String representation fo the task.
   */
  String display() {
    return "[" + markDisplay() + "] " + this.name;
  }
}
