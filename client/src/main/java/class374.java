import java.util.Comparator;

class class374 implements Comparator {
   static int field4385;
   // $FF: synthetic field
   final class366 this$0;

   class374(class366 var1) {
      this.this$0 = var1;
   }

   int method6772(class371 var1, class371 var2) {
      if (var1.field4371 > var2.field4371) {
         return 1;
      } else {
         return var1.field4371 < var2.field4371 ? -1 : 0;
      }
   }

   public int compare(Object var1, Object var2) {
      return this.method6772((class371)var1, (class371)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   static String method6775(class300 var0, int var1) {
      int var4 = class190.method3528(var0);
      boolean var3 = 0 != (var4 >> 1 + var1 & 1);
      if (!var3 && var0.field3549 == null) {
         return null;
      } else {
         return var0.field3546 != null && var0.field3546.length > var1 && null != var0.field3546[var1] && var0.field3546[var1].trim().length() != 0 ? var0.field3546[var1] : null;
      }
   }
}
