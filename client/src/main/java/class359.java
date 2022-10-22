import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.Random;

@class308
public final class class359 {
   public static byte[][][] field4312;
   static class319 field4313;

   class359() throws Throwable {
      throw new Error();
   }

   static final int method6655(long var0, String var2) {
      Random var4 = new Random();
      class460 var5 = new class460(128);
      class460 var6 = new class460(128);
      int[] var7 = new int[]{var4.nextInt(), var4.nextInt(), (int)(var0 >> 32), (int)var0};
      var5.method8097(10);

      int var8;
      for(var8 = 0; var8 < 4; ++var8) {
         var5.method8234(var4.nextInt());
      }

      var5.method8234(var7[0]);
      var5.method8234(var7[1]);
      var5.method8102(var0);
      var5.method8102(0L);

      for(var8 = 0; var8 < 4; ++var8) {
         var5.method8234(var4.nextInt());
      }

      var5.method8140(class54.field388, class54.field389);
      var6.method8097(10);

      for(var8 = 0; var8 < 3; ++var8) {
         var6.method8234(var4.nextInt());
      }

      var6.method8102(var4.nextLong());
      var6.method8101(var4.nextLong());
      class296.method5544(var6);
      var6.method8102(var4.nextLong());
      var6.method8140(class54.field388, class54.field389);
      var8 = class460.method1887(var2);
      if (0 != var8 % 8) {
         var8 += 8 - var8 % 8;
      }

      class460 var9 = new class460(var8);
      var9.method8104(var2);
      var9.field4878 = var8;
      var9.method8136(var7);
      class460 var10 = new class460(var9.field4878 + var6.field4878 + 5 + var5.field4878);
      var10.method8097(2);
      var10.method8097(var5.field4878);
      var10.method8107(var5.field4881, 0, var5.field4878);
      var10.method8097(var6.field4878);
      var10.method8107(var6.field4881, 0, var6.field4878);
      var10.method8174(var9.field4878);
      var10.method8107(var9.field4881, 0, var9.field4878);
      byte[] var12 = var10.field4881;
      int var14 = var12.length;
      StringBuilder var15 = new StringBuilder();

      int var18;
      for(int var16 = 0; var16 < 0 + var14; var16 += 3) {
         int var17 = var12[var16] & 255;
         var15.append(class351.field4277[var17 >>> 2]);
         if (var16 < var14 - 1) {
            var18 = var12[1 + var16] & 255;
            var15.append(class351.field4277[(var17 & 3) << 4 | var18 >>> 4]);
            if (var16 < var14 - 2) {
               int var19 = var12[var16 + 2] & 255;
               var15.append(class351.field4277[(var18 & 15) << 2 | var19 >>> 6]).append(class351.field4277[var19 & 63]);
            } else {
               var15.append(class351.field4277[(var18 & 15) << 2]).append("=");
            }
         } else {
            var15.append(class351.field4277[(var17 & 3) << 4]).append("==");
         }
      }

      String var13 = var15.toString();
      var13 = var13;

      try {
         URL var21 = new URL(class140.method2473("services", false) + "m=accountappeal/login.ws");
         URLConnection var22 = var21.openConnection();
         var22.setDoInput(true);
         var22.setDoOutput(true);
         var22.setConnectTimeout(5000);
         OutputStreamWriter var23 = new OutputStreamWriter(var22.getOutputStream());
         var23.write("data2=" + class61.method1338(var13) + "&dest=" + class61.method1338("passwordchoice.ws"));
         var23.flush();
         InputStream var24 = var22.getInputStream();
         var10 = new class460(new byte[1000]);

         do {
            var18 = var24.read(var10.field4881, var10.field4878, 1000 - var10.field4878);
            if (var18 == -1) {
               var23.close();
               var24.close();
               String var25 = new String(var10.field4881);
               if (var25.startsWith("OFFLINE")) {
                  return 4;
               } else if (var25.startsWith("WRONG")) {
                  return 7;
               } else if (var25.startsWith("RELOAD")) {
                  return 3;
               } else if (var25.startsWith("Not permitted for social network accounts.")) {
                  return 6;
               } else {
                  var10.method8137(var7);

                  while(var10.field4878 > 0 && 0 == var10.field4881[var10.field4878 - 1]) {
                     --var10.field4878;
                  }

                  var25 = new String(var10.field4881, 0, var10.field4878);
                  if (class81.method1622(var25)) {
                     class115.method2229(var25, true, false);
                     return 2;
                  } else {
                     return 5;
                  }
               }
            }

            var10.field4878 += var18;
         } while(var10.field4878 < 1000);

         return 5;
      } catch (Throwable var20) {
         var20.printStackTrace();
         return 5;
      }
   }

   public static int method1905(CharSequence var0) {
      return class13.method120(var0, 10, true);
   }

   public static int method6663(CharSequence var0) {
      int var2 = var0.length();
      int var3 = 0;

      for(int var4 = 0; var4 < var2; ++var4) {
         var3 = (var3 << 5) - var3 + class107.method2099(var0.charAt(var4));
      }

      return var3;
   }

   public static String method5222(CharSequence var0) {
      return class229.method4527('*', var0.length());
   }
}
