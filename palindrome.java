package AlgorithmForJava.list.listQuestion;

import AlgorithmForJava.list.Node;
import AlgorithmForJava.list.myList;
import AlgorithmForJava.sort.interfaces.getKey;

import java.util.Locale;

public class palindrome {
    //judge if the given list is palindrome recording to the given compared value
    //for example: [a,b,b,a] is palindrome while [a,b,c,a] is not

    public static <T,R extends Comparable> boolean isPalindrome(myList<T> list, getKey<T,R> key){
        boolean res=true;
        Node<T> position=list.getHead().Next;
        Node<T> n1=list.getHead().Next;
        Node<T> n2=list.getHead().Next;

        while (n2.Next!=null&&n2.Next.Next!=null){
            n1=n1.Next;
            n2=n2.Next.Next;
        }
        if (n2.Next!=null)
            n2=n2.Next;

        Node<T> tail=n2;
        Node<T> mid=n1;
        Node<T> n3=n1.Next;
        n1.Next=null;
        while (n3!=null){
            n2=n3.Next;
            n3.Next=n1;
            n1=n3;
            n3=n2;
        }

        n1=position;
        n2=tail;
        while (n1!=null&&n2!=null){
            if (key.get(n1.value).compareTo(key.get(n2.value))!=0){
                res=false;
                break;
            }
            else{
                n1=n1.Next;
                n2=n2.Next;
            }
        }

        n3=tail;
        n1=n3.Next;
        n3.Next=null;
        while (n1!=null){
            n2=n1.Next;
            n1.Next=n3;
            n3=n1;
            n1=n2;
        }

        return res;
    }

    public static void main(String[] args) {
        myList<String> test=new myList<>();

        test.disorderdAdd("b");
        test.disorderdAdd("b");
        test.disorderdAdd("b");
        test.disorderdAdd("b");
        test.disorderdAdd("b");
        test.disorderdAdd("b");

        var res=palindrome.isPalindrome(test,s -> s.toLowerCase(Locale.ROOT));
        System.out.println(res);
    }
}