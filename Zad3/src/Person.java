import java.util.Random;
import java.util.concurrent.Callable;

import static java.lang.Thread.sleep;

public class Person implements Callable {
    public boolean Rand_people() throws InterruptedException{
        int RandomNumberOfPeople = new Random().nextInt(100);
        int RandomSleep = new Random().nextInt(5);
        sleep(Math.abs(RandomSleep*1000));
        if(RandomNumberOfPeople<5){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public Object call() throws Exception {
        return Rand_people();
    }
}
