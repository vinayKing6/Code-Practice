package corejava;

import corejava.generic.Pair;
import com.king.corejava.*;
public class genericTest {
    public static void main(String[] args) {
        var pair=new Pair<>("hi","world");
        var e=new Employee("jack");
        printBuddies(new Pair<>(new Employee("jack",10000,2020,9,19),new Employee("king",20000,2020,5,6)));
        var manngerBuddies=new Manager[2];
        manngerBuddies[0]=new Manager("therery",3000,2019,12,12);
        manngerBuddies[1]=new Manager("marry",100000,2021,3,18);
        printBuddies(new Pair<Manager>(manngerBuddies[0],manngerBuddies[1]));
        printSuperBuddies(new Pair<>(e,e));
        System.out.println(hasNull(new Pair<>("hi",null)));
        Pair<?> instance;
        swap(instance=new Pair<>("Hello","king"));
        System.out.println(instance);
    }
    public static void printBuddies(Pair<? extends Employee> p)//通配符使用
    {
        var first=p.getFirst();
        var second=p.getSecond();
//        p.setFirst(new Employee("vinay",300,2021,6,7));无法使用setFirst,即无法为方法传入参数(只能使用确定的类型，例如Pair<Employee>)
        System.out.println(first.getClass().getName()+" "+first.getName()+" and "+second.getClass().getName()+" "+second.getName()+" are buddies");
    }
    public static void printSuperBuddies(Pair<? super Manager> p)
    {
        System.out.println(p.getFirst());
    }
    public static boolean hasNull(Pair<?> p)
    {
        boolean b = p.getFirst() == null || p.getSecond()==null;
        return b;
    }
    public static void swap(Pair<?> p)
    {
        swapHelper(p);
    }
    public static <T> void swapHelper(Pair<T> p)
    {
        T tmp=p.getFirst();
        p.setFirst(p.getSecond());
        p.setSecond(tmp);
    }
    public static <T extends Comparable<T>> Pair<T> getPair(T[] elements) {
        T max = elements[0];
        T min = elements[0];
        for (T t : elements) {
            if (t.compareTo(max) > 0)
                max = t;
            if (t.compareTo(min) < 0)
                min = t;
        }
        return new Pair<T>(max,min);
    }
}
