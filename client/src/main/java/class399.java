public abstract class class399 extends class259 implements class482 {
   static class72[] field4502;

   protected class399(class329 var1, class353 var2, int var3) {
      super(var1, var2, var3);
   }

   public int method7210() {
      return super.field2964;
   }

   public Object method8724(int var1) {
      class416 var3 = this.method7217(var1);
      return var3 != null && var3.method7549() ? var3.method7550() : null;
   }

   public class474 method7209(class460 var1) {
      int var3 = var1.method8115();
      class416 var4 = this.method7217(var3);
      class474 var5 = new class474(var3);
      Class var6 = var4.field4599.field4847;
      if (Integer.class == var6) {
         var5.field4963 = var1.method8119();
      } else if (var6 == Long.class) {
         var5.field4963 = var1.method8120();
      } else if (var6 == String.class) {
         var5.field4963 = var1.method8125();
      } else {
         if (!class461.class.isAssignableFrom(var6)) {
            throw new IllegalStateException();
         }

         try {
            class461 var7 = (class461)var6.newInstance();
            var7.method8355(var1);
            var5.field4963 = var7;
         } catch (InstantiationException var8) {
         } catch (IllegalAccessException var9) {
         }
      }

      return var5;
   }

   static boolean method7214(class453 var0, int var1) {
      int var3 = var0.method8007(2);
      int var4;
      int var5;
      int var8;
      int var9;
      int var10;
      int var11;
      if (0 == var3) {
         if (var0.method8007(1) != 0) {
            method7214(var0, var1);
         }

         var4 = var0.method8007(13);
         var5 = var0.method8007(13);
         boolean var12 = var0.method8007(1) == 1;
         if (var12) {
            class102.field1020[++class102.field1007 - 1] = var1;
         }

         if (client.field1763[var1] != null) {
            throw new RuntimeException();
         } else {
            class93 var13 = client.field1763[var1] = new class93();
            var13.field915 = var1;
            if (null != class102.field1011[var1]) {
               var13.method1906(class102.field1011[var1]);
            }

            var13.field860 = class102.field1014[var1];
            var13.field835 = class102.field1018[var1];
            var8 = class102.field1016[var1];
            var9 = var8 >> 28;
            var10 = var8 >> 14 & 255;
            var11 = var8 & 255;
            var13.field803[0] = class102.field1010[var1];
            var13.field914 = (byte)var9;
            var13.method1919(var4 + (var10 << 13) - class36.field241, (var11 << 13) + var5 - class169.field1536);
            var13.field919 = false;
            return true;
         }
      } else if (1 == var3) {
         var4 = var0.method8007(2);
         var5 = class102.field1016[var1];
         class102.field1016[var1] = (((var5 >> 28) + var4 & 3) << 28) + (var5 & 268435455);
         return false;
      } else {
         int var6;
         int var7;
         if (2 == var3) {
            var4 = var0.method8007(5);
            var5 = var4 >> 3;
            var6 = var4 & 7;
            var7 = class102.field1016[var1];
            var8 = (var7 >> 28) + var5 & 3;
            var9 = var7 >> 14 & 255;
            var10 = var7 & 255;
            if (0 == var6) {
               --var9;
               --var10;
            }

            if (var6 == 1) {
               --var10;
            }

            if (var6 == 2) {
               ++var9;
               --var10;
            }

            if (var6 == 3) {
               --var9;
            }

            if (4 == var6) {
               ++var9;
            }

            if (var6 == 5) {
               --var9;
               ++var10;
            }

            if (var6 == 6) {
               ++var10;
            }

            if (var6 == 7) {
               ++var9;
               ++var10;
            }

            class102.field1016[var1] = var10 + (var8 << 28) + (var9 << 14);
            return false;
         } else {
            var4 = var0.method8007(18);
            var5 = var4 >> 16;
            var6 = var4 >> 8 & 255;
            var7 = var4 & 255;
            var8 = class102.field1016[var1];
            var9 = (var8 >> 28) + var5 & 3;
            var10 = var6 + (var8 >> 14) & 255;
            var11 = var7 + var8 & 255;
            class102.field1016[var1] = (var9 << 28) + (var10 << 14) + var11;
            return false;
         }
      }
   }

   protected abstract class416 method7217(int var1);
}
