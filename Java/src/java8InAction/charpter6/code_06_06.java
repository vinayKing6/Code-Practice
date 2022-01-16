package java8InAction.charpter6;

import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class code_06_06 {
    public static void main(String[] args) {
        //better method to get primes

        //old way: using old partition
        long time_1=Long.MAX_VALUE;
        for (int i=0;i<1;i++)
        {
            long start_1=System.nanoTime();
            Map<Boolean, List<Integer>> map_1=code_06_04.partitionPrime(1_000_000_000);
            long duration_1=(System.nanoTime()-start_1)/1_000_000;
            if (duration_1<time_1) time_1=duration_1;
        }
        System.out.println("the time of old way is: "+time_1+" secs");

        long time_2=Long.MAX_VALUE;
        for (int i=0;i<1;i++)
        {
            long start_2=System.nanoTime();
            Map<Boolean,List<Integer>> map_2= IntStream.rangeClosed(2,1_000_000_000).boxed().collect(new primesPartitionCollector());
            long duration_2=(System.nanoTime()-start_2)/1_000_000;
            if (duration_2<time_2) time_2=duration_2;
        }
        System.out.println("the time of better method is: "+time_2+" secs");

    }
}
