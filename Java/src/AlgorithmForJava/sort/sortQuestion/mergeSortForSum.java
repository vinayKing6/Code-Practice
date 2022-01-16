package AlgorithmForJava.sort.sortQuestion;

//求小和问题
public class mergeSortForSum {
    public static void main(String[] args) {
        int[] array={1,3,5,2,0,8,9};
        System.out.println(process(array,0,6));
    }

    public static int merge(int[] Array,int start,int middle,int end){
        var array=new int[end-start+1];
        int i=0;
        int result=0;
        int p=start;
        int q=middle+1;
        while(p<=middle&&q<=end) {
            if (Array[p] < Array[q]) {
                result += Array[p] * (end - q + 1);
                array[i++] = Array[p++];
            } else {
                array[i++] = Array[q++];
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
        return result;
    }

    public static int process(int[] Array,int start,int end){
        if (start>=end)
            return 0;
        else {
            int middle=(start+end)/2;
            return process(Array,start,middle)+process(Array,middle+1,end)+merge(Array,start,middle,end);
        }
    }
}
