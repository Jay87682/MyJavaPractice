package interviewq;

/**
 * Created by jay on 8/17/16.
 * Target:
 * > Practice thread create from a class with main (ProcessBuilder)
 */
public class NewProcess_1 {
    NewProcess_1(){};

    static final String TAG = NewProcess_1.class.getCanonicalName();
    public static void main(String[] args){
        System.out.println(TAG + " start");
        try {
            Thread.sleep(5000);
        }catch(InterruptedException ine){
            System.out.println(TAG + " Error " + ine.toString());
        }
        System.out.println(TAG + " end");
        return;
    }

}
