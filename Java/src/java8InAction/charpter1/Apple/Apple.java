package java8InAction.charpter1.Apple;

import java.util.ArrayList;
import java.util.List;

public class Apple {
    private String color;
    private double weight;
    private static String[] originalColor={"red","blue","green","yellow","white","black"};

    public Apple(String color,double weight)
    {
        this.color=color;
        this.weight=weight;
    }

    public Apple(double weight){
        this.weight=weight;
        this.color=null;
    }

    public String getColor()
    {
        return color;
    }
    public double getWeight()
    {
        return weight;
    }

    public String toString()
    {
        return color+", "+weight+"kg .";
    }

    public static boolean isGreenApple(Apple apple)
    {
        return "green".equals(apple.getColor());
    }
    public static boolean isHeavyApple(Apple apple)
    {
        return apple.getWeight()>150;
    }

    public static List<Apple> giveMeApples(int size){
        var results=new ArrayList<Apple>();

        for (int i=0;i<size;i++){
            results.add(new Apple(originalColor[(int)(Math.random()*originalColor.length)],Math.random()*200));
        }

        return results;
    }

    public static Apple[] giveMeApplesForArray(int size){
        Apple[] results=new Apple[size];

        for (int i=0;i<size;i++){
            results[i]=new Apple(originalColor[(int)(Math.random()*originalColor.length)],Math.random()*200);
        }

        return results;
    }


    public static List<Apple> filterApples(List<Apple> apples,predicate<Apple> p)//use the lambda expression to fill the interface method
    {
        List<Apple> results=new ArrayList<>();
        for (Apple apple:apples)
        {
            if (p.test(apple))
                results.add(apple);
        }
        return results;
    }

    public static void prettyPrintApple(List<Apple> inventory,message<Apple> message)
    {
        for (Apple a:inventory)
            System.out.println(message.get(a));
    }
}
