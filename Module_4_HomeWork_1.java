import java.util.concurrent.RunnableFuture;

public class Module_4_HomeWork_1 {
    public static class Counter{
        int count;

        public Counter(){
            this.count = 0;
        }

        public void increment(){
            this.count += 1;
        }

        public int getValue(){
            return this.count;
        }
    }

    public static void main(String[] args) {
        Counter counter = new Counter();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0 ; i < 1000 ; i++){
                    counter.increment();
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0 ; i < 1000 ; i++){
                    counter.increment();
                }
            }
        });
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException();
        }
        System.out.println(counter.getValue());
    }
}