package class_.day17;

public class TestMain {
    public static void main(String[] args) {
        MyThred my1 = new MyThred("线程1");
        MyThred my2 = new MyThred("线程2");

        my1.start();
        my2.start();

        for (int i = 0; i < 100; i++) {
            System.out.println("主线程输出:" + i);
        }
    }
}
