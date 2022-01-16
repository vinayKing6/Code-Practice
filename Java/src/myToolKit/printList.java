package myToolKit;

import java.util.List;

public class printList {
    public static <T> void print(List<T> list){
        for (T t:list)
            System.out.println(t);
    }
}
