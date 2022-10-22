public class class322 implements Runnable {
   static class343 field3759 = new class343();
   static class343 field3760 = new class343();
   static int field3761 = 0;
   static Object field3762 = new Object();
   static Thread field3763;

   class322() {
   }

   public static void method4893() {
      while(true) {
         class334 var1;
         synchronized(field3759) {
            var1 = (class334)field3760.method6367();
         }

         if (null == var1) {
            return;
         }

         var1.field3863.method6271(var1.field3862, (int)var1.field4681, var1.field3861, false);
      }
   }

   public void run() {
      try {
         while(true) {
            class334 var1;
            synchronized(field3759) {
               var1 = (class334)field3759.method6356();
            }

            if (null != var1) {
               if (0 == var1.field3860) {
                  var1.field3862.method7138((int)var1.field4681, var1.field3861, var1.field3861.length);
                  synchronized(field3759) {
                     var1.remove();
                  }
               } else if (1 == var1.field3860) {
                  var1.field3861 = var1.field3862.method7137((int)var1.field4681);
                  synchronized(field3759) {
                     field3760.method6347(var1);
                  }
               }

               synchronized(field3762) {
                  if (field3761 <= 1) {
                     field3761 = 0;
                     field3762.notifyAll();
                     return;
                  }

                  field3761 = 600;
               }
            } else {
               class266.method3531(100L);
               synchronized(field3762) {
                  if (field3761 <= 1) {
                     field3761 = 0;
                     field3762.notifyAll();
                     return;
                  }

                  --field3761;
               }
            }
         }
      } catch (Exception var13) {
         class422.method7800((String)null, var13);
      }
   }

   static class149 method6178(int var0) {
      class149[] var2 = new class149[]{class149.field1391, class149.field1390, class149.field1386, class149.field1384, class149.field1385, class149.field1388, class149.field1389, class149.field1387, class149.field1392};
      class149 var3 = (class149)class217.method4362(var2, var0);
      if (var3 == null) {
         var3 = class149.field1392;
      }

      return var3;
   }

   public static void method3464() {
      synchronized(field3762) {
         if (0 != field3761) {
            field3761 = 1;

            try {
               field3762.wait();
            } catch (InterruptedException var4) {
            }
         }

      }
   }

   static void method6190(class189 var0, int var1, int var2, int var3) {
      if (client.field1894 < 50 && class413.field4575.method1736() != 0) {
         if (var0.field2007 != null && var1 < var0.field2007.length) {
            class100.method1993(var0.field2007[var1], var2, var3);
         }
      }
   }
}
