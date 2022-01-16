package corejava;

import corejava.collection.Item;

import java.util.Comparator;

public class TreeSet {
    public static void main(String[] args) {
        var parts=new java.util.TreeSet<Item>();
        parts.add(new Item("i am zack",1234));
        parts.add(new Item("i am king",899));
        parts.add(new Item("i am vinay",899));
        System.out.println(parts);

        var sortByDescription=new java.util.TreeSet<Item>(Comparator.comparing(Item::getDescription));

        sortByDescription.addAll(parts);
        System.out.println(sortByDescription);

    }
}
