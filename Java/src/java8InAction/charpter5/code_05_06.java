package java8InAction.charpter5;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class code_05_06 {
    public static void main(String[] args) {
        //IntStream
        List<Integer> num= Arrays.asList(3,12,7,8,4,55,6);
        int sum=num.stream().mapToInt(Integer::intValue).sum();//mapToInt return IntStream
        System.out.println(sum);

        int max=num.stream().mapToInt(Integer::intValue).max().orElse(0);
        System.out.println(max);
        //max() return OptionalInt;orElse(referred value) return max or referred value

        //IntStream.range/rangeClosed
        long count= IntStream.range(1,100).filter(i->i%2==0).count();//range does not include 1 and 100(edge)
        long count2=IntStream.rangeClosed(1,100).filter(i->i%2==0).count();//rangeClosed includes edge
        System.out.println(count+" "+count2);

    }
}
