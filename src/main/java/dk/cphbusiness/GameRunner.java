package dk.cphbusiness;

import java.util.concurrent.ArrayBlockingQueue;

import dk.cphbusiness.models.Dungeon;
import dk.cphbusiness.models.Player;

public class GameRunner {
    private final int QUEUE_CAPACITY = 100;
    private ArrayBlockingQueue<String> messageQueue; 
    private ArrayBlockingQueue<String> commandQueue; 
    
    private boolean isGameRunning;
    private Player player;
    
    public GameRunner() {
        this.isGameRunning = false;
        messageQueue = new ArrayBlockingQueue<String>(QUEUE_CAPACITY);
        commandQueue = new ArrayBlockingQueue<String>(QUEUE_CAPACITY);
    }

    public void start() {
        isGameRunning = true;
        
        initializeGame();
        
        while(isGameRunning) {
            
        }
    }
    
    private void initializeGame() {
        Dungeon d1 = new Dungeon();
        Dungeon d2 = new Dungeon();
        
        d1.addConnectedDungeon(d2);
        
        player = new Player(d1);
    }

    public void stop() {
        isGameRunning = false;
    }
}
