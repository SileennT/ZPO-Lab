import java.util.Random;
import java.util.concurrent.Callable;
import static java.lang.StrictMath.random;

public class Viewer implements Callable {
    public boolean Rand_people(){
        int RandomNumberOfPeople = new Random().nextInt(100);
        if(RandomNumberOfPeople<30){
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
