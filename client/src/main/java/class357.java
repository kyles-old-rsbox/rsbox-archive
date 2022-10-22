public final class class357 {
   int field4308;
   final Object field4307;

   class357(Object var1, int var2) {
      this.field4307 = var1;
      this.field4308 = var2;
   }

   static final void method6600(byte[] var0, int var1, int var2, class214 var3, class200[] var4) {
      class460 var6 = new class460(var0);
      int var7 = -1;

      while(true) {
         int var8 = var6.method8131();
         if (0 == var8) {
            return;
         }

         var7 += var8;
         int var9 = 0;

         while(true) {
            int var10 = var6.method8200();
            if (var10 == 0) {
               break;
            }

            var9 += var10 - 1;
            int var11 = var9 & 63;
            int var12 = var9 >> 6 & 63;
            int var13 = var9 >> 12;
            int var14 = var6.method8134();
            int var15 = var14 >> 2;
            int var16 = var14 & 3;
            int var17 = var1 + var12;
            int var18 = var2 + var11;
            if (var17 > 0 && var18 > 0 && var17 < 103 && var18 < 103) {
               int var19 = var13;
               if ((class82.field714[1][var17][var18] & 2) == 2) {
                  var19 = var13 - 1;
               }

               class200 var20 = null;
               if (var19 >= 0) {
                  var20 = var4[var19];
               }

               class458.method8083(var13, var17, var18, var7, var16, var15, var3, var20);
            }
         }
      }
   }
}
