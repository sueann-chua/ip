package duke;

import duke.tasks.Task;

import java.util.ArrayList;

/**
 * The class that contains all the operations that change the list of tasks
 * such as adding, completing, deleting.
 */
public class TaskList {
    private ArrayList<Task> tasks;

    /**
     * Public constructor.
     *
     * @return An instance of TaskList.
     */
    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    /**
     * Marks task as complete and shows message to user.
     *
     * @param taskID Task index as shown to the user.
     */
    public void completeTask(int taskID) {
        this.tasks.get(taskID - 1).markAsDone();
    }

    /**
     * Add task to list and shows message to user.
     *
     * @param newTask Task to be added.
     */
    public void addTask(Task newTask) {
        this.tasks.add(newTask);
    }

    /**
     * Lists all the items in the list if they have not been deleted.
     */
    public void listItems() {
        for (int i = 0; i < this.tasks.size(); i++) {
            int j = i + 1;
            System.out.println("     " + j + ". "
                    + this.tasks.get(i).toString());
        }
    }

    /**
     * Deletes a specific task from the list.
     *
     * @param taskID Task index as shown to user.
     * @throws IndexOutOfBoundsException If taskID is out of bounds.
     */
    public void deleteTask(int taskID) throws IndexOutOfBoundsException{
        if (taskID <=0 || taskID > this.tasks.size()) {
            Response.showNoTask();
            throw new IndexOutOfBoundsException();
        } else {
            this.tasks.remove(taskID - 1);
        }
    }

    /**
     * Getter to get individual tasks from arraylist.
     *
     * @param id Index of task in array.
     * @return Individual tasks.
     */
    public Task getIndividualTask(int id) {
        return this.tasks.get(id);
    }

    /**
     * Getter to get individual tasks from arraylist.
     *
     * @param id Index of task in array.
     * @return Individual tasks in string.
     */
    public String getIndividualTaskInString(int id) {
        return this.tasks.get(id).toString();
    }

    /**
     * Gets the number of tasks in the tasklist.
     *
     * @return Number of tasks in the tasklist.
     */
    public int getLength() {
        return this.tasks.size();
    }

    /**
     * Allows users to find a task by searching for a keyword
     * and using command 'find'.
     *
     * @param keyword Keyword to search with.
     */
    public String findTasks(String keyword) {
        int count = 0;
        String output = Response.showSuccessfulFind() +"\n";
        for (int i = 0; i < this.tasks.size(); i++) {
            String taskDescription = this.getIndividualTask(i).toString();

            int index = taskDescription.indexOf(keyword);

            if (index != -1) {
                count += 1;
                output = Response.showResults(output, count, taskDescription);
            }
        }

        if (count == 0) {
            output = Response.showUnsuccessfulFind();
        }
        return output;
    }
}
