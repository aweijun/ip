package main.java.duke.dukeexceptions;

public class ToDoException extends main.java.duke.dukeexceptions.DukeException {
    public ToDoException(String msg) {
        super(msg);
    }
    @Override
    public void callback() {
        System.out.println(
                "____________________________________________________________"
        );
        System.out.println("OOPS!!! The description of a todo cannot be empty.");
        System.out.println(
                "____________________________________________________________"
        );
    }
}
