package java8InAction.charpter6;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collector;

public class primesPartitionCollector implements Collector<Integer, Map<Boolean, List<Integer>>,Map<Boolean,List<Integer>>> {
    @Override
    public Supplier<Map<Boolean, List<Integer>>> supplier() {
        return ()->{
            Map<Boolean,List<Integer>> result=new HashMap<>();
            result.put(true,new ArrayList<Integer>());
            result.put(false,new ArrayList<Integer>());
            return result;
        };
    }

    @Override
    public BiConsumer<Map<Boolean, List<Integer>>, Integer> accumulator() {
        return (map,candidate)->{
            map.get(isPrime(map.get(true),candidate)).add(candidate);
        };
    }

    @Override
    public BinaryOperator<Map<Boolean, List<Integer>>> combiner() {
        return (map1,map2)->{
            map1.get(true).addAll(map2.get(true));
            map1.get(false).addAll(map2.get(false));
            return map1;
        };
    }

    @Override
    public Function<Map<Boolean, List<Integer>>, Map<Boolean, List<Integer>>> finisher() {
        return Function.identity();
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Collections.unmodifiableSet(EnumSet.of(Characteristics.IDENTITY_FINISH));
    }

    public boolean isPrime(List<Integer> primes,int candidate)
    {
        int candidateRoot=(int)Math.sqrt((double) candidate);

        return takeWhile(primes,i->i<=candidateRoot).stream().noneMatch(p->candidate%p==0);
    }

    public static <A> List<A> takeWhile(List<A> list, Predicate<A> p)
    {
        int i=0;
        for (A items:list)
        {
            if (!p.test(items))
                return list.subList(0,i);
            i++;
        }
        return list;
    }
}
