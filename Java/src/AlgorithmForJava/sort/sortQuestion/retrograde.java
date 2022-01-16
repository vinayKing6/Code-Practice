package AlgorithmForJava.sort.sortQuestion;

import corejava.generic.Pair;

import java.util.ArrayList;
import java.util.List;

public class retrograde {
    int[] array=null;
    List<Pair<Integer>> results=new ArrayList<>();

    public retrograde(int[] array){
        this.array=array;
    }

    public void merge(int[] Array,int start,int middle,int end){
        int i=0;
        int p=start;
        int q=middle+1;
        int[] array=new int[end-start+1];

        while (p<=middle&&q<=end){
            if (Array[p]<Array[q]){
                array[i++]=Array[p++];
            }
            else {
                for (int n=p;n<=middle;n++)
                    results.add(new Pair<>(Array[n],Array[q]));
                array[i++]=Array[q++];
            }
        }
        while (p<=middle){
            array[i++]=Array[p++];
        }
        while (q<=end){
            array[i++]=Array[q++];
        }
        i=0;
        for (int n=start;n<=end;n++){
            Array[n]=array[i++];
        }
    }

    public void process(int[] Array,int start,int end){
        if (start<end){
            int middle=(start+end)/2;
            process(Array,start,middle);
            process(Array,middle+1,end);
            merge(Array,start,middle,end);
        }
    }

    public static void main(String[] args) {
        int[] array={9,8,7,6,5,4,2,10};
        var retrograde=new retrograde(array);
        retrograde.process(array,0,array.length-1);
        System.out.println(retrograde.results);
        for (var i:array)
            System.out.print(i);
    }

}
