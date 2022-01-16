package AlgorithmForJava.list.listQuestion;

import AlgorithmForJava.list.Node;
import AlgorithmForJava.list.myList;
import AlgorithmForJava.sort.interfaces.getKey;
import com.king.corejava.Student;

public class listPartition {
    //define a number and partition the list into three parts: <num ==num >num
    //request: time-complex:O(N) space-complex:O(1)

    public static <T,R extends Comparable> void partition(myList<T> values, getKey<T,R> key,R Compare){
        Node<T> SH=null;
        Node<T> ST=null;
        Node<T> EH=null;
        Node<T> ET=null;
        Node<T> BH=null;
        Node<T> BT=null;
        Node<T> position=values.getHead().Next;

        while (position!=null){
            if (key.get(position.value).compareTo(Compare)==-1){
                if (SH==null){
                    SH=position;
                    ST=position;
                }
                else {
                    ST.Next=position;
                    ST=position;
                }
//                System.out.println(-1);
            }
            else if (key.get(position.value).compareTo(Compare)==0){
                if (EH==null){
                    EH=position;
                    ET=position;
                }
                else {
                    ET.Next=position;
                    ET=position;
                }
//                System.out.println(0);
            }
            else {
                if (BH==null){
                    BH=position;
                    BT=position;
                }
                else {
                    BT.Next=position;
                    BT=position;
                }
//                System.out.println(1);
            }
            position=position.Next;
        }

        if (SH!=null){
            ST.Next=EH;
            ET=(ET==null?ST:ET);
        }
        if (ET!=null){
            ET.Next=BH;
        }


//        System.out.println(ET.value);
//        System.out.println(BH.value);
        System.out.println();
        Node<T> last=(BT!=null?BT:(ET!=null?ET:ST));
        last.Next=null;

        values.getHead().Next=(SH!=null?SH:(EH!=null?EH:BH));
    }

    public static void main(String[] args) {
        var students= Student.giveMeExamples(20);
        myList.printList(students);
        System.out.println();

        listPartition.partition(students,student -> student.getId(),120);
        myList.printList(students);
    }
}
