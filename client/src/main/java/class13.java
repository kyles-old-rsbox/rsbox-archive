import java.util.concurrent.Future;

public class class13 {
   public static int field67;
   String field61;
   Future field63;

   class13(Future var1) {
      this.field63 = var1;
   }

   class13(String var1) {
      this.method105(var1);
   }

   void method105(String var1) {
      if (var1 == null) {
         var1 = "";
      }

      this.field61 = var1;
      if (null != this.field63) {
         this.field63.cancel(true);
         this.field63 = null;
      }

   }

   public final String method111() {
      return this.field61;
   }

   public boolean method119() {
      return this.field61 != null || null == this.field63;
   }

   public final boolean method107() {
      return this.method119() ? true : this.field63.isDone();
   }

   public final class9 method108() {
      if (this.method119()) {
         return new class9(this.field61);
      } else if (!this.method107()) {
         return null;
      } else {
         try {
            return (class9)this.field63.get();
         } catch (Exception var4) {
            String var3 = "Error retrieving REST request reply";
            System.err.println(var3 + "\r\n" + var4);
            this.method105(var3);
            return new class9(var3);
         }
      }
   }

   public static int method120(CharSequence var0, int var1, boolean var2) {
      if (var1 >= 2 && var1 <= 36) {
         boolean var4 = false;
         boolean var5 = false;
         int var6 = 0;
         int var7 = var0.length();

         for(int var8 = 0; var8 < var7; ++var8) {
            char var9 = var0.charAt(var8);
            if (0 == var8) {
               if ('-' == var9) {
                  var4 = true;
                  continue;
               }

               if (var9 == '+' && var2) {
                  continue;
               }
            }

            int var11;
            if (var9 >= '0' && var9 <= '9') {
               var11 = var9 - 48;
            } else if (var9 >= 'A' && var9 <= 'Z') {
               var11 = var9 - 55;
            } else {
               if (var9 < 'a' || var9 > 'z') {
                  throw new NumberFormatException();
               }

               var11 = var9 - 87;
            }

            if (var11 >= var1) {
               throw new NumberFormatException();
            }

            if (var4) {
               var11 = -var11;
            }

            int var10 = var11 + var6 * var1;
            if (var10 / var1 != var6) {
               throw new NumberFormatException();
            }

            var6 = var10;
            var5 = true;
         }

         if (!var5) {
            throw new NumberFormatException();
         } else {
            return var6;
         }
      } else {
         throw new IllegalArgumentException("" + var1);
      }
   }
}
