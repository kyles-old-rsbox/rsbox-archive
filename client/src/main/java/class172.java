import java.io.DataInputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;

public class class172 implements Runnable {
   public static String field1552;
   public static String field1559;
   public static short[] field1551;
   boolean field1557 = false;
   class181 field1554 = null;
   class181 field1556 = null;
   Thread field1555;

   public class172() {
      field1559 = "Unknown";
      field1552 = "1.6";

      try {
         field1559 = System.getProperty("java.vendor");
         field1552 = System.getProperty("java.version");
      } catch (Exception var2) {
      }

      this.field1557 = false;
      this.field1555 = new Thread(this);
      this.field1555.setPriority(10);
      this.field1555.setDaemon(true);
      this.field1555.start();
   }

   public final void method2721() {
      synchronized(this) {
         this.field1557 = true;
         this.notifyAll();
      }

      try {
         this.field1555.join();
      } catch (InterruptedException var4) {
      }

   }

   public final void run() {
      while(true) {
         class181 var1;
         synchronized(this) {
            while(true) {
               if (this.field1557) {
                  return;
               }

               if (this.field1556 != null) {
                  var1 = this.field1556;
                  this.field1556 = this.field1556.field1616;
                  if (null == this.field1556) {
                     this.field1554 = null;
                  }
                  break;
               }

               try {
                  this.wait();
               } catch (InterruptedException var7) {
               }
            }
         }

         try {
            int var2 = var1.field1618;
            if (var2 == 1) {
               var1.field1612 = new Socket(InetAddress.getByName((String)var1.field1617), var1.field1611);
            } else if (2 == var2) {
               Thread var3 = new Thread((Runnable)var1.field1617);
               var3.setDaemon(true);
               var3.start();
               var3.setPriority(var1.field1611);
               var1.field1612 = var3;
            } else if (var2 == 4) {
               var1.field1612 = new DataInputStream(((URL)var1.field1617).openStream());
            }

            var1.field1614 = 1;
         } catch (ThreadDeath var5) {
            throw var5;
         } catch (Throwable var6) {
            var1.field1614 = 2;
         }
      }
   }

   static final void method2733(class453 var0) {
      int var2 = 0;
      var0.method8006();

      byte[] var10000;
      int var3;
      int var4;
      int var5;
      for(var3 = 0; var3 < class102.field1012; ++var3) {
         var4 = class102.field1013[var3];
         if ((class102.field1019[var4] & 1) == 0) {
            if (var2 > 0) {
               --var2;
               var10000 = class102.field1019;
               var10000[var4] = (byte)(var10000[var4] | 2);
            } else {
               var5 = var0.method8007(1);
               if (var5 == 0) {
                  var2 = class57.method1273(var0);
                  var10000 = class102.field1019;
                  var10000[var4] = (byte)(var10000[var4] | 2);
               } else {
                  class62.method1339(var0, var4);
               }
            }
         }
      }

      var0.method8003();
      if (var2 != 0) {
         throw new RuntimeException();
      } else {
         var0.method8006();

         for(var3 = 0; var3 < class102.field1012; ++var3) {
            var4 = class102.field1013[var3];
            if ((class102.field1019[var4] & 1) != 0) {
               if (var2 > 0) {
                  --var2;
                  var10000 = class102.field1019;
                  var10000[var4] = (byte)(var10000[var4] | 2);
               } else {
                  var5 = var0.method8007(1);
                  if (0 == var5) {
                     var2 = class57.method1273(var0);
                     var10000 = class102.field1019;
                     var10000[var4] = (byte)(var10000[var4] | 2);
                  } else {
                     class62.method1339(var0, var4);
                  }
               }
            }
         }

         var0.method8003();
         if (var2 != 0) {
            throw new RuntimeException();
         } else {
            var0.method8006();

            for(var3 = 0; var3 < class102.field1017; ++var3) {
               var4 = class102.field1015[var3];
               if (0 != (class102.field1019[var4] & 1)) {
                  if (var2 > 0) {
                     --var2;
                     var10000 = class102.field1019;
                     var10000[var4] = (byte)(var10000[var4] | 2);
                  } else {
                     var5 = var0.method8007(1);
                     if (0 == var5) {
                        var2 = class57.method1273(var0);
                        var10000 = class102.field1019;
                        var10000[var4] = (byte)(var10000[var4] | 2);
                     } else if (class399.method7214(var0, var4)) {
                        var10000 = class102.field1019;
                        var10000[var4] = (byte)(var10000[var4] | 2);
                     }
                  }
               }
            }

            var0.method8003();
            if (0 != var2) {
               throw new RuntimeException();
            } else {
               var0.method8006();

               for(var3 = 0; var3 < class102.field1017; ++var3) {
                  var4 = class102.field1015[var3];
                  if ((class102.field1019[var4] & 1) == 0) {
                     if (var2 > 0) {
                        --var2;
                        var10000 = class102.field1019;
                        var10000[var4] = (byte)(var10000[var4] | 2);
                     } else {
                        var5 = var0.method8007(1);
                        if (var5 == 0) {
                           var2 = class57.method1273(var0);
                           var10000 = class102.field1019;
                           var10000[var4] = (byte)(var10000[var4] | 2);
                        } else if (class399.method7214(var0, var4)) {
                           var10000 = class102.field1019;
                           var10000[var4] = (byte)(var10000[var4] | 2);
                        }
                     }
                  }
               }

               var0.method8003();
               if (0 != var2) {
                  throw new RuntimeException();
               } else {
                  class102.field1012 = 0;
                  class102.field1017 = 0;

                  for(var3 = 1; var3 < 2048; ++var3) {
                     var10000 = class102.field1019;
                     var10000[var3] = (byte)(var10000[var3] >> 1);
                     class93 var6 = client.field1763[var3];
                     if (var6 != null) {
                        class102.field1013[++class102.field1012 - 1] = var3;
                     } else {
                        class102.field1015[++class102.field1017 - 1] = var3;
                     }
                  }

               }
            }
         }
      }
   }

   final class181 method2722(int var1, int var2, int var3, Object var4) {
      class181 var6 = new class181();
      var6.field1618 = var1;
      var6.field1611 = var2;
      var6.field1617 = var4;
      synchronized(this) {
         if (null != this.field1554) {
            this.field1554.field1616 = var6;
            this.field1554 = var6;
         } else {
            this.field1554 = this.field1556 = var6;
         }

         this.notify();
         return var6;
      }
   }

   public final class181 method2723(String var1, int var2) {
      return this.method2722(1, var2, 0, var1);
   }

   public final class181 method2731(Runnable var1, int var2) {
      return this.method2722(2, var2, 0, var1);
   }
}
