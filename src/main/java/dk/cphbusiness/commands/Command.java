package dk.cphbusiness.commands;

import java.util.Arrays;

import com.google.common.base.Preconditions;

public class Command {
    private String name;
    private String[] args;
    private String help;
    
    public Command(String name) {
        setName(name);
    }
    
    public Command(String name, String help) {
        setName(name);
        setHelp(help);
    }
    
    public Command(String name, String[] args) {
        setName(name);
        setArgs(args);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        Preconditions.checkNotNull(name, "Command name may not be null");
        Preconditions.checkArgument(!name.isEmpty(), "Command name may not be an empty string");
        
        this.name = name;
    }
    
    public String getHelp() {
        return help;
    }

    public void setHelp(String help) {
        Preconditions.checkNotNull(help, "Command help may not be null");
        Preconditions.checkArgument(!help.isEmpty(), "Command help may not be an empty string");
        
        this.help = help;
    }

    public String[] getArgs() {
        return args;
    }

    public void setArgs(String... args) {
        Preconditions.checkNotNull(args);
        
        this.args = args;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        //result = prime * result + Arrays.hashCode(args);
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        
        Command other = (Command) obj;
        /*if (!Arrays.equals(args, other.args)) {
            return false;
        }*/
        
        if (name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!name.equals(other.name)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Command [name=" + name + ", args=" + Arrays.toString(args)
                + ", help=" + help + "]";
    }

}
