package application.servlet.webcommand;

import application.context.ApplicationContext;
import application.operations.UserOperations;
import application.servlet.webcommand.impl.DefaultCommand;
import application.servlet.webcommand.impl.UpdateUserCommand;

import java.util.HashMap;
import java.util.Map;

public class CommandContainer {

    private Map<String, Command> commands;
    ApplicationContext applicationContext;

    public CommandContainer(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
        populateCommands();
    }

    public Command getCommand(String command) {
        return commands.getOrDefault(command, new DefaultCommand());
    }

    private void populateCommands() {
        commands = new HashMap<>();
        commands.put(UserOperations.UPDATE_USER.getOperationName(), new UpdateUserCommand(applicationContext.getUserService()));
    }


}
