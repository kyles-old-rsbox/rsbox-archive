public final class class376 extends class384 {
   public class376(byte[] var1, int[] var2, int[] var3, int[] var4, int[] var5, int[] var6, byte[][] var7) {
      super(var1, var2, var3, var4, var5, var6, var7);
   }

   public class376(byte[] var1) {
      super(var1);
   }

   final void method6883(byte[] var1, int var2, int var3, int var4, int var5, int var6) {
      int var7 = var2 + var3 * class481.field4993;
      int var8 = class481.field4993 - var4;
      int var9 = 0;
      int var10 = 0;
      int var11;
      if (var3 < class481.field4995) {
         var11 = class481.field4995 - var3;
         var5 -= var11;
         var3 = class481.field4995;
         var10 += var11 * var4;
         var7 += var11 * class481.field4993;
      }

      if (var3 + var5 > class481.field4998) {
         var5 -= var3 + var5 - class481.field4998;
      }

      if (var2 < class481.field4997) {
         var11 = class481.field4997 - var2;
         var4 -= var11;
         var2 = class481.field4997;
         var10 += var11;
         var7 += var11;
         var9 += var11;
         var8 += var11;
      }

      if (var2 + var4 > class481.field4996) {
         var11 = var2 + var4 - class481.field4996;
         var4 -= var11;
         var9 += var11;
         var8 += var11;
      }

      if (var4 > 0 && var5 > 0) {
         method6877(class481.field4992, var1, var6, var10, var7, var4, var5, var8, var9);
      }
   }

   final void method6949(byte[] var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      int var8 = var2 + var3 * class481.field4993;
      int var9 = class481.field4993 - var4;
      int var10 = 0;
      int var11 = 0;
      int var12;
      if (var3 < class481.field4995) {
         var12 = class481.field4995 - var3;
         var5 -= var12;
         var3 = class481.field4995;
         var11 += var12 * var4;
         var8 += var12 * class481.field4993;
      }

      if (var3 + var5 > class481.field4998) {
         var5 -= var3 + var5 - class481.field4998;
      }

      if (var2 < class481.field4997) {
         var12 = class481.field4997 - var2;
         var4 -= var12;
         var2 = class481.field4997;
         var11 += var12;
         var8 += var12;
         var10 += var12;
         var9 += var12;
      }

      if (var2 + var4 > class481.field4996) {
         var12 = var2 + var4 - class481.field4996;
         var4 -= var12;
         var10 += var12;
         var9 += var12;
      }

      if (var4 > 0 && var5 > 0) {
         method6879(class481.field4992, var1, var6, var11, var8, var4, var5, var9, var10, var7);
      }
   }
}
