package dk.cphbusiness.commands.handlers;

import dk.cphbusiness.commands.Command;
import dk.cphbusiness.utils.Translator;


public class QuitHandler extends CommandHandler {
    @Override
    public void handleCommand(Command cmd) {
        try {
            messageQueue.put(Translator.getMessage("goodbye"));
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
