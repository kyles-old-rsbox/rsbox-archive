public class class116 extends class393 {
   public static class335 field1137;
   static int field1135;
   final boolean field1136;

   public class116(boolean var1) {
      this.field1136 = var1;
   }

   int method2243(class396 var1, class396 var2) {
      if (0 != var1.field4491 && var2.field4491 != 0) {
         return this.field1136 ? var1.method7225().method8450(var2.method7225()) : var2.method7225().method8450(var1.method7225());
      } else {
         return this.method7155(var1, var2);
      }
   }

   public int compare(Object var1, Object var2) {
      return this.method2243((class396)var1, (class396)var2);
   }
}
