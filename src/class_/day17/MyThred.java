package class_.day17;

public class MyThred extends Thread {
    public MyThred() {
        super();
    }

    public MyThred(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            //获取当前执行的线程对象
            System.out.println(Thread.currentThread().getName());
        }
    }
}
