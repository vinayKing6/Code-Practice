package corejava;

import java.time.LocalDate;
import java.util.PriorityQueue;

public class PriorityQueueTest {
    public static void main(String[] args) {
        var pq=new PriorityQueue<LocalDate>();
        pq.add(LocalDate.of(1999,9,8));
        pq.add(LocalDate.of(2001,8,30));
        pq.add(LocalDate.of(1903,3,8));
        pq.add(LocalDate.of(1888,9,7));

        for (LocalDate d:pq)
            System.out.println(d);
        System.out.println();
        while (!pq.isEmpty())
            System.out.println(pq.remove());
    }
}
