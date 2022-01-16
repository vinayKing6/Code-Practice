package AlgorithmForJava;

import com.king.corejava.Student;
import myToolKit.printArray;

public class swapTest {
    public static void swap(Student s1,Student s2){
        Student tmp;
        tmp=s1;
        s1=s2;
        s2=tmp;
        System.out.println(s1);
        System.out.println(s2);
    }

    public static void main(String[] args) {
        var students=Student.giveMeExamplesToArray(2);
        printArray.print(students);
        swap(students[0],students[1]);
    }
}
