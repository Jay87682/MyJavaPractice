package interviewq;

/**
 * Created by jay on 8/17/16.
 */
import java.io.IOException;
import java.lang.ProcessBuilder;
import java.lang.Process;
import java.util.Enumeration;

public class InterviewQuestion {

    InterviewQuestion(){};

    public static void main(String[] args) {

/*
 * Demo the Producer_Customer Model
 */
/*
        Producer_Customer_Model psModel = new Producer_Customer_Model();
        psModel.start();
*/
/*
 * Test the static
 */
/*
        StaticTest st_1 = new StaticTest();
        System.out.println("st_1: " + st_1.getGlobal());
        StaticTest st_2 = new StaticTest();

        System.out.println("st_1: " + st_1.getGlobal()
        + ", st_2: " + st_2.getGlobal());
*/

/*
 * Demo the MyTable with the Enum
 */

/*
        MyTable myTable = new MyTable();
        myTable.addEntry("1", 1);
        myTable.addEntry("2", 2);
        myTable.addEntry("3", 3);

        Enumeration enu = myTable.getEnumerator();

        String key;
        while (enu.hasMoreElements()) {
            key = enu.nextElement().toString();
            System.out.println(key);
        }
*/

/*
 * Demo how to create a thread via ProcessBuilder
 */
/*
        final String JAVA_CLASS_PATH = System.getProperty("java.class.path");
        final String JAVA_HOME_PATH = System.getProperty("java.home");
        final String NEW_PROCESS_NAME = NewProcess_1.class.getCanonicalName();
        final String CMD = "java";

        try {
            Process pb = new ProcessBuilder(JAVA_HOME_PATH + "/bin/" + CMD, "-cp", JAVA_CLASS_PATH, NEW_PROCESS_NAME).inheritIO().start();
            pb.waitFor();
            pb.exitValue();
            System.out.println(InterviewQuestion.class.getCanonicalName() + "Finish");
        }catch(IOException ioe){
            System.out.println(" Error : " + ioe.toString());
        }catch(InterruptedException ine){
            System.out.println(" Error: " + ine.toString());
        }
*/
        return;
    }

}
