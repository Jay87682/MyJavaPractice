package interviewq;

/**
 * Created by jay on 8/19/16.
 */
public class StaticTest {

    private int global = 0;
    private static StaticTest obj = new StaticTest();

    StaticTest() {
        global++;
    }

    public int getGlobal(){
        return global;
    }

    public static StaticTest getInstance(){
        if(obj == null)
            return new StaticTest();
        else
            return obj;
    }

}
