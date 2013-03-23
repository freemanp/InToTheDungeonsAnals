package dk.cphbusiness.models;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;

public class Item {
    private String name;
    private int value;
    
    public Item(String name, int value) {
        this.setName(name);
        this.setValue(value);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        Preconditions.checkArgument(name != null, "Item name may not be null");
        Preconditions.checkArgument(!name.isEmpty(), "Item name may not be an empty string");
        
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        Preconditions.checkArgument(value > 0, "Item value was %s but expected nonnegative", value);
        
        this.value = value;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + value;
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
        Item other = (Item) obj;
        if (name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!name.equals(other.name)) {
            return false;
        }
        if (value != other.value) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Item [name=" + name + ", value=" + value + "]";
    }
}
