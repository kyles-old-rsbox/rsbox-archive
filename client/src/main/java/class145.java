public class class145 extends class140 {
   public static class376 field1336;
   static boolean field1335;
   static class214 field1333;
   static class336 field1338;
   byte field1330;
   int field1331;
   // $FF: synthetic field
   final class142 this$0;

   static int method2500(int var0, int var1) {
      class87 var3 = (class87)class87.field782.get((long)var0);
      if (var3 == null) {
         return 0;
      } else {
         return var1 >= 0 && var1 < var3.field783.length ? var3.field783[var1] : 0;
      }
   }

   class145(class142 var1) {
      this.this$0 = var1;
      this.field1331 = -1;
   }

   void method2467(class460 var1) {
      this.field1331 = var1.method8115();
      this.field1330 = var1.method8280();
   }

   void method2468(class148 var1) {
      var1.method2534(this.field1331, this.field1330);
   }
}
