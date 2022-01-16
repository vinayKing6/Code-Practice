package java8InAction.charpter6;

import java8InAction.charpter4.Dish;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class code_06_02 {
    public static void main(String[] args) {
        //Collectors.counting--count the number of the elements
        List<Dish> menu=Dish.giveMeMenu();
        long howManyDishes=menu.stream().collect(Collectors.counting());//equals menu.stream().count();
        System.out.println(howManyDishes);

        //Collectors.maxBy--find the max element
        //Optional is a container that contains the referred instance including null
        Optional<Dish> maxCalories=menu.stream().collect(Collectors.maxBy(Comparator.comparing(Dish::getCalories)));
        System.out.println(maxCalories);

        //Collectors.summingInt(summingDouble summingLong)--calculate summingInt(instance) while iterating
        int totalCalories=menu.stream().collect(Collectors.summingInt(Dish::getCalories));
        System.out.println(totalCalories);

        //Collectors.averagingInt(averagingDouble averagingLong)--return average of values of elements
        double averageCalories=menu.stream().collect(Collectors.averagingInt(Dish::getCalories));
        System.out.println(averageCalories);

        //Collectors.summarizingInt(summarizingDouble summarizingLong)--
        // calculate the number and average max min of the values in instances at once
        IntSummaryStatistics menuStatistics=menu.stream().collect(Collectors.summarizingInt(Dish::getCalories));
        System.out.println(menuStatistics);

        //Collectors.joining--format the String instances from stream
        String shortMenu=menu.stream().map(Dish::getName).collect(Collectors.joining(", "));
        System.out.println(shortMenu);

        //Collectors.reducing--the formal form of method mentioned above
        int totalCaloriesFromReducing=menu.stream().collect(Collectors.reducing(0,Dish::getCalories,(i,j)->i+j));
        System.out.println(totalCaloriesFromReducing);
        Optional<Dish> maxCalorieFromReducing=menu.stream()
                .collect(Collectors.reducing(((dish, dish2) -> dish.getCalories()>dish2.getCalories()?dish:dish2)));
        System.out.println(maxCalorieFromReducing);
    }
}
