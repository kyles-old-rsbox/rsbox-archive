public final class class363 {
   public static final char[] field4323 = new char[]{'_', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
   static long[] field4324 = new long[12];

   static {
      for(int var0 = 0; var0 < field4324.length; ++var0) {
         field4324[var0] = (long)Math.pow(37.0D, (double)var0);
      }

   }

   class363() throws Throwable {
      throw new Error();
   }

   public static String method4889(long var0) {
      if (var0 > 0L && var0 < 6582952005840035281L) {
         if (0L == var0 % 37L) {
            return null;
         } else {
            int var2 = 0;

            for(long var3 = var0; 0L != var3; var3 /= 37L) {
               ++var2;
            }

            StringBuilder var5;
            char var8;
            for(var5 = new StringBuilder(var2); var0 != 0L; var5.append(var8)) {
               long var6 = var0;
               var0 /= 37L;
               var8 = field4323[(int)(var6 - var0 * 37L)];
               if (var8 == '_') {
                  int var9 = var5.length() - 1;
                  var5.setCharAt(var9, Character.toUpperCase(var5.charAt(var9)));
                  var8 = 160;
               }
            }

            var5.reverse();
            var5.setCharAt(0, Character.toUpperCase(var5.charAt(0)));
            return var5.toString();
         }
      } else {
         return null;
      }
   }

   public static class486 method6668(int var0) {
      class486[] var2 = new class486[]{class486.field5008, class486.field5006, class486.field5007};
      class486[] var3 = var2;

      for(int var4 = 0; var4 < var3.length; ++var4) {
         class486 var5 = var3[var4];
         if (var0 == var5.field5005) {
            return var5;
         }
      }

      return null;
   }
}
