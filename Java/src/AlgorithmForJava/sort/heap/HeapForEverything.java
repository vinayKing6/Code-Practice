package AlgorithmForJava.sort.heap;

import AlgorithmForJava.sort.interfaces.getKey;
import com.king.corejava.Student;
import myToolKit.printArray;

import javax.swing.*;
import java.util.Arrays;

public class HeapForEverything {
    public static <T,R extends Comparable> void HeapSort(T[] Array, getKey<T,R> key){
        int heapSize=0;

        for (int i=0;i<Array.length;i++){
            HeapInsert(Array,++heapSize,key);
        }

        System.out.println(heapSize);

        while (heapSize>0){
            swap(Array,0,--heapSize);
            Descend(Array,0,heapSize-1,key);
        }
    }

    public static <T,R extends Comparable> void HeapInsert(T[] Array,int heapSize,getKey<T,R> key){
        //to create a heap
//        wait im thinking alright
        //every father is larger than its son
        int position=heapSize-1;
        T value=Array[position];

        while (position>0&&key.get(Array[(position-1)/2]).compareTo(key.get(value))==-1){
            Array[position]=Array[(position-1)/2];
            position=(position-1)/2;
        }

        Array[position]=value;
    }

    public static <T,R extends Comparable> void Descend(T[] Array,int L,int R,getKey<T,R> key){
        int position=L;
        int left=position*2+1;
        int right=left+1;
        T value=Array[position];

        while (left<=R){
            int max=left;
            if (right<=R){
                max=(key.get(Array[left]).compareTo(key.get(Array[right]))==1?left:right);
            }
            if (key.get(Array[max]).compareTo(key.get(value))==1){
                Array[position]=Array[max];
                position=max;
                left=position*2+1;
                right=left+1;
            }
            else
                break;
        }

        Array[position]=value;
    }

    public static <T> void swap(T[] Array,int n1,int n2){
        T tmp=Array[n1];
        Array[n1]=Array[n2];
        Array[n2]=tmp;
    }

    public static void main(String[] args) {
        var students= Student.giveMeExamplesToArray(100);
        printArray.print(students);
        System.out.println();
        HeapForEverything.HeapSort(students,student -> student.getId());
        printArray.print(students);
    }
}
