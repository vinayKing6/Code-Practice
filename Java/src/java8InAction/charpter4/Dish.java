package java8InAction.charpter4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Dish {
    private final String name;
    private final boolean vegetarian;
    private final int calories;
    private final Type type;

    public enum Type{MEAT,FISH,OTHER}

    public Dish(String name,boolean vegetarian,int calories,Type type){
        this.name=name;
        this.vegetarian=vegetarian;
        this.calories=calories;
        this.type=type;
    }

    public String getName(){
        return name;
    }

    public boolean isVegetarian(){
        return vegetarian;
    }

    public int getCalories(){
        return calories;
    }

    public Type getType(){
        return type;
    }

    public String toString(){
        return "[ "+this.getName()+" "+isVegetarian()+" "+this.getCalories()+" "+this.getType()+" ]";
    }

    public static List<Dish> giveMeMenu(){
        List<Dish> results=new ArrayList<>();

        results= Arrays.asList(
                new Dish("pork",false,800,Type.MEAT),
                new Dish("beef",false,700,Type.MEAT),
                new Dish("chicken",false,400,Type.MEAT),
                new Dish("french fries",true,530,Type.OTHER),
                new Dish("rice",true,350,Type.OTHER),
                new Dish("season fruit",true,120,Type.OTHER),
                new Dish("pizza",true,550,Type.OTHER),
                new Dish("prawns",false,300,Type.FISH),
                new Dish("salmon",false,450,Type.FISH)
        );

        return results;
    }
}
