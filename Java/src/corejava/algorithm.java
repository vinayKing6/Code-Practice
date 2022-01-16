package corejava;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;

public class algorithm {
    public static void main(String[] args) {
        //this algorithm is used to practice the sorting algorithm
        var listString=new ArrayList<String>();
        buildStringList(listString);
        System.out.println(listString+"\n");
        Collections.sort(listString);//this is going to sort the elements of the list given and also impact the list
        System.out.println(listString);
        listString.sort(Comparator.reverseOrder());
        System.out.println(listString);//sort in reverse order
        Collections.shuffle(listString);//disorder the list
        System.out.println(listString);
        listString.sort(Comparator.reverseOrder());
        System.out.println(listString);
//        int i=Collections.binarySearch(listString,"jack");
//        //above:this is going to find the place of the given element and the list that being looked through must be sorted in order
//        System.out.println(i);

        listString.removeIf(w->w.equals("jack"));//use the lambda expression to fill the method
        listString.replaceAll(String::toUpperCase);
        System.out.println(listString);

        var firstSet=new HashSet<Integer>();
        for (int i=0;i<10;i++)
        {
            firstSet.add((int) (Math.random()*100+1));
        }
        System.out.println(firstSet);
        var results=new HashSet<>(firstSet);
        var secondSet=new HashSet<Integer>();
        for (int i=0;i<10;i++)
        {
            secondSet.add((int) (Math.random()*100+1));
        }
        System.out.println(secondSet);
        results.retainAll(secondSet);// the set results contains the sharing elements of both firstSet and secondSet
        System.out.println(results);
    }
    public static void buildStringList(ArrayList<String> a){
       a.add("marry");
       a.add("jack");
       a.add("king");
       a.add("vinay");
       a.add("shelton");
    }
}
