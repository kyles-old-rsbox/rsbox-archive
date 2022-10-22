public class class249 extends class251 {
   final class260 field2895;
   final int field2896;
   final int field2897;
   final int field2898;

   class249(class295 var1, class295 var2, int var3, class260 var4) {
      super(var1, var2);
      this.field2898 = var3;
      this.field2895 = var4;
      class160 var5 = class90.method1885(this.method5024());
      class473 var6 = var5.method2644(false);
      if (var6 != null) {
         this.field2896 = var6.field4959;
         this.field2897 = var6.field4951;
      } else {
         this.field2896 = 0;
         this.field2897 = 0;
      }

   }

   public int method5024() {
      return this.field2898;
   }

   class260 method5030() {
      return this.field2895;
   }

   int method5012() {
      return this.field2896;
   }

   int method5013() {
      return this.field2897;
   }
}
