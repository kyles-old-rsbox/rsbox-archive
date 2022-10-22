public abstract class class251 {
   public static String[] field2908;
   int field2910;
   int field2914;
   public final class295 field2909;
   public final class295 field2915;

   class251(class295 var1, class295 var2) {
      this.field2909 = var1;
      this.field2915 = var2;
   }

   boolean method5029(int var1, int var2) {
      if (this.method5015(var1, var2)) {
         return true;
      } else {
         return this.method5016(var1, var2);
      }
   }

   boolean method5014() {
      return this.method5024() >= 0;
   }

   boolean method5015(int var1, int var2) {
      if (!this.method5014()) {
         return false;
      } else {
         class160 var4 = class90.method1885(this.method5024());
         int var5 = this.method5012();
         int var6 = this.method5013();
         switch(var4.field1483.field2046) {
         case 0:
            if (var1 < this.field2910 - var5 / 2 || var1 > var5 / 2 + this.field2910) {
               return false;
            }
            break;
         case 1:
            if (var1 > this.field2910 - var5 && var1 <= this.field2910) {
               break;
            }

            return false;
         case 2:
            if (var1 < this.field2910 || var1 >= var5 + this.field2910) {
               return false;
            }
         }

         switch(var4.field1484.field1941) {
         case 0:
            if (var2 <= this.field2914 - var6 || var2 > this.field2914) {
               return false;
            }
            break;
         case 1:
            if (var2 < this.field2914 - var6 / 2 || var2 > this.field2914 + var6 / 2) {
               return false;
            }
            break;
         case 2:
            if (var2 < this.field2914 || var2 >= var6 + this.field2914) {
               return false;
            }
         }

         return true;
      }
   }

   boolean method5016(int var1, int var2) {
      class260 var4 = this.method5030();
      if (var4 == null) {
         return false;
      } else if (var1 >= this.field2910 - var4.field2968 / 2 && var1 <= var4.field2968 / 2 + this.field2910) {
         return var2 >= this.field2914 && var2 <= var4.field2969 + this.field2914;
      } else {
         return false;
      }
   }

   abstract int method5012();

   abstract int method5013();

   public abstract int method5024();

   abstract class260 method5030();
}
