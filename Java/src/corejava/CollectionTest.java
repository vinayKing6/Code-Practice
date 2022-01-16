package corejava;

import java.util.*;

public class CollectionTest {
    public static void main(String[] args) {
        List<String> list=new LinkedList<String>();
        list.add("hi");
        list.add("hello");
        Iterator<String> iterator=list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        var staff=new LinkedList<String>();
        staff.add("king");
        staff.add("vinay");
        staff.add("jack");
        var it=staff.iterator();
        it.next();
        it.remove();
        System.out.println(it.next());
        for (String s:staff)
        {
            System.out.println(s);
        }
        for (int i=0;i<staff.size();i++)
        {
            System.out.println(staff.get(i));
        }
        ListIterator<String> listIterator=staff.listIterator();
        listIterator.next();
        listIterator.add("marry");
        for (String s:staff)
        {
            System.out.println(s);
        }
        System.out.println(listIterator.nextIndex());
        System.out.println(listIterator.next());
        listIterator.set("hi");//修改上一个元素
        for (String s:staff)
        {
            System.out.println(s);
        }
        System.out.println(staff);
    }
}
