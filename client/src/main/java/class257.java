import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class class257 extends class254 {
   HashSet field2952;
   HashSet field2954;
   List field2953;

   class257() {
   }

   void method5129(class460 var1, class460 var2, int var3, boolean var4) {
      this.method5073(var1, var3);
      int var6 = var2.method8115();
      this.field2952 = new HashSet(var6);

      int var7;
      for(var7 = 0; var7 < var6; ++var7) {
         class228 var8 = new class228();

         try {
            var8.method4518(var2);
         } catch (IllegalStateException var12) {
            continue;
         }

         this.field2952.add(var8);
      }

      var7 = var2.method8115();
      this.field2954 = new HashSet(var7);

      for(int var13 = 0; var13 < var7; ++var13) {
         class244 var9 = new class244();

         try {
            var9.method4872(var2);
         } catch (IllegalStateException var11) {
            continue;
         }

         this.field2954.add(var9);
      }

      this.method5130(var2, var4);
   }

   static int method5139(int var0, int var1) {
      class87 var3 = (class87)class87.field782.get((long)var0);
      if (null == var3) {
         return 0;
      } else if (var1 == -1) {
         return 0;
      } else {
         int var4 = 0;

         for(int var5 = 0; var5 < var3.field783.length; ++var5) {
            if (var1 == var3.field779[var5]) {
               var4 += var3.field783[var5];
            }
         }

         return var4;
      }
   }

   void method5130(class460 var1, boolean var2) {
      this.field2953 = new LinkedList();
      int var4 = var1.method8115();

      for(int var5 = 0; var5 < var4; ++var5) {
         int var6 = var1.method8133();
         class295 var7 = new class295(var1.method8119());
         boolean var8 = var1.method8134() == 1;
         if (var2 || !var8) {
            this.field2953.add(new class249((class295)null, var7, var6, (class260)null));
         }
      }

   }

   public static void method5138(int var0) {
      if (var0 != -1) {
         if (class299.field3442[var0]) {
            class105.field1044.method6094(var0);
            if (null != class300.field3593[var0]) {
               boolean var2 = true;

               for(int var3 = 0; var3 < class300.field3593[var0].length; ++var3) {
                  if (null != class300.field3593[var0][var3]) {
                     if (2 != class300.field3593[var0][var3].field3462) {
                        class300.field3593[var0][var3] = null;
                     } else {
                        var2 = false;
                     }
                  }
               }

               if (var2) {
                  class300.field3593[var0] = null;
               }

               class299.field3442[var0] = false;
            }
         }
      }
   }
}
