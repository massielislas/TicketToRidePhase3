package Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created by Topper on 5/14/2018.
 */

public class CommandManager {

    private final static CommandManager instance = new CommandManager();
    private Map<UserPass,Command[]> commandMap;
    public static CommandManager getInstance() {
        return instance;
    }

    public void addCommand(UserPass username, Command command) {
        if(commandMap.containsKey(username)) {
            Command[] commands = commandMap.get(username);
            ArrayList<Command> commandList = new ArrayList<>(Arrays.asList(commands));
            commandList.add(command);
            commandMap.put(username, (Command[]) commandList.toArray());
        }
        else
        {
            Command[] newCommandArray = {command};
            commandMap.put(username,newCommandArray);
        }
    }

    public void getNewCommands(UserPass username, int lastCommand) {
        if(commandMap.containsKey(username)){
            Command[] allCommands = commandMap.get(username);
            Command[] toReturn = new Command[allCommands.length-lastCommand];
            System.arraycopy(allCommands,lastCommand,toReturn,0,allCommands.length-lastCommand);
        }
    }
    public void addCommandMultipleUsers(List<UserPass> userList, Command command){
        for(UserPass user:userList) {
            addCommand(user,command);
        }
    }

    public void addCommandAllUsers(Command command)
    {
        for(UserPass key: commandMap.keySet())
        {
            addCommand(key, command);
        }
    }
}