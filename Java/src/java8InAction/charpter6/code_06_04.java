package java8InAction.charpter6;

import java8InAction.charpter4.Dish;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class code_06_04 {
    public static void main(String[] args) {
        List<Dish> dishes=Dish.giveMeMenu();
        //partitionBy : partition given values into two parts which is true or false recording to the given conditions
        Map<Boolean,List<Dish>> partitionDishes=dishes.stream().collect(Collectors.partitioningBy(Dish::isVegetarian));

        List<Dish> vegetarianDishes=partitionDishes.get(true);
        vegetarianDishes.forEach(System.out::println);

        //the second collectors
        Map<Boolean,Map<Dish.Type,List<Dish>>> partitionAndGroupBy=dishes.stream().collect(Collectors
                .partitioningBy(Dish::isVegetarian,Collectors.groupingBy(Dish::getType)));
        System.out.println(partitionAndGroupBy);

        Map<Boolean,List<Integer>> primePartitions=partitionPrime(9);
        System.out.println(primePartitions);
    }
    public static boolean isPrime(int candidate)
    {
        int candidateRoot=(int)Math.sqrt((double) candidate);

        return IntStream.rangeClosed(2,candidateRoot).noneMatch(i->candidate%i==0);
    }

    public static Map<Boolean,List<Integer>> partitionPrime(int range)
    {
        return IntStream.rangeClosed(2,range).boxed().collect(Collectors.partitioningBy(integer -> isPrime(integer)));
    }
}
