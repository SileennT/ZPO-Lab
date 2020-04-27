import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadSynchronizer {

    public void Strings(){
        String[] marks = new String[]{"aaaa", "bb", "cccccccccccc", "dddddddd"};
        Locker lock = new Locker();
        ExecutorService pool = Executors.newFixedThreadPool(marks.length);
        for (int i = 0; i < marks.length; i++) {
            Runnable runner = new Retard (marks[i],lock,i);
            pool.submit(runner);
        }
        pool.shutdown();
    }


    public class Retard implements Runnable{
        private String textOfThread;
        private Locker lock;
        private int ID;

        public Retard(String tab, Locker lock, int index){
            textOfThread = tab;
            this.lock = lock;
            ID = index;
        }

        public void run() {
            try {
                synchronized (lock) {
                    lock.RegisterID(ID);
                    lock.notifyAll();
                    lock.wait();
                }
                for (int i = 0; i < textOfThread.length(); i++) {
                    synchronized (lock) {
                        lock.notifyAll();
                        while (ID != lock.GetCurrent()) {
                            lock.wait();
                        }
                        System.out.print(textOfThread.charAt(i));
                        lock.Increment();
                    }
                }
                synchronized (lock) {
                    lock.notifyAll();
                    while (ID != lock.GetCurrent()) {
                        lock.wait();
                    }
                    lock.DeleteID(ID);
                    lock.notifyAll();
                }
            }
            catch (InterruptedException exc){
                System.out.println("It failed :( ");
                System.out.println(exc);
            }
        }

    }


    public class Locker {
        private int currentIndex = 0;
        private CopyOnWriteArrayList<Integer> queue;

        public Locker() {
            queue = new CopyOnWriteArrayList<>();
        }

        public void Increment(){
            if (currentIndex >= (queue.size() - 1)) {
                currentIndex = 0;
            }
            else{
                currentIndex++;
            }
        }

        public int GetCurrent(){
            if (currentIndex >= (queue.size() - 1)) {
                currentIndex = queue.size() - 1;
            }
            return queue.get(currentIndex);
        }

        public void RegisterID(int ID){
            queue.add(ID);
        }

        public void DeleteID(int ID){
            queue.remove(Integer.valueOf(ID));
        }
    }
}