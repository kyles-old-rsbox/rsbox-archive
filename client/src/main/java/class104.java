public final class class104 extends class212 {
   int field1038;
   int field1039 = 31;
   int field1043;

   class104() {
   }

   void method2029(int var1) {
      this.field1039 = var1;
   }

   boolean method2028(int var1) {
      if (var1 >= 0 && var1 <= 4) {
         return 0 != (this.field1039 & 1 << var1);
      } else {
         return true;
      }
   }

   protected final class209 method4112() {
      return class278.method5388(this.field1043).method3648(this.field1038);
   }
}
