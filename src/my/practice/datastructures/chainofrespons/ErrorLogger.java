package my.practice.datastructures.chainofrespons;

public class ErrorLogger extends Logger{
    public ErrorLogger(Logger nextLogger) {
        super(nextLogger);
    }

    @Override
    public void log(int logLevel, String message) {
        if(logLevel == ERROR) {
            System.out.println(message);
        }
        else {
            super.log(logLevel, message);
        }
    }
}
