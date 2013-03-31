package dk.cphbusiness;

import dk.cphbusiness.commands.Commands;

public class AppStart {

    public static void main(String[] args) {
        Commands commands = new Commands();
        new GameRunner(commands).start();
    }
}
