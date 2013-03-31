package dk.cphbusiness.commands.handlers;

import dk.cphbusiness.commands.Command;


public class QuitHandler extends CommandHandler {
    @Override
    public void handleCommand(Command cmd) {
        try {
            messageQueue.put("Have a nice day.");
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        gameRunner.stop();
    }
}
