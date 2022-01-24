package main.java;

import java.time.LocalDateTime;

/**
 * Deadline is a type of Task that contains addition.
 */

public class Deadline extends Task {
  private String type = "D";
  private String info;
  private LocalDateTime dateInfo;
  

  /**
   * Constructor for deadline.
   * 
   * @param name name of task.
   * @param dateInfo additional dateInfo of the task.
   */

  Deadline(String name, String dateInfo) {
    super(name);
    info = dateInfo;
    this.dateInfo = LocalDateTime.parse(dateInfo, this.dateTimeFormatIn);
  }

  Deadline(String name, boolean marked, String dateInfo) {
    super(name);
    this.dateInfo = LocalDateTime.parse(dateInfo, this.dateTimeFormatIn);
    this.isMarked = marked;
  }

  @Override
  String toStore() {
    return this.type + " | " + this.markStore() + " | " + this.name + " | " + this.info;
  }

  /**
   * @return String representation of the task.
   */

  @Override
  String display() {
    return "[" + this.type + "] " + "[" + markDisplay() + "] " + this.name + " (by " + dateInfo.format(this.dateTimeFormatterOut) + ")";
  }
}
