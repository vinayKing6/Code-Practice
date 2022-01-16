package java8InAction.charpter3;

import java8InAction.charpter1.Apple.Apple;
import java8InAction.charpter1.Apple.predicate;
import myToolKit.printList;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class combinedMethodInvoke {
    public static void main(String[] args) {
        //Combined comparator
        List<Apple> apples=new ArrayList<>();

        apples=Apple.giveMeApples(10);

        apples.sort(
                Comparator.comparing(Apple::getWeight).thenComparing(apple -> apple.getColor())
        );//if apples have equal weight,then compare their color
        for (var a:apples)
            System.out.println(a);
        System.out.println();

        //Combined predicate
        Predicate<Apple> predicate=apple -> apple.getWeight()>80;
        List<Apple> filterOriginal=filter(apples,predicate);
        printList.print(filterOriginal);
        System.out.println();
        //there: filter by original predicate;
        List<Apple> filterAnd=filter(apples,predicate.and(apple -> apple.getColor().equals("black")));
        printList.print(filterAnd);
        System.out.println();
        //there: predicate.and(condition) is going to filter both fit the predicate and condition
        List<Apple> filterNegate=filter(apples,predicate.negate());
        printList.print(filterNegate);
        System.out.println();
        //there: predicate.negate() is going to filter the result that contrary to the original condition
        System.out.println();

        //Combined function
        Function<Integer,Integer> f=x->x+1;
        Function<Integer,Integer> g=x->x*2;
        System.out.println(f(10,f)+" "+f(10,g)+" "+f(10,f.compose(g)));



    }

    public static <T> List<T> filter(List<T> inventory, Predicate<T> predicate) {
        List<T> results=new ArrayList<>();

        for (T t:inventory){
            if (predicate.test(t))
                results.add(t);
        }

        return results;
    }

    public static int f(int x,Function<Integer,Integer> function){
        return function.apply(x);
    }
}
