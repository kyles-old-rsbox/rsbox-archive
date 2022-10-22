public class class174 extends class140 {
   protected static boolean field1566;
   static class336 field1564;
   static class411 field1567;
   String field1565;
   long field1568;
   // $FF: synthetic field
   final class142 this$0;

   public static final void method2744(int var0, boolean var1, int var2) {
      if (var0 >= 8000 && var0 <= 48000) {
         SoundCache.field348 = var0;
         field1566 = var1;
         class282.field3209 = var2;
      } else {
         throw new IllegalArgumentException();
      }
   }

   class174(class142 var1) {
      this.this$0 = var1;
      this.field1568 = -1L;
      this.field1565 = null;
   }

   void method2467(class460 var1) {
      if (var1.method8134() != 255) {
         --var1.field4878;
         this.field1568 = var1.method8120();
      }

      this.field1565 = var1.method8298();
   }

   void method2468(class148 var1) {
      var1.method2571(this.field1568, this.field1565);
   }
}
