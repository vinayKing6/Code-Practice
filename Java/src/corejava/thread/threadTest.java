package corejava.thread;

import javax.swing.*;

public class threadTest {
    private static int DELAY=10;

    public static void main(String[] args) {
        Runnable task1=()->{
            try {
                var frame = new JFrame();
                frame.setSize(300, 300);
                frame.setTitle("Task1");
                frame.setLocation(400,400);
                frame.setVisible(true);
                Thread.sleep(8000);
            }
            catch (InterruptedException e)
            {
                System.out.println(1);
                Thread.currentThread().interrupt();
            }
        };
        Runnable task2=()->{
            try {
                var frame = new JFrame();
                frame.setSize(300, 300);
                frame.setTitle("Task2");
                frame.setVisible(true);
                Thread.sleep(8000);
            }
            catch (InterruptedException e)
            {
                System.out.println(2);
            }
        };

        var thread1=new Thread(task1);
        var thread2=new Thread(task2);
        System.out.println(thread1.getState()+" "+thread2.getState());
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread1.start();
        thread2.start();
        System.out.println(thread1.getState()+" "+thread2.getState());
        System.out.println(Thread.currentThread().isInterrupted());
        thread2.setName("king");
        System.out.println(thread1.getName()+' '+thread2.getName());
    }
}
