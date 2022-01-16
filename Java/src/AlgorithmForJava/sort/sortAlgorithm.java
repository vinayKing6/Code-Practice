package AlgorithmForJava.sort;

public class sortAlgorithm {
    public static void InsertionSort(int[] Arrays)
    {
        int j,i;
        for (i=1;i<Arrays.length;i++)
        {
            int key=Arrays[i];
            for (j=i-1;j>=0;j--)
            {
                if (Arrays[j]>key)
                    Arrays[j+1]=Arrays[j];
                else
                    break;
            }
            Arrays[j+1]=key;
        }
    }

    public static void MergeArrays(int[] Arrays,int p,int q,int r)
    {
        int n1,n2,i=0,k=0,j=0;
        n1=q-p+1;
        n2=r-q;
        int[] Left=new int[n1+1];
        int[] Right=new int[n2+1];
        Left[n1]=Integer.MAX_VALUE;
        Right[n2]=Integer.MAX_VALUE;
        for (i=0;i<n1;i++)
        {
            Left[i]=Arrays[i+p];
        }
        for (i=0;i<n2;i++)
        {
            Right[i]=Arrays[i+q+1];
        }
        i=p;
        while (i<=r)
        {
            if (Left[k]>Right[j])
            {
                Arrays[i]=Right[j];
                j++;
            }
            else
            {
                Arrays[i]=Left[k];
                k++;
            }
            ++i;
        }
    }

    public static void MergeSort(int[] Arrays,int start,int end)
    {
        if (start<end)
        {
            int middle=(start+end)/2;
            MergeSort(Arrays,start,middle);
            MergeSort(Arrays,middle+1,end);
            MergeArrays(Arrays,start,middle,end);
        }
    }

    public static void printIntegerArrays(int... Arrays)
    {
        for (int t:Arrays)
        {
            System.out.print(t+" ");
        }
        System.out.println();
    }

    public static int[] randomIntegerArrays(int num)
    {
        int[] Arrays=new int[num];
        for (int i=0;i<num;i++)
        {
            Arrays[i]= (int) (Math.random()*100-50);
        }
        return Arrays;
    }
}
