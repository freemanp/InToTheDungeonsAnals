package dk.cphbusiness.commands.handlers;

import static org.mockito.Mockito.*;

import java.util.concurrent.ArrayBlockingQueue;

import junit.framework.Assert;

import org.junit.Test;

import dk.cphbusiness.commands.Command;
import dk.cphbusiness.commands.Commands;

public class HelpHandlerTest {

    @Test
    public void should_list_all_commands_with_desctiptions() throws InterruptedException {
        HelpHandler helpHandler = new HelpHandler();
        ArrayBlockingQueue<String> messageQueue = new ArrayBlockingQueue<String>(5);
        
        Command expectedCommand = new Command("name", "description");
        Commands mockedCommands = mock(Commands.class);
        when(mockedCommands.listCommands()).thenReturn(new Command[]{expectedCommand});
        
        helpHandler.setMessageQueue(messageQueue);
        helpHandler.setCommands(mockedCommands);
        
        helpHandler.handleCommand();
        
        Assert.assertTrue(messageQueue.size() == 1);
        Assert.assertTrue(messageQueue.take().equals("name - description"));
    }

}
