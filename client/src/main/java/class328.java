import java.net.URL;

public class class328 {
   String field3809;
   String field3811;
   public final class347 field3807;
   public final int field3806;
   public final long field3805;

   static boolean method6239() {
      try {
         if (null == class96.field962) {
            class96.field962 = class28.field155.method2222(new URL(class130.field1236));
         } else if (class96.field962.method2102()) {
            byte[] var1 = class96.field962.method2115();
            class460 var2 = new class460(var1);
            var2.method8119();
            class72.field582 = var2.method8115();
            class399.field4502 = new class72[class72.field582];

            class72 var4;
            for(int var3 = 0; var3 < class72.field582; var4.field592 = var3++) {
               var4 = class399.field4502[var3] = new class72();
               var4.field590 = var2.method8115();
               var4.field587 = var2.method8119();
               var4.field589 = var2.method8124();
               var4.field588 = var2.method8124();
               var4.field580 = var2.method8134();
               var4.field593 = var2.method8197();
            }

            class12.method91(class399.field4502, 0, class399.field4502.length - 1, class72.field585, class72.field584);
            class96.field962 = null;
            return true;
         }
      } catch (Exception var5) {
         var5.printStackTrace();
         class96.field962 = null;
      }

      return false;
   }

   class328(class460 var1, byte var2, int var3) {
      this.field3811 = var1.method8124();
      this.field3809 = var1.method8124();
      this.field3806 = var1.method8115();
      this.field3805 = var1.method8120();
      int var4 = var1.method8119();
      int var5 = var1.method8119();
      this.field3807 = new class347();
      this.field3807.method6409(2);
      this.field3807.method6403(var2);
      this.field3807.field4253 = var4;
      this.field3807.field4256 = var5;
      this.field3807.field4255 = 0;
      this.field3807.field4258 = 0;
      this.field3807.field4254 = var3;
   }

   public String method6236() {
      return this.field3811;
   }

   public String method6237() {
      return this.field3809;
   }
}
