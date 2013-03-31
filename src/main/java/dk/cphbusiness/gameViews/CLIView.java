package dk.cphbusiness.gameViews;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.concurrent.ArrayBlockingQueue;

import dk.cphbusiness.commands.Command;

public class CLIView extends GameView {

    public CLIView(ArrayBlockingQueue<String> messageQueue,
            ArrayBlockingQueue<Command> commandQueue) {
        super(messageQueue, commandQueue);
    }

    public void run() {
        MessageWriter messageWriter = new MessageWriter(messageQueue);
        Thread messageWriterThread = new Thread(messageWriter);

        messageWriterThread.setDaemon(true);
        messageWriterThread.start();

        while (true) {
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    System.in));
            String line = "";

            try {
                line = in.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            String[] cmdInput = line.split("\\s+");
            Command cmd = new Command(cmdInput[0], Arrays.copyOfRange(cmdInput, 1, cmdInput.length));
            
            try {
                commandQueue.put(cmd);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private class MessageWriter implements Runnable {
        private ArrayBlockingQueue<String> messageQueue;

        public MessageWriter(ArrayBlockingQueue<String> messageQueue) {
            this.messageQueue = messageQueue;
        }

        public void run() {
            while (true) {
                String message;

                try {
                    message = messageQueue.take();
                } catch (InterruptedException e) {
                    continue;
                }

                System.out.println(message);
            }
        }
    }
}
