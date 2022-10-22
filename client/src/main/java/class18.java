import java.security.SecureRandom;

public class class18 implements class360 {
   public static final class18 field84 = new class18(1, "GET", true, false);
   public static final class18 field87 = new class18(0, "POST", true, true);
   static byte[][] field92;
   static class167 field94;
   static final class18 field86 = new class18(3, "PATCH", false, true);
   static final class18 field88 = new class18(2, "PUT", false, true);
   static final class18 field91 = new class18(4, "DELETE", false, true);
   boolean field83;
   boolean field90;
   int field93;
   String field89;

   public static final int method217(double var0, double var2, double var4) {
      double var6 = var4;
      double var8 = var4;
      double var10 = var4;
      if (0.0D != var2) {
         double var12;
         if (var4 < 0.5D) {
            var12 = (var2 + 1.0D) * var4;
         } else {
            var12 = var4 + var2 - var2 * var4;
         }

         double var14 = 2.0D * var4 - var12;
         double var16 = var0 + 0.3333333333333333D;
         if (var16 > 1.0D) {
            --var16;
         }

         double var20 = var0 - 0.3333333333333333D;
         if (var20 < 0.0D) {
            ++var20;
         }

         if (6.0D * var16 < 1.0D) {
            var6 = var14 + var16 * (var12 - var14) * 6.0D;
         } else if (2.0D * var16 < 1.0D) {
            var6 = var12;
         } else if (3.0D * var16 < 2.0D) {
            var6 = 6.0D * (var12 - var14) * (0.6666666666666666D - var16) + var14;
         } else {
            var6 = var14;
         }

         if (var0 * 6.0D < 1.0D) {
            var8 = var0 * 6.0D * (var12 - var14) + var14;
         } else if (var0 * 2.0D < 1.0D) {
            var8 = var12;
         } else if (var0 * 3.0D < 2.0D) {
            var8 = var14 + 6.0D * (0.6666666666666666D - var0) * (var12 - var14);
         } else {
            var8 = var14;
         }

         if (6.0D * var20 < 1.0D) {
            var10 = var20 * 6.0D * (var12 - var14) + var14;
         } else if (2.0D * var20 < 1.0D) {
            var10 = var12;
         } else if (var20 * 3.0D < 2.0D) {
            var10 = (0.6666666666666666D - var20) * (var12 - var14) * 6.0D + var14;
         } else {
            var10 = var14;
         }
      }

      int var22 = (int)(256.0D * var6);
      int var13 = (int)(256.0D * var8);
      int var23 = (int)(var10 * 256.0D);
      int var15 = (var13 << 8) + (var22 << 16) + var23;
      return var15;
   }

   class18(int var1, String var2, boolean var3, boolean var4) {
      this.field93 = var1;
      this.field89 = var2;
      this.field90 = var3;
      this.field83 = var4;
   }

   boolean method218() {
      return this.field90;
   }

   public String method215() {
      return this.field89;
   }

   boolean method207() {
      return this.field83;
   }

   public int method6656() {
      return this.field93;
   }

   static SecureRandom method219() {
      SecureRandom var1 = new SecureRandom();
      var1.nextInt();
      return var1;
   }

   static final boolean method220(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      int var8 = class234.field2768 + var6;
      if (var8 < var0 && var8 < var1 && var8 < var2) {
         return false;
      } else {
         var8 = class234.field2768 - var6;
         if (var8 > var0 && var8 > var1 && var8 > var2) {
            return false;
         } else {
            var8 = class234.field2767 + var6;
            if (var8 < var3 && var8 < var4 && var8 < var5) {
               return false;
            } else {
               var8 = class234.field2767 - var6;
               return var8 <= var3 || var8 <= var4 || var8 <= var5;
            }
         }
      }
   }

   static int method221(int var0, class78 var1, boolean var2) {
      class300 var4 = var2 ? class138.field1284 : class153.field1414;
      if (var0 == 1800) {
         class57.field404[++class387.field4452 - 1] = class290.method2693(class190.method3528(var4));
         return 1;
      } else if (var0 != 1801) {
         if (var0 == 1802) {
            if (null == var4.field3545) {
               class57.field405[++class126.field1220 - 1] = "";
            } else {
               class57.field405[++class126.field1220 - 1] = var4.field3545;
            }

            return 1;
         } else {
            return 2;
         }
      } else {
         int var5 = class57.field404[--class387.field4452];
         --var5;
         if (var4.field3546 != null && var5 < var4.field3546.length && null != var4.field3546[var5]) {
            class57.field405[++class126.field1220 - 1] = var4.field3546[var5];
         } else {
            class57.field405[++class126.field1220 - 1] = "";
         }

         return 1;
      }
   }
}
