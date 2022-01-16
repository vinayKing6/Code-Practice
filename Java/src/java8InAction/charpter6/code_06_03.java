package java8InAction.charpter6;

import java8InAction.charpter4.Dish;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class code_06_03 {
    public enum CalorieLevel{
        DIET,
        NORMAL,
        FAT
    }
    public static void main(String[] args) throws FileNotFoundException, IOException {
        String fileName="D:\\myFile\\Java\\src\\java8InAction\\charpter6\\data.txt";
        File data=new File(fileName);
        OutputStream fileOutPut=new FileOutputStream(data);

        //Collectors.groupingBy--
        // group the elements into different groups according to the given key and return map(key,List<> elements)
        List<Dish> menu=Dish.giveMeMenu();
        Map<Dish.Type,List<Dish>> groups=menu.stream().collect(Collectors.groupingBy(Dish::getType));
        System.out.println(groups);

        //write own group method
        Map<CalorieLevel,List<Dish>> groupByCalories=menu.stream().collect(Collectors.groupingBy(
                dish -> {
                    if (dish.getCalories()<=400)
                        return CalorieLevel.DIET;
                    else if (dish.getCalories()<=700)
                        return CalorieLevel.NORMAL;
                    else
                        return CalorieLevel.FAT;
                }
        ));
        fileOutPut.write(groupByCalories.toString().getBytes(StandardCharsets.UTF_8));

        //group by two keys
        Map<Dish.Type,Map<CalorieLevel,List<Dish>>> groupByTwoKeys=menu.stream()
                .collect(Collectors.groupingBy(Dish::getType,Collectors.groupingBy(
                        dish -> {
                            if (dish.getCalories()<=400)
                                return CalorieLevel.DIET;
                            else if (dish.getCalories()<=700)
                                return CalorieLevel.NORMAL;
                            else
                                return CalorieLevel.FAT;
                        }
                )));
        fileOutPut.write(("\n"+groupByTwoKeys.toString()).getBytes(StandardCharsets.UTF_8));

        //group by one key and output other determined values
        Map<Dish.Type,Long> countByType=menu.stream().collect(Collectors.groupingBy(Dish::getType,Collectors.counting()));
        fileOutPut.write(("\n"+countByType.toString()).getBytes(StandardCharsets.UTF_8));
        Map<Dish.Type, Optional<Dish>> maxInEveryType=menu.stream().collect(Collectors
                .groupingBy(Dish::getType,Collectors.maxBy(Comparator.comparing(dish->dish.getCalories()))));
        fileOutPut.write(("\n"+maxInEveryType.toString()).getBytes(StandardCharsets.UTF_8));
        Map<Dish.Type,Dish> maxInByType=menu.stream().collect(Collectors
                .groupingBy(Dish::getType, Collectors
                        .collectingAndThen(Collectors.maxBy(Comparator.comparing(Dish::getCalories)), Optional::get)));
        fileOutPut.write(("\n"+maxInByType.toString()).getBytes(StandardCharsets.UTF_8));
    }
}
