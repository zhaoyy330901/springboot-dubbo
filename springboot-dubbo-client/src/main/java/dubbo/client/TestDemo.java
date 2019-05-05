package dubbo.client;

public class TestDemo {
    ThreadLocal<Integer> local = new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue() {
            System.out.println("初始化变量"+ Thread.currentThread().getName());
            return 100;
        }
    };
    public int get(){
        return local.get();
    }
    public void set(int v){
        System.out.println("执行set...");
         local.set(v);
    }

    static class Transfer implements Runnable{
        TestDemo testDemo;

        public Transfer(TestDemo testDemo) {
            this.testDemo = testDemo;
        }

        @Override
        public void run() {
            for (int a=0;a<10;a++) {
                testDemo.set(10);
                System.out.println(Thread.currentThread()+" : "+testDemo.get());
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {

        TestDemo testDemo = new TestDemo();
        testDemo.get();
        testDemo.set(200);
        Transfer transfer = new Transfer(testDemo);
        Thread thread = new Thread(transfer);
        thread.start();
        Thread thread2 = new Thread(transfer);
        thread2.start();
        thread.join();
        thread2.join();
        System.out.println(testDemo.get());

    }
}
