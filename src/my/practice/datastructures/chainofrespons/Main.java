package my.practice.datastructures.chainofrespons;

public class Main {
    public static void main(String[] args) {
        Logger logger = new InfoLogger(new ErrorLogger(new DebugLogger(null)));
        logger.log(3,"DEBUG");
        logger.log(2,"ERROR");
        logger.log(1,"INFO");
    }
}
