package myToolKit;

public class printArray {
    public static <T> void print(T[] Array){
        for (T t:Array){
            System.out.println(t);
        }
    }
}
