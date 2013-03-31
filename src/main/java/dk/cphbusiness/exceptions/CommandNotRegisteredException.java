package dk.cphbusiness.exceptions;

public class CommandNotRegisteredException extends Exception {
    private static final long serialVersionUID = 4813952505706849125L;

    public CommandNotRegisteredException(String name) {
        super(name);
    }
}
