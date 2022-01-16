package corejava.thread;

import java.util.Arrays;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Bank {
    private double accounts[];
    private final ReentrantLock bankLock=new ReentrantLock();
    private Condition sufficientFunds;

    public Bank(int n,double initialBalance)
    {
        accounts=new double[n];
        Arrays.fill(accounts,initialBalance);
        sufficientFunds=bankLock.newCondition();
    }

    public void transfer(int from,int to,double amount)
    {
        bankLock.lock();
        try {
            while (accounts[from] < amount) {
                sufficientFunds.await();
            }
            System.out.println(Thread.currentThread());
            accounts[from] -= amount;
            accounts[to] += amount;
            System.out.printf("%10.2f from %d to %d", amount, from, to);
            System.out.printf(" Total Balance: %10.2f%n", getTotalBalance());
            sufficientFunds.signalAll();
        }catch (InterruptedException e)
        {
        }
        finally {
            bankLock.unlock();
        }
    }

    public double getTotalBalance()
    {
        System.out.println(Thread.currentThread());
        double sum=0;

        for (double a:accounts)
            sum+=a;
        return sum;
    }

    public int size()
    {
        return accounts.length;
    }
}
