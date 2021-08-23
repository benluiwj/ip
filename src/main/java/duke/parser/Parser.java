package duke.parser;

import duke.command.Command;
import duke.command.ByeCommand;
import duke.command.DeadLineCommand;
import duke.command.DeleteCommand;
import duke.command.DoneCommand;
import duke.command.ErrorCommand;
import duke.command.EventCommand;
import duke.command.ListCommand;
import duke.command.ToDoCommand;

/**
 * Processes the commands from Duke and initialises the appropriate command for it.
 */

public class Parser {
    /**
     * Processes the commands from Duke.
     * @param command the command from Duke
     * @return a command based on the commands from Duke
     */
    public Command parse(String command) {
        if (command.equals("list")) {
            return new ListCommand();

        } else if (command.equals("bye")) {
            return new ByeCommand();

        } else if (command.contains("todo")) {
            return prepToDo(command);

        } else if (command.contains("deadline")) {
            return prepDeadLine(command);

        } else if (command.contains("event")) {
            return prepEvent(command);

        } else if (command.contains("done")) {
            return prepDone(command);

        } else if (command.contains("delete")) {
            return prepDelete(command);
        }
        return new ErrorCommand();
    }

    /**
     * Initialises the ToDo command.
     * @param command the ToDo command from Duke
     * @return ToDo command to be executed
     */
    Command prepToDo(String command) {
        int startIndex = "todo".length();
        int endIndex = command.length();
        String task = command.substring(startIndex, endIndex);
        return new ToDoCommand(task);
    }

    /**
     * Initialises the DeadLine command.
     * @param command the DeadLine command from Duke
     * @return DeadLine command to be executed
     */
    Command prepDeadLine(String command) {
        int startIndex = "deadline".length();
        int endIndex = command.length();
        String task = command.substring(startIndex, endIndex);
        return new DeadLineCommand(task);
    }

    /**
     * Initialises the Event command.
     * @param command the Event command from Duke
     * @return Event command to be executed
     */
    Command prepEvent(String command) {
        int startIndex = "event".length();
        int endIndex = command.length();
        String task = command.substring(startIndex, endIndex);
        return new EventCommand(task);
    }

    /**
     * Initialises the Done command.
     * @param command the Done command from Duke
     * @return Done command to be executed
     */
    Command prepDone(String command) {
        int i = Integer.parseInt(
                String.valueOf(
                    command.toCharArray()[command.length() - 1])) - 1;
        return new DoneCommand(i);
    }

    /**
     * Initialises the Delete command.
     * @param command the Delete command from Duke
     * @return Delete command to be executed
     */
    Command prepDelete(String command) {
        int i = Integer.parseInt(
                String.valueOf(
                    command.toCharArray()[command.length() - 1])) - 1;
        return new DeleteCommand(i);
    }
}