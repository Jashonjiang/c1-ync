/**
 * 11.《JAVA 第一行代码》397 页“生产者与消费者案例”
 */
public class Task11 {
    public static void main(String[] args) throws Exception {
        Message msg = new Message();        //定义Message对象，用于保存和取出数据
        new Thread(new Producer(msg)).start();
        new Thread(new Consumer(msg)).start();
    }
}

class Message{
    private String title;
    private String content;
    private boolean flag = true;
    //flag == true: 表示可以生产，但不能取走
    //flag == false: 表示可以取走，但不能生产
    public synchronized void set(String title, String content){
        if(this.flag == false){         //已经生产过了，不能生产
            try{
                super.wait();       //等待
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        this.title = title;
        try{
            Thread.sleep(200);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        this.content = content;
        this.flag = false;      //已经生产完成，修改标志位
        super.notify();         //唤醒等待线程
    }

    public synchronized void get(){
        if(this.flag == true){      //未生产，不能取走
            try{
                super.wait();       //等待
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        try{
            Thread.sleep(100);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println((this.title + "-->" + this.content));
        this.flag = true;
        super.notify();
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

class Producer implements Runnable{     //定义生产者
    private Message msg = null;
    public Producer(Message msg){
        this.msg = msg;
    }
    @Override
    public void run(){
        for(int x = 0; x < 50; x++){        //生产50次数据
            if(x%2 == 0){
                this.msg.set("李兴华","Java讲师");       //设置属性
            }else {
                this.msg.set("mldn","www.mldnjava.cn"); //设置属性
            }
        }
    }
}

class Consumer implements Runnable{     //定义消费者
    private Message msg = null;
    public Consumer(Message msg){
        this.msg = msg;
    }
    @Override
    public void run(){
        for(int x = 0; x < 50; x++){    //取走50次数据
            this.msg.get();             //取走属性
        }
    }
}