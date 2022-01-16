package java8InAction.charpter4;

import com.king.corejava.Student;
import myToolKit.printList;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class streamTest {
    public static void main(String[] args) {
        List<Student> students=Student.giveMeExamplesToList(10);
        printList.print(students);
        System.out.println();
        List<String> filter=students.parallelStream().filter(student -> student.getId()>80)
                .sorted(Comparator.comparing(Student::getId)).map(Student::getName).collect(Collectors.toList());

        printList.print(filter);
        System.out.println();

        //stream process
        List<Dish> menu= Arrays.asList(
                new Dish("pork",false,800,Dish.Type.MEAT),
                new Dish("beef",false,700,Dish.Type.MEAT),
                new Dish("rice",true,350,Dish.Type.OTHER),
                new Dish("pizza",true,550,Dish.Type.OTHER),
                new Dish("salmon",false,450,Dish.Type.OTHER)
        );

        List<String> lowCaloriesDishes=menu.parallelStream()
                .filter(dish -> dish.getCalories()<600)
                .sorted(Comparator.comparing(Dish::getCalories))
                .map(Dish::getName).collect(Collectors.toList());

        printList.print(lowCaloriesDishes);
        System.out.println();

        Map<Dish.Type,List<Dish>> dishesByType=menu.parallelStream().collect(Collectors.groupingBy(Dish::getType));
        List<String> meat=dishesByType.get(Dish.Type.MEAT).parallelStream().map(Dish::getName).collect(Collectors.toList());
        printList.print(meat);

    }
}
