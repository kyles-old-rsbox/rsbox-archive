public class class389 extends class404 {
   int field4462 = 1;
   final class463 field4464;
   public class344 field4466 = new class344();

   public class389(class463 var1) {
      super(400);
      this.field4464 = var1;
   }

   class400 method7297() {
      return new class380();
   }

   class400[] method7299(int var1) {
      return new class380[var1];
   }

   public boolean method7010(class472 var1, boolean var2) {
      class380 var4 = (class380)this.method7282(var1);
      if (null == var4) {
         return false;
      } else {
         return !var2 || var4.field4491 != 0;
      }
   }

   public void method7011(class460 var1, int var2) {
      while(true) {
         if (var1.field4878 < var2) {
            boolean var4 = var1.method8134() == 1;
            class472 var5 = new class472(var1.method8124(), this.field4464);
            class472 var6 = new class472(var1.method8124(), this.field4464);
            int var7 = var1.method8115();
            int var8 = var1.method8134();
            int var9 = var1.method8134();
            boolean var10 = (var9 & 2) != 0;
            boolean var11 = (var9 & 1) != 0;
            if (var7 > 0) {
               var1.method8124();
               var1.method8134();
               var1.method8119();
            }

            var1.method8124();
            if (var5 != null && var5.method8442()) {
               class380 var12 = (class380)this.method7283(var5);
               if (var4) {
                  class380 var13 = (class380)this.method7283(var6);
                  if (var13 != null && var13 != var12) {
                     if (var12 != null) {
                        this.method7286(var13);
                     } else {
                        var12 = var13;
                     }
                  }
               }

               if (var12 != null) {
                  this.method7340(var12, var5, var6);
                  if (var7 != var12.field4491) {
                     boolean var15 = true;

                     for(class369 var14 = (class369)this.field4466.method6376(); var14 != null; var14 = (class369)this.field4466.method6373()) {
                        if (var14.field4359.equals(var5)) {
                           if (var7 != 0 && 0 == var14.field4360) {
                              var14.method7804();
                              var15 = false;
                           } else if (var7 == 0 && 0 != var14.field4360) {
                              var14.method7804();
                              var15 = false;
                           }
                        }
                     }

                     if (var15) {
                        this.field4466.method6374(new class369(var5, var7));
                     }
                  }
               } else {
                  if (this.method7332() >= 400) {
                     continue;
                  }

                  var12 = (class380)this.method7288(var5, var6);
               }

               if (var7 != var12.field4491) {
                  var12.field4490 = ++this.field4462 - 1;
                  if (var12.field4491 == -1 && 0 == var7) {
                     var12.field4490 = -(var12.field4490 * 765902219) * 1732968995;
                  }

                  var12.field4491 = var7;
               }

               var12.field4492 = var8;
               var12.field4407 = var10;
               var12.field4408 = var11;
               continue;
            }

            throw new IllegalStateException();
         }

         this.method7290();
         return;
      }
   }

   public static class473 method7007(class319 var0, int var1, int var2) {
      byte[] var5 = var0.method6167(var1, var2);
      boolean var4;
      if (null == var5) {
         var4 = false;
      } else {
         class317.method6072(var5);
         var4 = true;
      }

      return !var4 ? null : class475.method603();
   }
}
