public class class169 extends class137 {
   static int field1536;
   byte field1532;
   byte field1535;
   String field1534;
   // $FF: synthetic field
   final class143 this$0;

   public static class206 method2715(int var0) {
      class206 var2 = (class206)class206.field2330.method5439((long)var0);
      if (var2 != null) {
         return var2;
      } else {
         byte[] var3 = class206.field2346.method6167(32, var0);
         var2 = new class206();
         if (var3 != null) {
            var2.method3930(new class460(var3));
         }

         class206.field2330.method5434(var2, (long)var0);
         return var2;
      }
   }

   static void method2714(class336 var0, int var1, int var2, int var3, byte var4, boolean var5) {
      long var7 = (long)(var2 + (var1 << 16));
      class335 var9 = (class335)class324.field3794.get(var7);
      if (null == var9) {
         var9 = (class335)class324.field3779.get(var7);
         if (null == var9) {
            var9 = (class335)class324.field3782.get(var7);
            if (var9 != null) {
               if (var5) {
                  var9.method7882();
                  class324.field3794.put(var9, var7);
                  --class324.field3788;
                  ++class324.field3778;
               }

            } else {
               if (!var5) {
                  var9 = (class335)class324.field3784.get(var7);
                  if (var9 != null) {
                     return;
                  }
               }

               var9 = new class335();
               var9.field3866 = var0;
               var9.field3865 = var3;
               var9.field3868 = var4;
               if (var5) {
                  class324.field3794.put(var9, var7);
                  ++class324.field3778;
               } else {
                  class324.field3781.method6564(var9);
                  class324.field3782.put(var9, var7);
                  ++class324.field3788;
               }

            }
         }
      }
   }

   class169(class143 var1) {
      this.this$0 = var1;
   }

   void method2441(class460 var1) {
      this.field1534 = var1.method8298();
      if (this.field1534 != null) {
         var1.method8134();
         this.field1532 = var1.method8280();
         this.field1535 = var1.method8280();
      }

   }

   void method2442(class147 var1) {
      var1.field1350 = this.field1534;
      if (this.field1534 != null) {
         var1.field1345 = this.field1532;
         var1.field1351 = this.field1535;
      }

   }
}
