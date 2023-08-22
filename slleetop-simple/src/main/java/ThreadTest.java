/**
 * @program: SLLeeTop
 * @description: 线程使用
 * @author: shileilei
 * @date: 2023-08-22 21:31
 **/
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: SLLeeTop
 * @description: 交替打印
 * @author: shileilei
 * @date: 2023-08-14 16:35
 **/
public class ThreadTest {

    public static void main(String[] args) {
        final int n = 10;
//        Printer printer = new Printer(n);
//        Thread t1 = new Thread(printer, "t1");
//        Thread t2 = new Thread(printer, "t2");
//        Thread t3 = new Thread(printer, "t3");
//        t1.start();
//        t2.start();
//        t3.start();
        ReentrantLock lock = new ReentrantLock(true);
        Condition a = lock.newCondition();
        Condition b = lock.newCondition();
        Condition c = lock.newCondition();
        Thread aThread = new Thread(new PrinterV2(lock, a,b,n));
        Thread bThread = new Thread(new PrinterV2(lock, b,c,n));
        Thread cThread = new Thread(new PrinterV2(lock, c,a,n));
        aThread.start();
        bThread.start();
        cThread.start();

    }
}

class Printer implements Runnable{
    int n;
    int num = 0;

    Printer(int n){
        this.n =n;
    }
    @Override
    public void run() {
        while(num<n){
            synchronized (this){
                notify();
                num++;
                System.out.println(Thread.currentThread().getName()+":"+num);
                try {
                    if(num<n-1){
                        wait();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}

class PrinterV2 implements Runnable{

    private final ReentrantLock reentrantLock;
    private final Condition currentCondition;
    private final Condition nextCondition;
    private int n;
    private static volatile int num =0;

    PrinterV2(ReentrantLock reentrantLock, Condition currentCondition,
              Condition nextCondition,Integer n){
        this.reentrantLock = reentrantLock;
        this.currentCondition = currentCondition;
        this.nextCondition = nextCondition;
        this.n = n;
    }

    @Override
    public void run() {
        while(num<n){
            reentrantLock.lock();
            try {
                System.out.println(Thread.currentThread().getName()+":"+num);
                nextCondition.signal();
                num++;
                if(num<n){
                    currentCondition.await();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                reentrantLock.unlock();
            }
        }

    }
}


