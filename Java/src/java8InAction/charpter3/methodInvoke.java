package java8InAction.charpter3;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import java8InAction.charpter1.Apple.Apple;
import java8InAction.charpter3.interfaces.*;

public class methodInvoke {
    public static void main(String[] args) {
        //use simplified form of the lambda expression

        List<Integer> lis1= Arrays.asList(1,7,8,9);
        lis1.sort((i,j)->i.compareTo(j));//first form of lambda expression
        System.out.println(lis1);
        List<Integer> list2=Arrays.asList(1,7,8,9);
        list2.sort(Integer::compareTo);//second form of lambda expression
        System.out.println(list2);

        run("hi",t-> System.out.println(t));//first form to print
        run("world",System.out::println);//second form to print

        List<Double> weights=Arrays.asList(120.0,150.0,78.0,55.0);
        List<Apple> apples1=map(weights,weight->new Apple(weight));
        System.out.println(apples1);
        List<Apple> apples2=map(weights,Apple::new);//equals a static method invoking ,like System.out::println
        System.out.println(apples2);
    }

    public static <T> void run(T t,action<T> action){
        action.act(t);
    }

    public static <T,R> List<R> map(List<T> inventory, Function<T,R> function){
        List<R> results=new ArrayList<>();

        for (var t:inventory){
            results.add(function.apply(t));
        }

        return results;
    }
}
