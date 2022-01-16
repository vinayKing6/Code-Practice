package AlgorithmForJava.sort.heap;

public class heap {
    public static void heapSort(int[] Array){
        int heapsize=0;

        for (int i=0;i<Array.length;i++){
            heapInsert(Array,Array[i],++heapsize);
        }

        System.out.println(heapsize);
        while (heapsize>0){
            swap(Array,0,heapsize-1);
            heapify(Array,0,--heapsize);
            System.out.println(heapsize);
        }

    }

    public static void heapInsert(int[] Array,int num,int heapsize){
        int position=heapsize-1;

        while (position>0&&Array[(position-1)/2]<num){
            Array[position]=Array[(position-1)/2];
            position=(position-1)/2;
        }
        Array[position]=num;
    }

    public static void heapify(int[] Array,int index,int heapsize){
        int value=Array[index];
        int position=index;
        int left=position*2+1;
        int right=left+1;
        int largestChild=left;

        while (left<heapsize){
            if (right<heapsize){
                if (Array[left]>Array[right])
                    largestChild=left;
                else
                    largestChild=right;
            }
            if (Array[largestChild]>value){
                Array[position]=Array[largestChild];
                position=largestChild;
                left=position*2+1;
                right=left+1;
                largestChild=left;
            }
            else
                break;
        }
        Array[position]=value;
    }

    public static void swap(int[] Array,int n1,int n2){
        int tmp=Array[n1];
        Array[n1]=Array[n2];
        Array[n2]=tmp;
    }
}
