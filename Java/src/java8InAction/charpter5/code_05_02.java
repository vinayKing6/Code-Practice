package java8InAction.charpter5;

import java8InAction.charpter4.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class code_05_02 {
    public static void main(String[] args) {
        List<Dish> dishes=Dish.giveMeMenu();
        List<String> dishName=dishes.stream().map(dish -> dish.getName()).collect(Collectors.toList());
        dishName.stream().forEach(System.out::println);
        System.out.println();

        List<Integer> num1= Arrays.asList(1,4,6);
        List<Integer> num2=Arrays.asList(7,5,2,9,1);
        List<int[]> pairs=num1.stream()
                .flatMap(i->num2.stream().filter(j->(i+j)%2==0)
                        .map(j->new int[]{i,j}))//flatMap must have the returned type Stream
                .collect(Collectors.toList());
        pairs.stream().forEach(ints ->
                System.out.println(ints[0]+" "+ints[1]));


    }
}
