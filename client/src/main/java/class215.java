import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class class215 implements class220 {
   static int field2568;
   class186[] field2563;
   class319 field2566;
   class343 field2562 = new class343();
   double field2565 = 1.0D;
   int field2561;
   int field2564 = 128;
   int field2567 = 0;

   public class215(class319 var1, class319 var2, int var3, double var4, int var6) {
      this.field2566 = var2;
      this.field2561 = var3;
      this.field2567 = this.field2561;
      this.field2565 = var4;
      this.field2564 = var6;
      int[] var7 = var1.method6090(0);
      int var8 = var7.length;
      this.field2563 = new class186[var1.method6091(0)];

      for(int var9 = 0; var9 < var8; ++var9) {
         class460 var10 = new class460(var1.method6167(0, var7[var9]));
         this.field2563[var7[var9]] = new class186(var10);
      }

   }

   public int method4306() {
      int var2 = 0;
      int var3 = 0;
      class186[] var4 = this.field2563;

      for(int var5 = 0; var5 < var4.length; ++var5) {
         class186 var6 = var4[var5];
         if (null != var6 && var6.field1967 != null) {
            var2 += var6.field1967.length;
            int[] var7 = var6.field1967;

            for(int var8 = 0; var8 < var7.length; ++var8) {
               int var9 = var7[var8];
               if (this.field2566.method6082(var9)) {
                  ++var3;
               }
            }
         }
      }

      if (0 == var2) {
         return 0;
      } else {
         return var3 * 100 / var2;
      }
   }

   public static final class28 method4334(class172 var0, int var1, int var2) {
      if (SoundCache.field348 == 0) {
         throw new IllegalStateException();
      } else if (var1 >= 0 && var1 < 2) {
         if (var2 < 256) {
            var2 = 256;
         }

         try {
            class28 var4 = class30.field164.method354();
            var4.field136 = new int[256 * (class174.field1566 ? 2 : 1)];
            var4.field141 = var2;
            var4.method365();
            var4.field140 = 1024 + (var2 & -1024);
            if (var4.field140 > 16384) {
               var4.field140 = 16384;
            }

            var4.method366(var4.field140);
            if (class282.field3209 > 0 && class28.field154 == null) {
               class28.field154 = new class47();
               class339.field4217 = Executors.newScheduledThreadPool(1);
               class339.field4217.scheduleAtFixedRate(class28.field154, 0L, 10L, TimeUnit.MILLISECONDS);
            }

            if (null != class28.field154) {
               if (class28.field154.field339[var1] != null) {
                  throw new IllegalArgumentException();
               }

               class28.field154.field339[var1] = var4;
            }

            return var4;
         } catch (Throwable var5) {
            return new class28();
         }
      } else {
         throw new IllegalArgumentException();
      }
   }

   public void method4329(double var1) {
      this.field2565 = var1;
      this.method4312();
   }

   public int[] method4374(int var1) {
      class186 var3 = this.field2563[var1];
      if (null != var3) {
         if (var3.field1973 != null) {
            this.field2562.method6345(var3);
            var3.field1974 = true;
            return var3.field1973;
         }

         boolean var4 = var3.method3437(this.field2565, this.field2564, this.field2566);
         if (var4) {
            if (this.field2567 == 0) {
               class186 var5 = (class186)this.field2562.method6351();
               var5.method3438();
            } else {
               --this.field2567;
            }

            this.field2562.method6345(var3);
            var3.field1974 = true;
            return var3.field1973;
         }
      }

      return null;
   }

   public int method4372(int var1) {
      return this.field2563[var1] != null ? this.field2563[var1].field1965 : 0;
   }

   public boolean method4373(int var1) {
      return this.field2563[var1].field1966;
   }

   public boolean method4375(int var1) {
      return 64 == this.field2564;
   }

   public void method4312() {
      for(int var2 = 0; var2 < this.field2563.length; ++var2) {
         if (null != this.field2563[var2]) {
            this.field2563[var2].method3438();
         }
      }

      this.field2562 = new class343();
      this.field2567 = this.field2561;
   }

   public void method4313(int var1) {
      for(int var3 = 0; var3 < this.field2563.length; ++var3) {
         class186 var4 = this.field2563[var3];
         if (null != var4 && 0 != var4.field1971 && var4.field1974) {
            var4.method3439(var1);
            var4.field1974 = false;
         }
      }

   }

   static class72 method4335() {
      return class72.field583 < class72.field582 ? class399.field4502[++class72.field583 - 1] : null;
   }
}
