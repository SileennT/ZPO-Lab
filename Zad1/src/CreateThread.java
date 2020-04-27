public class CreateThread extends Thread{
    private int ID_thread;
    private int SleepTimeOfThread;
    CreateThread(int ID_of_thread){
        ID_thread = ID_of_thread;
        switch (ID_thread) {
            case (0):
                SleepTimeOfThread = 9;
                break;

            case (1):
                SleepTimeOfThread = 8;
                break;

            case (2):
                SleepTimeOfThread = 7;
                break;

            case (3):
                SleepTimeOfThread = 6;
                break;

            case (4):
                SleepTimeOfThread = 5;
                break;

            case (5):
                SleepTimeOfThread = 4;
                break;

            case (6):
                SleepTimeOfThread = 3;
                break;

            case (7):
                SleepTimeOfThread = 2;
                break;

            case (8):
                SleepTimeOfThread = 1;
                break;

            case (9):
                SleepTimeOfThread = 0;
                break;
        }
    }
    public void run(){
        try {
            sleep(SleepTimeOfThread*10);
            System.out.println("Hello from task: " + ID_thread);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
