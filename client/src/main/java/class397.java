import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

public class class397 implements Runnable {
   byte[] field4496;
   int field4495;
   int field4497 = 0;
   int field4498 = 0;
   IOException field4499;
   InputStream field4494;
   Thread field4493;

   public static class473[] method7198(class319 var0, int var1, int var2) {
      byte[] var5 = var0.method6167(var1, var2);
      boolean var4;
      if (var5 == null) {
         var4 = false;
      } else {
         class317.method6072(var5);
         var4 = true;
      }

      if (!var4) {
         return null;
      } else {
         class473[] var6 = new class473[class475.field4968];

         for(int var7 = 0; var7 < class475.field4968; ++var7) {
            class473 var8 = var6[var7] = new class473();
            var8.field4956 = class475.field4967;
            var8.field4957 = class475.field4971;
            var8.field4954 = class450.field4840[var7];
            var8.field4962 = class315.field3720[var7];
            var8.field4959 = class467.field4921[var7];
            var8.field4951 = class475.field4966[var7];
            int var9 = var8.field4951 * var8.field4959;
            byte[] var10 = class451.field4844[var7];
            var8.field4952 = new int[var9];

            for(int var11 = 0; var11 < var9; ++var11) {
               var8.field4952[var11] = class475.field4970[var10[var11] & 255];
            }
         }

         class450.field4840 = null;
         class315.field3720 = null;
         class467.field4921 = null;
         class475.field4966 = null;
         class475.field4970 = null;
         class451.field4844 = (byte[][])null;
         return var6;
      }
   }

   class397(InputStream var1, int var2) {
      this.field4494 = var1;
      this.field4495 = var2 + 1;
      this.field4496 = new byte[this.field4495];
      this.field4493 = new Thread(this);
      this.field4493.setDaemon(true);
      this.field4493.start();
   }

   public void run() {
      while(true) {
         int var1;
         synchronized(this) {
            while(true) {
               if (null != this.field4499) {
                  return;
               }

               if (this.field4498 == 0) {
                  var1 = this.field4495 - this.field4497 - 1;
               } else if (this.field4498 <= this.field4497) {
                  var1 = this.field4495 - this.field4497;
               } else {
                  var1 = this.field4498 - this.field4497 - 1;
               }

               if (var1 > 0) {
                  break;
               }

               try {
                  this.wait();
               } catch (InterruptedException var9) {
               }
            }
         }

         int var2;
         try {
            var2 = this.field4494.read(this.field4496, this.field4497, var1);
            if (var2 == -1) {
               throw new EOFException();
            }
         } catch (IOException var10) {
            IOException var3 = var10;
            synchronized(this) {
               this.field4499 = var3;
               return;
            }
         }

         synchronized(this) {
            this.field4497 = (this.field4497 + var2) % this.field4495;
         }
      }
   }

   boolean method7179(int var1) throws IOException {
      if (0 == var1) {
         return true;
      } else if (var1 > 0 && var1 < this.field4495) {
         synchronized(this) {
            int var4;
            if (this.field4498 <= this.field4497) {
               var4 = this.field4497 - this.field4498;
            } else {
               var4 = this.field4497 + (this.field4495 - this.field4498);
            }

            if (var4 < var1) {
               if (null != this.field4499) {
                  throw new IOException(this.field4499.toString());
               } else {
                  this.notifyAll();
                  return false;
               }
            } else {
               return true;
            }
         }
      } else {
         throw new IOException();
      }
   }

   int method7180() throws IOException {
      synchronized(this) {
         int var3;
         if (this.field4498 <= this.field4497) {
            var3 = this.field4497 - this.field4498;
         } else {
            var3 = this.field4495 - this.field4498 + this.field4497;
         }

         if (var3 <= 0 && this.field4499 != null) {
            throw new IOException(this.field4499.toString());
         } else {
            this.notifyAll();
            return var3;
         }
      }
   }

   int method7196() throws IOException {
      synchronized(this) {
         if (this.field4497 == this.field4498) {
            if (this.field4499 != null) {
               throw new IOException(this.field4499.toString());
            } else {
               return -1;
            }
         } else {
            int var3 = this.field4496[this.field4498] & 255;
            this.field4498 = (1 + this.field4498) % this.field4495;
            this.notifyAll();
            return var3;
         }
      }
   }

   int method7182(byte[] var1, int var2, int var3) throws IOException {
      if (var3 >= 0 && var2 >= 0 && var3 + var2 <= var1.length) {
         synchronized(this) {
            int var6;
            if (this.field4498 <= this.field4497) {
               var6 = this.field4497 - this.field4498;
            } else {
               var6 = this.field4497 + (this.field4495 - this.field4498);
            }

            if (var3 > var6) {
               var3 = var6;
            }

            if (0 == var3 && null != this.field4499) {
               throw new IOException(this.field4499.toString());
            } else {
               if (this.field4498 + var3 <= this.field4495) {
                  System.arraycopy(this.field4496, this.field4498, var1, var2, var3);
               } else {
                  int var7 = this.field4495 - this.field4498;
                  System.arraycopy(this.field4496, this.field4498, var1, var2, var7);
                  System.arraycopy(this.field4496, 0, var1, var2 + var7, var3 - var7);
               }

               this.field4498 = (var3 + this.field4498) % this.field4495;
               this.notifyAll();
               return var3;
            }
         }
      } else {
         throw new IOException();
      }
   }

   void method7183() {
      synchronized(this) {
         if (null == this.field4499) {
            this.field4499 = new IOException("");
         }

         this.notifyAll();
      }

      try {
         this.field4493.join();
      } catch (InterruptedException var4) {
      }

   }
}
