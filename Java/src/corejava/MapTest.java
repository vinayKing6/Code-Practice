package corejava;

import com.king.corejava.Employee;

import java.util.HashMap;

public class MapTest {
    public static void main(String[] args) {
        //hashMap
        var staff=new HashMap<String, Employee>();//键/值
        var king=new Employee("king");
        var jack=new Employee("jack");

        staff.put("990-888-001",king);
        staff.put("990-888-002",jack);

        System.out.println(staff);

        var id="990-888-002";
        Employee e=staff.get(id);
        System.out.println(e);
        System.out.println();

        staff.forEach((k,v)->System.out.println("key: "+k+" ,value: "+v));
    }
}
