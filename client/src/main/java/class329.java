public class class329 implements class360 {
   public static final class329 field3819 = new class329("oldscape", "RuneScape 2007", 5);
   static int field3822;
   static final class329 field3815 = new class329("stellardawn", "Stellar Dawn", 1);
   static final class329 field3816 = new class329("game3", "Game 3", 2);
   static final class329 field3817 = new class329("runescape", "RuneScape", 0);
   static final class329 field3818 = new class329("game5", "Game 5", 4);
   static final class329 field3821 = new class329("game4", "Game 4", 3);
   final int field3814;
   public final String field3820;

   public static class329[] method1596() {
      return new class329[]{field3817, field3821, field3818, field3815, field3816, field3819};
   }

   class329(String var1, String var2, int var3) {
      this.field3820 = var1;
      this.field3814 = var3;
   }

   public int method6656() {
      return this.field3814;
   }

   public static byte[] method6249(Object var0, boolean var1) {
      if (var0 == null) {
         return null;
      } else if (var0 instanceof byte[]) {
         byte[] var7 = (byte[])((byte[])var0);
         if (var1) {
            int var5 = var7.length;
            byte[] var6 = new byte[var5];
            System.arraycopy(var7, 0, var6, 0, var5);
            return var6;
         } else {
            return var7;
         }
      } else if (var0 instanceof class294) {
         class294 var3 = (class294)var0;
         return var3.method5516();
      } else {
         throw new IllegalArgumentException();
      }
   }
}
