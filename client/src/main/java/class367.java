public class class367 extends class404 {
   int field4351 = 1;
   final class375 field4345;
   final class463 field4346;
   public byte field4350;
   public int field4352;
   public String field4348 = null;
   public String field4349 = null;

   public class367(class463 var1, class375 var2) {
      super(500);
      this.field4346 = var1;
      this.field4345 = var2;
   }

   class400 method7297() {
      return new class373();
   }

   class400[] method7299(int var1) {
      return new class373[var1];
   }

   final void method6705(String var1) {
      long var6 = 0L;
      int var8 = var1.length();

      for(int var9 = 0; var9 < var8; ++var9) {
         var6 *= 37L;
         char var10 = var1.charAt(var9);
         if (var10 >= 'A' && var10 <= 'Z') {
            var6 += (long)(var10 + 1 - 65);
         } else if (var10 >= 'a' && var10 <= 'z') {
            var6 += (long)(var10 + 1 - 97);
         } else if (var10 >= '0' && var10 <= '9') {
            var6 += (long)(27 + var10 - 48);
         }

         if (var6 >= 177917621779460413L) {
            break;
         }
      }

      while(var6 % 37L == 0L && var6 != 0L) {
         var6 /= 37L;
      }

      String var11 = class363.method4889(var6);
      if (null == var11) {
         var11 = "";
      }

      this.field4348 = var11;
   }

   final void method6697(String var1) {
      long var6 = 0L;
      int var8 = var1.length();

      for(int var9 = 0; var9 < var8; ++var9) {
         var6 *= 37L;
         char var10 = var1.charAt(var9);
         if (var10 >= 'A' && var10 <= 'Z') {
            var6 += (long)(var10 + 1 - 65);
         } else if (var10 >= 'a' && var10 <= 'z') {
            var6 += (long)(1 + var10 - 97);
         } else if (var10 >= '0' && var10 <= '9') {
            var6 += (long)(27 + var10 - 48);
         }

         if (var6 >= 177917621779460413L) {
            break;
         }
      }

      while(0L == var6 % 37L && 0L != var6) {
         var6 /= 37L;
      }

      String var11 = class363.method4889(var6);
      if (var11 == null) {
         var11 = "";
      }

      this.field4349 = var11;
   }

   public final void method6698(class460 var1, int var2) {
      this.method6697(var1.method8124());
      long var4 = var1.method8120();
      long var7 = var4;
      String var6;
      int var9;
      if (var4 > 0L && var4 < 6582952005840035281L) {
         if (var4 % 37L == 0L) {
            var6 = null;
         } else {
            var9 = 0;

            for(long var10 = var4; var10 != 0L; var10 /= 37L) {
               ++var9;
            }

            StringBuilder var12 = new StringBuilder(var9);

            while(0L != var7) {
               long var13 = var7;
               var7 /= 37L;
               var12.append(class363.field4323[(int)(var13 - 37L * var7)]);
            }

            var6 = var12.reverse().toString();
         }
      } else {
         var6 = null;
      }

      this.method6705(var6);
      this.field4350 = var1.method8280();
      short var15;
      if (1 == var2) {
         var9 = var1.method8134();
         var15 = 255;
      } else {
         if (var2 != 2) {
            throw new IllegalArgumentException("Invalid friend chat full update version: " + var2);
         }

         var9 = var1.method8352();
         var15 = -1;
      }

      if (var15 != var9) {
         int var11 = var9;
         this.method7278();

         for(int var16 = 0; var16 < var11; ++var16) {
            class373 var17 = (class373)this.method7277(new class472(var1.method8124(), this.field4346));
            int var14 = var1.method8115();
            var17.method7171(var14, ++this.field4351 - 1);
            var17.field4492 = var1.method8280();
            var1.method8124();
            this.method6702(var17);
         }

      }
   }

   public final void method6699(class460 var1) {
      class472 var3 = new class472(var1.method8124(), this.field4346);
      int var4 = var1.method8115();
      byte var5 = var1.method8280();
      boolean var6 = false;
      if (-128 == var5) {
         var6 = true;
      }

      class373 var7;
      if (var6) {
         if (this.method7332() == 0) {
            return;
         }

         var7 = (class373)this.method7283(var3);
         if (var7 != null && var7.method7166() == var4) {
            this.method7286(var7);
         }
      } else {
         var1.method8124();
         var7 = (class373)this.method7283(var3);
         if (var7 == null) {
            if (this.method7332() > super.field4515) {
               return;
            }

            var7 = (class373)this.method7277(var3);
         }

         var7.method7171(var4, ++this.field4351 - 1);
         var7.field4492 = var5;
         this.method6702(var7);
      }

   }

   public final void method6700() {
      for(int var2 = 0; var2 < this.method7332(); ++var2) {
         ((class373)this.method7289(var2)).method6750();
      }

   }

   public final void method6701() {
      for(int var2 = 0; var2 < this.method7332(); ++var2) {
         ((class373)this.method7289(var2)).method6747();
      }

   }

   final void method6702(class373 var1) {
      if (var1.method7225().equals(this.field4345.method6778())) {
         this.field4352 = var1.field4492;
      }

   }

   static void method6723(boolean var0) {
      if (!class133.field1257.method2874() && !class133.field1257.method3038()) {
         class75.field624 = class338.field4115;
         class75.field630 = class338.field4192;
         class75.field631 = class338.field4111;
         class74.method1490(2);
         if (var0) {
            class75.field650 = "";
         }

         class28.method400();
         class279.method5396();
      } else {
         class74.method1490(10);
      }
   }
}
