package java8InAction.charpter7;

import java.util.stream.LongStream;
import java.util.stream.Stream;

public class ParallelStreams {
    public static long iterativeSum(long n)
    {
        long sum=0;
        for (long i=0;i<=n;i++)
        {
            sum+=i;
        }
        return sum;
    }

    public static long sequentialSum(long n)
    {
        return Stream.iterate(1L, i->i+1).limit(n).reduce(0L,Long::sum);
    }

    public static long parallelSum(long n)
    {
        return Stream.iterate(1L,i->i+1).limit(n).parallel().reduce(0L,Long::sum);
    }

    public static long rangedSum(long n)
    {
        return LongStream.rangeClosed(1,n).reduce(1L,Long::sum);
    }

    public static long parallelRangedSum(long n)
    {
        return LongStream.rangeClosed(1,n).parallel().reduce(1L,Long::sum);
    }

}
