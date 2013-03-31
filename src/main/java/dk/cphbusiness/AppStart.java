package dk.cphbusiness;

import dk.cphbusiness.commands.Commands;
import dk.cphbusiness.utils.Translator;

public class AppStart {

    public static void main(String[] args) {
    	String startingLanguage = new String("en");
    	String startingCountry = new String("US");
        
    	if (args.length >= 2){
	        startingLanguage = new String(args[0]);
	        startingCountry = new String(args[1]);
    	}
    	
    	Translator.changeLanguage(startingLanguage, startingCountry);
    	
        Commands commands = new Commands();
        new GameRunner(commands).start();
    }
}
