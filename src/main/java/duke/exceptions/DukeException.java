package duke.exceptions;

public class DukeException extends Exception{
    public DukeException(String message) {
        super(message);
    }

    public DukeException() { }

    @Override
    public String toString() {
        return "Error! DukeException";
    }
}
