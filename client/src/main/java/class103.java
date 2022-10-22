public class class103 implements class360 {
   static class433 field1034;
   static final class103 field1025 = new class103(5, 6);
   static final class103 field1026 = new class103(1, 2);
   static final class103 field1028 = new class103(3, 4);
   static final class103 field1029 = new class103(4, 5);
   static final class103 field1030 = new class103(2, 3);
   static final class103 field1032 = new class103(0, -1);
   final int field1027;
   final int field1036;

   static class103[] method2745() {
      return new class103[]{field1028, field1026, field1029, field1030, field1032, field1025};
   }

   class103(int var1, int var2) {
      this.field1027 = var1;
      this.field1036 = var2;
   }

   public int method6656() {
      return this.field1036;
   }

   static void method2025() {
      for(class70 var1 = (class70)class70.field563.method6356(); null != var1; var1 = (class70)class70.field563.method6350()) {
         if (var1.field565 != null) {
            class451.field4849.method737(var1.field565);
            var1.field565 = null;
         }

         if (var1.field569 != null) {
            class451.field4849.method737(var1.field569);
            var1.field569 = null;
         }
      }

      class70.field563.method6346();
   }
}
