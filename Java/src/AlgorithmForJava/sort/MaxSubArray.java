package AlgorithmForJava.sort;

public class MaxSubArray {
    private final int low;
    private final int high;
    private final int value;

    public MaxSubArray(int low,int high,int value)
    {
        this.low=low;
        this.high=high;
        this.value=value;
    }

    public int getLow()
    {
        return low;
    }

    public int getHigh() {
        return high;
    }

    public int getValue() {
        return value;
    }

    //this algorithm is going to find the max sub array of the given array
    private static MaxSubArray FindCrossingSubArray(int low, int mid, int high, int[] Array)
    {
        int leftSum=Integer.MIN_VALUE;
        int i;
        int left=mid;
        int sum=0;
        for (i=mid;i>=low;i--)
        {
            sum+=Array[i];
            if(sum>leftSum)
            {
                leftSum=sum;
                left=i;
            }
        }
        int rightSum=Integer.MIN_VALUE;
        int j;
        int right=mid+1;
        sum=0;
        for (j=mid+1;j<=high;j++)
        {
            sum+=Array[j];
            if (sum>rightSum)
            {
                rightSum=sum;
                right=j;
            }
        }
        return new MaxSubArray(left,right,leftSum+rightSum);
    }

    public static MaxSubArray FindMaxSubArray(int low, int high, int[] Array)
    {
        if (low==high)
            return new MaxSubArray(low,high,Array[low]);
        else
        {
            int mid=(low+high)/2;
            var leftSubArray=FindMaxSubArray(low,mid,Array);
            var rightSubArray=FindMaxSubArray(mid+1,high,Array);
            var crossingSubArray=FindCrossingSubArray(low,mid,high,Array);
            if (leftSubArray.getValue()>= rightSubArray.getValue()&&leftSubArray.getValue()>=crossingSubArray.getValue())
                return leftSubArray;
            else if (rightSubArray.getValue()>= leftSubArray.getValue()&&rightSubArray.getValue()>=crossingSubArray.getValue())
                return rightSubArray;
            else return crossingSubArray;
        }

    }

    public String toString()
    {
        return "[left: "+low+", right: "+high+" ,value: "+value+"]";
    }
}
