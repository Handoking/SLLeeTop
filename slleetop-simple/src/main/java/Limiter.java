import java.util.concurrent.Semaphore;

/**
 * @program: SLLeeTop
 * @description:
 * @author: shileilei
 * @date: 2023-08-22 19:45
 **/
public class Limiter {



    public static void main(String[] args) {
        Semaphore limiter = new Semaphore(3);
        Thread a = new Thread(new LimiterTest(limiter),"a");
        Thread b= new Thread(new LimiterTest(limiter),"b");
        Thread c = new Thread(new LimiterTest(limiter),"c");
        a.start();
        b.start();
        c.start();
    }
}

class LimiterTest implements Runnable{

    private final Semaphore limiter;

    LimiterTest(Semaphore limiter){
        this.limiter = limiter;
    }
    @Override
    public void run() {
        try {
            limiter.acquire();
            System.out.println(Thread.currentThread().getName()+"_"+"beforeTime:"+ System.currentTimeMillis());
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName()+"_"+"afterTime:"+ System.currentTimeMillis());
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            limiter.release();
        }

    }
}
