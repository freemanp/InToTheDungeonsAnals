package dk.cphbusiness.commands.handlers;

import dk.cphbusiness.commands.Command;

public class HelpHandler extends CommandHandler {

    @Override
    public void handleCommand() {
        try {
            Command[] cmds = commands.listCommands();
            for (Command cmd : cmds) {
                messageQueue.put(cmd.getName() + " - " + cmd.getHelp());
            }
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
    }

}
