package ThreadPool;

import java.util.concurrent.*;

/**
 * @author maitentai
 * @version 1.0
 * @date 2019-09-16 15:14
 */
public class TreadPoolTest {

    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor =
                new ThreadPoolExecutor(10, 15,
                        200, TimeUnit.MILLISECONDS,
                        new ArrayBlockingQueue<Runnable>(5));
        for (int i = 0; i < 20; i++) {
            MyRunable runable = new MyRunable(i);
            threadPoolExecutor.execute(runable);
            System.out.println("线程池中线程数目：" + threadPoolExecutor.getPoolSize() + "，队列中等待执行的任务数目：" +
                    threadPoolExecutor.getQueue().size() + "，" +
                    "已执行玩别的任务数目：" + threadPoolExecutor.getCompletedTaskCount());

        }
        threadPoolExecutor.shutdown();
        System.out.println("线程池已经停止");
    }

    static class MyRunable implements Runnable {
        private int runablenum;

        MyRunable(int runablenum) {
            this.runablenum = runablenum;
        }

        @Override
        public void run() {
            System.out.println("正在执行：" + runablenum);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("执行完毕：" + runablenum);
        }
    }
}
