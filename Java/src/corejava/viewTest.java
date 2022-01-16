package corejava;

import com.king.corejava.Employee;

import java.util.*;

public class viewTest {
    public static void main(String[] args) {
        //All the collection below is unchangeable,only new etc. can be changed
        List<String> smallList=List.of("king","jack","marry");
//        smallList.add("hi"); like this one which is not permitted
        var changeableList=new ArrayList<>(smallList);
        changeableList.add("vinay");//like this that can be changed
        Set<Integer> smallInteger=Set.of(2,3,4);
        Map<String,Integer> smallMap=Map.ofEntries(Map.entry("king",1),
                Map.entry("jack",2),Map.entry("marry",3));
        System.out.println(smallList);//still, it's not changed
        System.out.println(changeableList);
        System.out.println(smallInteger);
        System.out.println(smallMap);

        List<String> settings= Collections.nCopies(10,"copied");
        //above:return a type that is not changeable,each element is copied by the number given
        System.out.println(settings);

        var staff=new Employee[5];
        staff[0]=new Employee("king");
        staff[1]=new Employee("jack");
        staff[2]=new Employee("vinay");
        staff[3]=new Employee("alan");
        staff[4]=new Employee("marry");
        List<Employee> staffList=new ArrayList<>();
        staffList.addAll(List.of(staff));//List.of can turn an array into a list
        var subList=staffList.subList(2,4);
        //above:create a new list that have elements from the specified list that range from num1 to num2,and num1 is included while num2 is not
        System.out.println(staffList);
        System.out.println(subList);//sublist can impact the original list
        subList.clear();
        System.out.println(subList+" \n"+staffList);//the original list is also reduced same to the reduction of sublist

        var modifiableList=Collections.unmodifiableList(staffList);
//        this list is not permitted to be modified but read

    }
}
