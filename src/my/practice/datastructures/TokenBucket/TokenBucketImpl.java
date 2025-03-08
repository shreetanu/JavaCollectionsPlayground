package my.practice.datastructures.TokenBucket;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TokenBucketImpl {
  private final int capacity;
  private final int rate;
  private int token;
  private final Object lock = new Object();


  public TokenBucketImpl(int token,int capacity,int rate) {
      this.token = token;
      this.capacity = capacity;
      this.rate = rate;
      scheduleRefill();
  }

  private void scheduleRefill() {
      ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
      scheduledExecutorService.scheduleAtFixedRate(() -> {
          synchronized (lock) {
              token = Math.min(token + rate, capacity);
          }
      },0,1,TimeUnit.SECONDS);
  }

  public boolean allowRequest() {
      synchronized (lock) {
          if(token > 0) {
              token -=1;
              return true;
          }
          else {
              return false;
          }
      }
  }

    public static void main(String[] args) throws InterruptedException {
        TokenBucketImpl tokenBucket = new TokenBucketImpl(0,10,2);

        for(int i=1;i<=50;i++) {
            Thread.sleep(50);
            if(tokenBucket.allowRequest()) {
                System.out.println("REQUEST"+i+"ALLOWED");
            }
            else {
                System.out.println("Request"+i+"NOT ALLOWED");
            }
        }
    }
}
