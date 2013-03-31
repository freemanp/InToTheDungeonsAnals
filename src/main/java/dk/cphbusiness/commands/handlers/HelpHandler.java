package dk.cphbusiness.commands.handlers;

import dk.cphbusiness.commands.Command;

public class HelpHandler extends CommandHandler {

    @Override
    public void handleCommand(Command cmd) {
        try {
            Command[] cmds = commands.listCommands();
            for (Command command : cmds) {
                messageQueue.put(command.getName() + " - " + command.getHelp());
            }
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
    }

}
