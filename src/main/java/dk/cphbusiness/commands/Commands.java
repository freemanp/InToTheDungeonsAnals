package dk.cphbusiness.commands;

import java.util.Map;
import java.util.Set;

import com.google.common.collect.Maps;

import dk.cphbusiness.commands.handlers.CommandHandler;
import dk.cphbusiness.commands.handlers.HelpHandler;
import dk.cphbusiness.commands.handlers.QuitHandler;
import dk.cphbusiness.exceptions.CommandNotRegisteredException;

public class Commands {
    private Map<Command, Class<? extends CommandHandler>> commandsAndHandlers;

    public Commands() {
        commandsAndHandlers = Maps.newHashMap();
        
        commandsAndHandlers.put(new Command("help", "Lists all commands and their purpose."), HelpHandler.class);
        commandsAndHandlers.put(new Command("quit", "Exits the game."), QuitHandler.class);
        commandsAndHandlers.put(new Command("move", "Move to a different dungeon"), QuitHandler.class);
    }
    
    public Command[] listCommands() {
        Set<Command> keySet = commandsAndHandlers.keySet();
        
        return keySet.toArray(new Command[keySet.size()]);
    }
    
    public Class<? extends CommandHandler> getCommandHandler(Command cmd) throws CommandNotRegisteredException {
        if (!commandsAndHandlers.containsKey(cmd))
            throw new CommandNotRegisteredException(cmd.getName());
        return commandsAndHandlers.get(cmd);
    }
}
