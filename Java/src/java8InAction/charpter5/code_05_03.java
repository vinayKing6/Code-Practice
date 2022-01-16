package java8InAction.charpter5;

import java8InAction.charpter4.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class code_05_03 {
    public static void main(String[] args) {
        List<Dish> menu=Dish.giveMeMenu();

        //anyMatch: find at least one result matches the condition or would be false
        if (menu.stream().anyMatch(Dish::isVegetarian))
            System.out.println("Have Vegetarian");
        //allMatch: return true if all matches the condition else return false
        if (menu.stream().allMatch(dish -> dish.getCalories()<1000))
            System.out.println("not all healthy");
        //noneMatch: contrary to allMatch
        if (menu.stream().noneMatch(dish -> dish.getCalories()>5000))
            System.out.println("all smaller than 5000");

        //findAny:
        Optional<Dish> dish=menu.stream().filter(Dish::isVegetarian).findAny();
        System.out.println(dish);
        //findFirst
        List<Integer> numbers= Arrays.asList(1,6,4,5,3);
        Optional<Integer> firstSquareDivisibleByThree=numbers.stream().map(integer -> integer*integer)
                .filter(integer -> integer%3==0)
                .findFirst();
        System.out.println(firstSquareDivisibleByThree);

        //reduce
        int sum=numbers.stream().reduce(0,(a,b)->a+b);
        int multiple=numbers.stream().reduce(1,(a,b)->a*b);
        System.out.println(sum+" "+multiple);
        Optional<Integer> sum2=numbers.stream().reduce(Integer::sum);
        System.out.println(sum2);

        Optional<Integer> max=numbers.stream().reduce(Integer::max);
        Optional<Integer> min=numbers.stream().reduce(Integer::min);
        System.out.println(max.get()+" "+min.get());

        int count=menu.stream().map(dish1 -> 1).reduce(0,Integer::sum);
        long count2=menu.stream().count();
        System.out.println(count+" "+count2);

    }
}
