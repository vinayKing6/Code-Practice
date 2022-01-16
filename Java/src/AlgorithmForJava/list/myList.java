package AlgorithmForJava.list;

import com.king.corejava.Student;
import AlgorithmForJava.sort.interfaces.getKey;

public class myList<T> {
    private Node<T> head;

    public myList(){
        head=new Node<>();
        head.value=null;
        head.Next=null;
    }

    public void disorderdAdd(T t){
        Node<T> addition=new Node<>();
        Node<T> tmp;

        tmp=head.Next;
        addition.value=t;
        addition.Next=tmp;
        head.Next=addition;
    }

    public <K extends Comparable> void orderedAdd(T t,getKey<T,K> key){
        var position=head;
        var addition=new Node<T>();
        addition.value=t;

        while (position.Next!=null){
            if (key.get(position.Next.value).compareTo(key.get(t))==-1){
                position=position.Next;
            }
            else
                break;
        }

        var tmp=position.Next;
        position.Next=addition;
        addition.Next=tmp;


    }

    public Node<T> getHead(){
        return head;
    }

    public static <T> void printList(myList<T> list){
        var position=list.getHead().Next;

        while (position!=null){
            System.out.println(position.value);
            position=position.Next;
        }
    }

    public static void main(String[] args) {
        myList<Student> students=new myList<>();

        students.orderedAdd(new Student("vinay","math",1001),student -> student.getId());
        students.orderedAdd(new Student("king","english",99),student -> student.getId());
        students.orderedAdd(new Student("jack","math",2009),student -> student.getId());

        myList.printList(students);
    }
}
