package main.java;

public class ToDoException extends DukeException{
    ToDoException(String msg) {
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
