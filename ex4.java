import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class Logger {
    private static Logger instanta;
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private Logger() {
        System.out.println("Logger creat!");
    }
    public static Logger getInstance() {
        if (instanta == null) {
            instanta = new Logger();
        }
        return instanta;
    }
    public static void logInfo(String mesaj) {
        System.out.println(getPrefix("INFO") + mesaj);
    }
    public static void logWarning(String mesaj) {
        System.out.println(getPrefix("WARNING") + mesaj);
    }
    public static void logError(String mesaj) {
        System.out.println(getPrefix("ERROR") + mesaj);
    }

    private static String getPrefix(String tip) {
        String time = LocalDateTime.now().format(formatter);
        return "[" + time + "] [" + tip + "] ";
    }
}
public class ex4 {
    public static void main(String[] args) {
        Logger.logInfo("Aplicația a pornit");
        Logger.logWarning("Memorie scăzută");
        Logger.logError("Eroare la conectare");

        Logger l1 = Logger.getInstance();
        Logger l2 = Logger.getInstance();

        if (l1 == l2) {
            System.out.println("Aceeași instanța ");
        } else {
            System.out.println("Instanțe diferite");
        }
    }
}
