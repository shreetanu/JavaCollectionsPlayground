package my.practice.datastructures.chainofrespons;

public abstract class Logger {

    Logger nextLogger;
    public static int INFO = 1;
    public static int DEBUG = 2;
    public static int ERROR = 3;

    Logger(Logger l) {
        this.nextLogger = l;
    }

    public void log(int logLevel, String message) {
        if(nextLogger!=null)
            nextLogger.log(logLevel,message);
    }
}
