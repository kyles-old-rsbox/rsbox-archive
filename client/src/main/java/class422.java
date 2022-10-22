import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.URL;

public class class422 {
   static final int[] field4668 = new int[16384];
   static final int[] field4672 = new int[16384];

   static {
      double var0 = 3.834951969714103E-4D;

      for(int var2 = 0; var2 < 16384; ++var2) {
         field4672[var2] = (int)(16384.0D * Math.sin((double)var2 * var0));
         field4668[var2] = (int)(16384.0D * Math.cos((double)var2 * var0));
      }

   }

   class422() throws Throwable {
      throw new Error();
   }

   public static float method3465(int var0) {
      var0 &= 16383;
      return (float)(6.283185307179586D * (double)((float)var0 / 16384.0F));
   }

   public static int method4672(int var0, int var1) {
      return (int)Math.round(Math.atan2((double)var0, (double)var1) * 2607.5945876176133D) & 16383;
   }

   public static int method6174(int var0) {
      return field4672[var0 & 16383];
   }

   public static void method7800(String var0, Throwable var1) {
      try {
         String var3 = "";
         if (var1 != null) {
            Throwable var5 = var1;
            String var6;
            if (var1 instanceof class487) {
               class487 var7 = (class487)var1;
               var6 = var7.field5011 + " | ";
               var5 = var7.field5014;
            } else {
               var6 = "";
            }

            StringWriter var19 = new StringWriter();
            PrintWriter var8 = new PrintWriter(var19);
            var5.printStackTrace(var8);
            var8.close();
            String var9 = var19.toString();
            BufferedReader var10 = new BufferedReader(new StringReader(var9));
            String var11 = var10.readLine();

            while(true) {
               String var12 = var10.readLine();
               if (var12 == null) {
                  var6 = var6 + "| " + var11;
                  var3 = var6;
                  break;
               }

               int var13 = var12.indexOf(40);
               int var14 = var12.indexOf(41, var13 + 1);
               if (var13 >= 0 && var14 >= 0) {
                  String var15 = var12.substring(1 + var13, var14);
                  int var16 = var15.indexOf(".java:");
                  if (var16 >= 0) {
                     var15 = var15.substring(0, var16) + var15.substring(5 + var16);
                     var6 = var6 + var15 + ' ';
                     continue;
                  }

                  var12 = var12.substring(0, var13);
               }

               var12 = var12.trim();
               var12 = var12.substring(var12.lastIndexOf(32) + 1);
               var12 = var12.substring(var12.lastIndexOf(9) + 1);
               var6 = var6 + var12 + ' ';
            }
         }

         if (null != var0) {
            if (var1 != null) {
               var3 = var3 + " | ";
            }

            var3 = var3 + var0;
         }

         System.out.println("Error: " + var3);
         var3 = var3.replace(':', '.');
         var3 = var3.replace('@', '_');
         var3 = var3.replace('&', '_');
         var3 = var3.replace('#', '_');
         if (class487.field5015 == null) {
            return;
         }

         URL var4 = new URL(class487.field5015.getCodeBase(), "clienterror.ws?cv=" + class487.field5012 + "&cs=" + class487.field5010 + "&u=" + class487.field5013 + "&v1=" + class172.field1559 + "&v2=" + class172.field1552 + "&ct=" + class460.field4885 + "&e=" + var3);
         DataInputStream var18 = new DataInputStream(var4.openStream());
         var18.read();
         var18.close();
      } catch (Exception var17) {
      }

   }

   public static int method2841(int var0) {
      return field4668[var0 & 16383];
   }
}
