public class class408 {
   public int field4533 = -1;
   public int field4534 = -1;
   public int field4535 = -1;
   public int field4536 = -1;
   public int field4537 = -1;
   public int field4538 = -1;
   public int field4539 = -1;
   public int field4540 = -1;
   public int field4541 = -1;
   public int field4542 = -1;
   public int field4543 = -1;

   public void method7395(class319 var1) {
      byte[] var3 = var1.method6095(class403.field4511.field4510);
      class460 var4 = new class460(var3);

      while(true) {
         int var5 = var4.method8134();
         if (0 == var5) {
            return;
         }

         switch(var5) {
         case 1:
            var4.method8305();
            break;
         case 2:
            this.field4534 = var4.method8133();
            this.field4535 = var4.method8133();
            this.field4533 = var4.method8133();
            this.field4536 = var4.method8133();
            this.field4537 = var4.method8133();
            this.field4538 = var4.method8133();
            this.field4539 = var4.method8133();
            this.field4540 = var4.method8133();
            this.field4541 = var4.method8133();
            this.field4542 = var4.method8133();
            this.field4543 = var4.method8133();
         }
      }
   }

   static void method7398(int var0) {
      class87 var2 = (class87)class87.field782.get((long)var0);
      if (var2 != null) {
         var2.remove();
      }
   }
}
