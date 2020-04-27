import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

import static java.lang.Thread.sleep;

public class Main3{
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(6);
        List<Callable<Boolean>> listOfPerson = new ArrayList<>();
        for(int i = 0; i<100; i++){
            Person person = new Person();
            listOfPerson.add(person);
        }
        List<Future<Boolean>> listOfDecision = executorService.invokeAll(listOfPerson);
        executorService.shutdown();
        int numberOfPeople = 0;
        for(Future<Boolean> i : listOfDecision){
            if(i.get()){
                numberOfPeople++;
            }
        }
        if(numberOfPeople<5) {
            System.out.println("Film sie nie odbedzie");
            System.exit(0);
        }
        System.out.println("Film sie odbedzie");
        sleep(2000);
        System.out.println("Koniec pierwszej połowy filmu");
        executorService.shutdown();


        int numberOfPeopleAfterFirstHalf = 0;
        ExecutorService executorServiceAfterFirstHalf = Executors.newFixedThreadPool(numberOfPeople);
        List<Callable<Boolean>> listOfPersonAfterFirstHalf = new ArrayList<>();

        for(int i = 0; i<numberOfPeople; i++){
            Viewer viewer = new Viewer();
            listOfPersonAfterFirstHalf.add(viewer);
        }
        listOfPersonAfterFirstHalf.clear();
        List<Future<Boolean>> listOfDecisionAfterFirstHalf = executorService.invokeAll(listOfPersonAfterFirstHalf);

        for(Future<Boolean> i : listOfDecisionAfterFirstHalf){
            if(i.get()){
                numberOfPeopleAfterFirstHalf++;
            }
        }

        if((numberOfPeople - numberOfPeopleAfterFirstHalf)<5) {
            System.out.println("Film nie bedzie kontynuowany ze względu na to że jesteście Frajerami i odchodzcie z fajnego filmu Pajace :) " +
                    "Kaski nie będzie bo za coś trzeba żyć a na takich jak Wy szkoda prądu :) ");
            System.exit(0);
        }
        System.out.println("Druga połowa się rozpoczyna");
        sleep(2000);
        System.out.println("Koniec seansu, dzięki że byliście kochani :) Zapraszamy ponownie! ESSA WARIATY :)");
    }
}
