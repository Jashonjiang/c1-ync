/**
 * 10.创建两个线程 A 和 B，让他们交替打印 0 到 10 的所有整数，其中 A 线程打印偶数，B 线程 打印奇
 */
public class Task10 {
    public static void main(String[] args) {
        RunnableDemo R1 = new RunnableDemo( "A",0);
        R1.start();

        RunnableDemo R2 = new RunnableDemo( "B",1);
        R2.start();
    }
}

class RunnableDemo implements Runnable {
    private Thread t;
    private String threadName;
    private int n;

    RunnableDemo(String name, int n) {
        this.threadName = name;
        this.n = n;
    }

    public void run() {
        try {
            for(int i = n; i <= 10; i += 2) {
                System.out.println("线程" + this.threadName + "打印：" + i);
                Thread.sleep(50);
            }
        }catch (InterruptedException e) {
            System.out.println("线程" +  this.threadName + "出错.");
        }
    }

    public void start () {
        if (t == null) {
            t = new Thread (this, this.threadName);
            t.start ();
        }
    }
}
