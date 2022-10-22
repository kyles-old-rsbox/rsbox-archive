public class class381 extends class404 {
   final class463 field4410;

   public class381(class463 var1) {
      super(400);
      this.field4410 = var1;
   }

   class400 method7297() {
      return new class398();
   }

   class400[] method7299(int var1) {
      return new class398[var1];
   }

   public void method6817(class460 var1, int var2) {
      while(true) {
         if (var1.field4878 < var2) {
            int var4 = var1.method8134();
            boolean var5 = (var4 & 1) == 1;
            class472 var6 = new class472(var1.method8124(), this.field4410);
            class472 var7 = new class472(var1.method8124(), this.field4410);
            var1.method8124();
            if (null != var6 && var6.method8442()) {
               class398 var8 = (class398)this.method7283(var6);
               if (var5) {
                  class398 var9 = (class398)this.method7283(var7);
                  if (var9 != null && var8 != var9) {
                     if (null != var8) {
                        this.method7286(var9);
                     } else {
                        var8 = var9;
                     }
                  }
               }

               if (var8 != null) {
                  this.method7340(var8, var6, var7);
                  continue;
               }

               if (this.method7332() < 400) {
                  int var10 = this.method7332();
                  var8 = (class398)this.method7288(var6, var7);
                  var8.field4501 = var10;
               }
               continue;
            }

            throw new IllegalStateException();
         }

         return;
      }
   }
}
