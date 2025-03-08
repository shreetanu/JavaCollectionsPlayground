package my.practice.datastructures.chainofrespons;

public class InfoLogger extends Logger{

    InfoLogger(Logger nextlogger) {
        super(nextlogger);
    }

    public void log(int logLevel, String message) {
        if(logLevel == INFO) {
            System.out.println(message);
        }
        else {
            super.log(logLevel,message);
        }
    }
}
