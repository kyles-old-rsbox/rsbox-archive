import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class class4 {
   static class336 field12;
   static class420 field10;
   ExecutorService field5 = Executors.newSingleThreadExecutor();
   Future field13;
   final class24 field8;
   final class460 field7;

   public class4(class460 var1, class24 var2) {
      this.field7 = var1;
      this.field8 = var2;
      this.method30();
   }

   public boolean method17() {
      return this.field13.isDone();
   }

   public void method18() {
      this.field5.shutdown();
      this.field5 = null;
   }

   public class460 method19() {
      try {
         return (class460)this.field13.get();
      } catch (Exception var3) {
         return null;
      }
   }

   void method30() {
      this.field13 = this.field5.submit(new class6(this, this.field7, this.field8));
   }

   public static File method34(String var0, String var1, int var2) {
      String var4 = var2 == 0 ? "" : "" + var2;
      class163.field1501 = new File(class45.field328, "jagex_cl_" + var0 + "_" + var1 + var4 + ".dat");
      String var5 = null;
      String var6 = null;
      boolean var7 = false;
      class460 var9;
      File var22;
      if (class163.field1501.exists()) {
         try {
            class464 var8 = new class464(class163.field1501, "rw", 10000L);

            int var10;
            for(var9 = new class460((int)var8.method8366()); var9.field4878 < var9.field4881.length; var9.field4878 += var10) {
               var10 = var8.method8362(var9.field4881, var9.field4878, var9.field4881.length - var9.field4878);
               if (-1 == var10) {
                  throw new IOException();
               }
            }

            var9.field4878 = 0;
            var10 = var9.method8134();
            if (var10 < 1 || var10 > 3) {
               throw new IOException("" + var10);
            }

            int var11 = 0;
            if (var10 > 1) {
               var11 = var9.method8134();
            }

            if (var10 <= 2) {
               var5 = var9.method8125();
               if (var11 == 1) {
                  var6 = var9.method8125();
               }
            } else {
               var5 = var9.method8126();
               if (var11 == 1) {
                  var6 = var9.method8126();
               }
            }

            var8.method8367();
         } catch (IOException var19) {
            var19.printStackTrace();
         }

         if (var5 != null) {
            var22 = new File(var5);
            if (!var22.exists()) {
               var5 = null;
            }
         }

         if (var5 != null) {
            var22 = new File(var5, "test.dat");
            if (!class32.method601(var22, true)) {
               var5 = null;
            }
         }
      }

      if (var5 == null && 0 == var2) {
         label147:
         for(int var20 = 0; var20 < class251.field2908.length; ++var20) {
            for(int var23 = 0; var23 < class347.field4261.length; ++var23) {
               File var24 = new File(class347.field4261[var23] + class251.field2908[var20] + File.separatorChar + var0 + File.separatorChar);
               if (var24.exists()) {
                  File var12 = new File(var24, "test.dat");

                  boolean var28;
                  try {
                     RandomAccessFile var13 = new RandomAccessFile(var12, "rw");
                     int var14 = var13.read();
                     var13.seek(0L);
                     var13.write(var14);
                     var13.seek(0L);
                     var13.close();
                     var12.delete();
                     var28 = true;
                  } catch (Exception var17) {
                     var28 = false;
                  }

                  if (var28) {
                     var5 = var24.toString();
                     var7 = true;
                     break label147;
                  }
               }
            }
         }
      }

      if (var5 == null) {
         var5 = class45.field328 + File.separatorChar + "jagexcache" + var4 + File.separatorChar + var0 + File.separatorChar + var1 + File.separatorChar;
         var7 = true;
      }

      File var21;
      if (null != var6) {
         var21 = new File(var6);
         var22 = new File(var5);

         try {
            File[] var25 = var21.listFiles();
            File[] var29 = var25;

            for(int var27 = 0; var27 < var29.length; ++var27) {
               File var30 = var29[var27];
               File var32 = new File(var22, var30.getName());
               boolean var15 = var30.renameTo(var32);
               if (!var15) {
                  throw new IOException();
               }
            }
         } catch (Exception var18) {
            var18.printStackTrace();
         }

         var7 = true;
      }

      if (var7) {
         var21 = new File(var5);
         var9 = null;

         try {
            class464 var26 = new class464(class163.field1501, "rw", 10000L);
            class460 var31 = new class460(500);
            var31.method8097(3);
            var31.method8097(var9 != null ? 1 : 0);
            var31.method8192(var21.getPath());
            if (null != var9) {
               var31.method8192("");
            }

            var26.method8363(var31.field4881, 0, var31.field4878);
            var26.method8367();
         } catch (IOException var16) {
            var16.printStackTrace();
         }
      }

      return new File(var5);
   }

   static final void method16(class300 var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      if (client.field1714) {
         client.field1715 = 32;
      } else {
         client.field1715 = 0;
      }

      client.field1714 = false;
      int var8;
      if (class42.field289 == 1 || !class95.field944 && 4 == class42.field289) {
         if (var5 >= var1 && var5 < 16 + var1 && var6 >= var2 && var6 < var2 + 16) {
            var0.field3482 -= 4;
            class136.method2438(var0);
         } else if (var5 >= var1 && var5 < 16 + var1 && var6 >= var2 + var3 - 16 && var6 < var2 + var3) {
            var0.field3482 += 4;
            class136.method2438(var0);
         } else if (var5 >= var1 - client.field1715 && var5 < var1 + 16 + client.field1715 && var6 >= 16 + var2 && var6 < var2 + var3 - 16) {
            var8 = (var3 - 32) * var3 / var4;
            if (var8 < 8) {
               var8 = 8;
            }

            int var9 = var6 - var2 - 16 - var8 / 2;
            int var10 = var3 - 32 - var8;
            var0.field3482 = var9 * (var4 - var3) / var10;
            class136.method2438(var0);
            client.field1714 = true;
         }
      }

      if (client.field1639 != 0) {
         var8 = var0.field3448;
         if (var5 >= var1 - var8 && var6 >= var2 && var5 < 16 + var1 && var6 <= var2 + var3) {
            var0.field3482 += client.field1639 * 45;
            class136.method2438(var0);
         }
      }

   }

   static final void method32(class89 var0, boolean var1) {
      int var3 = var0.field796;
      int var4 = (int)var0.field4681;
      var0.remove();
      if (var1) {
         class257.method5138(var3);
      }

      class152.method2593(var3);
      class300 var5 = class282.method5426(var4);
      if (null != var5) {
         class136.method2438(var5);
      }

      if (-1 != client.field1893) {
         class217.method4361(client.field1893, 1);
      }

   }
}
