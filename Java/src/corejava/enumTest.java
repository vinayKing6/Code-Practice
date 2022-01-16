package corejava;

import com.king.corejava.Employee;

import java.util.EnumMap;
import java.util.EnumSet;

public class enumTest {
    public static void main(String[] args) {
        enum Weekday{MONDAY,TUESDAY,WEEKDAY,THURSDAY,FRIDAY,SATURDAY,SUNDAY};
        EnumSet<Weekday> always=EnumSet.allOf(Weekday.class);
        EnumSet<Weekday> never=EnumSet.noneOf(Weekday.class);//create a set that have specified type but empty
        EnumSet<Weekday> workday=EnumSet.range(Weekday.MONDAY,Weekday.FRIDAY);
        EnumSet<Weekday> mwf=EnumSet.of(Weekday.MONDAY,Weekday.WEEKDAY,Weekday.FRIDAY);

        for (Weekday d:always)
        {
            System.out.print(d.toString()+" ");
        }
        System.out.println();
        for (Weekday d:never)
        {
            System.out.print(d.toString()+" ");
        }
        System.out.println();
        for (Weekday d:workday)
        {
            System.out.print(d.toString()+" ");
        }
        System.out.println();
        for (Weekday d:mwf)
        {
            System.out.print(d.toString()+" ");
        }
        System.out.println();
        System.out.println(never);
        var enumMap=new EnumMap<Weekday, Employee>(Weekday.class);
        var staff=new Employee[3];
        staff[0]=new Employee("king");
        staff[1]=new Employee("jack");
        staff[2]=new Employee("marry");
        enumMap.put(Weekday.MONDAY,staff[0]);
        enumMap.put(Weekday.FRIDAY,staff[1]);
        enumMap.put(Weekday.SUNDAY,staff[2]);

        System.out.println(enumMap.get(Weekday.SUNDAY));
        System.out.println(enumMap);
    }
}
