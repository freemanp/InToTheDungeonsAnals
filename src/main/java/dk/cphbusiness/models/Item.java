package dk.cphbusiness.models;

import com.google.common.base.Preconditions;

public class Item {
    private String name;
    private int value;
    
    public Item(String name, int value) {
        Preconditions.checkArgument(name != null, "Item name may not be null");
        Preconditions.checkArgument(!name.isEmpty(), "Item name may not be an empty string");
        Preconditions.checkArgument(value > 0, "Item value was %s but expected nonnegative", value);
        
        this.name = name;
        this.value = value;
    }
}
