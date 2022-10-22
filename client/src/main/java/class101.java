public final class class101 extends class427 {
   static class73 field1005;
   static int field1004;
   int field1000;
   int field1001 = 31;
   int field1003 = -1;
   int field1006 = 0;
   int field991;
   int field992;
   int field993;
   int field994;
   int field995;
   int field996;
   int field997;
   int field998;
   int field999;

   class101() {
   }

   void method1995(int var1) {
      this.field1001 = var1;
   }

   boolean method1996(int var1) {
      if (var1 >= 0 && var1 <= 4) {
         return (this.field1001 & 1 << var1) != 0;
      } else {
         return true;
      }
   }
}
