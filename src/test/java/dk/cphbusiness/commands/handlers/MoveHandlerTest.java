package dk.cphbusiness.commands.handlers;

import static org.mockito.Mockito.*;

import java.util.concurrent.ArrayBlockingQueue;

import junit.framework.Assert;

import org.junit.Test;

import dk.cphbusiness.GameRunner;
import dk.cphbusiness.commands.Command;
import dk.cphbusiness.models.Dungeon;
import dk.cphbusiness.models.Player;

public class MoveHandlerTest {

    @Test
    public void should_move_the_player_to_the_desired_dungeon() {
        MoveHandler moveHandler = new MoveHandler();
        
        Dungeon rootDungeon = new Dungeon();
        Dungeon expectedDestination = new Dungeon();
        
        rootDungeon.addConnectedDungeon(expectedDestination);
        
        Player p = new Player(rootDungeon);
        
        ArrayBlockingQueue<String> messageQueue = new ArrayBlockingQueue<String>(5);
        GameRunner mockGameRunner = mock(GameRunner.class);
        when(mockGameRunner.getPlayer()).thenReturn(p);
        
        moveHandler.setMessageQueue(messageQueue);
        moveHandler.setGameRunner(mockGameRunner);
        
        Command moveCmd = new Command("move", new String[] {"0"});
        moveHandler.handleCommand(moveCmd);
        
        Assert.assertTrue(p.getCurrentDungeon().equals(expectedDestination));
    }

}
