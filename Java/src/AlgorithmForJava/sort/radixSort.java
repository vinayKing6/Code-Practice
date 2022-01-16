package AlgorithmForJava.sort;

import AlgorithmForJava.sort.interfaces.getKey;
import com.king.corejava.Student;
import java.util.HashMap;
import java.util.Map;

public class radixSort<T> {
    int radix;
    private int[] bucket;
    private T[] Array;
    private getKey key;

    public radixSort(T[] Array,int radix,getKey<T,Integer> key){
        this.Array=Array;
        this.radix=radix;
        this.key=key;

        bucket=new int[Array.length];
    }

    public <T> int maxDigit(T[] Array, int radix, getKey<T,Integer> key){
        int results=0;
        int max=key.get(Array[0]);

        for (T i:Array){
            if (key.get(i).compareTo(max)==1)
                max=key.get(i);
        }

        while (max!=0){
            results++;
            max/=radix;
        }

        return results;
    }

    public int getDigit(int n,int d,int radix){
        int results=0;
        for (int i=0;i<d;i++){
            results=n%radix;
            n/=radix;
        }
        return results;
    }

    public void Sort(){
        int digits=maxDigit(Array,radix,key);
        var original=new int[Array.length];
        Map<Integer,T> map=new HashMap<>();

        for (T t:Array) {
            map.put((int)key.get(t), t);
        }

        for (int i=0,j=0;i<Array.length;i++,j++) {
            original[j] = (int) key.get(Array[i]);
        }

        for (int d=1;d<=digits;d++){
            int[] counts=new int[radix];
            for (int i=0;i<radix;i++)
                counts[i]=0;
            int j;

            for (int i=0;i<Array.length;i++){
                counts[getDigit(original[i],d,radix)]++;
            }

            for (int i=1;i<radix;i++){
                counts[i]+=counts[i-1];
            }

            for (int i=Array.length-1;i>=0;i--){
                j=getDigit(original[i],d,radix);
                bucket[counts[j]-1]=original[i];
                counts[j]--;
            }

            for (int i=0;i<Array.length;i++){
                original[i]=bucket[i];
            }

        }
        for (int i=0;i<Array.length;i++) {
            Array[i] = map.get(bucket[i]);
        }
    }

    public static void main(String[] args) {
        var test=new Student[10];

        for (int i=0;i<10;i++){
            test[i]=new Student("vinay","math", (int) (Math.random()*1000+1));
        }

        var radixSort= new radixSort<>(test, 10, student -> student.getId());

        radixSort.Sort();

        System.out.println();

        for (var i:test)
            System.out.println(i);

        Integer[] test2={4,7,8,1,3,0,33};
        var radixSort2= new radixSort<>(test2, 10, integer -> integer);

        radixSort2.Sort();

        for (var i:radixSort2.bucket)
            System.out.println(i);
    }
}
