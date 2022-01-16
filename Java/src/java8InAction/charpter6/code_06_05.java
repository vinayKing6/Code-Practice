package java8InAction.charpter6;

import java8InAction.charpter4.Dish;

import java.util.List;

public class code_06_05 {
    public static void main(String[] args) {
        //test my own collector

        List<Dish> dishes=Dish.giveMeMenu();
        List<String> names=dishes.stream().map(Dish::getName).collect(myToList());

        names.forEach(System.out::println);
    }

    public static <T> myToListCollector<T> myToList()
    {
        return new myToListCollector<T>();
    }
}
