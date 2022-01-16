package java8InAction.charpter4;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class code_04_04 {
    public static void main(String[] args) {
        List<String> name=Dish.giveMeMenu().stream().filter(
                dish -> {
                    System.out.println(dish);
                    return dish.getCalories()>300;
        }).map(dish -> {
            System.out.println(dish.getName());
            return dish.getName();
        }).collect(Collectors.toList());

        Dish.giveMeMenu().stream().forEach(System.out::println);
        System.out.println();
        Dish.giveMeMenu().stream().filter(Dish::isVegetarian).forEach(System.out::println);

        List<Integer> test= Arrays.asList(1,4,4,4,7,8,8,9,0,0,2,5);
        test.stream().filter(integer -> integer%2==0).distinct().forEach(System.out::println);
    }
}
