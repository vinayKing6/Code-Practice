package AlgorithmForJava.sort;

public class AlgorithmTest {
    public static void main(String[] args) {
        var arrays= sortAlgorithm.randomIntegerArrays(20);
        sortAlgorithm.printIntegerArrays(arrays);
        sortAlgorithm.InsertionSort(arrays);
        sortAlgorithm.printIntegerArrays(arrays);
        var arrays2=sortAlgorithm.randomIntegerArrays(20);
        sortAlgorithm.printIntegerArrays(arrays2);
        sortAlgorithm.MergeSort(arrays2,0,arrays.length-1);
        sortAlgorithm.printIntegerArrays(arrays2);

        var arrays3=sortAlgorithm.randomIntegerArrays(20);
        sortAlgorithm.printIntegerArrays(arrays3);
        System.out.println(MaxSubArray.FindMaxSubArray(0,19,arrays3));

    }
}
