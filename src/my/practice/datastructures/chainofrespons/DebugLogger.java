package my.practice.datastructures.chainofrespons;

public class DebugLogger extends Logger{
    public DebugLogger(Logger nextLogger) {
        super(nextLogger);
    }

    @Override
    public void log(int logLevel, String message) {
        if (logLevel == DEBUG) {
            System.out.println(message);
        }
        else {
            super.log(logLevel, message);
        }
    }
}
