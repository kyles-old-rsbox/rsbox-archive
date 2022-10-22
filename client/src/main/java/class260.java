import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.Iterator;

public class class260 {
   class210 field2967;
   int field2968;
   int field2969;
   String field2971;

   class260(String var1, int var2, int var3, class210 var4) {
      this.field2971 = var1;
      this.field2968 = var2;
      this.field2969 = var3;
      this.field2967 = var4;
   }

   protected static int method5146() {
      int var1 = 0;
      if (class217.field2586 == null || !class217.field2586.isValid()) {
         try {
            Iterator var2 = ManagementFactory.getGarbageCollectorMXBeans().iterator();

            while(var2.hasNext()) {
               GarbageCollectorMXBean var3 = (GarbageCollectorMXBean)var2.next();
               if (var3.isValid()) {
                  class217.field2586 = var3;
                  class31.field200 = -1L;
                  class31.field199 = -1L;
               }
            }
         } catch (Throwable var10) {
         }
      }

      if (class217.field2586 != null) {
         long var11 = class272.method2046();
         long var4 = class217.field2586.getCollectionTime();
         if (class31.field199 != -1L) {
            long var6 = var4 - class31.field199;
            long var8 = var11 - class31.field200;
            if (0L != var8) {
               var1 = (int)(100L * var6 / var8);
            }
         }

         class31.field199 = var4;
         class31.field200 = var11;
      }

      return var1;
   }

   static void method5145() {
      if (class4.field10 != null) {
         class4.field10.method7590(class55.field396, class36.field241 + (class291.field3364.field827 >> 7), (class291.field3364.field802 >> 7) + class169.field1536, false);
         class4.field10.method7594();
      }

   }

   static boolean method5147(class93 var0) {
      if (client.field1768 == 0) {
         return false;
      } else if (var0 == class291.field3364) {
         return class451.method7965();
      } else {
         boolean var2 = client.method6193();
         boolean var3;
         if (!var2) {
            var3 = 0 != (client.field1768 & 1);
            var2 = var3 && var0.method1907();
         }

         var3 = var2;
         if (!var2) {
            boolean var4 = (client.field1768 & 2) != 0;
            var3 = var4 && var0.method1939();
         }

         return var3;
      }
   }
}
