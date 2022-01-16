package AlgorithmForJava.sort.heap;

public class test {
    public static void main(String[] args) {
        int[] array={3,66,7,333,5,1,0,0,5,5,5,22222,66,77,55};
//        for (int i=0;i<array.length;i++)
//            heap.heapInsert(array,array[i],i+1);


        heap.heapSort(array);
        for (var i:array){
            System.out.print(i+" ");
        }

    }
}
