package corejava;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class SetTest {
    public static void main(String[] args) {
        long totalTime=0;
        List<String> word=new LinkedList<String>();
        word.add("jack");
        word.add("king");
        word.add("kool");
        word.add("hi");

        var words=new HashSet<>(word);

        Iterator<String> iter=words.iterator();
        for (int i=1;i<=20&&iter.hasNext();i++)
        {
            System.out.println(iter.next());
        }
        System.out.println("...");
        System.out.println(words.size()+" distinct words. "+totalTime+" millisecond. ");
    }
}
