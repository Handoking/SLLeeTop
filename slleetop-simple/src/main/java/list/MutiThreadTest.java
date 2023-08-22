package list;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.*;

/**
 * @program: SLLeeTop
 * @description: 多线程test
 * @author: shileilei
 * @date: 2023-08-18 21:32
 **/
@Slf4j
public class MutiThreadTest {
    private static final ExecutorService MULTI_THREAD_POOL_SERVICE = new ThreadPoolExecutor(
            Runtime.getRuntime().availableProcessors(),
            Runtime.getRuntime().availableProcessors()*2,
            60,
            TimeUnit.SECONDS,
            new LinkedBlockingQueue<>(100),
            ((r, executor) -> log.warn("被拒绝")));

    private static ConcurrentLinkedQueue<Integer> clq = new ConcurrentLinkedQueue<>();

    public static void main(String[] args) {
        //测试case
        Integer num = 100;
        //mock 添加数据
        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
               clq.offer(num);
            }, "thread" + i).start();
        }
        //2.消费控制线程数
        Semaphore semaphore = new Semaphore(10,true);
        //3.消费逻辑
        Remove thread = new Remove(semaphore,clq);
        MULTI_THREAD_POOL_SERVICE.submit(thread);
    }
}

class Remove implements Runnable{

    private final Semaphore semaphore;
    private ConcurrentLinkedQueue<Integer> clq;

    Remove(Semaphore semaphore,ConcurrentLinkedQueue<Integer> clq){
        this.semaphore= semaphore;
        this.clq = clq;
    }


    @Override
    public void run() {
        try{
            semaphore.acquire();
            //删除
            clq.poll();
            System.out.println();
        }catch(InterruptedException e){
            e.printStackTrace();
        }finally {
            semaphore.release();
        }

    }
}

class Add implements Runnable{

    private final Semaphore semaphore;
    private ConcurrentLinkedQueue<Integer> clq;
    private int num;

    Add(Semaphore semaphore,ConcurrentLinkedQueue<Integer> clq,Integer num){
        this.semaphore= semaphore;
        this.clq = clq;
        this.num = num;
    }


    @Override
    public void run() {
        try{
            semaphore.acquire();
            //删除
            clq.offer(num);

        }catch(InterruptedException e){
            e.printStackTrace();
        }finally {
            semaphore.release();
        }

    }
}

