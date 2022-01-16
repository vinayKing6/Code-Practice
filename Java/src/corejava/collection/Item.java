package corejava.collection;

import java.util.Objects;

public class Item implements Comparable<Item>{
    private String description;
    private int partNumber;

    public Item(String description,int partNumber){
        this.description=description;
        this.partNumber=partNumber;
    }

    public String getDescription(){
        return description;
    }

    public String toString(){
        return "["+description+" , "+partNumber+" ]";
    }

    public boolean equals(Object otherObject){
        if (this==otherObject) return true;
        if (otherObject==null) return false;
        if (getClass()!=otherObject.getClass()) return false;
        var other=(Item)otherObject;
        return Objects.equals(description,other.description)&&partNumber==other.partNumber;
    }

    public int hashCode()
    {
        return Objects.hash(description,partNumber);
    }
    @Override
    public int compareTo(Item o) {
        int diff=Integer.compare(partNumber,o.partNumber);
        return diff !=0? diff:description.compareTo(o.description);
    }
}
