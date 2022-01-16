package java8InAction.charpter1;

import java8InAction.charpter1.Apple.*;

import static  java8InAction.charpter1.Apple.Apple.filterApples;//import static only imports static method of a class


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class appleTest {
    public static void main(String[] args) {
        var inventory=new ArrayList<Apple>();
        inventory.add(new Apple("red",120));
        inventory.add(new Apple("green",160));
        inventory.add(new Apple("green",120));
        inventory.add(new Apple("blue",300));

        var filter1=Apple.filterApples(inventory,Apple::isGreenApple);
        var filter2=Apple.filterApples(inventory, apple -> {return apple.getColor().equals("red");});
        var filter3=Apple.filterApples(inventory,Apple::isHeavyApple);

        var filter4=filter(inventory,apple -> apple.getColor().equals("blue"));

        for (Apple apple:filter1)
        {
            System.out.println(apple);
        }
        for (Apple apple:filter2)
        {
            System.out.println(apple);
        }
        for (var a:filter3)
        {
            System.out.println(a);
        }
        for (var a:filter4)
            System.out.println(a);
        System.out.println();
        List<Apple> streamFilter=inventory.stream().filter(apple -> apple.getWeight()>120).collect(Collectors.toList());
        System.out.println(streamFilter);

        Apple.prettyPrintApple(inventory,apple->{
            return apple.getWeight()>120? apple.toString()+" over weight!":apple.toString();
        });

        printEveryMessage(inventory,fetch());


    }

    public static <T> List<T> filter(List<T> inventory, predicate<T> p){
        List<T> results=new ArrayList<>();
        for (T t:inventory){
            if (p.test(t))
                results.add(t);
        }
        return results;
    }

    public static <T> void printEveryMessage(List<T> inventory,message<T> message){
        for (T t:inventory){
            System.out.println(message.get(t));
        }
    }

    public static message<Apple> fetch(){
        return apple->{
            if (apple.getWeight()>150)
                return apple.toString()+"over weight!";
            else
                return apple.toString();
        };
    }


}
