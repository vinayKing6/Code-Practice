package AlgorithmForJava.sort;

import AlgorithmForJava.sort.interfaces.getKey;
import java8InAction.charpter1.Apple.Apple;

import java.util.List;

public class quickSort {
    public static <T,R extends Comparable> void sort(T[] Array, int L, int R, getKey<T,R> key){
        if (L<R){
            int rand=(int)(Math.random()*(R-L+1));
            swap(Array,rand+L,R);

            int[] equalRange=partition(Array,L,R,key);
            sort(Array,L,equalRange[0]-1,key);
            sort(Array,equalRange[1]+1,R,key);
        }
    }

    public static <T,R extends Comparable> int[] partition(T[] Array,int L,int R,getKey<T,R> key){
        int smaller=L-1;
        int larger=R;

        while (L<larger){
            if (key.get(Array[L]).compareTo(key.get(Array[R]))==-1){
                swap(Array,++smaller,L++);
            }
            else if(key.get(Array[L]).compareTo(key.get(Array[R]))==0){
                L++;
            }
            else{
                swap(Array,L,--larger);
            }
        }
        swap(Array,larger,R);

        int[] equalRange={smaller+1,larger};

        return equalRange;
    }

    public static <T> void swap(T[] Array,int t1,int t2){
        T tmp=Array[t1];
        Array[t1]=Array[t2];
        Array[t2]=tmp;
    }

    public static void main(String[] args) {
        var apples=Apple.giveMeApplesForArray(10);

        quickSort.sort(apples,0,apples.length-1,apple -> apple.getWeight());
        for (var a:apples){
            System.out.println(a);
        }
    }
}
