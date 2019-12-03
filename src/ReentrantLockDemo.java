import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {
    static Threadmethod threadmethod = new Threadmethod();
    static Thread01 thread01 = new Thread01(threadmethod);
    static Thread02 thread02 = new Thread02(threadmethod);

    public static void main(String[] args) {
        thread01.start();
        thread02.start();
    }

}

class Thread01 extends Thread {
    Threadmethod td;
    Thread01(Threadmethod td){
        this.td = td;
    }
    @Override
    public void run() {
        super.run();
        td.conditionWait();
    }
}
class Thread02 extends Thread{
    Threadmethod td;
    Thread02(Threadmethod td){
        this.td = td;
    }
    @Override
    public void run() {
        super.run();
        td.conditionSignal();
    }
}


class Threadmethod {
    ReentrantLock lock = new ReentrantLock();
    Condition condition01 = lock.newCondition();

    public void conditionWait() {
        lock.lock();
        try {
            System.out.println("暂停之前。");
            condition01.await();
            System.out.println("暂停之后。");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void conditionSignal() {
        lock.lock();
        try {
            System.out.println("恢复之前");
            condition01.signal();
            System.out.println("恢复之后");
        } finally {
            lock.unlock();
        }
    }
}
