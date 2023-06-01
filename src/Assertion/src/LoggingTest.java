import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggingTest {
    private static final Logger mLog = Logger.getLogger("asd.myapp");

    public static void main(String[] args) {

        mLog.setLevel(Level.SEVERE);
        mLog.severe("severe");
        mLog.warning("warning");
        mLog.finest("finest");
        mLog.info("info");
        mLog.setLevel(Level.WARNING);
        mLog.warning("warning");
        mLog.log(Level.CONFIG,"config");

    }
}
