package java8InAction.charpter7;

import java.util.function.Function;

public class code_07_01 {
    public static void main(String[] args) {
        System.out.println(measureSumRunTime(ParallelStreams::sequentialSum,10_000_000));
        System.out.println(measureSumRunTime(ParallelStreams::iterativeSum,10_000_000));
        System.out.println(measureSumRunTime(ParallelStreams::parallelSum,10_000_000));
        System.out.println(measureSumRunTime(ParallelStreams::rangedSum,10_000_000));
        System.out.println(measureSumRunTime(ParallelStreams::parallelRangedSum,10_000_000));
    }

    public static long measureSumRunTime(Function<Long,Long> adder,long n)
    {
        long fastest=Long.MAX_VALUE;
        for (int i=0;i<10;i++)
        {
            long start=System.nanoTime();
            long sum=adder.apply(n);
            long duration=(System.nanoTime()-start)/1_000_000;
            System.out.println("Result: "+sum);
            fastest= Math.min(fastest, duration);
        }
        return fastest;
    }
}
