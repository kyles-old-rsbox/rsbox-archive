public class class122 extends class393 {
   static class473 field1185;
   static int field1186;
   final boolean field1188;

   public class122(boolean var1) {
      this.field1188 = var1;
   }

   int method2294(class396 var1, class396 var2) {
      if (var1.field4492 != var2.field4492) {
         return this.field1188 ? var1.field4492 - var2.field4492 : var2.field4492 - var1.field4492;
      } else {
         return this.method7155(var1, var2);
      }
   }

   public int compare(Object var1, Object var2) {
      return this.method2294((class396)var1, (class396)var2);
   }

   public static boolean method2302(char var0) {
      return var0 >= 'A' && var0 <= 'Z' || var0 >= 'a' && var0 <= 'z';
   }
}
