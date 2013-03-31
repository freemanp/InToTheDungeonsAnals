package dk.cphbusiness.commands.handlers;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.concurrent.ArrayBlockingQueue;

import org.junit.Test;

import dk.cphbusiness.GameRunner;

public class QuitHandlerTest {

    @Test
    public void should_stop_the_game() throws InterruptedException {
        QuitHandler quitHandler = new QuitHandler();
        ArrayBlockingQueue<String> messageQueue = new ArrayBlockingQueue<String>(5);
        GameRunner mockGameRunner = mock(GameRunner.class);
        
        quitHandler.setMessageQueue(messageQueue);
        quitHandler.setGameRunner(mockGameRunner);
        
        quitHandler.handleCommand();
        
        verify(mockGameRunner).stop();
    }
}
