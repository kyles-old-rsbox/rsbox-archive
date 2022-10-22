import netscape.javascript.JSObject;

public class class330 {
   static final class330 field3823 = new class330(51, 27, 800, 0, 16, 16);
   static final class330 field3824 = new class330(25, 28, 800, 656, 40, 40);
   final int field3825;
   final int field3826;

   class330(int var1, int var2, int var3, int var4, int var5, int var6) {
      this.field3825 = var5;
      this.field3826 = var6;
   }

   static void method6250(String var0) {
      class61.field481 = var0;

      try {
         String var2 = class133.field1257.getParameter(Integer.toString(18));
         String var3 = class133.field1257.getParameter(Integer.toString(13));
         String var4 = var2 + "settings=" + var0 + "; version=1; path=/; domain=" + var3;
         if (var0.length() == 0) {
            var4 = var4 + "; Expires=Thu, 01-Jan-1970 00:00:00 GMT; Max-Age=0";
         } else {
            var4 = var4 + "; Expires=" + class309.method5983(class272.method2046() + 94608000000L) + "; Max-Age=" + 94608000L;
         }

         client var5 = class133.field1257;
         String var6 = "document.cookie=\"" + var4 + "\"";
         JSObject.getWindow(var5).eval(var6);
      } catch (Throwable var7) {
      }

   }
}
