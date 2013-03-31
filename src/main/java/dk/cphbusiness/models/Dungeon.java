package dk.cphbusiness.models;

import java.util.Collections;
import java.util.List;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;

public class Dungeon {
    private String name;
    private List<Dungeon> connectedDungeons;
    private List<Item> items;
    
    public Dungeon() {
        this.connectedDungeons = Lists.newArrayList();
        this.items = Lists.newArrayList();
    }

    public List<Dungeon> getConnectedDungeons() {
        return connectedDungeons;
    }

    public void setConnectedDungeons(List<Dungeon> connectedDungeons) {
        Preconditions.checkNotNull(connectedDungeons, "Connected dungeons list may not be null");
        
        this.connectedDungeons = connectedDungeons;
    }
    
    public void addConnectedDungeon(Dungeon dungeon) {
        addConnectedDungeons(dungeon);
    }
    
    public void addConnectedDungeons(Dungeon... dungeons) {
        Preconditions.checkNotNull(dungeons, "Dungeons may not be null");
        
        Collections.addAll(this.connectedDungeons, dungeons);
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        Preconditions.checkNotNull(items, "Items list may not be null");
        
        this.items = items;
    }
    
    public void addItem(Item item) {
        addItems(item);
    }
    
    public void addItems(Item... items) {
        Preconditions.checkNotNull(items, "Items list may not be null");
        
        Collections.addAll(this.items, items);
    }

    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        Preconditions.checkArgument(name != null, "Dungeon name may not be null");
        Preconditions.checkArgument(!name.isEmpty(), "Dungeon name may not be an empty string");
        
        this.name = name;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime
                * result
                + ((connectedDungeons == null) ? 0 : connectedDungeons
                        .hashCode());
        result = prime * result + ((items == null) ? 0 : items.hashCode());
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
        Dungeon other = (Dungeon) obj;
        if (connectedDungeons == null) {
            if (other.connectedDungeons != null) {
                return false;
            }
        } else if (!connectedDungeons.equals(other.connectedDungeons)) {
            return false;
        }
        if (items == null) {
            if (other.items != null) {
                return false;
            }
        } else if (!items.equals(other.items)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Dungeon [connectedDungeons=" + connectedDungeons + ", items="
                + items + "]";
    }

    
}
