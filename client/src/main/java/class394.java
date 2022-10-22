public class class394 {
   class394() throws Throwable {
      throw new Error();
   }

   static float method7163(class106 var0, float var1, boolean var2) {
      float var4 = 0.0F;
      if (var0 != null && var0.method2055() != 0) {
         float var5 = (float)var0.field1061[0].field1153;
         float var6 = (float)var0.field1061[var0.method2055() - 1].field1153;
         float var7 = var6 - var5;
         if ((double)var7 == 0.0D) {
            return var0.field1061[0].field1150;
         } else {
            float var8 = 0.0F;
            if (var1 > var6) {
               var8 = (var1 - var6) / var7;
            } else {
               var8 = (var1 - var5) / var7;
            }

            double var9 = (double)((int)var8);
            float var11 = Math.abs((float)((double)var8 - var9));
            float var12 = var7 * var11;
            var9 = Math.abs(var9 + 1.0D);
            double var13 = var9 / 2.0D;
            double var15 = (double)((int)var13);
            var11 = (float)(var13 - var15);
            float var17;
            float var18;
            if (var2) {
               if (var0.field1058 == class118.field1143) {
                  if ((double)var11 != 0.0D) {
                     var12 += var5;
                  } else {
                     var12 = var6 - var12;
                  }
               } else if (class118.field1145 != var0.field1058 && class118.field1144 != var0.field1058) {
                  if (var0.field1058 == class118.field1142) {
                     var12 = var5 - var1;
                     var17 = var0.field1061[0].field1152;
                     var18 = var0.field1061[0].field1151;
                     var4 = var0.field1061[0].field1150;
                     if ((double)var17 != 0.0D) {
                        var4 -= var12 * var18 / var17;
                     }

                     return var4;
                  }
               } else {
                  var12 = var6 - var12;
               }
            } else if (class118.field1143 == var0.field1057) {
               if ((double)var11 != 0.0D) {
                  var12 = var6 - var12;
               } else {
                  var12 += var5;
               }
            } else if (class118.field1145 != var0.field1057 && class118.field1144 != var0.field1057) {
               if (class118.field1142 == var0.field1057) {
                  var12 = var1 - var6;
                  var17 = var0.field1061[var0.method2055() - 1].field1154;
                  var18 = var0.field1061[var0.method2055() - 1].field1155;
                  var4 = var0.field1061[var0.method2055() - 1].field1150;
                  if (0.0D != (double)var17) {
                     var4 += var12 * var18 / var17;
                  }

                  return var4;
               }
            } else {
               var12 += var5;
            }

            var4 = class144.method2499(var0, var12);
            float var19;
            if (var2 && class118.field1144 == var0.field1058) {
               var19 = var0.field1061[var0.method2055() - 1].field1150 - var0.field1061[0].field1150;
               var4 = (float)((double)var4 - (double)var19 * var9);
            } else if (!var2 && class118.field1144 == var0.field1057) {
               var19 = var0.field1061[var0.method2055() - 1].field1150 - var0.field1061[0].field1150;
               var4 = (float)((double)var4 + var9 * (double)var19);
            }

            return var4;
         }
      } else {
         return var4;
      }
   }
}
