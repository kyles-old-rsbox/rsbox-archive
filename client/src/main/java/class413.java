import java.io.IOException;
import java.io.OutputStream;

public class class413 implements Runnable {
   static class83 field4575;
   boolean field4573;
   byte[] field4569;
   int field4566 = 0;
   int field4568;
   int field4571 = 0;
   IOException field4572;
   OutputStream field4567;
   Thread field4574;

   class413(OutputStream var1, int var2) {
      this.field4567 = var1;
      this.field4568 = var2 + 1;
      this.field4569 = new byte[this.field4568];
      this.field4574 = new Thread(this);
      this.field4574.setDaemon(true);
      this.field4574.start();
   }

   boolean method7477() {
      if (this.field4573) {
         try {
            this.field4567.close();
            if (null == this.field4572) {
               this.field4572 = new IOException("");
            }
         } catch (IOException var3) {
            if (this.field4572 == null) {
               this.field4572 = new IOException(var3);
            }
         }

         return true;
      } else {
         return false;
      }
   }

   public void run() {
      do {
         int var1;
         synchronized(this) {
            while(true) {
               if (this.field4572 != null) {
                  return;
               }

               if (this.field4566 <= this.field4571) {
                  var1 = this.field4571 - this.field4566;
               } else {
                  var1 = this.field4571 + (this.field4568 - this.field4566);
               }

               if (var1 > 0) {
                  break;
               }

               try {
                  this.field4567.flush();
               } catch (IOException var10) {
                  this.field4572 = var10;
                  return;
               }

               if (this.method7477()) {
                  return;
               }

               try {
                  this.wait();
               } catch (InterruptedException var11) {
               }
            }
         }

         try {
            if (var1 + this.field4566 <= this.field4568) {
               this.field4567.write(this.field4569, this.field4566, var1);
            } else {
               int var13 = this.field4568 - this.field4566;
               this.field4567.write(this.field4569, this.field4566, var13);
               this.field4567.write(this.field4569, 0, var1 - var13);
            }
         } catch (IOException var9) {
            IOException var2 = var9;
            synchronized(this) {
               this.field4572 = var2;
               return;
            }
         }

         synchronized(this) {
            this.field4566 = (var1 + this.field4566) % this.field4568;
         }
      } while(!this.method7477());

   }

   void method7487(byte[] var1, int var2, int var3) throws IOException {
      if (var3 >= 0 && var2 >= 0 && var3 + var2 <= var1.length) {
         synchronized(this) {
            if (this.field4572 != null) {
               throw new IOException(this.field4572.toString());
            } else {
               int var6;
               if (this.field4566 <= this.field4571) {
                  var6 = this.field4568 - this.field4571 + this.field4566 - 1;
               } else {
                  var6 = this.field4566 - this.field4571 - 1;
               }

               if (var6 < var3) {
                  throw new IOException("");
               } else {
                  if (this.field4571 + var3 <= this.field4568) {
                     System.arraycopy(var1, var2, this.field4569, this.field4571, var3);
                  } else {
                     int var7 = this.field4568 - this.field4571;
                     System.arraycopy(var1, var2, this.field4569, this.field4571, var7);
                     System.arraycopy(var1, var2 + var7, this.field4569, 0, var3 - var7);
                  }

                  this.field4571 = (var3 + this.field4571) % this.field4568;
                  this.notifyAll();
               }
            }
         }
      } else {
         throw new IOException();
      }
   }

   void method7480() {
      synchronized(this) {
         this.field4573 = true;
         this.notifyAll();
      }

      try {
         this.field4574.join();
      } catch (InterruptedException var4) {
      }

   }
}
