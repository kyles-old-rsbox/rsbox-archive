public class class152 extends class140 {
   String field1410;
   // $FF: synthetic field
   final class142 this$0;

   class152(class142 var1) {
      this.this$0 = var1;
   }

   void method2467(class460 var1) {
      this.field1410 = var1.method8124();
      var1.method8119();
   }

   void method2468(class148 var1) {
      var1.field1372 = this.field1410;
   }

   static void method2593(int var0) {
      for(class426 var2 = (class426)client.field1785.method7860(); null != var2; var2 = (class426)client.field1785.method7851()) {
         if ((var2.field4681 >> 48 & 65535L) == (long)var0) {
            var2.remove();
         }
      }

   }
}
