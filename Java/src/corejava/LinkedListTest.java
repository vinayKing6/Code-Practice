package corejava;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedListTest {
    public static void main(String[] args) {
        var a=new LinkedList<String>();
        a.add("king");
        a.add("vinay");
        a.add("jack");

        var b=new LinkedList<String>();
        b.add("bob");
        b.add("marry");
        b.add("frances");
        b.add("gloria");

//        merge the word from a to b

        ListIterator<String> aIter=a.listIterator();

        for (String s : b) {
            if (aIter.hasNext())
                aIter.next();
            aIter.add(s);
        }

        System.out.println(a);

//        remove every second word from b

        var bIter=b.iterator();
        while (bIter.hasNext())
        {
            bIter.next();
            if (bIter.hasNext())
            {
                bIter.next();
                bIter.remove();
            }
        }
        System.out.println(b);

//        remove all words in b from a
        a.removeAll(b);
        System.out.println(a);
    }
}
