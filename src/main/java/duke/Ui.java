package duke;

/**
 * Class that deals with all the interactions with the user for CLI application.
 */
public class Ui {

    private static final String LINE =
            "--------------------------------------------------------------------------------------";

    private static final String LOGO = " ____        _        \n"
            + "|  _ \\ _   _| | _____ \n"
            + "| | | | | | | |/ / _ \\\n"
            + "| |_| | |_| |   <  __/\n"
            + "|____/ \\__,_|_|\\_\\___|\n";

    private static final String WELCOME_MESSAGE = "Hello! I'm Duke, your personal task manager!\n"
            + "What can I do for you?\n"
            + "Type help to learn how to use Duke!";

    private static final String HELP_MESSAGE = "Add tasks by commands: todo, deadline, event\n"
            + "E.g. todo run, deadline hw /by yyyy-mm-dd {time}, event meeting /at {date and/or time}\n"
            + "\n"
            + "To view list, type 'list'\n"
            + "\n"
            + "To delete or mark task as done, type 'delete {task number}' or 'done {task number}'\n"
            + "\n"
            + "To find tasks by keyword, type 'find' followed by keywords.\n"
            + "E.g. If your keyword is run, type 'find run'.\n"
            + "\n"
            + "To exit, type 'bye'.";


    public Ui() {}

    /**
     * Gets the help message.
     *
     * @return the help message.
     */
    public static String getHelpMessage() {
        return HELP_MESSAGE;
    }

    /**
     * Gets the welcome message string.
     *
     * @return Welcome message string.
     */
    public static String getWelcomeMessage() {
        return WELCOME_MESSAGE;
    }

    /**
     * Shows welcome message to user.
     */
    public static void showWelcomeMessage() {
        showToUser(LOGO, WELCOME_MESSAGE, LINE, HELP_MESSAGE, LINE);
    }

    /**
     * Shows message to warn user that task number is missing.
     */
    public static void showWarningMissingNumber() {
        String message = "OOPS!!! To delete a task, the task number must be stated.";
        showToUser(LINE, message, LINE);
    }

    /**
     * Shows message to warn user that keyword is missing.
     */
    public static void showWarningMissingKeyword() {
        String message = "OOPS!!! To find a task, a keyword must be stated.";
        showToUser(LINE, message, LINE);
    }

    /**
     * Warns user that there is a missing description for the task.
     *
     * @param command Command word from user input.
     */
    public static void showWarningMissingDescription(String command) {
        switch (command) {
        case "todo":
            String todoMessage = "OOPS!!! The description of a todo cannot be empty.";
            showToUser(LINE, todoMessage, LINE);
            break;
        case "deadline":
            String deadlineMessage = "OOPS!!! The description of a deadline cannot be empty.";
            showToUser(LINE, deadlineMessage, LINE);
            break;
        case "event":
            String eventMessage = "OOPS!!! The description of an event cannot be empty.";
            showToUser(LINE, eventMessage, LINE);
            break;
        }
    }

    /**
     * Shows goodbye message when user exits programme with command bye.
     */
    public static void showGoodbyeMessage() {
        String message = "     Bye. Hope to see you again soon!";
        showToUser(LINE, message, LINE);
    }

    /**
     * Shows message prompting user that command is invalid or wrong.
     */
    public static void showInvalidInputMessage() {
        String message = "OOPS!!! I'm sorry, but I don't know what that means :-(";
        showToUser(LINE, message, LINE);
    }

    /**
     * Shows message that warns user that due date of a deadline cannot be empty.
     */
    public static void showMissingDeadline() {
        System.out.println("---------------------------------------------");
        System.out.println("OOPS!!! The due date of a deadline cannot be empty.");
        System.out.println("Use format \"/by yyyy-mm-dd {time}\" when providing due date.");
        System.out.println("---------------------------------------------");
    }

    /**
     * Shows message that warns user that details of an event cannot be empty.
     */
    public static void showMissingEventDetails() {
        System.out.println("---------------------------------------------");
        System.out.println("OOPS!!! The details of an event cannot be empty.");
        System.out.println("Please input time, day, or - if details unknown.");
        System.out.println("---------------------------------------------");
    }

    /**
     * Method that takes in mutliple strings to form a message shown to the user.
     * @param message Messages that form the whole message.
     */
    public static void showToUser(String... message) {
        for (String m : message) {
            System.out.println(m);
        }
    }


}
