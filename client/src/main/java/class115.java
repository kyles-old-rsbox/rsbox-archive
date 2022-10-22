import java.awt.Desktop;
import java.awt.Desktop.Action;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.util.LinkedList;
import java.util.Queue;

public abstract class class115 implements Runnable {
   static int field1134;
   int field1131;
   Queue field1133 = new LinkedList();
   final Thread field1130 = new Thread(this);
   volatile boolean field1129;

   class115(int var1) {
      this.field1130.setPriority(1);
      this.field1130.start();
      this.field1131 = var1;
   }

   public static void method2229(String var0, boolean var1, boolean var2) {
      if (var1) {
         if (!var2 && Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Action.BROWSE)) {
            try {
               Desktop.getDesktop().browse(new URI(var0));
               return;
            } catch (Exception var5) {
            }
         }

         if (class30.field157.startsWith("win") && !var2) {
            class411.method7404(var0, 0, "openjs");
         } else if (class30.field157.startsWith("mac")) {
            class411.method7404(var0, 1, "openjs");
         } else {
            class411.method7404(var0, 2, "openjs");
         }
      } else {
         class411.method7404(var0, 3, "openjs");
      }

   }

   public void run() {
      while(!this.field1129) {
         try {
            class109 var1;
            synchronized(this) {
               var1 = (class109)this.field1133.poll();
               if (null == var1) {
                  try {
                     this.wait();
                  } catch (InterruptedException var5) {
                  }
                  continue;
               }
            }

            this.method2238(var1);
         } catch (Exception var7) {
            class422.method7800((String)null, var7);
         }
      }

   }

   void method2223(URLConnection var1) {
      var1.setConnectTimeout(5000);
      var1.setReadTimeout(5000);
      var1.setUseCaches(false);
      var1.setRequestProperty("Connection", "close");
      var1.setRequestProperty("User-Agent", "OldSchoolRuneScape/" + this.field1131);
   }

   void method2224(URLConnection var1, class109 var2) {
      DataInputStream var4 = null;

      try {
         int var6 = var1.getContentLength();
         var4 = new DataInputStream(var1.getInputStream());
         byte[] var5;
         if (var6 >= 0) {
            var5 = new byte[var6];
            var4.readFully(var5);
         } else {
            var5 = new byte[0];
            byte[] var7 = class378.method765(5000);

            byte[] var9;
            for(int var8 = var4.read(var7, 0, var7.length); var8 > -1; var5 = var9) {
               var9 = new byte[var8 + var5.length];
               System.arraycopy(var5, 0, var9, 0, var5.length);
               System.arraycopy(var7, 0, var9, var5.length, var8);
            }

            class205.method3927(var7);
         }

         var2.field1083 = var5;
      } catch (IOException var11) {
      }

      if (null != var4) {
         try {
            var4.close();
         } catch (IOException var10) {
         }
      }

   }

   public class109 method2222(URL var1) {
      class109 var3 = new class109(var1);
      synchronized(this) {
         this.field1133.add(var3);
         this.notify();
         return var3;
      }
   }

   public void method2236() {
      this.field1129 = true;

      try {
         synchronized(this) {
            this.notify();
         }

         this.field1130.join();
      } catch (InterruptedException var5) {
      }

   }

   abstract void method2238(class109 var1) throws IOException;
}
