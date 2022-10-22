import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class class15 {
   final int field71;
   final String field72;
   final ThreadFactory field73;
   final ThreadPoolExecutor field74;

   public class15(String var1, int var2, int var3) {
      this.field72 = var1;
      this.field71 = var2;
      this.field73 = new class26(this);
      this.field74 = this.method132(var3);
   }

   final ThreadPoolExecutor method132(int var1) {
      return new ThreadPoolExecutor(var1, var1, 0L, TimeUnit.MILLISECONDS, new ArrayBlockingQueue(this.field71), this.field73);
   }

   public class13 method131(class12 var1) {
      if (this.field74.getQueue().remainingCapacity() <= 0) {
         System.err.println("REST thread pool queue is empty\r\nThread pool size " + this.field74.getCorePoolSize() + " Queue capacity " + this.field71);
         return new class13("Queue full");
      } else {
         class13 var3 = new class13(this.field74.submit(new class17(this, var1)));
         return var3;
      }
   }

   public final void method130() {
      try {
         this.field74.shutdown();
      } catch (Exception var3) {
         System.err.println("Error shutting down RestRequestService\r\n" + var3);
      }

   }
}
