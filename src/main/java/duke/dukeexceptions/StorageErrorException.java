package main.java.duke.dukeexceptions;

public class StorageErrorException extends DukeException{
    public StorageErrorException(String msg) {
        super(msg);
    }

    @Override
    public void callback() {
        System.out.println(
                "____________________________________________________________"
        );
        System.out.println("Invalid Storage");
        System.out.println(
                "____________________________________________________________"
        );
    }
}
